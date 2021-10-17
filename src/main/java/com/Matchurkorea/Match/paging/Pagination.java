package com.Matchurkorea.Match.paging;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagination {
    private int currentPage;
    private int recordsPerPage;
//    페이지 당 최대 게시글 개수
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
