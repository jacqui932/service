package com.rhindon.bridge

import com.rhindon.bridge.filter.ClubFilter
import com.rhindon.bridge.multitenant.Club
import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.transactions.Transactional

@Transactional
class ClubService {

    def search(ClubFilter filter) {
        Club.createCriteria().list {
            if (filter.heat) {
                heats {
                    idEq(filter.heat)
                }
            }
            if (filter.active != null) {
                if (filter.active) {
                    eq("active", true)
                } else {
                    eq("active", false)
                }
            }
        }
    }
}
