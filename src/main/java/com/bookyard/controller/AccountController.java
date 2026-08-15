package com.bookyard.controller;

import com.bookyard.entity.Account;
import com.bookyard.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/register")
    public Account register(@RequestParam String username, @RequestParam String password, @RequestParam String role) {
        return accountService.register(username, password, role);
    }
}