package com.rhindon.bridge

import com.rhindon.bridge.multitenant.Heat
import com.rhindon.bridge.multitenant.HeatQualifier
import com.rhindon.bridge.multitenant.HeatQualifierPlayer

class UploadController {

    def upload(Long heatId) {
        Heat heat = Heat.get(heatId)

        def qualified = request.JSON.findAll {it -> it.qualified}
        qualified.each {it ->
            def heatQualifier = new HeatQualifier([heat: heat]).save(true)
            it.players.each {it2 ->
                new HeatQualifierPlayer([heatQualifier: heatQualifier, firstName: it2.firstName,
                                         lastName: it2.lastName, ebuNumber: it2.ebuNumber as Long]).save(true)
            }
        }
    }
}
