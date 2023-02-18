package com.harrontech.ec_records.model

import java.time.LocalDateTime

class ObjectMetadata {
    var updateTimestamp: LocalDateTime = LocalDateTime.now()
    var isVisible: Boolean = false
}