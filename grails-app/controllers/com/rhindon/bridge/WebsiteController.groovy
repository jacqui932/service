package com.rhindon.bridge

import com.rhindon.bridge.filter.BridgeEventFilter
import com.rhindon.bridge.filter.ClubFilter
import com.rhindon.bridge.filter.HeatFilter
import com.rhindon.bridge.filter.PlayerFilter
import com.rhindon.bridge.multitenant.BridgeEvent
import com.rhindon.bridge.multitenant.EventEntry
import grails.gorm.transactions.Transactional

import static org.springframework.http.HttpStatus.CREATED

class WebsiteController {

    static responseFormats = ['json']

    def clubService

    def bridgeEventService

    def heatService

    def eventEntryService

//    def bridgeEmailService

    def playerService

    def clubs() {
        respond clubService.search(new ClubFilter(request.JSON))
    }

    def eventSummaries() {
        respond bridgeEventService.search(new BridgeEventFilter(request.JSON))
    }

    def heats() {
        respond heatService.search(new HeatFilter(request.JSON))
    }

    def event(Long id) {
        respond BridgeEvent.get(id)
    }

    def entries(Long id) {
        respond EventEntry.findAllByEvent(BridgeEvent.get(id), [fetch:[players:"join"]])
    }

    @Transactional
    def saveEntry(EventEntry eventEntry) {
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
        respond eventEntry
    }

//    def thankyou() {
//        bridgeEmailService.afterEventReport()
//    }
}
