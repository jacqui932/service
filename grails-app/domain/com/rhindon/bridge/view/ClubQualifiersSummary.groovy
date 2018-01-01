package com.rhindon.bridge.view

class ClubQualifiersSummary {

    Long clubId
    Long seasonId
    String name
    boolean active
    Long numHeatsWithoutQualifiers
    Long numUnmatchedEventEntries

    static constraints = {
        sort "name"
        version false
    }

    static mapping = {
        id name: "clubId"
    }
}
