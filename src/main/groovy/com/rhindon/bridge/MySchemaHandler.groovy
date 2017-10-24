package com.rhindon.bridge

import org.grails.datastore.gorm.jdbc.schema.SchemaHandler

import javax.sql.DataSource
import java.sql.Connection

class MySchemaHandler implements SchemaHandler {

    @Override
    Collection<String> resolveSchemaNames(DataSource dataSource) {
        return ['bridge', 'demo', 'herts']
    }

    @Override
    void useSchema(Connection connection, String name) {
        connection
                .createStatement()
                .execute(String.format("use %s", name) )
    }

    @Override
    void useDefaultSchema(Connection connection) {
        connection
                .createStatement()
                .execute(String.format("use %s", "bridge") )
    }

    @Override
    void createSchema(Connection connection, String name) {
        connection
                .createStatement()
                .execute(String.format("create schema %s", name) )
    }
}
