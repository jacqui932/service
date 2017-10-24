package com.rhindon.bridge.multitenant

import grails.gorm.MultiTenant
import grails.rest.*

@Resource(readOnly = false, formats = ['json'])
class Venue {

    String addressLine_1
    String addressLine_2
    String addressLine_3
    String addressLine_4
    String postcode

    static constraints = {
        addressLine_1 maxSize: 100, nullable: true
        addressLine_2 maxSize: 45, nullable: true
        addressLine_3 maxSize: 45, nullable: true
        addressLine_4 maxSize: 45, nullable: true
        postcode maxSize: 45, nullable: true
    }

    static mapping = {
        sort addressLine_1:"asc"
    }
}
