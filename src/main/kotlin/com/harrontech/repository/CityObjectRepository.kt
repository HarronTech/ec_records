package com.harrontech.repository

import com.harrontech.model.CityObject
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CityObjectRepository : MongoRepository<CityObject, String> {
    fun findAllByLocationId(locationId: String) : List<CityObject>
}