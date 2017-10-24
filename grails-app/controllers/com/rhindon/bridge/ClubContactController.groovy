package com.rhindon.bridge

import com.rhindon.bridge.filter.ClubContactFilter
import com.rhindon.bridge.multitenant.ClubContact
import grails.rest.RestfulController

class ClubContactController extends RestfulController<ClubContact> {

    static responseFormats = ['json']

    def clubContactService

    ClubContactController() {
        super(ClubContact)
    }

    def search() {
        respond clubContactService.search(new ClubContactFilter(request.JSON))
    }
}
