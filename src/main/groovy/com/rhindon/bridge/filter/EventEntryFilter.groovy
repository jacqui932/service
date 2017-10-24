package com.rhindon.bridge.filter

import grails.validation.Validateable

class EventEntryFilter implements Validateable {

    Long event
    Boolean withdrawn
}
