package com.Matchurkorea.Match.paging;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagination {
//    현재 페이지 번호
    private int page = 1;
    // TODO API 요청 시 사용
    private int block = 1;

//    화면 하단에 출력할 페이지 크기
    private int pageSize = 10;
    private int blockSize = 10;

    private int totalCount;
    private int totalPageCount;
    private int totalBlockCount;

    private int startPage;
    private int endPage;

    private int prevBlock;
    private int nextBlock;

    private String searchKeyword;


    public Pagination(int totalCount, int page){
        setPage(page);
        setTotalCount(totalCount);
        setTotalPageCount((int) Math.ceil(totalCount * 1.0 / pageSize));
        setTotalBlockCount((int) Math.ceil(totalPageCount * 1.0 / blockSize));
        setBlock((int) Math.ceil((page * 1.0)/blockSize));
        setStartPage((block-1) * blockSize + 1);
        setEndPage(startPage + blockSize -1);

        if(endPage > this.totalPageCount){this.endPage = totalPageCount;}

        setPrevBlock((block * blockSize) - blockSize);

        if(prevBlock < 1){this.prevBlock = 1;}

        setNextBlock((block * blockSize) + 1);
        if(nextBlock > totalPageCount){nextBlock = totalPageCount;}

    }
}
