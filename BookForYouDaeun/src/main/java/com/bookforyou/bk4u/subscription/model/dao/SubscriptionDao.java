package com.bookforyou.bk4u.subscription.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bookforyou.bk4u.book.model.vo.Book;
import com.bookforyou.bk4u.common.model.vo.PageInfo;
import com.bookforyou.bk4u.member.model.vo.Coupon;
import com.bookforyou.bk4u.member.model.vo.Member;
import com.bookforyou.bk4u.member.model.vo.MemberCategory;
import com.bookforyou.bk4u.member.model.vo.MemberInterest;
import com.bookforyou.bk4u.payment.model.vo.Payment;
import com.bookforyou.bk4u.point.model.vo.Point;
import com.bookforyou.bk4u.subscription.model.vo.Subscription;

@Repository
public class SubscriptionDao {

	/**
	 * [관리자] 정기구독 목록 개수 조회 (한진)
	 */
	public int selectAllListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("subscriptionMapper.selectAllListCount");
	}

	/**
	 * [관리자] 정기구독 목록 조회 (한진)
	 */
	public ArrayList<Subscription> selectAdminSubscList(SqlSessionTemplate sqlSession, PageInfo pi, HashMap<String, String> filter) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("subscriptionMapper.selectAdminSubscList", filter, rowBounds);
	}

	/*
	 * [관리자] '베이직' 목록 개수 조회 (한진)
	 */
	public int selectBasicListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("subscriptionMapper.selectBasicListCount");
	}

	/*
	 * [관리자] '프리미엄' 목록 개수 조회 (한진)
	 */
	public int selectPremiumListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("subscriptionMapper.selectPremiumListCount");
	}

	/*
	 * [관리자] '구독중' 목록 개수 조회 (한진)
	 */
	public int selectStatusYListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("subscriptionMapper.selectStatusYListCount");
	}

	/*
	 * [관리자] '구독해지' 목록 개수 조회 (한진)
	 */
	public int selectStatusNListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("subscriptionMapper.selectStatusNListCount");
	}

	/**
	 * [관리자] 검색조건에 일치하는 목록 개수 조회 (한진)
	 */
	public int selectAdminSubscListSearchCount(SqlSessionTemplate sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("subscriptionMapper.selectAdminSubscListSearchCount", map);
	}

	/**
	 * [관리자] 검색조건에 일치하는 목록 조회 (한진)
	 */
	public ArrayList<Subscription> selectAdminSubscSearchList(SqlSessionTemplate sqlSession, HashMap<String, String> map) {
		return (ArrayList)sqlSession.selectList("subscriptionMapper.selectAdminSubscSearchList", map);
	}

	/**
	 * [관리자] 정기구독 상세 조회 (한진)
	 */
	public Subscription selectAdminSubscDetail(SqlSessionTemplate sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("subscriptionMapper.selectAdminSubscDetail", map);
	}

	/*
	 * [관리자] 정기구독 상세 조회 - 도서 조회 (한진)
	 */
	public ArrayList<Book> selectAdminSubscDetailBook(SqlSessionTemplate sqlSession, HashMap<String, String> map) {
		return (ArrayList)sqlSession.selectList("bookMapper.selectAdminSubscDetailBook", map);
	}

	/**
	 * [관리자] 정기구독 상세 조회 - 배송 (한진)
	 */
	public Subscription selectAdminSubscDetailDel(SqlSessionTemplate sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("subscriptionMapper.selectAdminSubscDetailDel", map);
	}

	/**
	 * [관리자] 정기구독 상세 조회 - 결제 (한진)
	 */
	public Payment selectAdminSubscDetailPay(SqlSessionTemplate sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("paymentMapper.selectAdminSubscDetailPay", map);
	}

	/**
	 * [관리자] 정기구독 상세 조회 - 쿠폰 (한진)
	 */
	public Coupon selectAdminSubscDetailCoupon(SqlSessionTemplate sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("couponDetailMapper.selectAdminSubscDetailCoupon", map);
	}

	/*
	 * [관리자] 배송지 변경 (한진)
	 */
	public int updateAdminAddress(SqlSessionTemplate sqlSession, Subscription s) {
		return sqlSession.update("subscriptionMapper.updateAdminAddress", s);
	}

	/**
	 * [관리자] 오늘 날짜의 정기배송 목록 개수 조회 (한진)
	 */
	public int selectTodaySubscCount(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("subscriptionMapper.selectTodaySubscCount");
	}

	/**
	 * [관리자] 오늘 날짜의 정기배송 목록 조회 (한진)
	 */
	public ArrayList<Subscription> selectTodaySubscList(SqlSessionTemplate sqlSession, PageInfo pi) {
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("subscriptionMapper.selectTodaySubscList", null, rowBounds);
	}

	/**
	 * [관리자] 선택된 날짜의 정기배송 목록 개수 조회 (한진)
	 */
	public int selectDaySubscCount(SqlSessionTemplate sqlSession, int date) {
		return sqlSession.selectOne("subscriptionMapper.selectDaySubscCount", date);
	}

	/**
	 * [관리자] 선택된 날짜의 정기배송 목록 조회 (한진)
	 */
	public ArrayList<Subscription> selectDaySubscDeliveryList(SqlSessionTemplate sqlSession, PageInfo pi, int date) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("subscriptionMapper.selectDaySubscDeliveryList", date, rowBounds);
	}

	/**
	 * [관리자] 풀캘린더에 표시할 리스트 조회 (한진)
	 */
	public ArrayList<Subscription> selectListForCalendarEvents(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("subscriptionMapper.selectListForCalendarEvents");
	}

	/**
	 * [관리자] 회원 취향에 맞는 정기배송 책 목록 개수 조회 (한진)
	 */
	public int selectAdminSubscBookCount(SqlSessionTemplate sqlSession, String sNo) {
		return sqlSession.selectOne("bookMapper.selectAdminSubscBookCount", sNo);
	}

	/**
	 * [관리자] 회원 취향에 맞는 정기배송 목록 조회 (한진)
	 */
	public ArrayList<Book> selectAdminSubscBookList(SqlSessionTemplate sqlSession, PageInfo pi, String sNo) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("bookMapper.selectAdminSubscBookList", sNo, rowBounds);
	}

	/**
	 * [관리자] 정기구독 회원 조회 (한진)
	 */
	public Member selectAdminSubscMember(SqlSessionTemplate sqlSession, String sNo) {
		return sqlSession.selectOne("memberMapper.selectAdminSubscMember", sNo);
	}

	/**
	 * [관리자] 정기구독 회원 interest 조회 (한진)
	 */
	public ArrayList<MemberInterest> selectAdminSubscInterest(SqlSessionTemplate sqlSession, String sNo) {
		return (ArrayList)sqlSession.selectList("memberMapper.selectAdminSubscInterest", sNo);
	}

	/**
	 * [관리자] 정기구독 회원 sub_category 조회 (한진)
	 */
	public ArrayList<MemberCategory> selectAdminSubscCategory(SqlSessionTemplate sqlSession, String sNo) {
		return (ArrayList)sqlSession.selectList("memberMapper.selectAdminSubscCategory", sNo);
	}

	/**
	 * [관리자] 도서 발송 (한진)
	 */
	public int insertSubscOrder(SqlSessionTemplate sqlSession, HashMap<String, String> map) {
		return sqlSession.insert("subscriptionMapper.insertSubscOrder", map);
	}
	
	/** 쿠폰 조회
	 * @author daeunlee
	 */
	public ArrayList<Coupon> selectSubscCoupon(SqlSessionTemplate sqlSession, int memNo) {
		return (ArrayList)sqlSession.selectList("subscriptionMapper.selectSubscCoupon", memNo);
	}
	
	/** 포인트 조회 
	 * @author daeunlee
	 */
	public ArrayList<Point> selectSubPoint(SqlSessionTemplate sqlSession, int memNo) {
		return (ArrayList)sqlSession.selectList("subscriptionMapper.selectSubPoint", memNo);
	}
	
	/** 정기구독 등록
	 * @author daeunlee
	 */
	public int insertSubsc(SqlSessionTemplate sqlSession, Subscription sub) {
		return sqlSession.insert("subscriptionMapper.insertSubsc", sub);
	}
	
	/** 정기구독 조회
	 * @author daeunlee
	 */
	public Subscription selectSubscription(SqlSessionTemplate sqlSession, int memNo) {
		return sqlSession.selectOne("subscriptionMapper.selectSubscription", memNo);
	}

	/**
	 * [관리자] 정기구독 발송 내역 조회 (한진)
	 */
	public int selectAdminSubscOrderCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("subscriptionMapper.selectAdminSubscOrderCount");
	}

	/**
	 * [관리자] 정기구독 발송 내역 조회 (한진)
	 * @param map 
	 */
	public ArrayList<Subscription> selectAdminSubscOrderList(SqlSessionTemplate sqlSession, PageInfo pi, HashMap<String, Integer> map) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("subscriptionMapper.selectAdminSubscOrderList", map, rowBounds);
	}

	/**
	 * [관리자] 메모 등록/수정 (한진)
	 */
	public int updateAdminMemo(SqlSessionTemplate sqlSession, HashMap<String, String> map) {
		return sqlSession.update("subscriptionMapper.updateAdminMemo", map);
	}

	/**
	 * [관리자] 메모 삭제 (한진)
	 */
	public int deleteAdminMemo(SqlSessionTemplate sqlSession, String subscNo) {
		return sqlSession.update("subscriptionMapper.deleteAdminMemo", subscNo);
	}

	/**
	 * [관리자] 정기구독 도서 선택 페이지 검색 결과 개수 조회 (한진)
	 */
	public int selectAdminBookSelectSearchListCount(SqlSessionTemplate sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("bookMapper.selectAdminBSSearchListCount", map);
	}

	/**
	 * [관리자] 정기구독 도서 선택 페이지 검색 결과 조회 (한진)
	 */
	public ArrayList<Book> selectAdminBookSelectSearchList(SqlSessionTemplate sqlSession, PageInfo pi, HashMap<String, String> map) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("bookMapper.selectAdminBSSearchList", map, rowBounds);
	}

	/**
	 * [관리자] 정기구독 도서 중복 체크 (한진)
	 */
	public int checkBookDuplicates(SqlSessionTemplate sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("subscriptionMapper.checkBookDuplicates", map);
	}

	/**
	 * [관리자] 정기구독 발송 내역 페이지 검색 결과 개수 조회 (한진)
	 */
	public int selectSubscOrderSearchCount(SqlSessionTemplate sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("subscriptionMapper.selectSubscOrderSearchCount", map);
	}

	/**
	 * [관리자] 정기구독 발송 내역 페이지 검색 결과 조회 (한진)
	 */
	public ArrayList<Subscription> selectAdminOrderSearchList(SqlSessionTemplate sqlSession, PageInfo pi, HashMap<String, String> map) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("subscriptionMapper.selectAdminOrderSearchList", map, rowBounds);
	}

}
