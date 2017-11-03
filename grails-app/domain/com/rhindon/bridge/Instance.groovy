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
    boolean swallowOnlineCosts

    static constraints = {
        entryConfirmationEmailAddresses nullable: true
        heatUpdatedEmailAddresses nullable: true
    }
}
