package com.harrontech.ec_records.service

import com.harrontech.ec_records.repository.FavoritesRepository

class FavoritesService(val repository: FavoritesRepository) {
    fun getAllFavoritesByUserId(userId: String) : List<String> {

        return repository.findByUserId(userId).favorites
    }

    fun addToFavorites(userId: String, objectId: String) {
        var fav = repository.findByUserId(userId)
        fav.favorites.add(objectId)

        repository.save(fav)
    }

    fun removeToFavorites(userId: String, objectId: String) {
        var fav = repository.findByUserId(userId)
        fav.favorites.remove(objectId)

        repository.save(fav)
    }
}