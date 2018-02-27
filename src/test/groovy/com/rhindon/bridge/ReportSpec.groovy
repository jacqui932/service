package com.rhindon.bridge

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.apache.http.HttpStatus
import spock.lang.Specification

import static io.restassured.RestAssured.given

@Integration
@Rollback
class ReportSpec extends Specification {

    void setup() {
        RestAssured.port = serverPort
    }

    void "test running the monthly financial report"() {
        expect:
        byte[] pdf = given()
                .body('{"year": 2018, "month": 2}')
                .contentType(ContentType.JSON)
                .when()
                .post("/report/monthlyFinancialReport.pdf")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .asByteArray();
        pdf.size() > 0
    }

    void "test running the bridge events report"() {
        expect:
        false
    }

    void "test running the clubs report"() {
        expect:
        false
    }

    void "test running the heats report"() {
        expect:
        false
    }

    void "test running the event heats report"() {
        expect:
        false
    }

    void "test running the event players report"() {
        expect:
        false
    }

    void "test running the victor ludorum report"() {
        expect:
        false
    }

    void "test running the club event heat qualifiers report"() {
        expect:
        false
    }

    void "test running the outstanding payments report"() {
        expect:
        false
    }

    void "test running the eccles cup points report"() {
        expect:
        false
    }
}
