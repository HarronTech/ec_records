package com.harrontech.ec_records.integration

import com.harrontech.ec_records.model.CityObject
import com.harrontech.ec_records.repository.CityObjectRepository
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.test.context.TestPropertySource

@SpringBootTest
@TestPropertySource(properties = ["spring.mongodb.embedded.version=3.5.5"])
@EnableMongoRepositories(basePackageClasses = [CityObjectRepository::class])
class CityObjectRepositoryTest {

    @Autowired
    lateinit var repository: CityObjectRepository

    @Test
    fun `test`() {
        val obj = CityObject()

        //when
        val result = repository.save(obj)

        //then
        assertThat(obj.id, `is`(result.id))

        var t = repository.findById(obj.id).get()
        assertThat(repository.findById(obj.id).get(), notNullValue())
    }
}