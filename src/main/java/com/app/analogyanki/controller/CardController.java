package com.app.analogyanki.controller;

import com.app.analogyanki.dto.CardDto;
import com.app.analogyanki.entity.Card;
import com.app.analogyanki.service.CardService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public CardDto addNewCard(@NonNull @RequestBody Card card) {
        return cardService.addNewCard(card);
    }

    /*
        TODO вернуть карты на повторение +
        TODO получить карты по 1 слову в предложении(не важно где) (после Stepik) +
        TODO получить sentence LIKE pattern "sentence" (слово в слово) (после Stepik) +
        TODO удалить по ID card +
        TODO удалить по word из card
        TODO создать, изменить, удалить КОЛОДЫ - хранить карты в колодах
     */


    @GetMapping("/cards_to_repeat")
    public List<CardDto> getCardsToRepeat() {
        return cardService.getCardsToRepeat();
    }

    @GetMapping("/get_cards_by_word/{word}")
    public List<CardDto> getCardsByWord(@PathVariable String word) {
        return cardService.getCardsByWord(word);
    }

    @GetMapping("/get_cards_by_pattern")
    public CardDto getCardByPatternSentence(@RequestParam String patternSentence) {
        return cardService.getCardByPatternSentence(patternSentence);
    }

    @DeleteMapping("/deleteById/{card_id}")
    public void deleteByCardId(@PathVariable Long card_id) {
        cardService.deleteByCardId(card_id);
    }
}
