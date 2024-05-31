package com.hongyun.user.model;

import java.util.List;

public class Response {
    private String jsonrpc;
    private String id;
    private ResponseResult result;

    public Response() {
    }

    public Response(String jsonrpc, String id, ResponseResult result) {
        this.jsonrpc = jsonrpc;
        this.id = id;
        this.result = result;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ResponseResult getResult() {
        return result;
    }

    public void setResult(ResponseResult result) {
        this.result = result;
    }
}
