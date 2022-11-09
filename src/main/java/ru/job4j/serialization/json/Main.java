package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /* JSONObject из json-строки строки */
        JSONObject jsonArcher = new JSONObject("{\"skills\":\"Shoots fire arrows\"}");
        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Alive");
        list.add("Light");
        JSONArray jsonStatuses = new JSONArray(list);
        /* JSONObject напрямую методом put */
        final Archer archer = new Archer(false, 234,
                new ArcherSkills("Shoots fire arrows"), "Elf", new String[] {"Alive", "Light"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", archer.isSex());
        jsonObject.put("range", archer.getRange());
        jsonObject.put("skills", archer.getSkills());
        jsonObject.put("race", archer.getRace());
        jsonObject.put("statuses", archer.getStatuses());
        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());
        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(archer).toString());
    }
}

