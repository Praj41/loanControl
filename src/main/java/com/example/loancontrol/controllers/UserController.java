package com.example.loancontrol.controllers;

import com.example.loancontrol.model.DigitalAccount;
import com.example.loancontrol.model.User;
import com.example.loancontrol.payload.response.DashboardResponse;
import com.example.loancontrol.repository.UserRepository;
import com.example.loancontrol.security.services.UserDetailsImpl;
import com.example.loancontrol.service.BlockchainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlockchainService blockchainService;

    @PostMapping("/current")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getCurrentUser(Authentication authentication) {

        User user = userRepository.findById(((UserDetailsImpl) authentication.getPrincipal()).getId()).get();

        try {
            BigDecimal balance = blockchainService.getBalance(user.getDigitalAccount().getPublicKey()).divide(new BigDecimal("1000000000000000000"));
            DashboardResponse response = new DashboardResponse(user, balance);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
