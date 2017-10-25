package com.rhindon.bridge.multitenant

import grails.gorm.MultiTenant
import grails.rest.Resource

@Resource(readOnly = false, formats = ['json'])
class EventEntryPlayer {

    EventEntry eventEntry
    Long ebuNumber
    String firstName
    String lastName
    BigDecimal victorLudorumPoints

    static constraints = {
        firstName blank: false
        lastName blank: false
        ebuNumber nullable: true
        victorLudorumPoints scale: 2, nullable: true, max: 99.99
    }
}
