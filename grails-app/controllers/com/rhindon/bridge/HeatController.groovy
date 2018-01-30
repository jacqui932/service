package com.rhindon.bridge

import com.rhindon.bridge.filter.HeatFilter
import com.rhindon.bridge.multitenant.Heat
import com.rhindon.bridge.view.HeatQualifiersSummary
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

    def clubSummaries(Long clubId) {
        respond HeatQualifiersSummary.findAllByClubIdAndSeasonId(clubId, 2)
    }

    def eventSummaries(Long eventId) {
        respond HeatQualifiersSummary.findAllByEventIdAndSeasonId(eventId, 2)
    }
}
