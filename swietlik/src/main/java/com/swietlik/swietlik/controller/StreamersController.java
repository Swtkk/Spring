package com.swietlik.swietlik.rest;


import com.swietlik.swietlik.entity.Strimerki;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    List<Strimerki> strimerki = new ArrayList<>();
    static Map<Integer,String> DataBase = new HashMap<>();
    @Bean
    public static void creatingMockData(){
        DataBase.put(DataBase.size()+1, "skarpetyki");
        DataBase.put(DataBase.size()+1, "dupa");
    }

    @GetMapping("/strimerki")
    public Map<Integer,String> getStrimerki() {
        return DataBase;
    }


    @GetMapping("/strimerki/{strimerkaId}")
    public Strimerki getStrimerka(@PathVariable int strimerkaId) {
        return strimerki.get(strimerkaId);
    }

//    @PostMapping("/strimerki")
//    public Strimerki addStrimerka(@RequestBody Strimerki strim) {
//        Strimerki strimerka = new Strimerki();
//        strimerka.setId(strim.getId());
//        strimerka.setUsername(strim.getUsername());
//        getStrimerki().add(strimerka);
//        return strimerka;
//    }
}
