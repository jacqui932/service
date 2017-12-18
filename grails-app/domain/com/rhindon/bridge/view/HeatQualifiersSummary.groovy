package com.rhindon.bridge.view

class HeatQualifiersSummary {

    Long heatId
    Long clubId
    Date heatDate
    Long eventId
    Long seasonId
    String eventName
    Long numQualifiers
    Long numEntries
    Long numUnmatchedEntries

    static constraints = {
        version false
        sort "heatDate"
        id name: 'heatId', column: 'heat_id'
    }
}
