package com.fintracker.controller;

import com.fintracker.dto.DashboardResponse;
import com.fintracker.dto.TransactionDto;
import com.fintracker.entity.Transaction;
import com.fintracker.entity.TransactionType;
import com.fintracker.entity.User;
import com.fintracker.mapper.TransactionMapper;
import com.fintracker.repository.TransactionRepository;
import com.fintracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.awt.image.RasterFormatException;
import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final TransactionMapper transactionMapper;

    //to add transactions
    // we can create transaction our like INCOME and EXPENSE
    @PostMapping("/user/{userId}")
    public Transaction addTransaction(@RequestBody Transaction transaction,@PathVariable  Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        transaction.setUser(user);

        return transactionRepository.save(transaction);

    }
    //dashboard for user
    @GetMapping("/user/{userId}/dashboard")
    public DashboardResponse getDashboard(@PathVariable Long userId) {

        List<Transaction> transactions = transactionRepository.findByUserId(userId);

        double income = 0;
        double expense = 0;

        for (Transaction t : transactions) {

            if (t.getType() == TransactionType.INCOME) {
                income += t.getAmount();
            } else {
                expense += t.getAmount();
            }
        }

        double balance = income - expense;

        return new DashboardResponse(income, expense, balance, transactions);
    }

    //to get users transactions
    //@GetMapping("/user/{userId}")
    //public List<Transaction> getAllTransaction(@PathVariable Long userId){
      //  return transactionRepository.findByUserId(userId);
    //}

    @GetMapping("/user/{userId}")
    public List<TransactionDto> getAllTransaction(@PathVariable Long userId){

        List<Transaction> transactions =
                transactionRepository.findByUserId(userId);

        return transactions.stream()
                .map(transactionMapper::toDTO)
                .toList();
    }


    //to get single transaction by id
    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable Long id){
        return transactionRepository.findById(id).orElse(null);
    }
    //to delete transaction by id
    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable Long id){
        transactionRepository.deleteById(id);
        return "Transaction deleted";
    }
    @GetMapping("/user/{userId}/type/{type}")
    public List<Transaction> getByType(
            @PathVariable Long userId,
            @PathVariable TransactionType type) {

        return transactionRepository.findByUserIdAndType(userId, type);
    }


    @GetMapping("/user/{userId}/balance")
    public Double getBalance(@PathVariable Long userId) {

        List<Transaction> transactions = transactionRepository.findByUserId(userId);

        double income = 0;
        double expense = 0;

        for (Transaction t : transactions) {

            if (t.getType() == TransactionType.INCOME) {
                income += t.getAmount();
            }
            else if (t.getType() == TransactionType.EXPENSE) {
                expense += t.getAmount();
            }
        }

        return income - expense;
    }
    //update transaction
    @PutMapping("/{id}")
    public Transaction updateTransaction(
            @PathVariable Long id,
            @RequestBody Transaction updatedTransaction) {

        Transaction existing = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        existing.setTitle(updatedTransaction.getTitle());
        existing.setAmount(updatedTransaction.getAmount());
        existing.setCategory(updatedTransaction.getCategory());
        existing.setType(updatedTransaction.getType());
        existing.setDate(updatedTransaction.getDate());
        existing.setNote(updatedTransaction.getNote());

        return transactionRepository.save(existing);
    }



}
