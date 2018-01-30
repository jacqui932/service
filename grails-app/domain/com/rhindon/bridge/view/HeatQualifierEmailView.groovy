package com.rhindon.bridge.view

import grails.rest.Resource

@Resource(readOnly = true, formats = ['json'])
class HeatQualifierEmailView {

    String clubName
    String firstName
    String email
    Long heatQualifierId
    Date eventDate
    Date dateTime
    Long eventId
    String eventName

    static constraints = {
        version false
    }
}
