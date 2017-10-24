package com.rhindon.bridge

import com.rhindon.bridge.filter.EventEntryFilter
import com.rhindon.bridge.filter.PlayerFilter
import com.rhindon.bridge.multitenant.EventEntry
import grails.gorm.transactions.Transactional
import grails.rest.RestfulController

import static org.springframework.http.HttpStatus.CREATED

class EventEntryController extends RestfulController<EventEntry> {

	static responseFormats = ['json']

    def eventEntryService

    def playerService

    EventEntryController() {
        super(EventEntry)
    }

    def search() {
        respond eventEntryService.search(new EventEntryFilter(request.JSON))
    }

    @Transactional
    def savethis(EventEntry eventEntry) {
        if (eventEntry == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (eventEntry.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond eventEntry.errors, view:'create'
            return
        }

        eventEntry.players.forEach({
            if (it.ebuNumber == null) {
                def players = playerService.search(new PlayerFilter(firstName: it.firstName, lastName: it.lastName))
                if (players.size() == 1) {
                    it.ebuNumber = players.get(0).ebuNumber
                }
            }
        })
        eventEntryService.saveEventEntry(eventEntry)

        request.withFormat {
            '*' { respond eventEntry, [status: CREATED] }
        }
    }
}
