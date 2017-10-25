package com.rhindon.bridge

import grails.gorm.MultiTenant
import grails.rest.Resource

@Resource(readOnly = true, formats = ['json'])
class Instance {

    String name
    String domain
    String entryConfirmationEmailAddresses
    String entryConfirmationSignature
    String heatUpdatedEmailAddresses
    String stripeApiKey
    String stripeApiTestKey
    boolean stripeProductionMode
    boolean swallowOnlineCosts
    String bankAccountNumber
    String sortCode
    String chequePayee
    String chequeAddress
    String bannerColour

//    static constraints = {
//        name nullable: false
//        entryConfirmationEmailAddresses nullable: true
//        heatUpdatedEmailAddresses nullable: true
//        stripeApiKey nullable: true
//        stripeApiTestKey nullable: true
//        chequePayee nullable: true
//        chequeAddress nullable: true
//    }

    String getActiveStripeKey() {
        return stripeProductionMode ? stripeApiKey : stripeApiTestKey;
    }
}
