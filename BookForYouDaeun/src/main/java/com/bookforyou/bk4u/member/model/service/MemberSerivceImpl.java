package com.bookforyou.bk4u.member.model.service;



import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookforyou.bk4u.member.model.dao.MemberDao;
import com.bookforyou.bk4u.member.model.vo.Coupon;
import com.bookforyou.bk4u.member.model.vo.Member;
import com.bookforyou.bk4u.member.model.vo.MemberCategory;
import com.bookforyou.bk4u.member.model.vo.MemberInterest;

@Service
public class MemberSerivceImpl implements MemberService{
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Member loginMember(Member member) {
		return memberDao.loginMember(sqlSession,member);
	}

	@Override
	public int idCheck(String memId) {
		return memberDao.idCheck(sqlSession,memId);
	}

	@Override
	public int nickCheck(String memNickname) {
		return memberDao.nickCheck(sqlSession,memNickname);
	}

	@Override
	public int emailCheck(String memEmail) {
		return memberDao.emailCheck(sqlSession,memEmail);
	}

	@Override
	public int insertMember(Member member) {
		return memberDao.insertMember(sqlSession,member);
	}

	@Override
	public int updateEmailStatus(Member member) {
		return memberDao.updateEmailStatus(sqlSession,member);
	}

	@Override
	public int selectByMemId(Member member) {
		return memberDao.selectByMemId(sqlSession,member);
	}

	@Override
	public int insertMemberInterest(MemberInterest memberInterest) {
		return memberDao.insertMemberInterest(sqlSession, memberInterest);
	}

	@Override
	public int insertMemberCategory(MemberCategory memberCategory) {
		return memberDao.insertMemberCategory(sqlSession, memberCategory);
	}

	@Override
	public Member selectEmailAndAuthKey(Member member) {
		return memberDao.selectEmailAndAuthKey(sqlSession,member);
	}

	@Override
	public Member findMemberByEmail(Member member) {
		return memberDao.selectMemberByEmail(sqlSession,member);
	}

	@Override
	public Member findMemberByEmailAndId(Member member) {
		return memberDao.selectMemberByEmailAndId(sqlSession,member);
	}
	
	/**
	 * ?????? ???????????? ???????????? ?????????
	 */
	@Override
	public String createTempPassword() {
		String pswd = "";
		StringBuffer sb = new StringBuffer();
		StringBuffer sc = new StringBuffer("!@#$%^&*-=?~"); 

		// ????????? 4???
		sb.append((char)((Math.random() * 26)+65));  

		for( int i = 0; i<3; i++) {
		   sb.append((char)((Math.random() * 26)+65));
		} 

		// ????????? 4???
		for( int i = 0; i<4; i++) {
		    sb.append((char)((Math.random() * 26)+97));
		}  


		// ?????? 2
		for( int i = 0; i<2; i++) {
		    sb.append((char)((Math.random() * 10)+48));
		}


		// ???????????? ?????? 
		sb.setCharAt(((int)(Math.random()*3)+1), sc.charAt((int)(Math.random()*sc.length()-1))); //?????????3?????? ??????   
		sb.setCharAt(((int)(Math.random()*4)+4), sc.charAt((int)(Math.random()*sc.length()-1))); //?????????4?????? ??????

		pswd = sb.toString();

		return pswd;
	}

	@Override
	public int updatePassword(Member member) {
		return memberDao.updatePassword(sqlSession,member);
	}

	/*
	 * [?????????] ?????? ?????? ?????? ?????? (??????)
	 */
	@Override
	public int selectCouponCount(int memNo) {
		return memberDao.selectCouponCount(sqlSession, memNo);
	}

	/*
	 * [?????????] ?????? ?????? ?????? (??????)
	 */
	@Override
	public ArrayList<Coupon> selectCouponList(int memNo){
		return memberDao.selectCouponList(sqlSession, memNo);
	}

	/**
	 * [?????????] ????????? ????????? ??? ?????? ????????? ??????
	 * @author ?????????
	 */
	@Override
	public int updateMemberWorkAndLevel(Member member) {
		return memberDao.updateMemberWorkAndLevel(sqlSession, member);
	}
	
	/**
	 * ????????? ??????????????? ??????????????? ?????????
	 */
	@Override
	public String selectMemberPassword(int memNo) {
		return memberDao.selectMemberPassword(sqlSession,memNo);
	}
	
	

}
