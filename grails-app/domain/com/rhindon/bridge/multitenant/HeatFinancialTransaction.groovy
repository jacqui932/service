package com.rhindon.bridge.multitenant

import grails.rest.Resource

@Resource(readOnly = false, formats = ['json'])
class HeatFinancialTransaction {

    Heat heat
    String paymentMethod
    BigDecimal amount
    Date datePaid
    Date dateCleared
    String paymentRef

    static constraints = {
        paymentMethod nullable: false, inList: ['Bank Transfer', 'Card', 'Cash', 'Cheque']
        amount scale: 2, nullable: false, max: 9999.99
        paymentRef nullable: true
        dateCleared nullable: true
    }
}
