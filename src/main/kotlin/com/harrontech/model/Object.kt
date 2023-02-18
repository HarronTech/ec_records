package com.harrontech.model

import com.harrontech.model.common.Coordinates
import org.springframework.data.annotation.Id
import java.util.*

abstract class Object<T : ObjectTranslation> {
    @Id
    var id: String = UUID.randomUUID().toString()

    var title: String = ""
    var description: String = ""
    var coordinates: Coordinates? = null
    var locationId: String? = null
    var districtId: String? = null
    var metadata: ObjectMetadata = ObjectMetadata()
    var translations: Map<LanguageCode, T>? = null



    fun containsLanguage(language: LanguageCode) : Boolean {
        return translations?.keys?.contains(language) ?: false
    }
}