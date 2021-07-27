package com.example.SpringBootConsumer.model
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*


@JsonIgnoreProperties(ignoreUnknown = true)
data class Person(

        var id:Long?=-1,
        var name:String?="",
        var email:String?="",
        var gender:String?="",
        var address:String?="",

        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Paris")
        var dateOfBirth:Date?=null
)
