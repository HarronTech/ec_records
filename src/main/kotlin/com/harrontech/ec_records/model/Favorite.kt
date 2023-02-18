package com.harrontech.ec_records.model

import java.util.UUID

class Favorite {
    var id: String = UUID.randomUUID().toString()

    var userId: String? = null

    var favorites: MutableList<String> = mutableListOf()
}