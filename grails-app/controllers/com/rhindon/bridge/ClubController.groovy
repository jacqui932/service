package com.rhindon.bridge

import com.rhindon.bridge.multitenant.Club
import com.rhindon.bridge.view.ClubQualifiersSummary
import grails.rest.RestfulController

class ClubController extends RestfulController<Club> {

    static responseFormats = ['json']

    ClubController() {
        super(Club)
    }

    def search() {
        respond ClubQualifiersSummary.all
    }
}
