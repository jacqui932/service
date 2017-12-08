package com.rhindon.bridge

import grails.rest.Resource

@Resource(readOnly = true, formats = ['json'])
class RankCode {

    static hasMany = [playerRankCodes: PlayerRankCode]

    Long externalCode
    String name

    static constraints = {
        externalCode nullable: false
        name nullable: false
        version false
    }

    static mapping = {
        externalCode sqlType: "integer"
    }
}
