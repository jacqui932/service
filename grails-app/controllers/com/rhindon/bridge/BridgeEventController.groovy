package com.rhindon.bridge

import com.rhindon.bridge.multitenant.BridgeEvent
import com.rhindon.bridge.multitenant.Season
import com.rhindon.bridge.view.EventSummary
import grails.rest.RestfulController

class BridgeEventController extends RestfulController<BridgeEvent> {

	static responseFormats = ['json']

    BridgeEventController() {
        super(BridgeEvent)
    }

    def search() {
        respond EventSummary.findAllBySeason(Season.get(request.JSON.season))
    }
}
