/**
 * 
 */
package com.heroku.demo.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heroku.demo.entities.Member;
import com.heroku.demo.exceptions.MemberNotFoundException;
import com.heroku.demo.repositories.MemberRepository;

/**
 * @author rtorres
 *
 */
@Service
@Transactional(rollbackFor=MemberNotFoundException.class)
public class MemberService 
{
	private static Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Autowired
	private MemberRepository memberRepository;
	
	/*
	 * READ methods
	 */
	public Page<Member> findAll(int page, int count) {
		
		if (logger.isDebugEnabled())
			logger.debug("MemberService -> findAll Members");
		
		return memberRepository.findAll(new PageRequest(page, count));
	}

	public List<Member> findByMemberId(String memberid){
		if (logger.isDebugEnabled())
			logger.debug("MemberService -> findByAccountId - " + memberid);
		
		return memberRepository.findByMemberid(memberid);
		
	}
	
	public Iterable<Member> findAll() {
		
		if (logger.isDebugEnabled())
			logger.debug("MemberService -> findAll Members");
		
		return memberRepository.findAll();
	}

	public Member get(int id) {
		if (logger.isDebugEnabled())
			logger.debug("Retrieving Member with id:" + id);
		
		Member elementToGet = memberRepository.findOne(id);
		
		if (elementToGet == null)
			throw new MemberNotFoundException(id);
		
		return elementToGet;
	}

	/*
	 * 
	 */
	public Member create(Member member) {

		if (logger.isDebugEnabled())
			logger.debug("MemberService -> create:" + member);
			
		return memberRepository.save(member);
	}

	public Member update(Member member) {
		
		if (logger.isDebugEnabled())
			logger.debug("MemberService -> create:" + member);

		Member elementToUpdate = memberRepository.findOne(member.getId());
		
		if (elementToUpdate == null)
			throw new MemberNotFoundException(member.getName());
		
		elementToUpdate.update(member);
		memberRepository.save(elementToUpdate);
		
		return elementToUpdate;
	}

	public Member delete(int id) {
		if (logger.isDebugEnabled())
			logger.debug("MemberService -> delete:" + id);

		Member elementToDelete = get(id);
		
		if (elementToDelete == null)
			throw new MemberNotFoundException(id);
		
		memberRepository.delete(elementToDelete);

		return elementToDelete;
	}

	/*
	 * HELPERS
	 */

}

