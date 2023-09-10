package com.swietlik.swietlik.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StreamerErrorResponse {
    private int status;
    private String message;
    private long timeStamp;


}
