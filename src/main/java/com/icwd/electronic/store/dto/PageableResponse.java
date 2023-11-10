package com.icwd.electronic.store.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageableResponse<UserDto> {

    private List<UserDto> content;
    private int pageNumber;
    private int pageSize;
    private Long totalElement;
    private int totalPages;
    private boolean lastPage;


}
