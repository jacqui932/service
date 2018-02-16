package com.rhindon.bridge.multitenant

import grails.rest.Resource

@Resource(readOnly = false, formats = ['json'])
class EventEntry {

    List players
    static hasMany = [
            players:EventEntryPlayer,
            financialTransactions:FinancialTransaction,
            heatQualifiers:HeatQualifier]

    BridgeEvent event
    String name
    String email
    String paymentMethod = 'Not Paid'
    Date dateEntered = new Date()
    Heat heat
    String comments
    Club club
    boolean withdrawn
    boolean fullyPaid

    static mapping = {
        players cascade: 'all-delete-orphan'
        financialTransactions cascade: 'all-delete-orphan'
        event column: 'event'
        heat column: 'heat'
    }

    static constraints = {
        event nullable: false
        name nullable: false
        email nullable: false, email: true

        // TODO: Remove not paid after migration (and from default above in field list)
        paymentMethod nullable: false, inList: ['Cheque or Bank Transfer', 'Card',
                                                'Pay On The Day', 'Cheque', 'Bank Transfer']
        dateEntered nullable: false
        heat nullable: true
        comments nullable: true
        club nullable: true
    }
}
