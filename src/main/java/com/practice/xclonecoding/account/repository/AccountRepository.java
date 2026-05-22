package com.practice.xclonecoding.account.repository;

import com.practice.xclonecoding.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByNickname(String nickname);
}
