package com.app.analogyanki.repository;

import com.app.analogyanki.entity.NewWord;
import org.springframework.data.jpa.repository.JpaRepository;
public interface NewWordRepository extends JpaRepository<NewWord, Long> {

}
