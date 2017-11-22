package com.rhindon.bridge

import com.rhindon.bridge.filter.HeatQualifierFilter
import com.rhindon.bridge.multitenant.HeatQualifier
import grails.rest.RestfulController

class HeatQualifierController extends RestfulController<HeatQualifier> {

    static responseFormats = ['json']

    def heatQualifierService

    HeatQualifierController() {
        super(HeatQualifier)
    }

    def search() {
        respond heatQualifierService.search(new HeatQualifierFilter(request.JSON))
    }
}
