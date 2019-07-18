package com.example.pokeappmain.Common;

import android.graphics.Color;

import com.example.pokeappmain.model.PokemonDetail;

import java.util.ArrayList;
import java.util.List;

public class Common {

    public static int getColorByType(String type) {
        switch(type)
        {

            case "normal":
                return Color.parseColor("#A4A27A");


            case "dragon":
                return Color.parseColor("#743BFB");



            case "psychic":
                return Color.parseColor("#F15B85");


            case "electric":
                return Color.parseColor("#E9CA3C");


            case "ground":
                return Color.parseColor("#D9BF6C");


            case "grass":
                return Color.parseColor("#81C85B");

            case "poison":
                return Color.parseColor("#A441A3");

            case "steel":
                return Color.parseColor("#BAB7D2");


            case "fairy":
                return Color.parseColor("#DDA2DF");


            case "fire":
                return Color.parseColor("#F48130");


            case "fight":
                return Color.parseColor("#BE3027");


            case "bug":
                return Color.parseColor("#A8B822");


            case "ghost":
                return Color.parseColor("#705693");


            case "dark":
                return Color.parseColor("#745945");


            case "ice":
                return Color.parseColor("#9BD8D8");


            case "water":
                return Color.parseColor("#658FF1");
            default:
                return Color.parseColor("#658FA0");
        }
    }

}

