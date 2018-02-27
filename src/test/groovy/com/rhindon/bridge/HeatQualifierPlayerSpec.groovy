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
class HeatQualifierPlayerSpec extends Specification {

    void "test updating a heat qualifier player"() {
        expect:
        false
    }

    void "test creating a new heat qualifier player"() {
        expect:
        false
    }

    void "test deleting a heat qualifier player by id"() {
        expect:
        false
    }

    void "test searching for heat qualifier players"() {
        expect:
        false
    }
}
