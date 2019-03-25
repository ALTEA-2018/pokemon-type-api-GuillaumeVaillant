package com.miage.altea.tp.pokemon_type_api.service;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.repository.PokemonTypeRepository;
import com.miage.altea.tp.pokemon_type_api.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{

    public PokemonTypeRepository pokemonTypeRepository;

    private TranslationRepository translationRepository;

    @Override
    public PokemonType getPokemonType(int id) {
        // TODO

        PokemonType pokemonType = this.pokemonTypeRepository.findPokemonTypeById(id);
        System.out.println(pokemonType);
        pokemonType.setName(this.translationRepository.getPokemonName(id, LocaleContextHolder.getLocale()));

        return pokemonType;
    }

    @Override
    public List<PokemonType> getAllPokemonTypes(){
        // TODO
        List<PokemonType> pokemonTypes = this.pokemonTypeRepository.findAllPokemonType();
        return pokemonTypes.stream().peek(type -> {
            String name = this.translationRepository.getPokemonName(type.getId(), LocaleContextHolder.getLocale());
            type.setName(name);
        }).collect(Collectors.toList());
    }

    @Override
    public PokemonType getPokemonType(String name) {
        return this.pokemonTypeRepository.findPokemonTypeByName(name);
    }

    @Autowired
    public void setPokemonTypeRepository(PokemonTypeRepository pokemon) {
        this.pokemonTypeRepository = pokemon;
    }

    @Autowired
    public void setTranslationRepository(TranslationRepository translation) {
        this.translationRepository = translation;
    }


}