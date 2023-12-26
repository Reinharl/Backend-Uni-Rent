package com.unirent.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ChatResponse {

    private List<Choice> choices;

    @Setter
    @Getter
    public static class Choice {

        private int index;
        private Message message;

    }

}