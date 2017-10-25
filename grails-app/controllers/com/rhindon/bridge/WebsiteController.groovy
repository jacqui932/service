package com.rhindon.bridge

import com.rhindon.bridge.filter.BridgeEventFilter
import com.rhindon.bridge.filter.ClubFilter
import com.rhindon.bridge.filter.HeatFilter

class WebsiteController {

    static responseFormats = ['json']

    def clubService

    def bridgeEventService

    def heatService

    def clubs() {
        respond clubService.search(new ClubFilter(request.JSON))
    }

    def eventSummaries() {
        respond bridgeEventService.search(new BridgeEventFilter(request.JSON))
    }

    def heats() {
        respond heatService.search(new HeatFilter(request.JSON))
    }
}
