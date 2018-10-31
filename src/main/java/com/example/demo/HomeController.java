package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    PetRepository petRepository;


    @RequestMapping("/")
    public String index(Model model){
        Set<Person> owners = new HashSet<Person>();
        Person person = new Person();
        person.setName("Emily");
        owners.add(person);

        Person person2 = new Person();
        person2.setName("Lora");
        owners.add(person2);

        Set<Pet> pets = new HashSet<Pet>();

       /* pets.add(new Pet("cat", "Gerda", "2"));
        pets.add(new Pet("dog", "Kheruka", "3"));
        pets.add(new Pet("snake", "Stripe", "4"));
        pets.add(new Pet("parrot", "Kay", "5"));*/

        Pet pet = new Pet();
        pet.setCategory("cat");
        pet.setName("Gerda");
        pet.setAge("1");
        pet.setPerson(person);
        pets.add(pet);

        Pet pet2 = new Pet();
        pet2.setCategory("dog");
        pet2.setName("Kheruka");
        pet2.setAge("3");
        pet2.setPerson(person);
        pets.add(pet2);

        Pet pet3 = new Pet();
        pet3.setCategory("snake");
        pet3.setName("Stripe");
        pet3.setAge("4");
        pet3.setPerson(person2);
        pets.add(pet3);

        Pet pet4 = new Pet();
        pet4.setCategory("parrot");
        pet4.setName("Kay");
        pet4.setAge("5");
        pet4.setPerson(person2);
        pets.add(pet4);

        petRepository.save(pet);
        petRepository.save(pet2);
        petRepository.save(pet3);
        petRepository.save(pet4);

        person.getPets().add(pet);
        person.getPets().add(pet2);
        person2.getPets().add(pet3);
        person2.getPets().add(pet4);



       /*person.addPet(new Pet("cat", "Gerda", "1"));
       person.addPet(new Pet("dog", "Kheruka", "3"));
       person2.addPet(new Pet("snake", "Stripe", "4"));
       person2.addPet(new Pet("parrot", "Kay", "5"));*/


        personRepository.save(person);
        personRepository.save(person2);
        model.addAttribute("persons", personRepository.findAll());
        return "index";

    }

}
