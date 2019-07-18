package com.example.pokeappmain.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokeappmain.R;
import com.example.pokeappmain.Utils;
import com.example.pokeappmain.adapter.RecyclerViewHomeAdapter;
import com.example.pokeappmain.adapter.RecyclerViewOnScroll;
import com.example.pokeappmain.model.PokemonData;
import com.example.pokeappmain.view.detail.DetailFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity implements HomeView{


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.btn_refresh)
    FloatingActionButton btn_refresh;

    HomePresenter presenter;
    private List<PokemonData.Pokemon> items = new ArrayList<>();

    private static int offset;

    private static boolean isLoading;
    private RecyclerViewHomeAdapter homeAdapter;

    public static void setIsLoading(boolean isLoading) {
        HomeActivity.isLoading = isLoading;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        presenter = new HomePresenter(this);
        presenter.getData(offset);
        offset = 0;
        isLoading = true;

        homeAdapter = new RecyclerViewHomeAdapter(items, this);

        recyclerView.setAdapter(homeAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerViewOnScroll() {
            @Override
            protected void loadMore() {

                if (isLoading) {
                    offset+=30;
                    presenter.getData(offset);
                    isLoading = false;
                    homeAdapter.setPokemonList(items);
                }
            }
        });
        homeAdapter.setListener(new RecyclerViewHomeAdapter.ListItemClickListener() {
            @Override
            public void itemOnClick(View view, int position) {
                showDetailFragment(position);
            }
        });
    }

    private void showDetailFragment(int position) {
        DetailFragment detailFragment = new DetailFragment(position);
        detailFragment.show(getSupportFragmentManager(), "detailFragment");
    }

    @Override
    public void setData(List<PokemonData.Pokemon> pokemons) {
        items.addAll(pokemons);
        homeAdapter.setPokemonList(items);
        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.clear();
                presenter.getData((int)(Math.random() * (100+1-0)) + 0);
                homeAdapter.setPokemonList(items);
            }
        });

    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(this, "Tittle", message);
    }

}
