package com.bookforyou.bk4u.subscription.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookforyou.bk4u.subscription.model.service.SubscriptionService;

@Controller
public class SubscriptionController {
	
		
	@RequestMapping("join.sub")
	public String joinSub() {
		return "subscription/subscriptionJoin";
	}
	
	@RequestMapping("joinAgree.sub")
	public String joinAgreeSub() {
		return "subscription/subscriptionJoinAgree";
	}
	
	@RequestMapping("pay.sub")
	public String paySub() {
		return "subscription/subscriptionPay";
	}
	
	@RequestMapping("payComplete.sub")
	public String payCompleteSub() {
		return "subscription/subscriptionPayComplete";
	}

}
