package com.harrontech.dto.city_object.request

import com.harrontech.model.common.Coordinates

class CityObjectFilterQuery {
    var title: String? = null
    var tags: List<String>? = null
    var categories: List<String>? = null
    var isOpenNow: Boolean? = null
    var isFree: Boolean? = null
    var distance: Double? = null
    var coordinates: Coordinates? = null
}