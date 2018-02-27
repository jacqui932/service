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
class EventEntrySpec extends Specification {

    void "test getting a list of event entry summaries"() {
        expect:
        false
    }

    void "test updating an event entry"() {
        expect:
        false
    }

    void "test creating a new event entry"() {
        expect:
        false
    }

    void "test getting an event entry by id"() {
        expect:
        false
    }
}
