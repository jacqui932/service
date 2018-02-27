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
class EventEntryPlayerSpec extends Specification {

    void "test updating an event entry player"() {
        expect:
        false
    }

    void "test creating an event entry player"() {
        expect:
        false
    }

    void "test deleting an event entry player"() {
        expect:
        false
    }

    void "test searching for event entry players"() {
        expect:
        false
    }
}
