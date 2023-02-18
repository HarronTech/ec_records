package com.harrontech.ec_records.integration

import com.harrontech.ec_records.model.CityObject
import com.harrontech.ec_records.repository.CityObjectRepository
import com.harrontech.ec_records.service.CityObjectService
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.hamcrest.CoreMatchers.`is` as Is

class CityObjectServiceTests {

    val cityObjectRepository: CityObjectRepository = mock {  }

    val cityObjectService = CityObjectService(cityObjectRepository)

}