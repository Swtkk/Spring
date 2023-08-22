package com.swietlik.swietlik.rest;


import com.swietlik.swietlik.entity.Strimerki;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

        List<Strimerki> strimerki =new ArrayList<>();


    @GetMapping("/strimerki")
    public List<Strimerki> getStrimerki(){
        return strimerki;
    }


    @GetMapping("/strimerki/{strimerkaId}")
    public Strimerki getStrimerka(@PathVariable int strimerkaId){

        return strimerki.get(strimerkaId);
    }

    @PostMapping("/strimerki")
    public Strimerki addStrimerka(@RequestBody Strimerki strim){
        Strimerki strimerka = new Strimerki();

        strimerka.setId(strim.getId());
        strimerka.setUsername(strim.getUsername());
        getStrimerki().add(strimerka);
        return strimerka;
    }
}
