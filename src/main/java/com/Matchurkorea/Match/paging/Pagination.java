package com.Matchurkorea.Match.paging;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagination {
//    현재 페이지 번호
    private int currentPage;
//    페이지 당 출력할 여행지 개수
    private int recordsPerPage;
//    화면 하단에 출력할 페이지 크기
    private int pageSize;

    private String searchKeyword;

    public Pagination() {
        this.currentPage = 1;
        this.recordsPerPage = 10;
        this.pageSize = 10;
    }

    public int getStartPage() {
        return (currentPage - 1) * recordsPerPage;
    }
}
