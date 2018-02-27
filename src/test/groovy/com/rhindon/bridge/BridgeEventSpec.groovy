package com.rhindon.bridge

import com.rhindon.bridge.multitenant.BankAccount
import com.rhindon.bridge.multitenant.BridgeEvent
import com.rhindon.bridge.multitenant.Season
import com.rhindon.bridge.multitenant.Venue
import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import io.restassured.RestAssured
import spock.lang.Specification

@Integration
@Rollback
class BridgeEventSpec extends Specification {

    static BridgeEvent bridgeEvent1

    static Date date = new Date()

    private static final String NAME = 'Name 1'

    private static final String DESCRIPTION = 'Description 1'

    private static final Integer COST = 123

    private static final String MASTERPOINT_TYPE = 'Green'

    private static final String COMPETITION_TYPE = 'pairs'

    private static final boolean ACTIVE = false

    private static final boolean CLUB_HEATS = false

    private static final boolean CLUB_REPRESENTATIVE = false

    private static final String ENTRY_CONFIRMATION_EMAIL_ADDRESSES = 'Email Addresses 1'

    private static final String MORE_INFO = 'More Info 1'

    private static final boolean ALLOW_PAY_ON_THE_DAY = false

    private static final boolean VICTOR_LUDORUM = false

    void setup() {
        RestAssured.port = serverPort
        def venue = new Venue().save(flush: true)
        def season = new Season().save(flush: true)
        def bankAccount = new BankAccount(name: 'Bank Account').save(flush: true)

        bridgeEvent1 = new BridgeEvent(
                season: season,
                name: NAME,
                description: DESCRIPTION,
                dateTime: date,
                venue: venue,
                cost: COST,
                masterpointType: MASTERPOINT_TYPE,
                competitionType: COMPETITION_TYPE,
                active: ACTIVE,
                clubHeats: CLUB_HEATS,
                clubRepresentative: CLUB_REPRESENTATIVE,
                entryConfirmationEmailAddresses: ENTRY_CONFIRMATION_EMAIL_ADDRESSES,
                moreInfo: MORE_INFO,
                allowPayOnTheDay: ALLOW_PAY_ON_THE_DAY,
                victorLudorum: VICTOR_LUDORUM,
                bankAccount: bankAccount
        ).save(flush: true)
        new BridgeEvent(
                season: season,
                name: 'Name 2',
                description: 'Description 2',
                dateTime: date,
                venue: venue,
                cost: 321,
                masterpointType: 'Blue',
                competitionType: 'teamsOfFour',
                active: true,
                clubHeats: true,
                clubRepresentative: true,
                entryConfirmationEmailAddresses: 'Email Addresses 2',
                moreInfo: 'More Info',
                allowPayOnTheDay: true,
                victorLudorum: true,
                bankAccount: bankAccount
        ).save(flush: true)
    }

    void "test updating name"() {
        expect:
        false
    }

    void "test updating description"() {
        expect:
        false
    }

    void "test updating date time"() {
        expect:
        false
    }

    void "test updating venue"() {
        expect:
        false
    }

    void "test updating cost"() {
        expect:
        false
    }

    void "test updating masterpoint type"() {
        expect:
        false
    }

    void "test updating competition type"() {
        expect:
        false
    }

    void "test updating active"() {
        expect:
        false
    }

    void "test updating club heats"() {
        expect:
        false
    }

    void "test updating club representative"() {
        expect:
        false
    }

    void "test updating entry confirmation email addresses"() {
        expect:
        false
    }

    void "test updating more info"() {
        expect:
        false
    }

    void "test updating pay on the day"() {
        expect:
        false
    }

    void "test updating victor ludorum"() {
        expect:
        false
    }

    void "test updating bank account"() {
        expect:
        false
    }

    void "test creating a bridge event"() {
        expect:
        false
    }

    void "test getting a bridge event by id"() {
        expect:
        false
    }

    void "test deleting a bridge event by id"() {
        expect:
        false
    }

    void "test searching for bridge events by season id"() {
        expect:
        false
    }

    void "test searching for bridge events by competition type"() {
        expect:
        false
    }

    void "test searching for bridge events by not played only"() {
        expect:
        false
    }

    void "test limiting fields returned to those given"() {
        expect:
        false
    }
}
