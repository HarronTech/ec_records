package com.harrontech.ec_records.integration

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.harrontech.controller.CityObjectController
import com.harrontech.model.CityObject
import com.harrontech.repository.CityObjectRepository
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.http.MediaType
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
@TestPropertySource(properties = ["spring.mongodb.embedded.version=3.5.5"])
@EnableMongoRepositories(basePackageClasses = [CityObjectRepository::class])
@WebMvcTest(CityObjectController::class)
class CityObjectControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

//    @Autowired
//    lateinit var repository: CityObjectRepository

    @Test
    fun shouldReturnDefaultMessage() {
        var objectMapper = ObjectMapper()
        objectMapper.registerModule(JavaTimeModule())

        var body = objectMapper.writeValueAsString(CityObject())

        mockMvc.perform(post("/")
            .content(body)
            .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())


//        MatcherAssert.assertThat(repository.findAll().size, CoreMatchers.`is`(1))
    }

    @Test
    fun test() {
        mockMvc.perform(get("/"))
            .andDo(print())
            .andExpect(status().isOk())
    }
}