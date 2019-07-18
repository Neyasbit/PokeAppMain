package com.example.pokeappmain.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class RecyclerViewOnScroll extends RecyclerView.OnScrollListener {

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if ( dy > 0) {

            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            int visibleItemCount = gridLayoutManager.getChildCount();//смотрим сколько элементов на экране
            int totalItemCount = gridLayoutManager.getItemCount();//сколько всего элементов
            int firstVisibleItems = gridLayoutManager.findFirstVisibleItemPosition();//какая позиция первого элемента

            if ((visibleItemCount + firstVisibleItems) >= totalItemCount) {
                loadMore();
            }
        }
    }

    protected abstract void loadMore();

}
