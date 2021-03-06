package com.application.initialization.core.poll;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PollsJson {
    private final List<PollJson> polls = new ArrayList<>();

    @Data
    public static class PollJson {
        private final String code;
        private final String name;
        private final String objectives;
        private final String category;
        private final List<String> questions;
        private final ScoreJson scores;
        private final List<String> supplements;

        @Data
        public static class ScoreJson {
            private final int medium;
            private final int high;
        }
    }

}
