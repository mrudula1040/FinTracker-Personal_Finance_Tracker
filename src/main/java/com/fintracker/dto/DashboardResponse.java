package com.fintracker.dto;

import com.fintracker.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DashboardResponse {
    private double totalIncome;
    private double totalExpense;
    private double balance;
    private List<Transaction> transactions;


}
