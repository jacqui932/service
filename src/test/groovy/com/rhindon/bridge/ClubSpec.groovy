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
class ClubSpec extends Specification {

    void "test updating a club"() {
        expect:
        false
    }

    void "test creating a club"() {
        expect:
        false
    }

    void "test deleting a club by id"() {
        expect:
        false
    }

    void "test getting a club by id"() {
        expect:
        false
    }

    void "test searching for clubs"() {
        expect:
        false
    }
}
