package com.rhindon.bridge

import com.rhindon.bridge.filter.HeatFilter
import com.rhindon.bridge.multitenant.Heat
import grails.rest.RestfulController

class HeatController extends RestfulController<Heat> {

    static responseFormats = ['json']

    def heatService

    HeatController() {
        super(Heat)
    }

    def search() {
        respond heatService.search(new HeatFilter(request.JSON))
    }
}
