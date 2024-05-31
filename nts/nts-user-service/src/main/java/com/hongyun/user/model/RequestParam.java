package com.hongyun.user.model;

public class RequestParam {
    private String mint;
    private long page;
    private long limit;

    public RequestParam() {
    }

    public RequestParam(String mint, long page, long limit) {
        this.mint = mint;
        this.page = page;
        this.limit = limit;
    }

    public String getMint() {
        return mint;
    }

    public void setMint(String mint) {
        this.mint = mint;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }
}
