package com.swietlik.swietlik.controller;


import com.swietlik.swietlik.model.Streamers;
import com.swietlik.swietlik.service.StreamersDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streamers")
public class StreamersController {

    private StreamersDataBase theDataBase;

    @Autowired
    public StreamersController(StreamersDataBase theDataBase){
        this.theDataBase = theDataBase;
    }
    @GetMapping()
    public List<Streamers> findAll() {
        return theDataBase.findAllStreamers();
    }


    @GetMapping("/{streamerId}")
    public Streamers getStreamer(@PathVariable int streamerId) {
        Streamers streamer = theDataBase.getStreamer(streamerId);
        return streamer;
    }
    @PostMapping()
    public Streamers addStreamer(@RequestBody Streamers streamer){
        Streamers tmpStreamer = new Streamers();
        tmpStreamer.setId(streamer.getId());
        tmpStreamer.setUsername(streamer.getUsername());
        theDataBase.saveStreamer(tmpStreamer);
        return tmpStreamer;
    }
    @DeleteMapping("/{streamerId}")
    public String deleteStreamer(@PathVariable int streamerId){
        theDataBase.deleteStreamer(streamerId);
        return "Deleted streamer id - "+ streamerId;
    }
}
