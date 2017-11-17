package service

import com.rhindon.bridge.Instance
import com.rhindon.bridge.multitenant.*
import grails.util.Environment
import grails.web.mapping.LinkGenerator

class BootStrap {

    def grailsApplication

    def init = { servletContext ->

        LinkGenerator grailsLinkGenerator = grailsApplication.mainContext.getBean("grailsLinkGenerator")
        grailsLinkGenerator.configuredServerBaseURL ?: grailsApplication.config.grails.serverUrl

        if (Environment.current != Environment.PRODUCTION) {

            //VENUES
            new Venue(id: 1, addressLine_1: 'Bridge Centre', addressLine_2: 'Welwyn Garden City', postcode: 'AL1 2BC').save(failOnError: true)

            // INSTANCE
            new Instance(id: 1,
                    name: 'Hertfordshire Bridge Association',
                    domain: 'herts',
                    entryConfirmationEmailAddresses: 'jasnook@ntlworld.com',
                    heatUpdatedEmailAddresses: 'hbatournamentsec@gmail.com',
                    entryConfirmationSignature: 'Jacqui and David Collier<br/>HBA Tournament Secretary',
            ).save(failOnError: true)

            // BANK ACCOUNT
            new BankAccount(id: 1,
                    name: 'Test Bank Account',
                    stripeApiKey: 'sk_test_bJBzUjniwqb1sageSnRVrX2L',
                    stripeApiTestKey: 'sk_test_bJBzUjniwqb1sageSnRVrX2L',
                    bankAccountNumber: '33945168',
                    sortCode: '30-93-89',
                    chequePayee: 'HBA Bridge',
                    chequeAddress: '13 Sish Close, Stevenage, SG1 3LT'
            ).save(failOnError: true)

            // SEASONS
            new Season(id: 1,
                    instance: Instance.get(1),
                    startDate: new Date(2017 - 1900, 9, 12, 11, 00, 00),
                    endDate: new Date(2018 - 1900, 9, 12, 11, 00, 00)).save(failOnError: true)

            //EVENT
            new BridgeEvent(id: 1,
                    season: Season.get(1),
                    name: 'Test Event',
                    masterpointType: 'Local',
                    competitionType: 'pairs',
                    description: 'xxx',
                    cost: 6000,
                    dateTime: new Date(2017 - 1900, 8, 12, 11, 00, 00),
                    active: true,
                    allowPayOnTheDay: true,
                    clubRepresentative: true,
                    moreInfo: 'abcde',
                    venue: Venue.get(1),
                    bankAccount: BankAccount.get(1))
                    .save(failOnError: true);

            new BridgeEvent(id: 2,
                    season: Season.get(1),
                    name: 'Test Event 2',
                    masterpointType: 'Local',
                    competitionType: 'pairs',
                    description: 'yyy',
                    cost: 6000,
                    dateTime: new Date(2017 - 1900, 8, 12, 11, 00, 00),
                    active: true,
                    moreInfo: 'abcde',
                    venue: Venue.get(1),
                    bankAccount: BankAccount.get(1))
                    .save(failOnError: true);

            // CLUB
            new Club(id: 1,
                    name: 'Club 1',
                    address: 'Address 1').save(failOnError: true)

            // CLUB CONTACT
            new ClubContact(id: 1,
                    club: Club.get(1L),
                    name: 'Contact 1',
                    telephoneNumber: 'Telephone No.',
                    role: 'Role').save(failOnError: true)

            // HEAT
            new Heat(id: 1,
                    dateTime: new Date(),
                    club: Club.get(1L),
                    event: BridgeEvent.get(2L),
                    venue: Venue.get(1L)).save(failOnError: true)

            // EVENT ENTRY
            new EventEntry(id: 1,
                    event: BridgeEvent.get(1),
                    name: 'Name',
                    email: 'jasnook@ntlworld.com',
                    dateEntered: new Date(),
                    heat: Heat.get(1L),
                    comments: 'Comments').save(failOnError: true)

            // EVENT ENTRY PLAYER
            new EventEntryPlayer(id: 1,
                    ebuNumber: 12345,
                    eventEntry: EventEntry.get(1L),
                    firstName: 'First',
                    lastName: 'Last').save(failOnError: true)

            new EventEntryPlayer(id: 2,
                    ebuNumber: 54321,
                    eventEntry: EventEntry.get(1L),
                    firstName: 'Another',
                    lastName: 'Player').save(failOnError: true)
        }
    }

    def destroy = {
    }
}
