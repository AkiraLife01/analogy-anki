package com.app.analogyanki.service;

import com.app.analogyanki.dto.CardDto;
import com.app.analogyanki.dto.DeleteWordFromCardRequest;
import com.app.analogyanki.mapper.CardMapper;
import com.app.analogyanki.entity.Card;
import com.app.analogyanki.entity.NewWord;
import com.app.analogyanki.repository.CardRepository;
import com.app.analogyanki.repository.NewWordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final NewWordRepository newWordRepository;

    public CardService(CardRepository cardRepository, NewWordRepository newWordRepository) {
        this.cardRepository = cardRepository;
        this.newWordRepository = newWordRepository;
    }


    public CardDto addNewCard(Card card) {

        for (NewWord newWord : card.getListOfNewWords()) {
            newWord.setCard(card);
        }

        cardRepository.save(card);

        return CardMapper.INSTANCE.cardDto(card);
    }

    public List<CardDto> getCardsToRepeat() {
        List<Card> byDateToRepeatLessThanEqual =
                cardRepository.findByDateToRepeatLessThanEqual(LocalDateTime.now());

        List<CardDto> cards = new ArrayList<>();

        for (Card card : byDateToRepeatLessThanEqual) {
            CardDto addCardResponse = CardMapper.INSTANCE.cardDto(card);
            cards.add(addCardResponse);
        }

        return cards;
    }

    public List<CardDto> getCardsByWord(String word) {
        List<Card> cardsByWord = cardRepository.findCardsByWord(word);
        List<CardDto> cardDtos = new ArrayList<>();

        for (Card card : cardsByWord) {
            CardDto cardDto = CardMapper.INSTANCE.cardDto(card);
            cardDtos.add(cardDto);
        }
        return cardDtos;
    }

    public CardDto getCardByPatternSentence(String patternSentence) {
        var card = cardRepository.findCardsByFrontOfCard(patternSentence);
        System.out.println(card);
        return CardMapper.INSTANCE.cardDto(card);

    }

    public void deleteByCardId(Long cardId) {
        cardRepository.deleteById(cardId);
    }

    public void deleteWordFromCard(DeleteWordFromCardRequest deleteWordFromCardRequest) {
        newWordRepository.deleteById(deleteWordFromCardRequest.word_id());
    }

//    public CardDto getAllCardsWithSelectedWord(String word) {
//        cardRepository.
//    }
}

class Test {
    public static void main(String[] args) {
        String str1 = "xyaabbbccccdefww";
        String str2 = "xxxxyyyyabklmopq";

        String string = str1 + str2;

        List<Character> characters = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            if (i == 0) {
                characters.add(string.charAt(i));
            }

            if (!characters.contains(string.charAt(i))) {
                characters.add(string.charAt(i));
            }
        }

        String result = Arrays.toString(Arrays.stream(characters.toArray()).sorted().toArray());

        System.out.println(result);
    }
}