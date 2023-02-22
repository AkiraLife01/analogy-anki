package com.app.analogyanki.repository;

import com.app.analogyanki.dto.Word;
import com.app.analogyanki.entity.Card;
import com.app.analogyanki.entity.NewWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByDateToRepeatLessThanEqual(LocalDateTime time);

//    @Query("SELECT * FROM card where original_word LIKE "%word%"")
//    List<Card> findCards(String word);
}
