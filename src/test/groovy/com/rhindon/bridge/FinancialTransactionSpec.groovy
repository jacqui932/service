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
class FinancialTransactionSpec extends Specification {

    void "test updating a financial transaction"() {
        expect:
        false
    }

    void "test creating a financial transaction"() {
        expect:
        false
    }

    void "test deleting a financial transaction"() {
        expect:
        false
    }
}
