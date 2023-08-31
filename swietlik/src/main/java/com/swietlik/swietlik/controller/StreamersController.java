package com.swietlik.swietlik.controller;


import com.swietlik.swietlik.model.Streamer;
import com.swietlik.swietlik.service.StreamersDataBase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/streamers")
public class StreamersController {

    private final StreamersDataBase theDataBase;


    @GetMapping()
    public List<Streamer> findAll() {
        return theDataBase.findAllStreamers();
    }


    @GetMapping("/{streamerId}")
    public Streamer getStreamer(@PathVariable int streamerId) {
       return theDataBase.getStreamer(streamerId);

    }
    @PostMapping()
    public Streamer addStreamer(@RequestBody Streamer streamer){

        return new Streamer(streamer.getId(),streamer.getUsername());
    }
    @PutMapping()
    public void updateStreamer(@RequestBody Streamer streamer){

     theDataBase.saveStreamer(streamer);
    }
    @DeleteMapping("/{streamerId}")
    public void deleteStreamer(@PathVariable int streamerId){
        theDataBase.deleteStreamer(streamerId);

    }
}
