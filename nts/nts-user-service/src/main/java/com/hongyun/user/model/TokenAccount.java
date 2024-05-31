package com.hongyun.user.model;

public class TokenAccount {
//    "address": "4nQCoXm4dWrF2h8PCdqasy2KYfkZR3sQ9LXD5YaoeuAb",
//            "mint": "7GCihgDB8fe6KNjn2MYtkzZcRjQy3t9GHdC8uHYmW2hr",
//            "owner": "6tAxhNDtyYsWdV4qGz4GMgdGUukUJu3Prio5VevCQgJr",
//            "amount": 32143604121,
//            "delegated_amount": 0,
//            "frozen": false
    private String address;
    private String mint;
    private String owner;
    private long amount;
    private long delegated_amount;
    private boolean frozen;

    public TokenAccount() {
    }

    public TokenAccount(String address, String mint, String owner, long amount, long delegated_amount, boolean frozen) {
        this.address = address;
        this.mint = mint;
        this.owner = owner;
        this.amount = amount;
        this.delegated_amount = delegated_amount;
        this.frozen = frozen;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMint() {
        return mint;
    }

    public void setMint(String mint) {
        this.mint = mint;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getDelegated_amount() {
        return delegated_amount;
    }

    public void setDelegated_amount(long delegated_amount) {
        this.delegated_amount = delegated_amount;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    @Override
    public String toString() {
        return "TokenAccount{" +
                "address='" + address + '\'' +
                ", mint='" + mint + '\'' +
                ", owner='" + owner + '\'' +
                ", amount=" + amount +
                ", delegated_amount=" + delegated_amount +
                ", frozen=" + frozen +
                '}';
    }
}
