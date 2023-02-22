package com.app.analogyanki.dto;

public record Word(Long id, String originalWord,
                   String translatedWord, byte[] audio) {


}
