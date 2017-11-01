package com.rhindon.bridge

import com.rhindon.bridge.filter.BridgeEventFilter
import com.rhindon.bridge.filter.ClubFilter
import com.rhindon.bridge.filter.HeatFilter
import com.rhindon.bridge.multitenant.BridgeEvent
import com.rhindon.bridge.multitenant.EventEntry

class WebsiteController {

    static responseFormats = ['json']

    def clubService

    def bridgeEventService

    def heatService

    def eventEntryService

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

    def entries(Long id) {
        respond EventEntry.findAllByEvent(BridgeEvent.get(id), [fetch:[players:"join"]])
    }
}
