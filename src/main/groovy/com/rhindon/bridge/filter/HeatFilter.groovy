package com.rhindon.bridge.filter

import grails.validation.Validateable

class HeatFilter implements Validateable {

    Long event
    Long club
    boolean alreadyPlayed = false
}
