package com.rhindon.bridge

import com.rhindon.bridge.filter.EventEntryFilter
import com.rhindon.bridge.multitenant.EventEntry
import grails.rest.RestfulController

class EventEntryController extends RestfulController<EventEntry> {

	static responseFormats = ['json']

    def eventEntryService

    def playerService

    EventEntryController() {
        super(EventEntry)
    }

    def summary() {
        respond eventEntryService.search(new EventEntryFilter(request.JSON))
    }
}
