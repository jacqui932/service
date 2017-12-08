package com.rhindon.bridge

import grails.rest.Resource

@Resource(readOnly = true, formats = ['json'])
class County {

    String code
    String name
    String domain

    static constraints = {
        code nullable: false, minSize: 3, maxSize: 3
        name nullable: false
        domain nullable: true
        version false
        id name: 'code', column: 'code', generator: 'assigned'
    }
}
