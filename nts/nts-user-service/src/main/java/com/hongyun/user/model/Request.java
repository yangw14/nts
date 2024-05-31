package com.hongyun.user.model;

public class Request {
    private String jsonrpc;
    private String method;
    private String id;
    private RequestParam params;

    public Request() {
    }

    public Request(String jsonrpc, String method, String id, RequestParam params) {
        this.jsonrpc = jsonrpc;
        this.method = method;
        this.id = id;
        this.params = params;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RequestParam getParams() {
        return params;
    }

    public void setParams(RequestParam params) {
        this.params = params;
    }
}
