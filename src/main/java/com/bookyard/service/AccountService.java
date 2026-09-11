package com.bookyard.service;

import com.bookyard.entity.Account;

public interface AccountService {
    Account register(String username, String password, String role);
}