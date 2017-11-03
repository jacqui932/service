package com.rhindon.bridge

import com.rhindon.bridge.filter.BridgeEventFilter
import com.rhindon.bridge.filter.ClubFilter
import com.rhindon.bridge.filter.EventEntryPlayerFilter
import com.rhindon.bridge.filter.HeatFilter
import com.rhindon.bridge.multitenant.BridgeEvent
import com.rhindon.bridge.multitenant.EventEntryPlayer
import grails.converters.JSON

class WebsiteController {

    static responseFormats = ['json']

    def clubService

    def bridgeEventService

    def heatService

    def eventEntryPlayerService

    def bridgeEmailService

    def clubs() {
        respond clubService.search(new ClubFilter(request.JSON))
    }

    def eventSummaries() {
        respond bridgeEventService.search(new BridgeEventFilter(request.JSON))
    }

    def heats() {
        respond heatService.search(new HeatFilter(request.JSON))
    }

    def event(Long id) {
        respond BridgeEvent.get(id)
    }

    def entries() {
        def filter = new EventEntryPlayerFilter(request.JSON)
        def results = EventEntryPlayer.withCriteria {
            eventEntry {
                eq "event.id", filter.event
            }
        }
        render results.groupBy({eventPlayer -> eventPlayer.eventEntry}).values() as JSON
    }

//    def thankyou() {
//        bridgeEmailService.afterEventReport()
//    }
}
