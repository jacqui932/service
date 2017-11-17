package com.rhindon.bridge.multitenant

import grails.rest.Resource

@Resource(readOnly = false, formats = ['json'])
class BridgeEvent {

    static hasMany = [heats: Heat, entries: EventEntry]

    Season season
    String name
    String description
    Date dateTime
    Venue venue
    Integer cost
    String masterpointType
    String competitionType
    boolean active
    boolean clubHeats
    boolean clubRepresentative
    String entryConfirmationEmailAddresses = ''
    String moreInfo
    boolean allowPayOnTheDay
    boolean victorLudorum
    BankAccount bankAccount

    static mapping = {
        entries cascade: 'all-delete-orphan'
        venue column: 'venue'
        sort dateTime:"asc"
    }

    static constraints = {
        entryConfirmationEmailAddresses nullable: true
        season nullable: false
        name blank: false, maxSize: 1000
        description blank: true, maxSize: 1000
        dateTime nullable: false
        venue nullable: false
        cost max: 10000, min: 0
        masterpointType nullable: false, inList: ['Local', 'Green', 'Blue']
        competitionType inList: ['pairs','teamsOfFour','teamsOfEight']
        bankAccount nullable: false
    }
}
