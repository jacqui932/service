package com.rhindon.bridge

import grails.rest.*

@Resource(readOnly = true, formats = ['json'])
class Player {

    Long ebuNumber
    String firstName
    String lastName
    String countyOfAffiliation
    String email
    MasterpointGrade masterpointGrade

    static constraints = {
        firstName blank: false
        lastName blank: false
        ebuNumber nullable: true
        countyOfAffiliation nullable: true
        email nullable: true
        masterpointGrade nullable: true
    }
}
