package com.fdmgroup.model.dao;

import java.util.Date;
import java.util.List;

import com.fdmgroup.model.entity.Member;

public interface MemberDAO {

	Member createMember(String username, String email, String password, Date dateOfBirth);

	Member findMember(String username);

	boolean findMemberByEmail(String email);
	
	boolean findMemberByUsername(String username);
	
	List<Member> listMembers();

	boolean removeMember(String username);

	long findNumberOfPostsByMember(Member member);

	boolean updatePassword(Member member, String password);


}