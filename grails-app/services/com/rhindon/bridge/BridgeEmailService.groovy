package com.rhindon.bridge

import com.rhindon.bridge.multitenant.EventEntry
import grails.gorm.transactions.Transactional

@Transactional
class BridgeEmailService {

    def amazonSESTemplateService

    def sendMail(EventEntry eventEntry) {
        sendPlayerEmail(eventEntry)
        for (item in eventEntry.event.entryConfirmationEmailAddresses.split(',')) {
            if (!item.isEmpty()) {
                sendEventConfirmationEmail(eventEntry, item)
            }
        }
        for(item in eventEntry.event.season.instance.entryConfirmationEmailAddresses.split(',')){
            if (!item.isEmpty()) {
                sendEventConfirmationEmail(eventEntry, item)
            }
        }
    }

    def afterEventReport() {
        def emails = ['Janet': 'jane.akers@tiscali.co.uk',
                      'Susan': 'susancarolarnold@yahoo.co.uk',
                      'Kathleen': 'john_kath_barnes@hotmail.com',
                      'Bob': 'robert.bastock@gmail.com',
                      'Richard': 'jarbean@ntlworld.com',
                      'Rowena': 'rowena.birdsey@btinternet.com',
                      'Patricia': 'pbon1947@gmail.com',
                      'Val': 'v-brown@tiscali.co.uk',
                      'John and Jan': 'john@burnell.me.uk',
                      'Patricia': 'patriciacahalane@yahoo.co.uk',
                      'Wendy': 'wendycorns@fsmail.net',
                      'Rosemary': 'rosemary.marks@ntlworld.com',
                      'Carol': 'edrichca@gmail.com',
                      'Margaret': 'davcapsuk@aol.com',
                      'Valerie': 'valerie.fullforth@ntlworld.com',
                      'Robert': 'r.girvan@ntlworld.com',
                      'Peter': 'peter.gore162@btinternet.com',
                      'Christine': 'christine.m.gray@btinternet.com',
                      'Judy': 'judyhowlett@yahoo.co.uk',
                      'Gill': 'gill.humby@live.co.uk',
                      'Kathy': 'glandkl@virginmedia.com',
                      'Christine': 'christinenewcombe21@hotmail.com',
                      'Liz': 'orrocke@googlemail.com',
                      'Marcia': 'marcia.music1@gmail.com',
                      'Robert': 'robert.scane@googlemail.com',
                      'Merv': 'mervandjoyce@hotmail.com',
                      'Frances': 'f.street@sky.com',
                      'Stephen': 'steve.sj.welch@talk21.com',
                      'Jean': 'jean-burr@hotmail.co.uk',
                      'Jacqui' : 'jasnook@ntlworld.com']

        emails.each {name, email ->
                sendThankyouEmail(name, email)
        };
    }

    private sendThankyouEmail(name, email) {
        amazonSESTemplateService.mailTemplate {
            to email
            subjectCode 'email.thankyou.subject'
            subjectVariables[]
            model ([data: name])
            templateName 'thankyou'
        }
    }

    private sendPlayerEmail(EventEntry eventEntry) {
        def eeModel = [  eventEntry: eventEntry ]
        amazonSESTemplateService.mailTemplate {
            to eventEntry.email
            subjectCode 'email.confirmation.subject'
            subjectVariables  []
            model eeModel
            templateName 'entryConfirmation'
        }
    }

    private sendEventConfirmationEmail(EventEntry eventEntry, String email) {
        def eeModel = [  eventEntry: eventEntry ]
        amazonSESTemplateService.mailTemplate {
            to email
            subjectCode 'email.tsconfirmation.subject'
            subjectVariables []
            model eeModel
            templateName 'tsEntryConfirmation'
        }
    }
}
