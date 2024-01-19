package com.study.todoapi.user.repository;

import com.study.todoapi.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    //쿼리 메서드
    //이메일로 회원정보 조회
    Optional<User> findByEmail(String email);

    //이메일 중복 체크
    boolean existsByEmail(String email);
}
