databaseChangeLog = {

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-2") {
        createTable(tableName: "bridge_event") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "bridge_eventPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "venue", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "club_heats", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "masterpoint_type", type: "VARCHAR(5)") {
                constraints(nullable: "false")
            }

            column(name: "competition_type", type: "VARCHAR(12)") {
                constraints(nullable: "false")
            }

            column(name: "active", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "club_representative", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "season_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "entry_confirmation_email_addresses", type: "VARCHAR(255)")

            column(name: "more_info", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "date_time", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "CLOB") {
                constraints(nullable: "false")
            }

            column(name: "allow_pay_on_the_day", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "cost", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "victor_ludorum", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "description", type: "CLOB") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-3") {
        createTable(tableName: "club") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "clubPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "address", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "active", type: "BOOLEAN") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-4") {
        createTable(tableName: "club_contact") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "club_contactPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "role", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "club_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "email", type: "VARCHAR(255)")

            column(name: "telephone_number", type: "VARCHAR(255)")
        }
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-5") {
        createTable(tableName: "director") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "directorPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "email", type: "VARCHAR(255)")

            column(name: "telephone_number", type: "VARCHAR(255)")
        }
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-6") {
        createTable(tableName: "director_assignment") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "director_assignmentPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "director_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "event_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-7") {
        createTable(tableName: "event_entry") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "event_entryPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "heat", type: "BIGINT")

            column(name: "payment_method", type: "VARCHAR(23)") {
                constraints(nullable: "false")
            }

            column(name: "date_entered", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "withdrawn", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "event", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "comments", type: "VARCHAR(255)")

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "fully_paid", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "club_id", type: "BIGINT")

            column(name: "email", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-8") {
        createTable(tableName: "event_entry_player") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "event_entry_playerPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "first_name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "event_entry_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "victor_ludorum_points", type: "DECIMAL(19, 2)")

            column(name: "last_name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "ebu_number", type: "BIGINT")
        }
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-9") {
        createTable(tableName: "financial_transaction") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "financial_transactionPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "payment_ref", type: "VARCHAR(255)")

            column(name: "payment_method", type: "VARCHAR(13)") {
                constraints(nullable: "false")
            }

            column(name: "date_paid", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "event_entry_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "amount", type: "DECIMAL(19, 2)") {
                constraints(nullable: "false")
            }

            column(name: "date_cleared", type: "datetime")
        }
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-10") {
        createTable(tableName: "heat") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "heatPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "date_time", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "visitors_info", type: "VARCHAR(255)")

            column(name: "club_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "event_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-11") {
        createTable(tableName: "heat_qualifier") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "heat_qualifierPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "event_entry_id", type: "BIGINT")
        }
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-12") {
        createTable(tableName: "heat_qualifier_player") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "heat_qualifier_playerPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "first_name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "heat_qualifier_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "last_name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "ebu_number", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-13") {
        createTable(tableName: "instance") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "instancePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "bank_account_number", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "stripe_api_test_key", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "stripe_production_mode", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "cheque_payee", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "stripe_api_key", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "entry_confirmation_email_addresses", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "sort_code", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "banner_colour", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "swallow_online_costs", type: "BOOLEAN") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "cheque_address", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "entry_confirmation_signature", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "heat_updated_email_addresses", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "domain", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-14") {
        createTable(tableName: "masterpoint_grade") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "masterpoint_gradePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-15") {
        createTable(tableName: "player") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "playerPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "first_name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "county_of_affiliation", type: "VARCHAR(255)")

            column(name: "masterpoint_grade_id", type: "BIGINT")

            column(name: "last_name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "ebu_number", type: "BIGINT")

            column(name: "email", type: "VARCHAR(255)")
        }
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-16") {
        createTable(tableName: "season") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "seasonPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "start_date", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "instance_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "end_date", type: "datetime") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-17") {
        createTable(tableName: "venue") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "venuePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "address_line_1", type: "VARCHAR(100)")

            column(name: "postcode", type: "VARCHAR(45)")

            column(name: "address_line_3", type: "VARCHAR(45)")

            column(name: "address_line_4", type: "VARCHAR(45)")

            column(name: "address_line_2", type: "VARCHAR(45)")
        }
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-18") {
        addForeignKeyConstraint(baseColumnNames: "masterpoint_grade_id", baseTableName: "player", constraintName: "FK1nud737eqnqnjee979ou2t9iy", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "masterpoint_grade")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-19") {
        addForeignKeyConstraint(baseColumnNames: "instance_id", baseTableName: "season", constraintName: "FK1q8e5t4j01fc36glbmjxejy6u", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "instance")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-20") {
        addForeignKeyConstraint(baseColumnNames: "event_id", baseTableName: "heat", constraintName: "FK2leot2bs547hgyd28801ymmee", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "bridge_event")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-21") {
        addForeignKeyConstraint(baseColumnNames: "event_entry_id", baseTableName: "heat_qualifier", constraintName: "FK354n1bdtohebrc82ra3bgjytk", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "event_entry")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-22") {
        addForeignKeyConstraint(baseColumnNames: "season_id", baseTableName: "bridge_event", constraintName: "FK3xycp2s6od64f8fcx5h3vk4y3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "season")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-23") {
        addForeignKeyConstraint(baseColumnNames: "event_entry_id", baseTableName: "event_entry_player", constraintName: "FK46osms7qbh6iua0iaixuyf7i0", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "event_entry")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-24") {
        addForeignKeyConstraint(baseColumnNames: "event_id", baseTableName: "director_assignment", constraintName: "FK6hq52wbqwqmdtvi2oiqwmr2lh", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "bridge_event")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-25") {
        addForeignKeyConstraint(baseColumnNames: "club_id", baseTableName: "heat", constraintName: "FK7c1p3cfeapo6dqgfv0dnggxsb", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "club")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-26") {
        addForeignKeyConstraint(baseColumnNames: "venue", baseTableName: "bridge_event", constraintName: "FK7otsmf5tdp5o0wm1fnrguegt8", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "venue")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-27") {
        addForeignKeyConstraint(baseColumnNames: "event_entry_id", baseTableName: "financial_transaction", constraintName: "FKaefv9krp53tcp78oikvxav2od", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "event_entry")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-28") {
        addForeignKeyConstraint(baseColumnNames: "heat", baseTableName: "event_entry", constraintName: "FKasds0peam4qoevudl6aqxac3o", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "heat")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-29") {
        addForeignKeyConstraint(baseColumnNames: "heat_qualifier_id", baseTableName: "heat_qualifier_player", constraintName: "FKdmpq1uo89hwcx00n1hj7k668v", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "heat_qualifier")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-30") {
        addForeignKeyConstraint(baseColumnNames: "club_id", baseTableName: "club_contact", constraintName: "FKevue1jxi2mx0sm2kk4f97thbf", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "club")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-31") {
        addForeignKeyConstraint(baseColumnNames: "event", baseTableName: "event_entry", constraintName: "FKgqe5t7hqht79j68tftkw1adq3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "bridge_event")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-32") {
        addForeignKeyConstraint(baseColumnNames: "club_id", baseTableName: "event_entry", constraintName: "FKiesy2gc3qfuai26kv4pbfkkyv", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "club")
    }

    changeSet(author: "Jacqui.Snook (generated)", id: "1508944607108-33") {
        addForeignKeyConstraint(baseColumnNames: "director_id", baseTableName: "director_assignment", constraintName: "FKmnehjuf5gncqmh1gteu4ys6g9", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "director")
    }
}
