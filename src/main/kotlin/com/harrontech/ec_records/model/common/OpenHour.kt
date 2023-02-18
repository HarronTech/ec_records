package com.harrontech.ec_records.model.common

import java.time.LocalTime

class OpenHour(
    val day: Int,
    val time: String
) {
    fun isTimeBetweenTimeRange(localTime: LocalTime): Boolean {
        var times = time.split("-")
        var startTime = LocalTime.parse(times[0])
        var endTime = LocalTime.parse(times[1])

        return startTime.isBefore(localTime) || endTime.isAfter(localTime)
    }
}