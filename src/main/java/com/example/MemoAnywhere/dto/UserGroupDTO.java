package com.example.MemoAnywhere.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGroupDTO {
    private Long userGroupId;
    private Long userId;
    private Long groupId;
}