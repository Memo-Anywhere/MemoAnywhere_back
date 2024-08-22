package com.example.MemoAnywhere.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemoDTO {
    private Long memoId;
    private Long userId;
    private String title;
    private String content;
}