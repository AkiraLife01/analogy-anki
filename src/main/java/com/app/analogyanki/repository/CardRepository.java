package com.app.analogyanki.repository;

import com.app.analogyanki.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByDateToRepeatLessThanEqual(LocalDateTime time);

    @Query(value = "SELECT * FROM card" +
            " JOIN new_word ON card.id = new_word.card_id" +
            " WHERE card.front_of_card LIKE %?1%",

           nativeQuery = true)
    List<Card> findCardsByWord(String word);


    Card findCardsByFrontOfCard(String patternSentence);

    @Query(
            value = "DELETE\n" +
                    "FROM card USING new_word\n" +
                    "WHERE new_word.card_id = card.id\n" +
                    "  AND card.id = ?1\n" +
                    "  AND new_word.word_id = ?2",
            nativeQuery = true
    )
    void deleteWordFromCard(Long cardId, Long wordId);

}
