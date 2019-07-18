package com.example.pokeappmain.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokeappmain.R;
import com.example.pokeappmain.model.PokemonDetail;
import com.robertlevonyan.views.chip.Chip;

import java.util.List;

public class PokemonStateAdapter extends RecyclerView.Adapter<PokemonStateAdapter.ItemViewHOlder> {

    private List<PokemonDetail.StateData> stateDataList;
    private Context context;

    public PokemonStateAdapter(List<PokemonDetail.StateData> stateDataList, Context context) {
        this.stateDataList = stateDataList;
        this.context = context;
    }

    public void setStateDataList(List<PokemonDetail.StateData> stateDataList) {
        this.stateDataList = stateDataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chip_item_state, parent, false);
        return new ItemViewHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHOlder holder, int position) {

        for (PokemonDetail.StateData item : stateDataList) {
            switch (item.getStatSpecific().getName()) {
                case "hp":
                    holder.hp.setChipText(String.valueOf(item.getBaseStat()));
                    break;

                case "attack":
                    holder.attack.setChipText(String.valueOf(item.getBaseStat()));
                    break;

                case "defense":
                    holder.defense.setChipText(String.valueOf(item.getBaseStat()));
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return stateDataList.size();
    }

    public class ItemViewHOlder extends RecyclerView.ViewHolder {

        Chip attack;
        Chip hp;
        Chip defense;

        private ItemViewHOlder(@NonNull View itemView) {
            super(itemView);
            attack = itemView.findViewById(R.id.chip_attack);
            hp = itemView.findViewById(R.id.chip_hp);
            defense = itemView.findViewById(R.id.chip_defense);
        }


    }
}
