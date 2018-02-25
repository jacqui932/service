package com.rhindon.bridge

import com.rhindon.bridge.filter.HeatFilter
import com.rhindon.bridge.filter.ClubEventHeatQualifiersFilter
import com.rhindon.bridge.multitenant.BridgeEvent
import com.rhindon.bridge.multitenant.Club
import com.rhindon.bridge.multitenant.Heat
import grails.gorm.transactions.Transactional

@Transactional
class HeatService {

    def search(HeatFilter filter) {
        Heat.createCriteria().list {
            if (filter.event) {
                eq("event", BridgeEvent.get(filter.event))
            }
            if (filter.alreadyPlayed) {
                le("dateTime", new Date())
            }
            if (filter.club) {
                eq("club", Club.get(filter.club))
            }
            order("dateTime", "asc")
        }
    }

    def createHeatsReportData(HeatFilter filter) {
        def heats = search(filter)
        if (heats) {
            def result = heats.groupBy { it.event }
            [heats: result]
        } else {
            []
        }
    }

    def createClubEventHeatQualifiersData(ClubEventHeatQualifiersFilter filter) {
        def event = BridgeEvent.get(filter.event)
        def club = Club.get(filter.club)
        def heats = Heat.findAllByClubAndEvent(club, event)
        return [heats: heats, event: event, club: club]
    }
}
