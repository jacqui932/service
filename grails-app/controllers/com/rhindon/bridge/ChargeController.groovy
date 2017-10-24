package com.rhindon.bridge

import com.rhindon.bridge.exception.ChargeException
import com.rhindon.bridge.multitenant.BridgeEvent
import com.rhindon.bridge.multitenant.EventEntry

import static grails.gorm.multitenancy.Tenants.withCurrent

class ChargeController {

	static responseFormats = ['json']

    def chargeService

    def onlineChargeAmount(Long id) {
        render chargeService.onlineChargeAmount(BridgeEvent.get(id))
    }

    def save() {
        if (!request.JSON.eventEntryId) {
            throw new ChargeException("The event entry id was not in the request")
        }
        EventEntry eventEntry = withCurrent { EventEntry.get(request.JSON.eventEntryId) }
        if (!eventEntry) {
            throw new ChargeException("The event entry could not be found")
        }
        respond chargeService.charge(eventEntry)
    }
}
