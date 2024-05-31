package com.hongyun.user.service;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hongyun.user.model.Request;
import com.hongyun.user.model.RequestParam;
import com.hongyun.user.model.Response;
import com.hongyun.user.model.TokenAccount;
import com.hongyun.user.model.UserEntity;
import com.hongyun.user.repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final RestTemplate restTemplate;
    private static final String API_KEY = "6b6afc5f-9204-4f7f-aae8-c5673d60f816";
    private static final String url = "https://mainnet.helius-rpc.com?api-key=";

    public UserService(UserRepository userRepository,
                       RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public UserEntity addUser(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String uriTemplate = "https://mainnet.helius-rpc.com?api-key=6b6afc5f-9204-4f7f-aae8-c5673d60f816";
        Request request = new Request();
        request.setJsonrpc("2.0");
        request.setMethod("getTokenAccounts");
        request.setId("helius-test");
        RequestParam requestParam = new RequestParam();
        requestParam.setMint("7GCihgDB8fe6KNjn2MYtkzZcRjQy3t9GHdC8uHYmW2hr");
        requestParam.setLimit(1000);

        int page = 30;
        boolean hasNext = true;

        while(hasNext) {
            page++;
            System.out.println("page: " + page);
            requestParam.setPage(page);
            request.setParams(requestParam);
            String s = JSON.toJSONString(request);

            RequestEntity<String> requestEntity = RequestEntity.post(URI.create(uriTemplate))
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(s);
            ResponseEntity<Response> responseEntity = restTemplate.exchange(requestEntity, Response.class);
            hasNext = !(responseEntity.getBody() != null
                    && responseEntity.getBody().getResult().getTokenAccounts().isEmpty())
                || false;

            responseEntity.getBody().getResult().getTokenAccounts().stream()
//                    .filter(tokenAccount -> tokenAccount.getAmount() > 0)
                    .filter(tokenAccount -> tokenAccount.getOwner().equals("Gate.io")
                        || tokenAccount.getOwner().startsWith("CXDjP")
                        || tokenAccount.getAddress().startsWith("CXDjP"))
                    .forEach(tokenAccount -> {
                        System.out.println("address: " + tokenAccount.getAddress());
                        System.out.println("mint: " + tokenAccount.getMint());
                        System.out.println("owner: " + tokenAccount.getOwner());
                        System.out.println("amount: " + tokenAccount.getAmount());
                        System.out.println("delegated_amount: " + tokenAccount.getDelegated_amount());
                        System.out.println("frozen: " + tokenAccount.isFrozen());
                    });
        }

    }

}
