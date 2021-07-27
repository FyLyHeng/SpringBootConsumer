package com.example.SpringBootConsumer.controller

import com.example.SpringBootConsumer.model.Person
import com.example.SpringBootConsumer.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import java.sql.DriverManager.println

@Controller
@RequestMapping("/person")
class PersonController {

    @Autowired
    lateinit var personService: PersonService

    @RequestMapping("/")
    fun index(map: ModelMap): String {
        println("print mee here list all bro")
        map.addAttribute("persons", personService.listPerson())
        map.addAttribute("heading", "List All Account")
        return "person"
    }

    @RequestMapping("/edit/{id}")
    fun edit(@PathVariable id: Long, map: ModelMap): String {
        println("print mee here edit bro")

        val account = personService.getPerson(id)
        map.addAttribute("person", account)
        map.addAttribute("heading", "Edit Account")
        return "editPerson"
    }

    @RequestMapping("/update")
    fun edit(map: ModelMap, person: Person): String {
        println("print mee here comsum save-update bro")

        //personService.savePerson(person)
        val persons = personService.listPerson()

        map.addAttribute("persons", persons)
        map.addAttribute("heading", "List All Account")
        return "redirect:/person/"
    }


    @RequestMapping("/add")
    fun save(map: ModelMap): String {
        println("print mee here save bro")

        var newPerson = Person()
        map.addAttribute("person",newPerson)
        map.addAttribute("heading", "Add new Person")
        return "editPerson"
    }


    @RequestMapping("/delete/{id}")
    fun delete(@PathVariable id:Long, map: ModelMap):String {
        println("print mee here delete bro")
        //personService.deletePerson(id)
        val allPerson = personService.listPerson()
        map.addAttribute("persons",allPerson)
        map.addAttribute("heading","List All Account")
        return "redirect:/person/"
    }
}