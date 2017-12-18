package com.rhindon.bridge

import com.agorapulse.awssdk.AwsSdkUtils
import com.amazonaws.AmazonClientException
import com.amazonaws.AmazonServiceException
import com.amazonaws.AmazonWebServiceClient
import com.amazonaws.regions.RegionUtils
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient
import com.amazonaws.services.simpleemail.model.*
import com.rhindon.bridge.multitenant.EventEntry
import com.rhindon.bridge.multitenant.HeatQualifier
import grails.gsp.PageRenderer
import org.springframework.transaction.annotation.Transactional

import java.util.stream.Collectors

import static com.agorapulse.awssdk.ses.AwsSdkSesEmailDeliveryStatus.*
import static org.apache.commons.lang.StringUtils.isNotEmpty

@Transactional
class BridgeEmailService {

    String templatePath = '/email'

    AmazonWebServiceClient client = new AmazonSimpleEmailServiceClient(AwsSdkUtils.clientConfigurationWithMap([:])).withRegion(RegionUtils.getRegion('us-west-2'))

    def amazonSESTemplateService

    PageRenderer groovyPageRenderer

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

    private static getEmailAddresses(HeatQualifier heatQualifier) {
        heatQualifier.heatQualifierPlayers.stream().map({Player.findByEbuNumber(it.ebuNumber).email})
                .filter({it != null && isNotEmpty(it)}).distinct().collect(Collectors.toList())
    }

    def sendHeatQualifier() {
        HeatQualifier heatQualifier = HeatQualifier.get(124);

//        heatQualifiers.each {
            send(getEmailAddresses(heatQualifier), "Well done - you have qualified for the ${heatQualifier.heat.event.name}",
                    renderHtmlForTemplate([heatQualifier: heatQualifier], 'heatQualifier'), 'hbatournamentsec@gmail.com', 'hbatournamentsec@gmail.com')
//        }
    }

    def sendDesFlockhart() {
//        def emailsTo = [
//                [name: 'Jacqui', email: 'jasnook@ntlworld.com']
//        ]
        def emailsTo = [
                [name: 'Ian', email: 'greig.ian@outlook.com'],
                [name: 'Stan', email: 'tarastan30@gmail.com'],
                [name: 'John', email: 'jmat261807@aol.com'],
                [name: 'Roger', email: 'rogeredmonds2@gmail.com'],
                [name: 'Susan', email: 'wbbcemail@gmail.com'],
                [name: 'Alan', email: 'ajwo56@hotmail.com']
        ]
        emailsTo.each {
            send([it.email], "Desmond Flockhart Trophy", renderHtmlForTemplate([name: it.name], 'desFlockhart'), 'hbatournamentsec@gmail.com', 'hbatournamentsec@gmail.com')
        }
    }

    String renderHtmlForTemplate(Map model, String templateName) {
        def t = "${templatePath}/${templateName}" as String
        groovyPageRenderer.render(
                model: model,
                template: t
        )
    }

    /**
     *
     * @param destinationEmail
     * @param subject
     * @param htmlBody
     * @param sourceEmail
     * @param replyToEmail
     * @return 1 if successful, 0 if not sent, -1 if blacklisted
     */
    @SuppressWarnings(['LineLength', 'ElseBlockBraces'])
    int send(List<String> destinationEmail,
             String subject,
             String htmlBody,
             String sourceEmail = '',
             String replyToEmail = '') {
        int statusId = STATUS_NOT_DELIVERED
        if ( !destinationEmail ) {
            return statusId
        }

        Destination destination = new Destination().withToAddresses(destinationEmail).withBccAddresses('hbatournamentsec@gmail.com')
        Content messageSubject = new Content(subject)
        Body messageBody = new Body().withHtml(new Content(htmlBody))
        Message message = new Message(messageSubject, messageBody)
        try {
            SendEmailRequest sendEmailRequest = new SendEmailRequest(sourceEmail, destination, message)
            if ( replyToEmail ) {
                sendEmailRequest.replyToAddresses = [replyToEmail]
            }
            (client as AmazonSimpleEmailServiceClient).sendEmail(sendEmailRequest)
            statusId = STATUS_DELIVERED
        } catch (AmazonServiceException exception) {

            if (exception.message.find('Address blacklisted')) {
                log.debug "Address blacklisted destinationEmail=$destinationEmail"
                statusId = STATUS_BLACKLISTED

            } else if (exception.message.find('Missing final')) {
                log.warn "An amazon service exception was caught while sending email: destinationEmail=$destinationEmail, sourceEmail=$sourceEmail, replyToEmail=$replyToEmail, subject=$subject"

            } else {
                log.warn 'An amazon service exception was caught while send +ng email' + exception.message
            }

        } catch (AmazonClientException exception) {
            log.warn 'An amazon client exception was caught while sending email' + exception.message
        }
        statusId
    }
}
