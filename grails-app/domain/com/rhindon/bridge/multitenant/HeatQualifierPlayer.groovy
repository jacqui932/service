package com.rhindon.bridge.multitenant

import grails.rest.Resource

@Resource(readOnly = false, formats = ['json'])
class HeatQualifierPlayer {

    Long ebuNumber
    String firstName
    String lastName
    HeatQualifier heatQualifier

    static mapping = {
        heatQualifier column: 'heat_qualifier_id'
    }
}
