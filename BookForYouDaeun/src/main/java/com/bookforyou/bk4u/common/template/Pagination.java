package com.bookforyou.bk4u.common.template;

import com.bookforyou.bk4u.common.model.vo.PageInfo;

public class Pagination {
	
	public static PageInfo getpageInfo(int listCount, int currentPage, int pageLimit, int boardLimit) {
		// * 총 페이지 수
        int maxPage = (int) Math.ceil((double) listCount / boardLimit);
        // * 시작 수
        int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
        // * 끝 수
        int endPage = startPage + pageLimit - 1;
        if (endPage > maxPage) {
            endPage = maxPage;
        }
        return new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
	}

}
