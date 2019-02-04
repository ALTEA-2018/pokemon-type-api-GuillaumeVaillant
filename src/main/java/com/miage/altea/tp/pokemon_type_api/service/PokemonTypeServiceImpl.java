package com.miage.altea.tp.pokemon_type_api.service;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.repository.PokemonTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{

    @Autowired
    public PokemonTypeRepository pokemonTypeRepository;

    public PokemonTypeServiceImpl(PokemonTypeRepository pokemon){ // TODO

        this.pokemonTypeRepository = pokemon;
    }

    @Override
    public PokemonType getPokemonType(int id) {
        // TODO
        return this.pokemonTypeRepository.findPokemonTypeById(id);
    }

    @Override
    public List<PokemonType> getAllPokemonTypes(){
        // TODO
        return this.pokemonTypeRepository.findAllPokemonType();
    }
}