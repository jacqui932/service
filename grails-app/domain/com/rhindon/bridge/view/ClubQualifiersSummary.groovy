package com.rhindon.bridge.view

class ClubQualifiersSummary {

    String name
    boolean active
    Long numHeatsWithoutQualifiers
    Long numUnmatchedEventEntries

    static constraints = {
        sort "name"
        version false
    }
}
