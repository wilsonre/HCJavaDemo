package com.heroku.demo.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.heroku.demo.entities.Member;

/**
 * Repository : Account.
 */
public interface MemberRepository extends PagingAndSortingRepository<Member, Integer> {
	List<Member> findByMemberid(String memberid);
}
