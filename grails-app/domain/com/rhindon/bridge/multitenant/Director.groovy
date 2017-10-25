package com.rhindon.bridge.multitenant

import grails.rest.Resource

@Resource(readOnly = false, formats = ['json'])
class Director {

    String name
    String email
    String telephoneNumber

    static constraints = {
        email nullable: true
        telephoneNumber nullable: true
    }
}
