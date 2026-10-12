package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals = new HashMap<>();

    public AnimalController() {
        animals.put(1, new Animal(1, "maymun"));
    }

    // Bütün hayvanları listele
    @GetMapping
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(animals.values());
    }

    // ID'ye göre hayvan getir
    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Integer id) {
        return animals.get(id);
    }

    // Yeni hayvan ekle
    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;
    }

    // Hayvan güncelle
    @PutMapping("/{id}")
    public Animal updateAnimal(
            @PathVariable Integer id,
            @RequestBody Animal animal) {

        if (!animals.containsKey(id)) {
            return null;
        }

        animals.remove(id);
        animals.put(animal.getId(), animal);

        return animal;
    }

    // Hayvan sil
    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Integer id) {
        animals.remove(id);
    }

}
