package com.rhindon.bridge

import com.rhindon.bridge.multitenant.BankAccount
import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import io.restassured.RestAssured
import spock.lang.Specification

import static io.restassured.RestAssured.expect
import static io.restassured.RestAssured.when
import static org.hamcrest.Matchers.equalTo

@Integration
@Rollback
class WebsiteSpec extends Specification {

    void "test getting the event summaries"() {
        expect:
        false
    }

    void "test getting a list of clubs"() {
        expect:
        false
    }

    void "test getting a list of heats"() {
        expect:
        false
    }

    void "test getting a list of entries for the given id"() {
        expect:
        false
    }

    void "test getting an event by id"() {
        expect:
        false
    }

    void "test looking up a player by ebu number"() {
        expect:
        false
    }

    void "test creating a new event entry"() {
        expect:
        false
    }
}
