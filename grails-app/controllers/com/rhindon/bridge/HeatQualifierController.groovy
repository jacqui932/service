package com.rhindon.bridge

import com.rhindon.bridge.multitenant.EventEntry
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

    def unmatched(Long heatId) {
        respond EventEntry.findAllByHeatAndHeatQualifiersIsEmpty(Heat.get(heatId))
    }

    def link() {
        def heatQualifier = HeatQualifier.get(request.JSON.heatQualifierId)
        heatQualifier.setEventEntry(EventEntry.get(request.JSON.eventEntryId))
        heatQualifier.save(flush: true)
        respond 200
    }
}
