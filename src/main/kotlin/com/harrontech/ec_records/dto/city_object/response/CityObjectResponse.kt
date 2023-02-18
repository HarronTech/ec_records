package com.harrontech.ec_records.dto.city_object.response

import com.harrontech.ec_records.model.CityObject
import com.harrontech.ec_records.model.LanguageCode

data class CityObjectResponse(
    var id: String = "",
    var title: String = "",
    var description: String = ""
) {
    companion object {
        fun toResponse(cityObject: CityObject, languageCode: LanguageCode): CityObjectResponse? {
            if (languageCode == LanguageCode.EN) {
                return CityObjectResponse(
                    id = cityObject.id,
                    title = cityObject.title,
                    description = cityObject.description
                )
            }

            if (cityObject.containsLanguage(languageCode)) {
                val translations = cityObject.translations!![languageCode]!!
                return CityObjectResponse(
                    id = cityObject.id,
                    title = translations.title,
                    description = translations.description
                )
            }

            return null
        }
    }
}