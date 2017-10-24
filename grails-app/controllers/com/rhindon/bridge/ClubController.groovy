package com.rhindon.bridge

import com.rhindon.bridge.filter.ClubFilter
import com.rhindon.bridge.multitenant.Club
import grails.rest.RestfulController

class ClubController extends RestfulController<Club> {

    static responseFormats = ['json']

    def clubService

    ClubController() {
        super(Club)
    }

    def search() {
        respond clubService.search(new ClubFilter(request.JSON))
    }
}
