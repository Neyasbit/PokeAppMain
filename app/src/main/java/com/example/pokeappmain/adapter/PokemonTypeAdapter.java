package com.example.pokeappmain.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokeappmain.Common.Common;
import com.example.pokeappmain.R;
import com.example.pokeappmain.model.PokemonDetail;
import com.robertlevonyan.views.chip.Chip;

import java.util.List;

public class PokemonTypeAdapter extends RecyclerView.Adapter<PokemonTypeAdapter.ItemViewHolder> {

    private List<PokemonDetail.TypeData> typeDataList;
    private Context context;

    public PokemonTypeAdapter(List<PokemonDetail.TypeData> typeDataList, Context context) {
        this.typeDataList = typeDataList;
        this.context = context;
    }

    public void setTypeDataList(List<PokemonDetail.TypeData> typeDataList) {
        this.typeDataList = typeDataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chip_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        PokemonDetail.TypeData item = typeDataList.get(position);
        holder.chip.setChipText(item.getType().getName());
        holder.chip.changeBackgroundColor(Common.getColorByType(item.getType().getName()));
    }

    @Override
    public int getItemCount() {
        return typeDataList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        Chip chip;

        private ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            chip = itemView.findViewById(R.id.chip);
        }
    }
}
