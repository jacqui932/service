package com.rhindon.bridge

import com.rhindon.bridge.multitenant.BankAccount
import grails.rest.RestfulController

class BankAccountController extends RestfulController<BankAccount> {

    static responseFormats = ['json']

//    def bankAcService

    BankAccountController() {
        super(BankAccount)
    }

//    def search() {
//        respond clubService.search(new ClubFilter(request.JSON))
//    }
}
