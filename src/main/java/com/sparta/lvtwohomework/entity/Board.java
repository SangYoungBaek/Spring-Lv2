package com.sparta.lvtwohomework.entity;

import com.sparta.lvtwohomework.dto.BoardRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
글번호 - no
제목 - title
작성자ID - id
작성내용 - contents
작성날짜 - save_date
비밀번호 - con_pw
 */
@Entity
@Getter
@Setter
@Table(name = "board")
@NoArgsConstructor
public class Board extends  Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false, length = 500)
    private String contents;


    public Board(BoardRequestDto requestDto, String username) {
        this.username = username;
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }


    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}
