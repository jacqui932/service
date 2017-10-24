package com.rhindon.bridge.filter

import grails.validation.Validateable

class EventEntryPlayerFilter implements Validateable {

    Long event
    Long eventEntry
    Boolean victorLudorumOnly
}
