package com.rhindon.bridge

import grails.rest.Resource

@Resource(readOnly = true, formats = ['json'])
class MasterpointGrade {

    String name

    static constraints = {
        name blank: false
    }
}
