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
class ClubContactSpec extends Specification {

    void "test updating a club contact"() {
        expect:
        false
    }

    void "test creating a club contact"() {
        expect:
        false
    }

    void "test deleting a club contact"() {
        expect:
        false
    }

    void "test searching for club contacts"() {
        expect:
        false
    }
}
