package com.rhindon.bridge

import com.rhindon.bridge.filter.BridgeEventFilter
import com.rhindon.bridge.multitenant.BridgeEvent
import com.rhindon.bridge.multitenant.Season
import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.transactions.Transactional
import org.hibernate.sql.JoinType

@Transactional
class BridgeEventService {

    def search(BridgeEventFilter filter) {
        BridgeEvent.createCriteria().listDistinct {
            createAlias("entries","entries", JoinType.LEFT_OUTER_JOIN)
            createAlias("heats","heats", JoinType.LEFT_OUTER_JOIN)
            createAlias("season","season", JoinType.LEFT_OUTER_JOIN)
            createAlias("venue","venue", JoinType.LEFT_OUTER_JOIN)
            if (filter.active != null) {
                if (filter.active) {
                    eq("active", true)
                } else {
                    eq("active", false)
                }
            }
            if (filter.todayOrLater) {
                ge("dateTime", new Date())
            }
            if (filter.year) {
                ge("dateTime", new Date(filter.year - 1900, 0, 1))
                le("dateTime", new Date(filter.year, 11, 31))
            }
            if (filter.competitionType) {
                if (filter.competitionType == 'pairs') {
                    eq("competitionType", "pairs")
                }
                if (filter.competitionType == 'teams') {
                    or {
                        eq("competitionType", "teamsOfFour")
                        eq("competitionType", "teamsOfEight")
                    }
                }
            }
            if (filter.activeHeatsOnly) {
                or {
                    eq("clubHeats", false)
                    heats {
                        le("dateTime", new Date())
                    }
                }
            }
            if (filter.season) {
                eq("season", Season.get(filter.season))
            }
            order("dateTime", "asc")
        }
    }
}
