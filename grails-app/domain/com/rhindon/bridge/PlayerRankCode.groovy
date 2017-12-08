package com.rhindon.bridge

import grails.rest.Resource

@Resource(readOnly = true, formats = ['json'])
class PlayerRankCode {

    Player player
    RankCode rankCode
    Date startDate
    Date endDate

    static constraints = {
        player nullable: false
        rankCode nullable: false
        startDate nullable: false
        endDate nullable: true
    }

    static mapping = {
        player column: 'player'
        rankCode column: 'rank_code'
        version false
    }
}
