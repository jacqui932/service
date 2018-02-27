package com.rhindon.bridge

import com.rhindon.bridge.multitenant.BankAccount
import grails.testing.mixin.integration.Integration
import grails.transaction.Rollback
import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.apache.http.HttpStatus
import spock.lang.Specification

import static io.restassured.RestAssured.given
import static io.restassured.RestAssured.when
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath
import static org.hamcrest.Matchers.equalTo
import static org.hamcrest.Matchers.hasItems

@Integration
@Rollback
class BankAccountSpec extends Specification {

    static BankAccount bankAccount1

    private static final String NAME = 'Bank Account 1'

    private static final String STRIPE_API_KEY = 'Stripe API Key 1'

    private static final String STRIPE_API_TEST_KEY = 'Stripe API Test Key 1'

    private static final boolean STRIPE_PRODUCTION_MODE = false

    private static final String BANK_ACCOUNT_NUMBER = 'Bank Account Number 1'

    private static final String SORT_CODE = 'Sort Code 1'

    private static final String CHEQUE_PAYEE = 'Cheque Payee 1'

    private static final String CHEQUE_ADDRESS = 'Cheque Address 1'

    void setup() {
        RestAssured.port = serverPort
        bankAccount1 = new BankAccount(
                name: NAME,
                stripeApiKey: STRIPE_API_KEY,
                stripeApiTestKey: STRIPE_API_TEST_KEY,
                stripeProductionMode: STRIPE_PRODUCTION_MODE,
                bankAccountNumber: BANK_ACCOUNT_NUMBER,
                sortCode: SORT_CODE,
                chequePayee: CHEQUE_PAYEE,
                chequeAddress: CHEQUE_ADDRESS
        ).save(flush: true)
        new BankAccount(
                name: 'Bank Account 2',
                stripeApiKey: 'Stripe API Key 2',
                stripeApiTestKey: 'Stripe API Test Key 2',
                stripeProductionMode: true,
                bankAccountNumber: 'Bank Account Number 2',
                sortCode: 'Sort Code 2',
                chequePayee: 'Cheque Payee 2',
                chequeAddress: 'Cheque Address 2'
        ).save(flush: true)
    }

    void cleanup() {
        BankAccount.findAll().each { it.delete(flush: true, failOnError: true) }
    }

