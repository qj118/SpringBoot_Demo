package org.demon.bean;

import org.springframework.stereotype.Component;

@Component
public class Account {

    private Integer accountId;
    private Double balance;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", balance='" + balance + '\'' +
                '}';
    }
}
