package com.harrontech.controller

import com.harrontech.model.CityObject
import com.harrontech.service.CityObjectService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/api/v1/city-objects")
class AdminCityObjectController(val service: CityObjectService) {
    @PostMapping
    fun createCityObject(@RequestBody cityObject: CityObject): CityObject {
        return service.createCityObject(cityObject)
    }

    @PutMapping("{id}")
    fun updateCityObject(@RequestParam id: String, @RequestBody cityObject: CityObject): CityObject {
        return service.updateCityObject(id, cityObject)
    }

    @DeleteMapping("{id}")
    fun deleteCityObject(@RequestParam id: String) {
        service.deleteCityObject(id)
    }
}