    void "test getting a bank account by id"() {
        expect:
        when().get("/bankAccount/{id}", bankAccount1.id)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("bank_account.json"))
                .body("name", equalTo(NAME))
                .body("stripeApiKey", equalTo(STRIPE_API_KEY))
                .body("stripeApiTestKey", equalTo(STRIPE_API_TEST_KEY))
                .body("stripeProductionMode", equalTo(STRIPE_PRODUCTION_MODE))
                .body("bankAccountNumber", equalTo(BANK_ACCOUNT_NUMBER))
                .body("sortCode", equalTo(SORT_CODE))
                .body("chequePayee", equalTo(CHEQUE_PAYEE))
                .body("chequeAddress", equalTo(CHEQUE_ADDRESS))
    }

    void "test getting a bank account by id when not found"() {
        expect:
        when().get("/bankAccount/{id}", 999)
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
    }

    void "test getting a bank account by id when invalid id"() {
        expect:
        when().get("/bankAccount/{id}", 'abcde')
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
    }

    void "test updating a bank account name"() {
        expect:
        given()
                .body('{"name": "Updated Name"}')
                .contentType(ContentType.JSON)
                .when()
                .put("/bankAccount/{id}", bankAccount1.id)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("bank_account.json"))
                .body("name", equalTo("Updated Name"))
                .body("stripeApiKey", equalTo(STRIPE_API_KEY))
                .body("stripeApiTestKey", equalTo(STRIPE_API_TEST_KEY))
                .body("stripeProductionMode", equalTo(STRIPE_PRODUCTION_MODE))
                .body("bankAccountNumber", equalTo(BANK_ACCOUNT_NUMBER))
                .body("sortCode", equalTo(SORT_CODE))
                .body("chequePayee", equalTo(CHEQUE_PAYEE))
                .body("chequeAddress", equalTo(CHEQUE_ADDRESS))
    }

    void "test updating stripe api key"() {
        expect:
        given()
                .body('{"stripeApiKey": "Updated Stripe API Key"}')
                .contentType(ContentType.JSON)
                .when()
                .put("/bankAccount/{id}", bankAccount1.id)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("bank_account.json"))
                .body("name", equalTo(NAME))
                .body("stripeApiKey", equalTo("Updated Stripe API Key"))
                .body("stripeApiTestKey", equalTo(STRIPE_API_TEST_KEY))
                .body("stripeProductionMode", equalTo(STRIPE_PRODUCTION_MODE))
                .body("bankAccountNumber", equalTo(BANK_ACCOUNT_NUMBER))
                .body("sortCode", equalTo(SORT_CODE))
                .body("chequePayee", equalTo(CHEQUE_PAYEE))
                .body("chequeAddress", equalTo(CHEQUE_ADDRESS))
    }

    void "test updating stripe api test key"() {
        expect:
        given()
                .body('{"stripeApiTestKey": "Updated Stripe API Test Key"}')
                .contentType(ContentType.JSON)
                .when()
                .put("/bankAccount/{id}", bankAccount1.id)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("bank_account.json"))
                .body("name", equalTo(NAME))
                .body("stripeApiKey", equalTo(STRIPE_API_KEY))
                .body("stripeApiTestKey", equalTo("Updated Stripe API Test Key"))
                .body("stripeProductionMode", equalTo(STRIPE_PRODUCTION_MODE))
                .body("bankAccountNumber", equalTo(BANK_ACCOUNT_NUMBER))
                .body("sortCode", equalTo(SORT_CODE))
                .body("chequePayee", equalTo(CHEQUE_PAYEE))
                .body("chequeAddress", equalTo(CHEQUE_ADDRESS))
    }

    void "test updating stripe production mode"() {
        expect:
        given()
                .body('{"stripeProductionMode": true}')
                .contentType(ContentType.JSON)
                .when()
                .put("/bankAccount/{id}", bankAccount1.id)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("bank_account.json"))
                .body("name", equalTo(NAME))
                .body("stripeApiKey", equalTo(STRIPE_API_KEY))
                .body("stripeApiTestKey", equalTo(STRIPE_API_TEST_KEY))
                .body("stripeProductionMode", equalTo(true))
                .body("bankAccountNumber", equalTo(BANK_ACCOUNT_NUMBER))
                .body("sortCode", equalTo(SORT_CODE))
                .body("chequePayee", equalTo(CHEQUE_PAYEE))
                .body("chequeAddress", equalTo(CHEQUE_ADDRESS))
    }

    void "test updating bank account number"() {
        expect:
        given()
                .body('{"bankAccountNumber": "Updated Number"}')
                .contentType(ContentType.JSON)
                .when()
                .put("/bankAccount/{id}", bankAccount1.id)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("bank_account.json"))
                .body("name", equalTo(NAME))
                .body("stripeApiKey", equalTo(STRIPE_API_KEY))
                .body("stripeApiTestKey", equalTo(STRIPE_API_TEST_KEY))
                .body("stripeProductionMode", equalTo(STRIPE_PRODUCTION_MODE))
                .body("bankAccountNumber", equalTo("Updated Number"))
                .body("sortCode", equalTo(SORT_CODE))
                .body("chequePayee", equalTo(CHEQUE_PAYEE))
                .body("chequeAddress", equalTo(CHEQUE_ADDRESS))
    }

    void "test updating sort code"() {
        expect:
        given()
                .body('{"sortCode": "Updated Sort Code"}')
                .contentType(ContentType.JSON)
                .when()
                .put("/bankAccount/{id}", bankAccount1.id)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("bank_account.json"))
                .body("name", equalTo(NAME))
                .body("stripeApiKey", equalTo(STRIPE_API_KEY))
                .body("stripeApiTestKey", equalTo(STRIPE_API_TEST_KEY))
                .body("stripeProductionMode", equalTo(STRIPE_PRODUCTION_MODE))
                .body("bankAccountNumber", equalTo(BANK_ACCOUNT_NUMBER))
                .body("sortCode", equalTo("Updated Sort Code"))
                .body("chequePayee", equalTo(CHEQUE_PAYEE))
                .body("chequeAddress", equalTo(CHEQUE_ADDRESS))
    }

    void "test updating cheque payee"() {
        expect:
        given()
                .body('{"chequePayee": "Updated Payee"}')
                .contentType(ContentType.JSON)
                .when()
                .put("/bankAccount/{id}", bankAccount1.id)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("bank_account.json"))
                .body("name", equalTo(NAME))
                .body("stripeApiKey", equalTo(STRIPE_API_KEY))
                .body("stripeApiTestKey", equalTo(STRIPE_API_TEST_KEY))
                .body("stripeProductionMode", equalTo(STRIPE_PRODUCTION_MODE))
                .body("bankAccountNumber", equalTo(BANK_ACCOUNT_NUMBER))
                .body("sortCode", equalTo(SORT_CODE))
                .body("chequePayee", equalTo("Updated Payee"))
                .body("chequeAddress", equalTo(CHEQUE_ADDRESS))
    }

    void "test updating cheque address"() {
        expect:
        given()
                .body('{"chequeAddress": "Updated Address"}')
                .contentType(ContentType.JSON)
                .when()
                .put("/bankAccount/{id}", bankAccount1.id)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("bank_account.json"))
                .body("name", equalTo(NAME))
                .body("stripeApiKey", equalTo(STRIPE_API_KEY))
                .body("stripeApiTestKey", equalTo(STRIPE_API_TEST_KEY))
                .body("stripeProductionMode", equalTo(STRIPE_PRODUCTION_MODE))
                .body("bankAccountNumber", equalTo(BANK_ACCOUNT_NUMBER))
                .body("sortCode", equalTo(SORT_CODE))
                .body("chequePayee", equalTo(CHEQUE_PAYEE))
                .body("chequeAddress", equalTo("Updated Address"))
    }

    void "test updating a bank account when no body"() {
        expect:
        when()
                .put("/bankAccount/{id}", bankAccount1.id)
                .then()
                .statusCode(HttpStatus.SC_OK)
    }

    void "test updating a bank account when id not a number"() {
        expect:
        when()
                .put("/bankAccount/{id}", 'abcde')
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
    }

    void "test creating a new bank account"() {
        expect:
        given()
                .body("""
                    {
                        "name": "Created Name",
                        "stripeApiKey": "Created Stripe API Key",
                        "stripeApiTestKey": "Created Stripe API Test Key",
                        "stripeProductionMode": true,
                        "bankAccountNumber": "Created Number",
                        "sortCode": "Created Sort Code",
                        "chequePayee": "Created Payee",
                        "chequeAddress": "Created Address"
                    }
                """)
                .contentType(ContentType.JSON)
                .when()
                .post("/bankAccount")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body(matchesJsonSchemaInClasspath("bank_account.json"))
                .body("name", equalTo("Created Name"))
                .body("stripeApiKey", equalTo("Created Stripe API Key"))
                .body("stripeApiTestKey", equalTo("Created Stripe API Test Key"))
                .body("stripeProductionMode", equalTo(true))
                .body("bankAccountNumber", equalTo("Created Number"))
                .body("sortCode", equalTo("Created Sort Code"))
                .body("chequePayee", equalTo("Created Payee"))
                .body("chequeAddress", equalTo("Created Address"))
        BankAccount.count == 3
    }

    void "test deleting a bank account by id"() {
        expect:
        BankAccount.count == 2
        when()
                .delete("/bankAccount/{id}", bankAccount1.id)
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT)
        BankAccount.count == 1
    }

    void "test getting a list of bank accounts"() {
        expect:
        when().get("/bankAccount")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("bank_accounts.json"))
                .body("stripeProductionMode", hasItems(true, false))
    }
}
