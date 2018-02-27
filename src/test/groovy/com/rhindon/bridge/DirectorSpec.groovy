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
class DirectorSpec extends Specification {

    void "test getting a list of directors"() {
        expect:
        false
    }

    void "test updating a director"() {
        expect:
        false
    }

    void "test creating a director"() {
        expect:
        false
    }

    void "test deleting a director by id"() {
        expect:
        false
    }

    void "test getting a director by id"() {
        expect:
        false
    }
}
