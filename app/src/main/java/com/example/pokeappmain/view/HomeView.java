package com.example.pokeappmain.view;

import com.example.pokeappmain.model.PokemonData;

import java.util.List;

public interface HomeView {

    void setData(List<PokemonData.Pokemon> pokemonList);
    void onErrorLoading(String message);

}
