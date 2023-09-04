package com.sparta.lvtwohomework.dto;

import com.sparta.lvtwohomework.entity.Board;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BoardResponseDto {
    private Long id;
    private String username;
    private String title;
    private String contents;
    private LocalDate saveDate;


    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.username = board.getUsername();
        this.title = board.getTitle();
        this.contents = board.getContents();
        this.saveDate = board.getSaveDate();
    }
}
