package com.rhindon.bridge

import com.rhindon.bridge.filter.BridgeEventFilter
import com.rhindon.bridge.multitenant.BridgeEvent
import com.rhindon.bridge.view.EventSummary
import grails.rest.RestfulController

class BridgeEventController extends RestfulController<BridgeEvent> {

	static responseFormats = ['json']

//    def bridgeEventService

    BridgeEventController() {
        super(BridgeEvent)
    }

    def search() {
        respond EventSummary.all
        //bridgeEventService.search(new BridgeEventFilter(request.JSON))
    }
}
