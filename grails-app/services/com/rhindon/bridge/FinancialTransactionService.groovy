package com.rhindon.bridge

import com.rhindon.bridge.filter.FinancialTransactionFilter
import com.rhindon.bridge.multitenant.EventEntry
import com.rhindon.bridge.multitenant.FinancialTransaction

import java.time.LocalDateTime
import java.time.ZoneId

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth

class FinancialTransactionService {

    def search(FinancialTransactionFilter filter) {
        FinancialTransaction.createCriteria().list {
            if (filter.eventEntry) {
                eq("eventEntry", EventEntry.get(filter.eventEntry))
            }
            order("datePaid", "asc")
        }
    }

    def createMonthlyFinancialReportData(FinancialTransactionFilter filter) {
        if (!filter.year && !filter.month) {
            []
        } else {
            def startDate = LocalDateTime.of(filter.year.intValue(), filter.month.intValue(), 1, 0, 0)
            def endDate = LocalDateTime.of(filter.year.intValue(), filter.month.intValue(), 1, 23, 59).with(lastDayOfMonth())

            def financialTransactions = FinancialTransaction.createCriteria().list {
                ge("dateCleared", Date.from(startDate.atZone(ZoneId.systemDefault()).toInstant()))
                le("dateCleared", Date.from(endDate.atZone(ZoneId.systemDefault()).toInstant()))
                order("dateCleared", "asc")
            }
            if (financialTransactions) {
                [year: filter.year, month: Date.parse('M', filter.month.toString()).format('MMMM'), data: financialTransactions.groupBy { it.eventEntry.event }]
            } else {
                []
            }
        }
    }
}
