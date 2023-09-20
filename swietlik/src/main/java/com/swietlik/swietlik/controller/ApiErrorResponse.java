package com.swietlik.swietlik.controller;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiErrorResponse{
    private int status;
    private String message;
    private long timeStamp;


}
