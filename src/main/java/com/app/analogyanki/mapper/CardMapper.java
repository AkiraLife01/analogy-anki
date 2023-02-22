package com.app.analogyanki.mapper;

import com.app.analogyanki.dto.CardDto;
import com.app.analogyanki.entity.Card;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardMapper {

    CardMapper INSTANCE = Mappers.getMapper( CardMapper.class );
    CardDto cardDto(Card card);
}