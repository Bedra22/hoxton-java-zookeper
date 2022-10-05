package com.zoo.zookeeperrr;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private AnimalsRepository animalsRepository;

    @GetMapping("/animal")
    public List<Animals> getAllAnimal() {
        return animalsRepository.findAll();
    }

    @Entity
    class Animals {

        @Id
        @GeneratedValue
        public Integer id;
        public String name;
        public String species;
        public String origin;
        public Boolean isHungry;

        public Animals() {
        }
    }

    interface AnimalsRepository extends JpaRepository<Animals, Integer> {
    }

}
