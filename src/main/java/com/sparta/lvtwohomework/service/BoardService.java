package com.sparta.lvtwohomework.service;

import com.sparta.lvtwohomework.dto.BoardRequestDto;
import com.sparta.lvtwohomework.dto.BoardResponseDto;
import com.sparta.lvtwohomework.entity.Board;
import com.sparta.lvtwohomework.entity.User;
import com.sparta.lvtwohomework.jwt.JwtUtil;
import com.sparta.lvtwohomework.repository.BoardRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardResponseDto createBoard(BoardRequestDto requestDto, HttpServletRequest req) {
        User user = (User) req.getAttribute("user");

        Board board = new Board(requestDto);
        board.setUsername(user.getUsername());

        Board saveBoard = boardRepository.save(board);
        return new BoardResponseDto(saveBoard);
    }

    public List<BoardResponseDto> getBoard() {
        return boardRepository.findAllByOrderBySaveDateDesc().stream().map(BoardResponseDto::new).toList();
    }

    public BoardResponseDto selectGetBoard(Long id) {
        Board result = boardRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글 입니다"));
        return new BoardResponseDto(result);
    }

    public BoardResponseDto updateBoard(Long id,
        BoardRequestDto requestDto,
        HttpServletRequest req) {
        User user = (User) req.getAttribute("user");

        Board board = boardRepository.findByUsernameAndId(user.getUsername(), id)
            .orElseThrow(()-> new IllegalArgumentException("게시물이 존재하지 않습니다."));

        board.update(requestDto);
        return new BoardResponseDto(board);
    }

    public String deleteBoard(Long id, HttpServletRequest req) {
        User user = (User) req.getAttribute("user");

        Board board = boardRepository.findByUsernameAndId(user.getUsername(), id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 비밀 번호 입니다."));

        boardRepository.delete(board);
        return id + "번 게시물 삭제에 성공했습니다.";
    }
}
