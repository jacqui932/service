package com.rhindon.bridge

import com.rhindon.bridge.exception.ChargeException
import com.rhindon.bridge.multitenant.BridgeEvent
import com.rhindon.bridge.multitenant.EventEntry
import com.stripe.exception.CardException
import com.stripe.model.Charge
import com.stripe.net.RequestOptions
import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.transactions.Transactional

@Transactional
class ChargeService {

    def eventEntryService

    def onlineChargeAmount(BridgeEvent bridgeEvent) {
        return bridgeEvent.season.instance.swallowOnlineCosts ? 0 : Double.valueOf(bridgeEvent.cost * 0.014).intValue() + 20
    }

    def charge(EventEntry eventEntry) {
        def requestOptions = (new RequestOptions.RequestOptionsBuilder()).setApiKey(
                eventEntry.event.season.instance.getActiveStripeKey()).build();
        def chargeParams = [
                'amount': eventEntry.event.cost + onlineChargeAmount(eventEntry.event),
                'currency': 'gbp',
                'card': request.JSON.token,
                'description': eventEntry.event.name,
                'receipt_email': eventEntry.email,
                "metadata": ['eventEntryId': eventEntry.id]
        ]
        try {
            Charge.create(chargeParams, requestOptions)
            eventEntry.setPaymentMethod('Card')
            eventEntryService.saveEventEntry(eventEntry)
        } catch(CardException e) {
            throw new ChargeException("There was an error processing the card", e)
        }
    }
}
