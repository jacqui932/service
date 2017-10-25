package com.rhindon.bridge.multitenant

import grails.rest.Resource

@Resource(readOnly = false, formats = ['json'])
class HeatQualifier {

    static belongsTo = Heat
    static hasMany = [heatQualifierPlayers:HeatQualifierPlayer]

    EventEntry eventEntry

    static constraints = {
        eventEntry nullable: true
    }
}
