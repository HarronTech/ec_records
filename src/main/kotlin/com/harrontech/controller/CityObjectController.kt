package com.harrontech.controller

import com.harrontech.dto.city_object.response.CityObjectResponse
import com.harrontech.model.CityObject
import com.harrontech.model.LanguageCode
import com.harrontech.dto.city_object.request.CityObjectFilterQuery
import com.harrontech.service.CityObjectService
import com.harrontech.dto.city_object.request.CityObjectSortQuery
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/v1/city-objects")
class CityObjectController(val service: CityObjectService) {
    @GetMapping
    fun getCityObjects(@RequestParam(required = false) language: LanguageCode = LanguageCode.EN,
                       @RequestParam locationId: String,
                       @RequestParam filterQuery: CityObjectFilterQuery,
                       @RequestParam sortQuery: CityObjectSortQuery,
                       @RequestParam page: Int,
                       @RequestParam size: Int): List<CityObject> {
       return service.getCityObjects(locationId, filterQuery, sortQuery, page, size)
    }


    @GetMapping(":search")
    fun search(@RequestParam locationId: String,
               @RequestParam searchQuery: String,
               @RequestParam page: Int,
               @RequestParam size: Int): List<CityObject> {
        return service.searchCityObjects(locationId, searchQuery, page, size)
    }

    @GetMapping("{id}")
    fun getCityObjectById(@PathVariable id: String,
                          @RequestParam(required = false) language: LanguageCode = LanguageCode.EN): CityObjectResponse? {
        val cityObject = service.getCityObjectById(id)

        if (cityObject.isEmpty) return null

        return CityObjectResponse.toResponse(cityObject.get(), language)
    }


}
