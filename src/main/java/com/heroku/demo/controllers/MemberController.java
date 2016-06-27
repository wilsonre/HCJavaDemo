package com.heroku.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.heroku.demo.entities.Member;
import com.heroku.demo.services.MemberService;

@Controller
@RequestMapping(value="members")
public class MemberController extends BaseController{
	
	private static Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	/*
	 * HTML Pages
	 */
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView listPage(@RequestParam(required = false, defaultValue = "0") int page, 
								 @RequestParam(required = false, defaultValue = "50") int records
								 ) {
		ModelAndView mav = new ModelAndView("members/all");
		List<Member> Member = new ArrayList<Member>();
		
		if (logger.isDebugEnabled())
			logger.debug("MemberController -> Page for listing Member");
			Member.addAll(memberService.findAll(page, records).getContent());
		mav.addObject("Members", Member);
		return mav;
	}

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView createPage() {
		ModelAndView mav = new ModelAndView("members/new");
		mav.addObject("Member", new Member());
		
		if (logger.isDebugEnabled())
			logger.debug("MemberController -> Page for creating Member");
		
		return mav;
	}
	
	@RequestMapping(value="/edit/{id}.html", method=RequestMethod.GET)
	public ModelAndView editPage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("members/edit");
		Member member = memberService.get(id);
		
		if (logger.isDebugEnabled())
			logger.debug("MemberController -> Page for editing Member");

		mav.addObject("Member", member);

		return mav;
	}
	
}
