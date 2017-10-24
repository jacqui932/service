package com.rhindon.bridge

import com.rhindon.bridge.filter.*
import com.rhindon.bridge.multitenant.BridgeEvent
import com.rhindon.bridge.multitenant.EventEntryPlayer

class ReportController {

    def bridgeEventService

    def clubService

    def heatService

    def eventEntryService

    def eventEntryPlayerService

    def financialTransactionService

    def monthlyFinancialReport(FinancialTransactionFilter filter) {
        render(filename:"File report_${filter.month}${filter.year}.pdf",
                view:"/report/monthlyFinancialReport",
                model: financialTransactionService.createMonthlyFinancialReportData(filter))
    }

    def bridgeEventsReport(BridgeEventFilter filter) {
        filter.year = 2017 - 1900
        render(filename:"File bridgeEvents.pdf",
                view:"/report/bridgeEvents",
                model: [events: bridgeEventService.search(filter)])
    }

    def clubsReport(ClubFilter filter) {
        render(filename:"File clubs.pdf",
                view:"/report/clubs",
                model: [clubs: clubService.search(filter)])
    }

    def heatsReport(HeatFilter filter) {
        render(filename:"File heats.pdf",
                view:"/report/heats",
                model: heatService.createHeatsReportData(filter))
    }

    def eventHeatsReport(HeatFilter filter) {
        render(filename:"File eventHeats.pdf",
                view:"/report/eventHeats",
                model: [event: BridgeEvent.get(filter.event), heats: heatService.search(filter)])
    }

    def eventPlayersReport(EventEntryFilter filter) {
        filter.withdrawn = false
        render(filename:"File eventPlayers.pdf",
                view:"/report/eventPlayers",
                model: [event: BridgeEvent.get(filter.event), eventEntries: eventEntryService.search(filter)])
    }

    def victorLudorumReport(EventEntryPlayerFilter filter) {
        filter.victorLudorumOnly = true

        List<EventEntryPlayer> all = eventEntryPlayerService.search(filter);
        def intermediate = []
        def cadet = []

        all.forEach({
            Player player = Player.findByEbuNumber(it.ebuNumber)
            if (player.masterpointGrade.id < 53) {
                intermediate.add(it)
                if (player.masterpointGrade.id < 7) {
                    cadet.add(it)
                }
            }
        })

        render(filename:"File victorLudorum.pdf",
                view:"/report/victorLudorum",
                model: [all: all, cadet: cadet, intermediate: intermediate])
    }
}
