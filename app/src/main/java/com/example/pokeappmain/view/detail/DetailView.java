package com.example.pokeappmain.view.detail;

import com.example.pokeappmain.model.PokemonDetail;

import java.util.List;

public interface DetailView {

    void setDetailPokemon(PokemonDetail pokemon);
    void setState(List<PokemonDetail.StateData> stateList);
    void setType(List<PokemonDetail.TypeData> typeList);
    void onErrorLoading(String message);
}
