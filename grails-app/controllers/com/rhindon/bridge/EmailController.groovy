package com.rhindon.bridge

import com.rhindon.bridge.view.HeatQualifierEmailView

class EmailController {

    def bridgeEmailService

    def heatQualifierEmail() {
        HeatQualifierEmailView[] qualifiers = HeatQualifierEmailView.findAllByEventId(16)
        def grouped = (qualifiers.groupBy { it.heatQualifierId })
        def emails = []
        grouped.each {
            def name = "${it.value[0].firstName} and ${it.value[1].firstName}"
            emails.add(new EmailItem([
                    name     : name,
                    clubName : it.value[0].clubName,
                    eventDate: it.value[0].eventDate,
                    heatDate : it.value[0].dateTime,
                    eventName: it.value[0].eventName,
                    emails   : it.value.groupBy { it.email }.collect { it.key }.findAll { it != null && !it.empty },

            ]))
        }
        bridgeEmailService.sendHeatQualifier(emails)
    }

    public class EmailItem {
        String name;
        String clubName;
        Date heatDate;
        Date eventDate;
        String eventName;
        String[] emails;
    }
}
