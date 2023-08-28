package com.swietlik.swietlik.service;

import com.swietlik.swietlik.controller.StreamersController;
import com.swietlik.swietlik.model.Streamers;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service
public class StreamersDataBase {
    List<Streamers> DataBaseStreamers;


    @PostConstruct
    public void loadData() {
        DataBaseStreamers = new ArrayList<>();
        DataBaseStreamers.add(new Streamers(1, "Ala"));
        DataBaseStreamers.add(new Streamers(2, "Masza"));
    }

    public Streamers getStreamer(int streamerId) {
        return DataBaseStreamers.get(streamerId);
    }

    public List<Streamers> findAllStreamers() {
        return DataBaseStreamers;
    }

    public void saveStreamer(Streamers streamer) {
        DataBaseStreamers.add(streamer);
    }
    public void deleteStreamer(int id) {DataBaseStreamers.remove(id);}

}
