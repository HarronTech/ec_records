package com.harrontech.ec_records.service

import com.harrontech.ec_records.dto.city_object.request.CityObjectFilterQuery
import com.harrontech.ec_records.dto.city_object.request.CityObjectSortQuery
import com.harrontech.ec_records.dto.city_object.request.SortingType
import com.harrontech.ec_records.model.CityObject
import com.harrontech.ec_records.repository.CityObjectRepository
import org.springframework.data.mongodb.core.MongoTemplate
import java.time.LocalDateTime.now
import java.util.*


class CityObjectService(val repository: CityObjectRepository) {


    fun getCityObjectById(id: String): Optional<CityObject> {
        return repository.findById(id)
    }

    fun getCityObjects(locationId: String, page: Int, size: Int) : List<CityObject> {
        return repository.findAllByLocationId(locationId)
            .drop(page * size)
            .take(size)
    }

    fun searchCityObjects(locationId: String, search: String, page: Int, size: Int) : List<CityObject> {
        return repository.findAllByLocationId(locationId)
            .filter { it.title.lowercase().contains(search.lowercase()) }
            .drop(page * size)
            .take(size)
    }

    fun getCityObjects(locationId: String, filterQuery: CityObjectFilterQuery, sortQuery: CityObjectSortQuery, page: Int, size: Int) : List<CityObject> {
        return sorterCityObjects(filterCityObjects(repository.findAllByLocationId(locationId), filterQuery)
            .drop(page * size)
            .take(size), sortQuery)
    }

    fun createCityObject(request: CityObject) : CityObject {
        return repository.save(request)
    }

    fun updateCityObject(id: String, request: CityObject) : CityObject {
        return repository.save(request)
    }

    fun deleteCityObject(id: String) {
        return repository.deleteById(id)
    }


    private fun filterCityObjects(cityObjects: List<CityObject>, filterQuery: CityObjectFilterQuery) : List<CityObject> {

        var temp = cityObjects

        if (filterQuery.title != null) {
            temp = temp.filter { it.title.lowercase().contains(filterQuery.title!!.lowercase()) }
        }

        if (filterQuery.categories != null) {
            temp = temp.filter { filterQuery.categories!!.contains(it.category?.id) }
        }

        if (filterQuery.tags != null) {
            temp = temp.filter { it.tags.map { it.id }.any(filterQuery.tags!!::contains) }
        }

        if (filterQuery.isFree != null) {
            temp = temp.filter { it.tickets!!.tickets.isEmpty() }
        }

        if (filterQuery.isOpenNow != null) {

            var time = now().toLocalTime()
            var dayOfWeek = now().dayOfWeek.value

            temp = temp.filter { it.openingHours!!.getOpenHourByDay(dayOfWeek)!!.isTimeBetweenTimeRange(time) }
        }

        if (filterQuery.distance != null && filterQuery.coordinates != null) {
            temp = temp
                .filter { it.coordinates!!.latitude <= filterQuery.distance!! }
        }

        return temp
    }

    private fun sorterCityObjects(cityObjects: List<CityObject>, sortQuery: CityObjectSortQuery): List<CityObject> {
        var temp = cityObjects
        if (sortQuery.byTitle != null) {
            temp = when(sortQuery.byTitle) {
                SortingType.ASC -> temp.sortedBy { it.title }
                SortingType.DESC -> temp.sortedByDescending { it.title }
                else -> temp
            }
        }

        return temp
    }
}
