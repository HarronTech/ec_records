package com.harrontech.ec_records.controller

import com.harrontech.ec_records.service.FavoritesService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/favorite")
class FavoriteController(val service: FavoritesService) {

    @GetMapping
    fun getAllFavorites(@RequestHeader userId: String) {
        service.getAllFavoritesByUserId(userId)
    }

    @PostMapping
    fun addToFavorites(@RequestHeader userId: String,
                       @RequestBody objectId: String) {
        service.addToFavorites(userId, objectId)
    }

    @DeleteMapping
    fun removeFromFavorites(@RequestHeader userId: String,
                            @RequestParam objectId: String) {
        service.removeToFavorites(userId, objectId)
    }

}