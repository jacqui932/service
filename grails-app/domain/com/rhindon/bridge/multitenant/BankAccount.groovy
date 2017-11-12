package com.rhindon.bridge.multitenant

class BankAccount {

    String name
    String stripeApiKey
    String stripeApiTestKey
    boolean stripeProductionMode
    String bankAccountNumber
    String sortCode
    String chequePayee
    String chequeAddress

    String getActiveStripeKey() {
        return stripeProductionMode ? stripeApiKey : stripeApiTestKey;
    }

    static constraints = {
        name nullable: false
        stripeApiKey nullable: true
        stripeApiTestKey nullable: true
        bankAccountNumber nullable: true
        sortCode nullable:  true
        chequePayee nullable: true
        chequeAddress nullable: true
    }
}
