package com.example.pokeappmain.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokeappmain.R;
import com.example.pokeappmain.model.PokemonData;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewHomeAdapter extends RecyclerView.Adapter<RecyclerViewHomeAdapter.RecyclerViewHolder> {

    private List<PokemonData.Pokemon> pokemonList;
    private Context context;
    private ListItemClickListener listener;

    public RecyclerViewHomeAdapter(List<PokemonData.Pokemon> pokemonList, Context context) {
        this.pokemonList = pokemonList;
        this.context = context;

    }

    public void setPokemonList(List<PokemonData.Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
        notifyDataSetChanged();
    }

    public void setListener(ListItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pokemon, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        PokemonData.Pokemon item = pokemonList.get(position);
        holder.bind(item);
    }
    public interface ListItemClickListener {
        void itemOnClick(View view, int position);
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.iv_pokemon_avatar)
        ImageView iv_pokemon_avatar;
        @BindView(R.id.tv_pokemon_name)
        TextView tv_pokemon_name;
        LinearLayout item;


        private RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            item = itemView.findViewById(R.id.ll_item);
            item.setOnClickListener(this);
        }

        void bind(PokemonData.Pokemon type) {
            tv_pokemon_name.setText(type.getName());
            Picasso.get()
                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + type.getId() + ".png")
                    .into(iv_pokemon_avatar);

        }

        @Override
        public void onClick(View view) {
            listener.itemOnClick(view, pokemonList.get(getAdapterPosition()).getId());
        }
    }
}
