package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Archer archer = new Archer(false, 234,
                new ArcherSkills("Shoots fire arrows"),
                "Elf", new String[] {"Alive", "Light"});
        /* Преобразовал объект archer в json-строку */
        final Gson gson = new GsonBuilder().create();
        String gsonString = gson.toJson(archer);
        System.out.println(gsonString);
        final  Archer archerMod = gson.fromJson(gsonString, Archer.class);
        System.out.println(archerMod);
    }
}
