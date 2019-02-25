package com.miage.altea.tp.pokemon_type_api.controller;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pokemon-types")
public class PokemonTypeController {

    public PokemonTypeService servicePokemon ;

    @Autowired
    public PokemonTypeController(PokemonTypeService service) {
        this.servicePokemon = service;
    }

    @GetMapping("/{id}")
    public PokemonType getPokemonTypeFromId(@PathVariable int id){
        // TODO

        return this.servicePokemon.getPokemonType(id);

    }

    @GetMapping("/")
    public List<PokemonType> getAllPokemonTypes() {
        // TODO

        return  this.servicePokemon.getAllPokemonTypes();
    }


    @GetMapping(value = "", params = "name")
    public PokemonType getPokemonByName(@RequestParam String name){
        return this.servicePokemon.getPokemonTypeByName(name);
    }


    public PokemonTypeService getServicePokemon() {
        return servicePokemon;
    }


}
