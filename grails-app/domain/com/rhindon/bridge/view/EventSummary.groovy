package com.rhindon.bridge.view

import com.rhindon.bridge.multitenant.Season
import grails.rest.Resource

@Resource(readOnly = true, formats = ['json'])
class EventSummary {

    String name
    String masterpointType
    boolean active
    Date dateTime
    Season season
    Long entries
    Long unpaidPayInAdvanceCount
    Long unpaidPayOnTheDayCount

    static mapping = {
        sort "dateTime"
        version false
    }
}
