package com.spring5.practice.config;

import com.spring5.practice.service.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.spring5.practice.service"})
public class RootConfig {
    @Bean
    public Account accountDetails() {
        Account account = new Account();
        account.setAccountId("1234");
        account.setAccountType("Business");
        account.setAccountHolderName("ABC Org");
        return account;
    }
}
