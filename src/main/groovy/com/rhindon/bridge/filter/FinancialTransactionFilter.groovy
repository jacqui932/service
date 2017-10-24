package com.rhindon.bridge.filter

import grails.validation.Validateable

class FinancialTransactionFilter implements Validateable {

    Long eventEntry
    Long year
    Long month
}
