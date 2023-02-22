package com.app.analogyanki.dto;

import java.time.LocalDateTime;
import java.util.List;

public record CardDto(Long id, String frontOfCard,
                      List<Word> listOfNewWords, LocalDateTime dateToRepeat) {

}
