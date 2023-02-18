package com.harrontech.ec_records.repository

import com.harrontech.ec_records.model.Favorite
import org.springframework.data.mongodb.repository.MongoRepository

interface FavoritesRepository : MongoRepository<Favorite, String> {
    fun findByUserId(userId: String) : Favorite
}