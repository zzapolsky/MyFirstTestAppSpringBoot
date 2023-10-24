package ru.arkhipov.MyFirstTestAppSpringBoot.hello;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class HelloController {
    List<String> array = new ArrayList<>();
    HashMap<String, String> hashMap = new HashMap<>();
    @GetMapping("/hello")
    public String hello(@RequestParam (value= "name", defaultValue = "World") String name){
        return String.format("Hello %s!", name);
    }
    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam ( value = "value", defaultValue = "") String value) {
        if (array.isEmpty()) {
            array = new ArrayList<>();}
            array.add(value);
            return "Done";
        }
    @GetMapping("/show-array")
    public String showArrayList() {
        return Arrays.toString(array.toArray());
    }
    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "value", defaultValue = " ") String value) {
        if (hashMap.isEmpty()) {
            hashMap = new HashMap<>();
        }
        hashMap.put(value, value);
        return "done";
    }

    @GetMapping("/show-map")
    public String showHashMap() {
        return Arrays.toString(hashMap.entrySet().toArray());
    }

    @GetMapping("/show-all-length")
    public String ShowAllLength() {
        return "Количество элементов ArrayList = " + array.size() + "\n" +
                "Количество элементов HashMap = " + hashMap.size();
    }
}
