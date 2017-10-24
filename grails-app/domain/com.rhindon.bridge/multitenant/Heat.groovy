package com.rhindon.bridge.multitenant

import grails.gorm.MultiTenant
import grails.rest.Resource

@Resource(readOnly = false, formats = ['json'])
class Heat {

    static belongsTo = BridgeEvent
    static hasMany = [eventEntries:EventEntry]

    Date dateTime
    Club club
    BridgeEvent event
    String visitorsInfo

    static mapping = {
        sort dateTime:"asc"
    }

    static constraints = {
        visitorsInfo nullable: true
    }
}
