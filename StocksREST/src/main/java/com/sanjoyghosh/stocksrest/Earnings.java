package com.sanjoyghosh.stocksrest;

public class Earnings {

    private final long id;
    private final String content;

    public Earnings(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}