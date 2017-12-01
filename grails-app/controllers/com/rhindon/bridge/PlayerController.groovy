package com.rhindon.bridge

import com.rhindon.bridge.filter.PlayerFilter
import com.rhindon.bridge.Player

class PlayerController {

	static responseFormats = ['json']

    def playerService

    def lookup(Long ebuNumber) {
        respond Player.findByEbuNumber(ebuNumber)
    }

    def search() {
        respond playerService.search(new PlayerFilter(request.JSON))
    }
}
