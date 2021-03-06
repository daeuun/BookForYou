package com.bookforyou.bk4u.subscription.model.service;

import java.util.ArrayList; 
import java.util.HashMap;

import com.bookforyou.bk4u.common.model.vo.PageInfo;
import com.bookforyou.bk4u.member.model.vo.Coupon;
import com.bookforyou.bk4u.member.model.vo.Member;
import com.bookforyou.bk4u.member.model.vo.MemberCategory;
import com.bookforyou.bk4u.member.model.vo.MemberInterest;
import com.bookforyou.bk4u.payment.model.vo.Payment;
import com.bookforyou.bk4u.point.model.vo.Point;
import com.bookforyou.bk4u.book.model.vo.Book;
import com.bookforyou.bk4u.subscription.model.vo.Subscription;

public interface SubscriptionService {

	
	/**
	 * [관리자] 정기구독 목록 개수 조회 (한진)
	 */
	int selectAllListCount();

	/**
	 * [관리자] 정기구독 목록 조회 (한진)
	 */
	ArrayList<Subscription> selectAdminSubscList(PageInfo pi, HashMap<String, String> filter);

	/*
	 * [관리자] '베이직' 목록 개수 조회 (한진)
	 */
	int selectBasicListCount();

	/*
	 * [관리자] '프리미엄' 목록 개수 조회 (한진)
	 */
	int selectPremiumListCount();

	/*
	 * [관리자] '구독중' 목록 개수 조회 (한진)
	 */
	int selectStatusYListCount();

	/*
	 * [관리자] '구독해지' 목록 개수 조회 (한진)
	 */
	int selectStatusNListCount();

	/**
	 * [관리자] 검색조건에 일치하는 목록 개수 조회 (한진)
	 */
	int selectAdminSubscListSearchCount(HashMap<String, String> map);

	/*
	 * [관리자] 검색조건에 일치하는 목록 조회 (한진)
	 */
	ArrayList<Subscription> selectAdminSubscSearchList(PageInfo pi, HashMap<String, String> map);

	/**
	 * [관리자] 정기구독 상세 조회 (한진)
	 */
	Subscription selectAdminSubscDetail(HashMap<String, String> map);

	/**
	 * [관리자] 정기구독 상세 조회 - 도서 (한진)
	 */
	ArrayList<Book> selectAdminSubscDetailBook(HashMap<String, String> map);

	/**
	 * [관리자] 정기구독 상세 조회 - 배송 (한진)
	 */
	Subscription selectAdminSubscDetailDel(HashMap<String, String> map);

	/**
	 * [관리자] 정기구독 상세 조회 - 결제 (한진)
	 */
	Payment selectAdminSubscDetailPay(HashMap<String, String> map);

	/**
	 * [관리자] 정기구독 상세 조회 - 쿠폰 (한진)
	 */
	Coupon selectAdminSubscDetailCoupon(HashMap<String, String> map);

	/**
	 * [관리자] 배송지 변경 (한진)
	 */
	int updateAdminAddress(Subscription s);

	/**
	 * [관리자] 오늘 날짜의 정기배송 목록 개수 조회 (한진)
	 */
	int selectTodaySubscCount();

	/**
	 * [관리자] 오늘 날짜의 정기배송 목록 조회 (한진)
	 */
	ArrayList<Subscription> selectTodaySubscList(PageInfo pi);

	/**
	 * [관리자] 선택된 날짜의 정기배송 목록 개수 조회 (한진)
	 */
	int selectDaySubscCount(int date);

	/**
	 * [관리자] 선택된 날짜의 정기배송 목록 조회 (한진)
	 */
	ArrayList<Subscription> selectDaySubscDeliveryList(PageInfo pi, int date);

	/**
	 * [관리자] 풀캘린더에 표시할 리스트 조회 (한진)
	 */
	ArrayList<Subscription> selectListForCalendarEvents();

	/**
	 * [관리자] 회원 취향에 맞는 정기배송 책 목록 개수 조회 (한진)
	 */
	int selectAdminSubscBookCount(String sNo);

	/**
	 * [관리자] 회원 취향에 맞는 정기배송 책 목록 조회 (한진)
	 */
	ArrayList<Book> selectAdminSubscBookList(PageInfo pi, String sNo);

	/**
	 * [관리자] 회원 조회 (한진)
	 */
	Member selectAdminSubscMember(String sNo);

	/**
	 * [관리자] 정기구독 회원 interest 조회 (한진)
	 */
	ArrayList<MemberInterest> selectAdminSubscInterest(String sNo);

	/**
	 * [관리자] 정기구독 회원 sub_category 조회 (한진)
	 */
	ArrayList<MemberCategory> selectAdminSubscCategory(String sNo);

	/**
	 * [관리자] 도서 발송 (한진)
	 */
	int insertSubscOrder(HashMap<String, String> map);
	
	/** 쿠폰 조회
	 * @author daeunlee
	 */
	ArrayList<Coupon> selectSubscCoupon(int memNo);
	
	/** 포인트 조회 
	 * @author daeunlee
	 */
	ArrayList<Point> selectSubPoint(int memNo);
	
	/** 정기구독 등록
	 * @author daeunlee
	 */
	int insertSubsc(Subscription sub);
	
	/** 정기구독 조회
	 * @author daeunlee
	 */
	Subscription selectSubscription(int memNo);

	/**
	 * [관리자] 정기구독 발송 내역 개수 조회 (한진)
	 */
	int selectAdminSubscOrderCount();

	/**
	 * [관리자] 정기구독 발송 내역 조회 (한진)
	 */
	ArrayList<Subscription> selectAdminSubscOrderList(PageInfo pi, HashMap<String, Integer> map);

	/**
	 * [관리자] 메모 등록/수정 (한진)
	 */
	int updateAdminMemo(HashMap<String, String> map);

	/**
	 * [관리자] 메모 삭제 (한진)
	 */
	int deleteAdminMemo(String subscNo);

	/**
	 * [관리자] 정기구독 도서 선택 페이지 검색 결과 개수 조회 (한진)
	 */
	int selectAdminBookSelectSearchListCount(HashMap<String, String> map);

	/**
	 * [관리자] 정기구독 도서 선택 페이지 검색 결과 조회 (한진)
	 */
	ArrayList<Book> selectAdminBookSelectSearchList(PageInfo pi, HashMap<String, String> map);

	/**
	 * [관리자] 정기구독 도서 중복 체크 (한진)
	 */
	int checkBookDuplicates(HashMap<String, String> map);

	/**
	 * [관리자] 정기구독 발송 내역 페이지 검색 결과 개수 조회 (한진)
	 */
	int selectSubscOrderSearchCount(HashMap<String, String> map);

	/**
	 * [관리자] 정기구독 발송 내역 페이지 검색 결과 조회 (한진)
	 */
	ArrayList<Subscription> selectAdminSubscOrderSearchList(PageInfo pi, HashMap<String, String> map);


}
