package com.study.todoapi.auth;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.SecureRandom;
import java.util.Base64;

@SpringBootTest
class TokenProviderTest {


    @Test
    @DisplayName("토큰 서명에 필요한 비밀키 해시값 생성하기")
    void makeSecretKey() {

        SecureRandom secureRandom = new SecureRandom();
        //512bit
        byte[] key = new byte[64];
        secureRandom.nextBytes(key);

        String s = Base64.getEncoder().encodeToString(key);

        System.out.println();
        System.out.println("key = " + s);
        System.out.println();
    }


}