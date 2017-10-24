package com.rhindon.bridge.multitenant

import grails.gorm.MultiTenant
import grails.rest.Resource

@Resource(readOnly = false, formats = ['json'])
class Club {

    static hasMany = [contacts:ClubContact, heats:Heat]

    String name
    String address
    boolean active = true

    static constraints = {
        name nullable: false
    }

    static mapping = {
        sort name:"asc"
    }
}
