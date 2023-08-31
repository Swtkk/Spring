package com.swietlik.swietlik.service;

import com.swietlik.swietlik.model.Streamer;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import java.util.ArrayList;
import java.util.List;

@Service
public class StreamersDataBase {
    private List<Streamer> dataBaseStreamers;


    @PostConstruct
    public void loadData() {
        dataBaseStreamers = new ArrayList<>();
        dataBaseStreamers.add(new Streamer(1, "Ala"));
        dataBaseStreamers.add(new Streamer(2, "Masza"));
    }

//    public Streamer getStreamer(int streamerId) {
//        for(Streamer streamer: dataBaseStreamers){
//            if(streamer.getId() == streamerId){
//                return streamer;
//            }
//
//
//        }
//        return null;
//    }
    public Streamer getStreamer(int streamerId) {

            Streamer streamer = null;
            for (Streamer streamer1 : dataBaseStreamers) {
                if (streamer1.getId() == streamerId) {
                    streamer = streamer1;
                    break;
                }
            }
            if (streamer != null) {
                return ResponseEntity.ok(streamer).getBody();
            } else if(streamerId < 0 || streamerId > dataBaseStreamers.size()) {
                 ResponseEntity.notFound().build();
                return null;
           }

            return null;
    }

    public List<Streamer> findAllStreamers() {
        return dataBaseStreamers;
    }

    public void saveStreamer(Streamer streamer) {
        for(Streamer streamer1: dataBaseStreamers){
            if(streamer1.getId() == streamer.getId()){
                streamer1.setUsername(streamer.getUsername());

            }
        }
    }

    public void deleteStreamer(int id) {
        dataBaseStreamers.remove(id);
        ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
