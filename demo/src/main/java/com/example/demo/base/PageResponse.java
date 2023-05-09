package com.example.demo.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class PageResponse extends BaseResponse{
    private int pageNo;
    private int totalPage;
    private int perPage;
}
