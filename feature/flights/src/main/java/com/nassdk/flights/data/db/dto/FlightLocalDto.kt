package com.nassdk.flights.data.db.dto

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class FlightLocalDto(
    @PrimaryKey var number: String? = null,
    @Required var statusCode: String? = null,
    @Required var arrivalTimezone: String? = null,
    @Required var arrivalTime: String? = null,
    @Required var departureTimezone: String? = null,
    @Required var departureTime: String? = null,
    @Required var arrDay: String? = null,
    @Required var depDay: String? = null,
    @Required var arrTime: String? = null,
    @Required var depTime: String? = null,
    @Required var flightTime: String? = null
) : RealmObject()
