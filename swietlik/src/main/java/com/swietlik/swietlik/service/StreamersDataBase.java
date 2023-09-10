package com.swietlik.swietlik.service;

import com.swietlik.swietlik.controller.BadRequestException;
import com.swietlik.swietlik.controller.NotFoundException;
import com.swietlik.swietlik.model.Streamer;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StreamersDataBase {
    private List<Streamer> dataBaseStreamers;

    @PostConstruct
    public void loadData() {
        dataBaseStreamers = new ArrayList<>();
        dataBaseStreamers.add(new Streamer(1, "Ala"));
        dataBaseStreamers.add(new Streamer(2, "Masza"));
    }



    public Streamer getStreamer(int streamerId) {
        Optional<Streamer> optionalStreamer = dataBaseStreamers.stream()
                .filter(streamer -> streamer.getId() == streamerId)
                .findFirst();
        if(optionalStreamer.isPresent()){
            return optionalStreamer.get();
        }else {
            throw new NotFoundException("Streamer id not found - "+streamerId);
        }
    }

    public List<Streamer> findAllStreamers() {
        return dataBaseStreamers;
    }


    public Streamer addStr(Streamer str) {
        Optional<Streamer> addStreamer = dataBaseStreamers.stream()
                .filter(streamer -> streamer.getId() == str.getId())
                .findFirst();
        if(addStreamer.isPresent()){
            throw new NotFoundException("Streamer with that id already exist");
        }else{
            dataBaseStreamers.add(str);
            return str;
        }
    }

    public void saveStreamer(Streamer streamer) {
        dataBaseStreamers.stream()
                .filter(str -> str.getId() == streamer.getId())
                .forEach(str -> str.setUsername(streamer.getUsername()));
    }

    public void deleteStreamer(int id) {
        Optional<Streamer> delStreamer = dataBaseStreamers.stream().filter(streamer -> streamer.getId() ==id)
                .findFirst();
        dataBaseStreamers.remove(delStreamer);
    }

}
