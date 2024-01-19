package com.study.todoapi.user.repository;

import com.study.todoapi.user.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@Rollback(value = false)
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("회원가입 하기")
    void loginTest() {
        //given
        User user = User.builder()
                .email("abc1234@abc.com")
                .password("1234")
                .userName("말포이")
                .build();
        //when
        User save = userRepository.save(user);
        //then
        assertNotNull(save);
    }

    @Test
    @DisplayName("이메일로 회원 찾기")
    void findByEmailTest() {
        //given
        String email = "abc1234@abc.com";
        //when
        Optional<User> byEmail = userRepository.findByEmail(email);
        //then
        assertTrue(byEmail.isPresent());
        User user = byEmail.get();
        assertEquals("말포이", user.getUserName());
        System.out.println();
        System.out.println("user = " + user);
        System.out.println();
    }

    @Test
    @DisplayName("이메일 중복체크 테스트")
    void emailDuplicateTest() {
        //given
        String email = "abc1234@abc.com";
        //when
        boolean flag = userRepository.existsByEmail(email);
        //then
        assertTrue(flag);
    }




}