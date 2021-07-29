package com.bookforyou.bk4u.booklist.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.bookforyou.bk4u.booklist.model.vo.Booklist;
import com.bookforyou.bk4u.common.model.vo.PageInfo;
import com.bookforyou.bk4u.reply.model.vo.Reply;

public interface BooklistService {
	
	/** 1. 독서록 게시글 갯수 조회용 (+페이징)
	 * @author daeunlee
	 */
	int selectListCount();
	ArrayList<Booklist> selectList(PageInfo pi);
	
	/** 2. 독서록 작성용
	 * @author daeunlee
	 */
	int insertBooklist(Booklist bl);
	
	/** 3. 독서록 상세조회
	 * @author daeunlee
	 */
	int increaseCount(int blNo);
	Booklist selectBooklist(int blNo);
	
	/** 4. 독서록 삭제
	 * @author daeunlee
	 */
	int deleteBooklist(int blNo);
	
	/** 5. 독서록 수정
	 * @author daeunlee
	 */
	int updateBooklist(Booklist bl);
	
	/** 6. 댓글 리스트 조회
	 * @author daeunlee
	 */
	ArrayList<Reply> selectReplyList(int blNo);
	
	/** 7. 댓글 작성
	 * @author daeunlee
	 */
	int insertReply(Reply r);
	
	/** 8. 검색
	 * @author daeunlee
	 */
	public int selectSerchListCount(HashMap<String, String> map);
	public ArrayList<Booklist> selectSearchList(PageInfo pi, HashMap<String, String> map);
	
	/** 9. 인기 독서록 정렬
	 * @author daeunlee
	 */
	public ArrayList<Booklist> selectTopBooklistList();

}
