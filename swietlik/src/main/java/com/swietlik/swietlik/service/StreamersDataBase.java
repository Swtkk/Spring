package com.swietlik.swietlik.service;

import com.swietlik.swietlik.controller.AlreadyExistException;
import com.swietlik.swietlik.controller.NotFoundException;
import com.swietlik.swietlik.model.Streamer;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

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


    public Streamer getStreamerById(int streamerId) {
        return dataBaseStreamers.stream()
                .filter(streamer -> streamer.getId() == streamerId)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Streamer id not found - " + streamerId));
    }


    public List<Streamer> findAllStreamers() {
        return dataBaseStreamers;
    }


    public Streamer addStr(Streamer str) throws AlreadyExistException {
        Optional<Streamer> addStreamer = dataBaseStreamers.stream()
                .filter(streamer -> streamer.getId() == str.getId())
                .findFirst();
        if (addStreamer.isPresent()) {
            throw new AlreadyExistException("Streamer with that id already exist");
        }
        dataBaseStreamers.add(str);
        return str;

    }

    public void updateStreamer(Streamer streamer) {
        dataBaseStreamers.stream()
                .filter(str -> str.getId() == streamer.getId())
                .forEach(str -> str.setUsername(streamer.getUsername()));
    }

    public void deleteStreamer(int id) {
        dataBaseStreamers.removeIf(streamer -> streamer.getId() == id);
    }

}
