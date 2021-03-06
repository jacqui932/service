package com.rhindon.bridge

import com.rhindon.bridge.filter.*
import com.rhindon.bridge.view.HeatQualifierEmailView
import com.rhindon.bridge.multitenant.BridgeEvent
import com.rhindon.bridge.multitenant.EventEntry
import com.rhindon.bridge.multitenant.EventEntryPlayer
import groovy.sql.Sql
import org.hibernate.criterion.CriteriaSpecification

import java.sql.Timestamp

class ReportController {

    def clubService

    def heatService

    def eventEntryService

    def eventEntryPlayerService

    def financialTransactionService

    def monthlyFinancialReport(FinancialTransactionFilter filter) {
        render(filename: "File report_${filter.month}${filter.year}.pdf",
                view: "/report/monthlyFinancialReport",
                model: financialTransactionService.createMonthlyFinancialReportData(filter))
    }

    def bridgeEventsReport() {
        render(filename: "File bridgeEvents.pdf",
                view: "/report/bridgeEvents",
                model: [events: BridgeEvent.findAllByDateTimeGreaterThan(new Date())])
    }

    def clubsReport(ClubFilter filter) {
        render(filename: "File clubs.pdf",
                view: "/report/clubs",
                model: [clubs: clubService.search(filter)])
    }

    def clubEventHeatQualifiersReport(ClubEventHeatQualifiersFilter filter) {
        render(filename: "File clubEventHeatQualifiersReport.pdf",
                view: "/report/clubEventHeatQualifiers",
                model: heatService.createClubEventHeatQualifiersData(filter))
    }

    def heatsReport(HeatFilter filter) {
        render(filename: "File heats.pdf",
                view: "/report/heats",
                model: heatService.createHeatsReportData(filter))
    }

    def eventHeatsReport(HeatFilter filter) {
        render(filename: "File eventHeats.pdf",
                view: "/report/eventHeats",
                model: [event: BridgeEvent.get(filter.event), heats: heatService.search(filter)])
    }

    def eventPlayersReport(EventEntryFilter filter) {
        filter.withdrawn = false
        render(filename: "File eventPlayers.pdf",
                view: "/report/eventPlayers",
                model: [event: BridgeEvent.get(filter.event), eventEntries: eventEntryService.search(filter)])
    }

    def outstandingPaymentsReport() {
        def results = EventEntry.createCriteria().list {
            createAlias('event', 'e', CriteriaSpecification.LEFT_JOIN)
            eq("fullyPaid", false)
        }

        render(filename: "File outstandingPayments.pdf",
                view: "/report/outstandingPayments",
                model: [data: results.groupBy({ it.event })])
    }

//    def ecclesCupPointsReport() {
//        render(filename: "File ecclesCupPoints.pdf",
//                view: "/report/ecclesCupPoints",
//                model: [data: EcclesCupPoints.all.groupBy { it.clubName }])
//    }

    private def groupVL(eventEntryPlayers) {
        eventEntryPlayers.groupBy({ it -> [firstName: it.firstName, lastName: it.lastName, ebuNumber: it.ebuNumber] })
                .collectEntries({ key, List<EventEntryPlayer> value ->
            [[player: key, total: value.sum { it.victorLudorumPoints }]: value.collectEntries {
                EventEntryPlayer e -> [(e.eventEntry.event): e.victorLudorumPoints]
            }]
        }).sort({ it -> -it.key.total })
    }

    def victorLudorumReport(EventEntryPlayerFilter filter) {
        filter.victorLudorumOnly = true

        List<EventEntryPlayer> all = eventEntryPlayerService.search(filter);
        def intermediate = []
        def cadet = []

        all.forEach({
            Player player = Player.findByEbuNumber(it.ebuNumber)
            if (player.playerRankCodes && player.playerRankCodes[0].rankCode.id < 320) {
                intermediate.add(it)
                if (player.playerRankCodes && player.playerRankCodes[0].rankCode.id < 7) {
                    cadet.add(it)
                }
            }
        })

        render(filename: "File victorLudorum.pdf",
                view: "/report/victorLudorum",
                model: [
                        events      : new ArrayList(all.groupBy { it -> it.eventEntry.event }.keySet().sort { it -> it.dateTime }),
                        all         : groupVL(all),
                        cadet       : groupVL(cadet),
                        intermediate: groupVL(intermediate)
                ])
    }
}
