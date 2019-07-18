package com.example.pokeappmain.model;

import com.squareup.moshi.Json;

import java.util.List;

public class PokemonData {
    @Json(name = "results")
    private List<Pokemon> results = null;

    public List<Pokemon> getResults() {
        return results;
    }

    public static class Pokemon {

        private int id;
        @Json(name = "name")
        private String name;
        @Json(name = "url")
        private String url;


        public int getId() {
            String[] urlPart = url.split("/");
            return Integer.parseInt(urlPart[urlPart.length-1]);
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }
}
