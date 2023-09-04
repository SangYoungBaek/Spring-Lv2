package com.sparta.lvtwohomework.controller;

import com.sparta.lvtwohomework.dto.BoardRequestDto;
import com.sparta.lvtwohomework.dto.BoardResponseDto;
import com.sparta.lvtwohomework.jwt.JwtUtil;
import com.sparta.lvtwohomework.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;

    //게시물 작성 API
    @PostMapping("/board")
    public BoardResponseDto createBoard(
        @RequestBody BoardRequestDto requestDto,
        HttpServletRequest req
    )
    {
        return boardService.createBoard(requestDto,req);
    }
    //전체 게시글 목록 조회하기 API
    @GetMapping("/board")
    public List<BoardResponseDto> getBoard() {
        return boardService.getBoard();
    }

    //선택한 게시글 조회 API
    @GetMapping("/board/{id}")
    public BoardResponseDto selectGetBoard(@PathVariable Long id) {
        return boardService.selectGetBoard(id);
    }

    //선택한 게시글 수정 API
    @PutMapping("/board/{id}")
    public BoardResponseDto updateBoard(@PathVariable Long id,
        @RequestBody BoardRequestDto requestDto,
        HttpServletRequest req
    )
    {
        return boardService.updateBoard(id, requestDto, req);
    }

    //선택한 게시글 삭제 API
    @DeleteMapping("/board/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable Long id,
        HttpServletRequest req
    )
    {
        String message = boardService.deleteBoard(id, req);
        return ResponseEntity.ok(message);
    }
}
