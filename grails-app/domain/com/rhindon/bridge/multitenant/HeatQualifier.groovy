package com.rhindon.bridge.multitenant

import grails.rest.Resource

@Resource(readOnly = false, formats = ['json'])
class HeatQualifier {

    static hasMany = [heatQualifierPlayers:HeatQualifierPlayer]

    Heat heat
    EventEntry eventEntry
    boolean withdrawn

    static mapping = {
        heat column: 'heat'
    }

    static constraints = {
        eventEntry nullable: true
    }
}
