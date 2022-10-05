package com.zoo.zookeeperrr;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private AnimalsRepository AnimalsRepository;

    @GetMapping("/Animals")
    public List<Animals> getAllAnimals() {
        return AnimalsRepository.findAll();
    }

    @PostMapping("/Animals")
    public Animals createNewAnimals(@RequestBody Animals AnimalsData) {
        return AnimalsRepository.save(AnimalsData);
    }

    @DeleteMapping("/Animals/{id}")
    public String deleteAnimals(@PathVariable Integer id) {
        AnimalsRepository.deleteById(id);
        return "Shush";
    }

    @PatchMapping("/Animals/{id}")
    public Animals updateAnimals(@RequestBody Animals AnimalsData, @PathVariable Integer id) {
        AnimalsData.id = id;
        return AnimalsRepository.save(AnimalsData);
    }
}

@Entity
class Animals {
    @Id
    @GeneratedValue
    public Integer id;
    public String name;
    public String species;
    public String origin;;
    public Boolean isHungry;

    public Animals() {
    }
}

interface AnimalsRepository extends JpaRepository<Animals, Integer> {
}
// @GetMapping("/animal")
// public List<Animals> getAllAnimal() {
// return animalsRepo.findAll();
// }

// @GetMapping("/animal")
// public List<Animals> getAllAnimals() {
// return animalsRepo.findAll();
// }

// @Entity
// class Animals {

// @Id
// @GeneratedValue
// public Integer id;
// public String name;
// public String species;
// public String origin;;
// public Boolean isHungry;

// public Animals() {
// }
// }
// }

// interface AnimalsRepo extends JpaRepository<Animals, Integer> {
// }
