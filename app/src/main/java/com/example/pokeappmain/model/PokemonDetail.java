package com.example.pokeappmain.model;

import com.squareup.moshi.Json;

import java.util.List;

public class PokemonDetail {
    @Json(name = "height")
    private Integer height;
    @Json(name = "name")
    private String name;
    @Json(name = "sprites")
    private Sprites sprites;
    @Json(name = "types")
    private List<TypeData> types = null;
    @Json(name = "stats")
    private List<StateData> stats = null;
    @Json(name = "weight")
    private Integer weight;

    public Integer getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public List<TypeData> getTypes() {
        return types;
    }

    public List<StateData> getStats() {
        return stats;
    }

    public Integer getWeight() {
        return weight;
    }

    public static class Sprites {

        @Json(name = "front_default")
        private String frontDefault;

        public String getFrontDefault() {
            return frontDefault;
        }
    }

    public static class StateData {

        @Json(name = "base_stat")
        private Integer baseStat;
        @Json(name = "effort")
        private Integer effort;
        @Json(name = "stat")
        private StatSpecific statSpecific;

        public Integer getBaseStat() {
            return baseStat;
        }

        public Integer getEffort() {
            return effort;
        }

        public StatSpecific getStatSpecific() {
            return statSpecific;
        }
    }

    public static class StatSpecific {

        @Json(name = "name")
        private String name;

        public String getName() {
            return name;
        }

    }

    public static class TypeData {

        @Json(name = "slot")
        private Integer slot;
        @Json(name = "type")
        private Type type;

        public Integer getSlot() {
            return slot;
        }

        public Type getType() {
            return type;
        }
    }

    public static class Type {

        @Json(name = "name")
        private String name;

        public String getName() {
            return name;
        }

    }
}
