package com.rhindon.bridge.view

class EcclesCupPoints {

    String clubName
    String firstName
    String lastName
    Long ebuNumber
    String rank
    Integer ecclesPoints

    static mapping = {
        table 'eccles_cup_points'
        version false
    }
}
