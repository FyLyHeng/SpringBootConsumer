package com.example.SpringBootConsumer.service

import com.example.SpringBootConsumer.integrationConfig.RESTConstant
import com.example.SpringBootConsumer.model.Person
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.exchange
import org.springframework.web.client.getForObject
import org.springframework.web.client.postForObject


@Service
class PersonService(val personRepo: RestTemplate = RestTemplate()) {
    private inline fun <reified T> typeReference() = object : ParameterizedTypeReference<T>() {}

    fun listPerson(): MutableList<Person>? {

        val headers = HttpHeaders()
        headers.set("x-client", "kotlin-test-client")

        val response: ResponseEntity<MutableList<Person>>? =
                personRepo.exchange(
                        url = "${RESTConstant.URL_BASE}/person",
                        method = HttpMethod.GET,
                        requestEntity = HttpEntity("parameters", headers),
                        typeReference<MutableList<Person>>()
                )
        return response?.body
    }

    fun getPerson(id: Long): Person {
        return personRepo.getForObject("${RESTConstant.URL_BASE}/person/$id", Person::class)
    }

    fun updatePerson(person: Person): Person {
        return personRepo.postForObject(
                url = "${RESTConstant.URL_BASE}/person",
                Person::class
        )
    }


    fun savePerson(person: Person): Person {
        return personRepo.postForObject(
                url = "${RESTConstant.URL_BASE}/person",
                Person::class
        )
    }


    fun deletePerson(id: Long) {
        personRepo.delete("${RESTConstant.URL_BASE}/person/$id")
    }
}