package com.example.pokeappmain.view.detail;

import android.view.View;

import androidx.fragment.app.DialogFragment;

import com.example.pokeappmain.Utils;
import com.example.pokeappmain.api.ApiService;
import com.example.pokeappmain.api.PokeClient;
import com.example.pokeappmain.model.PokemonDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter {

    private DetailView view;
    private DetailFragment fragment;

    public DetailPresenter(DetailView view) {
        this.view = view;
    }

    void getPokemon(int id) {
        Call<PokemonDetail> call = Utils.getApi().getDetailPokemon(id);

        call.enqueue(new Callback<PokemonDetail>() {
            @Override
            public void onResponse(Call<PokemonDetail> call, Response<PokemonDetail> response) {
                if (response.isSuccessful() && response.body() != null) {
                    view.setDetailPokemon(response.body());
                    view.setState(response.body().getStats());
                    view.setType(response.body().getTypes());
                }
                else {
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(Call<PokemonDetail> call, Throwable t) {
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
