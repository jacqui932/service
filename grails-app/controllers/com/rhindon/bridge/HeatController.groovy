package com.rhindon.bridge

import com.rhindon.bridge.filter.HeatFilter
import com.rhindon.bridge.multitenant.Heat
import com.rhindon.bridge.view.HeatQualifiersSummary
import grails.rest.RestfulController
import groovy.xml.DOMBuilder
import groovy.xml.dom.DOMCategory

class HeatController extends RestfulController<Heat> {

    static responseFormats = ['json']

    def heatService

    HeatController() {
        super(Heat)
    }

    def search() {
        respond heatService.search(new HeatFilter(request.JSON))
    }

    def upload() {
        def reader = new StringReader(pairs)
        def doc = DOMBuilder.parse(reader)
        def records = doc.documentElement

        use(DOMCategory) {
            respond records.USEBIO.EVENT
        }
    }

    def clubSummaries(Long clubId) {
        respond HeatQualifiersSummary.findAllByClubIdAndSeasonId(clubId, 2)
    }

    def eventSummaries(Long eventId) {
        respond HeatQualifiersSummary.findAllByEventIdAndSeasonId(eventId, 2)
    }
}
