package com.harrontech.model.common

class OpenHours(
    val openHour: List<OpenHour>,
    val url: String
) {
    fun getOpenHourByDay(dayOfWeek: Int) : OpenHour? {
        return openHour.find { it.day == dayOfWeek }
    }
}