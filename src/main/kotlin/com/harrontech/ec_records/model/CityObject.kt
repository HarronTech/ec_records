package com.harrontech.ec_records.model

import com.harrontech.ec_records.model.common.*
import com.harrontech.model.common.*

class CityObject : Object<CityObjectTranslation>() {
    var category: Category? = null
    var tags: List<Tag> = emptyList()
    var contacts: Contacts? = null
    var tickets: Tickets? = null
    var accessibility: Accessibility? = null
    var address: Address? = null
    var openingHours: OpenHours? = null
    var images: List<Images> = emptyList()
}
