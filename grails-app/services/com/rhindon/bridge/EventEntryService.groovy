package com.rhindon.bridge

import com.rhindon.bridge.filter.EventEntryFilter
import com.rhindon.bridge.multitenant.BridgeEvent
import com.rhindon.bridge.multitenant.EventEntry
import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.transactions.Transactional

@Transactional
class EventEntryService {

    def bridgeEmailService

    def saveEventEntry(EventEntry eventEntry) {
        eventEntry.save(failOnError: true)
        bridgeEmailService.sendMail(eventEntry)
    }

    def search(EventEntryFilter filter) {
        EventEntry.createCriteria().list {
            if (filter.event) {
                eq("event", BridgeEvent.get(filter.event))
            }
            if (filter.withdrawn) {
                eq("withdrawn", filter.withdrawn)
            }
        }
    }
}
