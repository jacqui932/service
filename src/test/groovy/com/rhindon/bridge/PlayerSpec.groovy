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
class PlayerSpec extends Specification {

    void "test looking up a player by ebu number"() {
        expect:
        false
    }
}
