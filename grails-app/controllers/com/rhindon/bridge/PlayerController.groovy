package com.rhindon.bridge

import com.rhindon.bridge.filter.PlayerFilter
import grails.rest.RestfulController

class PlayerController extends RestfulController<Player> {

    static responseFormats = ['json']

    def playerService

    PlayerController() {
        super(Player)
    }

    def lookup(Long ebuNumber) {
        respond Player.findByEbuNumber(ebuNumber)
    }

    def search() {
        respond playerService.search(new PlayerFilter(request.JSON))
    }
}
