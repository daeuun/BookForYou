package com.bookforyou.bk4u.booklist.conroller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bookforyou.bk4u.book.model.vo.Book;
import com.bookforyou.bk4u.booklist.model.service.BooklistService;
import com.bookforyou.bk4u.booklist.model.vo.Booklist;
import com.bookforyou.bk4u.common.model.vo.PageInfo;
import com.bookforyou.bk4u.common.template.Pagination;
import com.bookforyou.bk4u.reply.model.vo.Reply;
import com.google.gson.Gson;

@Controller
public class BooklistController {
	
	@Autowired
	private BooklistService blService;
	
	/** 독서록 리스트 조회용 + 페이징
	 * @author daeunlee
	 */
	@RequestMapping("list.bl")
	public String selectList(Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage) {
		
		int listCount = blService.selectListCount(); // 독서록 총 게시글 갯수 조회
		
		PageInfo pi = Pagination.getpageInfo(listCount, currentPage, 10, 5);
		ArrayList<Booklist> list = blService.selectList(pi);
		
		model.addAttribute("pi", pi);
		model.addAttribute("list", list);
		
		return "booklist/booklistListView";
	}
	
	/** 독서록 작성 페이지 호출용
	 * @author daeunlee
	 */
	@RequestMapping("enrollForm.bl")
	public String enrollForm() {
		return "booklist/booklistEnrollForm";
	}
	
	/** 독서록 작성용
	 * @author daeunlee
	 */
	@RequestMapping("insert.bl")
	public String insertBooklist(Booklist bl, Model model, HttpSession session) {
		
		System.out.println(bl);
		
		int result = blService.insertBooklist(bl);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "독서록이 작성되었습니다!");
			return "redirect:list.bl";
		}else {
			model.addAttribute("errorMag", "독서록을 작성하지 못했습니다.");
			return "common/errorPage";
		}
	}
	
	/*
	@RequestMapping("searchBk.bl")
	public ModelAndView selectBookSearchList(String condition, String keyword, ModelAndView mv,
											@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		// HashMap은 key+value 세트로 구성. Map 자료구조를 사용
		HashMap<String, String> map = new HashMap<>();
		map.put("condition", condition);
		map.put("keyword", keyword);
		int listCount = blService.selectSearchListCount(map);
		PageInfo pi = Pagination.getpageInfo(listCount, currentPage, 10, 5);
		ArrayList<Book> list = blService.selectSearchList(pi, map);
		mv.addObject("pi", pi)
		  .addObject("list", list)
		  .addObject("condition", condition)
		  .addObject("keyword", keyword);
		return mv;
	}
	*/
	
	/** 도서 검색 모달창(1) : 도서 갯수 조회용
	 * 	도서 검색 모달창(2) : 도서 조회용
	 * @author daeunlee
	 */
	
	@ResponseBody
	@RequestMapping(value="searchBk.bl", produces = "application/json; charset=utf-8")
	public String selectBookSearchList(Model model, String condition, String keyword) {
		
		// HashMap은 key+value 세트로 구성. Map 자료구조를 사용
		HashMap<String, String> map = new HashMap<>();
		map.put("condition", condition);
		map.put("keyword", keyword);
		
		ArrayList<Book> list = blService.selectBookSearchList(map);
		
		return new Gson().toJson(list);
	}
	
	/** 독서록 상세조회용
	 * @author daeunlee
	 */
	@RequestMapping("detail.bl")
	public ModelAndView selectBooklist(int blNo, ModelAndView mv){
		
		// 해당 게시글 조회수 증가용 서비스 호출 => update
		int result = blService.increaseCount(blNo);
		
		System.out.println(blNo);
		
		if(result > 0) {
			// 게시글 조회용 서비스 호출
			Booklist bl = blService.selectBooklist(blNo);
			// 해당 게시글의 책정보 조회 서비스 호출
			Book bk = blService.selectBook(blNo);
			mv.addObject("bl", bl)
			  .addObject("bk", bk)
			  .setViewName("booklist/booklistDetailView");
		}else {
			mv.addObject("errorMsg", "상세조회 실패").setViewName("common/errorPage");
		}
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="rlist.bl", produces="application/json; charset=utf-8")
	public String selectReplyList(int blNo) {
		
		ArrayList<Reply> list = blService.selectReplyList(blNo);
		return "booklist/booklistDetailView";
	}
	

}
