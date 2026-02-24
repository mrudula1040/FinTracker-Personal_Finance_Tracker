package com.fintracker.service;

import com.fintracker.entity.Role;
import com.fintracker.entity.User;
import com.fintracker.repository.TransactionRepository;
import com.fintracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
private final PasswordEncoder passwordEncoder;
    public User register(User user){
        Optional<User> existing =userRepository.findByEmail(user.getEmail());

        if (existing.isPresent()){
            throw new RuntimeException(
                    "Email already registered"
            );

        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        return userRepository.save(user);
    }
    public User login(String email,String password){
        User user = userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password,user.getPassword())){
            throw  new RuntimeException("Invalid password");
        }
        return user;
    }

}
