package com.sparta.lvtwohomework.service;

import com.sparta.lvtwohomework.dto.BoardRequestDto;
import com.sparta.lvtwohomework.dto.BoardResponseDto;
import com.sparta.lvtwohomework.entity.Board;
import com.sparta.lvtwohomework.jwt.JwtUtil;
import com.sparta.lvtwohomework.repository.BoardRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private  final JwtUtil jwtUtil;

    public BoardResponseDto createBoard(BoardRequestDto requestDto, String tokenValue) {

        String token = jwtUtil.substringToken(tokenValue);

        if (!jwtUtil.validateToken(token)) {
            throw new IllegalArgumentException("Token Error");
        }

        Claims info = jwtUtil.getUserInfoFromToken(token);

        String username = info.getSubject();

        Board board = new Board(requestDto, username);
        Board saveBoard = boardRepository.save(board);
        BoardResponseDto boardResponseDto = new BoardResponseDto(saveBoard);
        return boardResponseDto;
    }

    public List<BoardResponseDto> getBoard() {
        return boardRepository.findAllByOrderBySaveDateDesc().stream().map(BoardResponseDto::new).toList();
    }

    public List<BoardResponseDto> selectGetBoard(Long id) {
        return boardRepository.findById(id).stream().map(BoardResponseDto::new).toList();
    }

    public BoardResponseDto updateBoard(Long id, BoardRequestDto requestDto, String tokenValue) {
        String token = jwtUtil.substringToken(tokenValue);

        if (!jwtUtil.validateToken(token)) {
            throw new IllegalArgumentException("Token Error");
        }

        Claims info = jwtUtil.getUserInfoFromToken(token);

        String username = info.getSubject();
        Board board = boardRepository.findByUsernameAndId(username, id).orElseThrow(()->new IllegalArgumentException("게시물이 존재하지 않습니다."));
        board.update(requestDto);
        return new BoardResponseDto(board);
    }

    public String deleteBoard(Long id, BoardRequestDto requestDto, String tokenValue) {
        String token = jwtUtil.substringToken(tokenValue);

        if (!jwtUtil.validateToken(token)) {
            throw new IllegalArgumentException("Token Error");
        }

        Claims info = jwtUtil.getUserInfoFromToken(token);

        String username = info.getSubject();

        Board board = boardRepository.findByUsernameAndId(username, id)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 비밀 번호 입니다."));
        boardRepository.delete(board);
        return id + "번 게시물 삭제에 성공했습니다.";
    }
}
