package com.miage.altea.tp.pokemon_type_api.controller;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public PokemonTypeService getServicePokemon() {
        return servicePokemon;
    }

    public void setServicePokemon(PokemonTypeService servicePokemon) {
        this.servicePokemon = servicePokemon;
    }
}
