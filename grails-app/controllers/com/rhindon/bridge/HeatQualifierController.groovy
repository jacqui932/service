package com.rhindon.bridge

import com.rhindon.bridge.multitenant.Heat
import com.rhindon.bridge.multitenant.HeatQualifier
import grails.rest.RestfulController

class HeatQualifierController extends RestfulController<HeatQualifier> {

    static responseFormats = ['json']

    HeatQualifierController() {
        super(HeatQualifier)
    }

    def search(Long heatId) {
        respond HeatQualifier.findAllByHeat(Heat.get(heatId))
    }
}
