package com.fintracker.mapper;

import com.fintracker.dto.TransactionDto;
import com.fintracker.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(source = "user.id", target = "userId")
    TransactionDto toDTO(Transaction transaction);

    @Mapping(source = "userId", target = "user.id")
    Transaction toEntity(TransactionDto dto);
}

