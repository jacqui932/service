package com.rhindon.bridge.multitenant

import grails.gorm.MultiTenant
import grails.rest.Resource

@Resource(readOnly = false, formats = ['json'])
class ClubContact {

    Club club
    String name
    String email
    String telephoneNumber
    String role

    static constraints = {
        email nullable: true
        telephoneNumber nullable: true
    }
}
