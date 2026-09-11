package com.bookyard.service.impl;

import com.bookyard.entity.Account;
import com.bookyard.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AccountServiceImpl accountService;

    @Test
    void registerEncodesPasswordAndSavesAccount() {
        when(passwordEncoder.encode("secret")).thenReturn("encoded");
        when(accountRepository.save(any(Account.class))).thenAnswer(invocation -> invocation.getArgument(0));
        var account = accountService.register("alice", "secret", "USER");
        assertThat(account.getUsername()).isEqualTo("alice");
        assertThat(account.getPassword()).isEqualTo("encoded");
        assertThat(account.getRole()).isEqualTo("USER");
        verify(accountRepository).save(account);
    }
}
