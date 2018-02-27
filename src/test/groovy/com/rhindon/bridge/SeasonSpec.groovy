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
class SeasonSpec extends Specification {

    void "test getting the list of seasons"() {
        expect:
        false
    }

    void "test updating a season"() {
        expect:
        false
    }

    void "test creating a season"() {
        expect:
        false
    }

    void "test deleting a season by id"() {
        expect:
        false
    }
}
