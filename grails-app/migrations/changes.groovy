databaseChangeLog = {

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-1") {
        dropUniqueConstraint(constraintName: "id_UNIQUE", tableName: "financial_transaction")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-2") {
        dropUniqueConstraint(constraintName: "name_UNIQUE", tableName: "masterpoint_grade")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-3") {
        dropColumn(columnName: "county_logo", tableName: "instance")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-4") {
        dropColumn(columnName: "ebu_logo", tableName: "instance")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-5") {
        dropColumn(columnName: "financial_report_email_addresses", tableName: "instance")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-6") {
        dropColumn(columnName: "heat", tableName: "heat_qualifier")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-7") {
        dropColumn(columnName: "masterpoint_rank", tableName: "event_entry_player")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-8") {
        dropColumn(columnName: "order_number", tableName: "masterpoint_grade")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-9") {
        dropDefaultValue(columnDataType: "boolean", columnName: "active", tableName: "bridge_event")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-10") {
        dropDefaultValue(columnDataType: "boolean", columnName: "active", tableName: "club")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-11") {
        dropDefaultValue(columnDataType: "boolean", columnName: "allow_pay_on_the_day", tableName: "bridge_event")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-12") {
        addNotNullConstraint(columnDataType: "varchar(255)", columnName: "bank_account_number", tableName: "instance")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-13") {
        addNotNullConstraint(columnDataType: "varchar(255)", columnName: "banner_colour", tableName: "instance")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-14") {
        addNotNullConstraint(columnDataType: "varchar(255)", columnName: "cheque_address", tableName: "instance")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-15") {
        addNotNullConstraint(columnDataType: "varchar(255)", columnName: "cheque_payee", tableName: "instance")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-16") {
        dropDefaultValue(columnDataType: "boolean", columnName: "club_heats", tableName: "bridge_event")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-17") {
        dropDefaultValue(columnDataType: "boolean", columnName: "club_representative", tableName: "bridge_event")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-18") {
        addNotNullConstraint(columnDataType: "varchar(255)", columnName: "domain", tableName: "instance")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-19") {
        addNotNullConstraint(columnDataType: "bigint", columnName: "ebu_number", tableName: "heat_qualifier_player")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-20") {
        dropDefaultValue(columnDataType: "varchar(255)", columnName: "entry_confirmation_email_addresses", tableName: "bridge_event")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-21") {
        addNotNullConstraint(columnDataType: "varchar(255)", columnName: "entry_confirmation_email_addresses", tableName: "instance")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-22") {
        addNotNullConstraint(columnDataType: "varchar(255)", columnName: "entry_confirmation_signature", tableName: "instance")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-23") {
        dropDefaultValue(columnDataType: "boolean", columnName: "fully_paid", tableName: "event_entry")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-24") {
        addNotNullConstraint(columnDataType: "varchar(255)", columnName: "heat_updated_email_addresses", tableName: "instance")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-25") {
        addNotNullConstraint(columnDataType: "varchar(255)", columnName: "more_info", tableName: "bridge_event")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-26") {
        addNotNullConstraint(columnDataType: "varchar(255)", columnName: "name", tableName: "masterpoint_grade")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-27") {
        addNotNullConstraint(columnDataType: "varchar(23)", columnName: "payment_method", tableName: "event_entry")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-28") {
        dropDefaultValue(columnDataType: "varchar(255)", columnName: "payment_ref", tableName: "financial_transaction")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-29") {
        addNotNullConstraint(columnDataType: "varchar(255)", columnName: "role", tableName: "club_contact")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-30") {
        addNotNullConstraint(columnDataType: "varchar(255)", columnName: "sort_code", tableName: "instance")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-31") {
        addNotNullConstraint(columnDataType: "varchar(255)", columnName: "stripe_api_key", tableName: "instance")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-32") {
        addNotNullConstraint(columnDataType: "varchar(255)", columnName: "stripe_api_test_key", tableName: "instance")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-33") {
        addNotNullConstraint(columnDataType: "boolean", columnName: "stripe_production_mode", tableName: "instance")

        dropDefaultValue(columnDataType: "boolean", columnName: "stripe_production_mode", tableName: "instance")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-34") {
        addNotNullConstraint(columnDataType: "boolean", columnName: "swallow_online_costs", tableName: "instance")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-35") {
        dropDefaultValue(columnDataType: "bigint", columnName: "version", tableName: "financial_transaction")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-36") {
        addNotNullConstraint(columnDataType: "bigint", columnName: "version", tableName: "masterpoint_grade")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-37") {
        dropDefaultValue(columnDataType: "boolean", columnName: "victor_ludorum", tableName: "bridge_event")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508947205436-38") {
        dropDefaultValue(columnDataType: "boolean", columnName: "withdrawn", tableName: "event_entry")
    }
}
