package com.example.pokeappmain.api;

import com.example.pokeappmain.model.PokemonData;
import com.example.pokeappmain.model.PokemonDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("pokemon")
    Call<PokemonData> getData(@Query("offset") int offset, @Query("limit") int limit);

    @GET("pokemon/{id}")
    Call<PokemonDetail> getDetailPokemon(@Path("id") int id);
}
