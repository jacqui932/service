package com.rhindon.bridge

import com.rhindon.bridge.filter.FinancialTransactionFilter
import com.rhindon.bridge.multitenant.FinancialTransaction
import grails.rest.RestfulController

class FinancialTransactionController extends RestfulController<FinancialTransaction> {

    static responseFormats = ['json']

    def financialTransactionService

    FinancialTransactionController() {
        super(FinancialTransaction)
    }

    def search() {
        respond financialTransactionService.search(new FinancialTransactionFilter(request.JSON))
    }
}
