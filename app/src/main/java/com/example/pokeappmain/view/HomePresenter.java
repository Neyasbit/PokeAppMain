package com.example.pokeappmain.view;

import com.example.pokeappmain.Utils;
import com.example.pokeappmain.model.PokemonData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {

    private HomeView view;


    public HomePresenter(HomeView view) {
        this.view = view;
    }

    void getData(int offset) {

        Call<PokemonData> pokemonDataCall = Utils.getApi().getData(offset, 30);

        pokemonDataCall.enqueue(new Callback<PokemonData>() {
            @Override
            public void onResponse(Call<PokemonData> call, Response<PokemonData> response) {

                HomeActivity.setIsLoading(true);

                if (response.isSuccessful() && response.body() != null) {
                    view.setData(response.body().getResults());
                }
                else {
                    view.onErrorLoading(response.message());
                }
            }

            @Override
            public void onFailure(Call<PokemonData> call, Throwable t) {
                HomeActivity.setIsLoading(true);
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
