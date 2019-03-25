package com.miage.altea.tp.pokemon_type_api.controller;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon-types")
public class PokemonTypeController {

    PokemonTypeService pokemonTypeService;

    @Autowired
    public PokemonTypeController(PokemonTypeService service) {
        this.pokemonTypeService = service;
    }

    @GetMapping(value = "/{id}")
    public PokemonType getPokemonTypeFromId(@PathVariable int id){
        return pokemonTypeService.getPokemonType(id);
    }

    /*
    @GetMapping(value = "/", params = "name")
    public PokemonType getPokemonTypeFromId(@RequestParam String name){
        return pokemonTypeService.getPokemonType(name);
    }*/

    @GetMapping(value = "/{name}")
    public PokemonType getPokemonTypeFromId(@RequestParam String name){
        return pokemonTypeService.getPokemonType(name);
    }

    @GetMapping(value = "")
    public List<PokemonType> getAllPokemonTypes() {
        return pokemonTypeService.getAllPokemonTypes();
    }
}



