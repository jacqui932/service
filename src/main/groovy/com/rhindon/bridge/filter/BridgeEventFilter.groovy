package com.rhindon.bridge.filter

import grails.validation.Validateable

class BridgeEventFilter implements Validateable {

    Boolean active
    boolean todayOrLater
    String competitionType
    boolean activeHeatsOnly
    Long season
    Integer year
}
