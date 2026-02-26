package com.example.well.TREINAMENTO_API.exceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
public class Problem {
    private Integer status;
    private String type;
    private String title;
    private String detail;
    private String userMessage;
    private OffsetDateTime timestamp;

    @Getter
    @Builder
    public static class Object {

        private String name;
        private String userMessage;

    }
}
