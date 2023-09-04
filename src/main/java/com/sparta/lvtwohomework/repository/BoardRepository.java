package com.sparta.lvtwohomework.repository;

import com.sparta.lvtwohomework.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderBySaveDateDesc();
    List<Board> findByIdAndUsername(Long id, String username);

    Optional<Board> findByUsernameAndId(String username, Long id);
    //Optional<Board> findByIdAndConPwEquals(Long id, String conPw);
}
