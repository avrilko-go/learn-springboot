package com.avrilko.learn.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UnifyResponse {
    private int code;
    private String message;
    private String request;
}
