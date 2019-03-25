package com.miage.altea.tp.pokemon_type_api.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Repository
public class PokemonTypeRepositoryImpl implements PokemonTypeRepository {


    private List<PokemonType> pokemons;

    public TranslationRepository translationRepository;

    public PokemonTypeRepositoryImpl() {
        try {
            var pokemonsStream = this.getClass().getResourceAsStream("/pokemons.json");

            var objectMapper = new ObjectMapper();
            var pokemonsArray = objectMapper.readValue(pokemonsStream, PokemonType[].class);
            this.pokemons = Arrays.asList(pokemonsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PokemonType findPokemonTypeById(int id) {


        // TODO

        PokemonType pokemon = new PokemonType();

        for (PokemonType poke : this.pokemons ) {
            if(poke.getId() == id){
                pokemon = poke;
            }
        }

        System.out.println("Loading Pokemon information for Pokemon id " + id + pokemon.getName());

        return pokemon ;
    }

    @Override
    public PokemonType findPokemonTypeByName(String name) {
        System.out.println("Loading Pokemon information for Pokemon name " + name);

        // TODO

        PokemonType pokemon = new PokemonType();

        for (PokemonType poke : this.pokemons ) {
            if(poke.getName().equals(name)){
                pokemon = poke;
            }
        }

        return pokemon ;
    }

    @Override
    public List<PokemonType> findAllPokemonType() {
        // TODO

        return this.pokemons;
    }


}