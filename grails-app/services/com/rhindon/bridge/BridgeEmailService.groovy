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
