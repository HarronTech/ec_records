package com.harrontech.ec_records.model.common

class Location(
    val city: String,
    val country: String,
    val northEast: Coordinates,
    val southWest: Coordinates,
    val isVisible: Boolean
)