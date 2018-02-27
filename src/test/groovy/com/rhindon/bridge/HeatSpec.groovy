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
class HeatSpec extends Specification {

    void "test getting club summaries"() {
        expect:
        false
    }

    void "test getting event summaries"() {
        expect:
        false
    }

    void "test updating a heat"() {
        expect:
        false
    }

    void "test creating a new heat"() {
        expect:
        false
    }

    void "test deleting a heat by id"() {
        expect:
        false
    }
}
