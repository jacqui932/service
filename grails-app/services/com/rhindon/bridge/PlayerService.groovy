package com.rhindon.bridge

import com.rhindon.bridge.filter.PlayerFilter
import grails.gorm.transactions.Transactional

@Transactional
class PlayerService {

    def search(PlayerFilter filter) {
        Player.createCriteria().list {
            if (filter.ebuNumber) {
                eq("ebuNumber", filter.ebuNumber)
            }
            if (filter.firstName) {
                eq("firstName", filter.firstName)
            }
            if (filter.lastName) {
                eq("lastName", filter.lastName)
            }
        }
    }
}
