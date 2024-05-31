package com.hongyun.user.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class ResponseResult {
    private long total;
    private long limit;
    private int page;
    @JsonProperty("token_accounts")
    private List<TokenAccount> tokenAccounts;

    public ResponseResult() {
    }

    public ResponseResult(long total, long limit, int page, List<TokenAccount> tokenAccounts) {
        this.total = total;
        this.limit = limit;
        this.page = page;
        this.tokenAccounts = tokenAccounts;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<TokenAccount> getTokenAccounts() {
        return tokenAccounts;
    }

    public void setTokenAccounts(List<TokenAccount> tokenAccounts) {
        this.tokenAccounts = tokenAccounts;
    }
}
