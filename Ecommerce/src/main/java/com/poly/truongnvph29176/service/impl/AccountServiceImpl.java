package com.poly.truongnvph29176.service.impl;

import com.poly.truongnvph29176.entity.Account;
import com.poly.truongnvph29176.repository.AccountRepository;
import com.poly.truongnvph29176.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public Account findById(String username) {
        return accountRepository.findById(username).get();
    }
}
