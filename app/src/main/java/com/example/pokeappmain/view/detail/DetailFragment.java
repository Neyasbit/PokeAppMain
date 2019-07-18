package com.example.pokeappmain.view.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokeappmain.R;
import com.example.pokeappmain.Utils;
import com.example.pokeappmain.adapter.PokemonStateAdapter;
import com.example.pokeappmain.adapter.PokemonTypeAdapter;
import com.example.pokeappmain.model.PokemonDetail;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DetailFragment extends DialogFragment implements DetailView{
    @BindView(R.id.tv_detail_name)
    TextView detail_name;
    @BindView(R.id.tv_detail_height)
    TextView detail_height;
    @BindView(R.id.tv_detail_weight)
    TextView detail_weight;
    @BindView(R.id.iv_pokemon_avatar_detail)
    ImageView avatar_detail;
    @BindView(R.id.recyclerView_stat)
    RecyclerView recyclerView_state;
    @BindView(R.id.recyclerView_type)
    RecyclerView recyclerView_type;

    private int position;
    private List<PokemonDetail.StateData> stateDataList = new ArrayList<>();
    private List<PokemonDetail.TypeData> typeDataList = new ArrayList<>();
    private PokemonTypeAdapter typeAdapter;
    private PokemonStateAdapter stateAdapter;

    public DetailFragment(int position) {
        this.position  = position;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Light);
        DetailPresenter presenter = new DetailPresenter(this);
        presenter.getPokemon(position);
        typeAdapter = new PokemonTypeAdapter(typeDataList, getActivity());
        stateAdapter = new PokemonStateAdapter(stateDataList, getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_pokemon_detail, container);
        Unbinder unbinder = ButterKnife.bind(this, view);
        Picasso.get()
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + position +".png")
                .into(avatar_detail);
        recyclerView_state.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        recyclerView_state.setHasFixedSize(true);
        recyclerView_state.setAdapter(stateAdapter);

        recyclerView_type.setAdapter(typeAdapter);
        recyclerView_type.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        recyclerView_type.setHasFixedSize(true);

        return view;
    }

    @Override
    public void setDetailPokemon(PokemonDetail pokemon) {
        PokemonDetail pokemonDetail = pokemon;
        detail_name.setText(pokemonDetail.getName());
        detail_weight.setText("Weight: "+String.valueOf(pokemonDetail.getWeight()));
        detail_height.setText("Height: "+String.valueOf(pokemonDetail.getHeight()));
    }

    @Override
    public void setState(List<PokemonDetail.StateData> stateList) {
        stateDataList.addAll(stateList);
        stateAdapter.setStateDataList(stateDataList);
    }

    @Override
    public void setType(List<PokemonDetail.TypeData> typeList) {
        typeDataList.addAll(typeList);
        typeAdapter.setTypeDataList(typeDataList);
    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(getContext(), "Tittle", message);
    }
}
