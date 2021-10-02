package com.Matchurkorea.Match.paging;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {
    private int currentPageNo;
    private int recordsPerPage;
    private int pageSize;
    private String searchKeyword;

    public Criteria() {
        this.currentPageNo = 1;
        this.recordsPerPage = 10;
        this.pageSize = 10;
    }

    public int getStartPage() {
        return (currentPageNo - 1) * recordsPerPage;
    }
}
