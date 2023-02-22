package com.app.analogyanki.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "new_word")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class NewWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_id")
    private Long id;
    private String originalWord;
    private String translatedWord;
    private byte[] audio;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "card_id")
    private Card card;
}
