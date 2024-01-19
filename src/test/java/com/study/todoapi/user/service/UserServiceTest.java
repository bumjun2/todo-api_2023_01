package com.study.todoapi.user.service;

import com.study.todoapi.user.dto.request.UserSignUpRequestDTO;
import com.study.todoapi.user.dto.response.UserSignUpResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@Rollback(value = false)
class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    @DisplayName("회원가입을 하면 비밀번호가 인코딩되어 디비에 저장한다")
    void saveTest() {
        //given
        UserSignUpRequestDTO dto = UserSignUpRequestDTO.builder()
                .email("zz123@email.com")
                .password("1234")
                .userName("정범준")
                .build();
        //when
        UserSignUpResponseDTO userSignUpResponseDTO = userService.create(dto);
        //then
        assertEquals("zz123@email.com", userSignUpResponseDTO.getEmail());

        System.out.println();
        System.out.println("userSignUpResponseDTO = " + userSignUpResponseDTO);
        System.out.println();
    }


}