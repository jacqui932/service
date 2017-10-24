package com.rhindon.bridge

import com.rhindon.bridge.filter.EventEntryPlayerFilter
import com.rhindon.bridge.multitenant.EventEntryPlayer

class EventEntryPlayerService {

    def search(EventEntryPlayerFilter filter) {
        EventEntryPlayer.createCriteria().list {
            if (filter.victorLudorumOnly) {
                isNotNull("victorLudorumPoints")
            }
            if (filter.eventEntry) {
                eq("eventEntry.id", filter.eventEntry)
            }
        }
    }
}
