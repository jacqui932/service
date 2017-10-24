package com.rhindon.bridge

import com.rhindon.bridge.filter.EventEntryPlayerFilter
import com.rhindon.bridge.multitenant.EventEntry
import com.rhindon.bridge.multitenant.EventEntryPlayer
import grails.rest.RestfulController

class EventEntryPlayerController extends RestfulController<EventEntryPlayer> {

    static responseFormats = ['json']

    EventEntryPlayerController() {
        super(EventEntryPlayer)
    }

    def search() {
        def filter = new EventEntryPlayerFilter(request.JSON)
        respond EventEntryPlayer.createCriteria().list {
            if (filter.eventEntry) {
                eq("eventEntry", EventEntry.get(filter.eventEntry))
            }
        }
    }
}
