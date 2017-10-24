package com.rhindon.bridge

import com.rhindon.bridge.filter.ClubContactFilter
import com.rhindon.bridge.multitenant.Club
import com.rhindon.bridge.multitenant.ClubContact
import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.transactions.Transactional

@Transactional
class ClubContactService {

    def search(ClubContactFilter filter) {
        ClubContact.createCriteria().list {
            if (filter.club) {
                eq("club", Club.get(filter.club))
            }
        }
    }
}
