package com.bookforyou.bk4u.subscription.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookforyou.bk4u.subscription.model.service.SubscriptionService;

@Controller
public class SubscriptionController {

	/** 정기구독 메인페이지 호출용
	 * @author daeunlee
	 */
	@RequestMapping("join.sub")
	public String joinSub() {
		return "subscription/subscriptionJoin";
	}
	
	/** 정기구독 가입페이지 호출용
	 * @author daeunlee
	 */
	@RequestMapping("joinAgree.sub")
	public String joinAgreeSub() {
		return "subscription/subscriptionJoinAgree";
	}
	
	/** 정기구독 결제용
	 * @author daeunlee
	 */
	
	@RequestMapping("pay.sub")
	public String paySub() {
		return "subscription/subscriptionPay";
	}
	
	
	@RequestMapping("payComplete.sub")
	public String payCompleteSub() {
		return "subscription/subscriptionPayComplete";
	}
	
	
}
