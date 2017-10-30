package com.rhindon.bridge

import com.rhindon.bridge.filter.EventEntryPlayerFilter
import com.rhindon.bridge.multitenant.EventEntryPlayer
import org.hibernate.criterion.CriteriaSpecification

class EventEntryPlayerService {

    def search(EventEntryPlayerFilter filter) {
        EventEntryPlayer.createCriteria().list {
            createAlias('eventEntry', 'ee', CriteriaSpecification.LEFT_JOIN)
            if (filter.event) {
                createAlias('ee.event', 'e', CriteriaSpecification.LEFT_JOIN)
                eq("e.id", filter.event)
            }
            if (filter.victorLudorumOnly) {
                isNotNull("victorLudorumPoints")
            }
            if (filter.eventEntry) {
                eq("ee.id", filter.eventEntry)
            }
        }
    }
}
