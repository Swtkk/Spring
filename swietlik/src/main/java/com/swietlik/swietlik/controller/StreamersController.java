package com.swietlik.swietlik.controller;


import com.swietlik.swietlik.model.Streamer;
import com.swietlik.swietlik.service.StreamersDataBase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

        return theDataBase.getStreamerById(streamerId);
    }


    @PostMapping()
    public void addStreamer(@RequestBody Streamer streamer) throws AlreadyExistException {
        theDataBase.addStr(streamer);
    }


    @PutMapping()
    public void updateStreamer(@RequestBody Streamer streamer) {
        theDataBase.updateStreamer(streamer);
    }

    @DeleteMapping("/{streamerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStreamer(@PathVariable int streamerId) {
        theDataBase.deleteStreamer(streamerId);

    }
}
