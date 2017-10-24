package com.rhindon.bridge

import com.rhindon.bridge.filter.PlayerFilter

class PlayerController {

	static responseFormats = ['json']

    def playerService

    def search() {
        respond playerService.search(new PlayerFilter(request.JSON))
    }
}
