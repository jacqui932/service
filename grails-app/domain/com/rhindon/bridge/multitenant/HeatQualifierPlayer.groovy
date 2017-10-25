package com.rhindon.bridge.multitenant

import grails.rest.Resource

@Resource(readOnly = false, formats = ['json'])
class HeatQualifierPlayer {

    HeatQualifier heatQualifier
    Long ebuNumber
    String firstName
    String lastName
}
