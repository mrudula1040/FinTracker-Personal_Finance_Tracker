package com.fintracker.dto;


import com.fintracker.entity.TransactionType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TransactionDto {

    private Long id;

    private String title;

    private Double amount;

    private String category;

    private TransactionType type;

    private LocalDate date;

    private String note;

    private Long userId;

}
