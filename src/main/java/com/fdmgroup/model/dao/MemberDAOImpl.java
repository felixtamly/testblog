package com.fdmgroup.model.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.entity.Member;

public class MemberDAOImpl implements MemberDAO {

	private EntityManager em;

	public MemberDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public Member createMember(String username, String email, String password, Date dateOfBirth) {
		Member member = new Member(username, email, password, dateOfBirth);

		em.getTransaction().begin();
		em.merge(member);
		em.getTransaction().commit();

		return member;
	}

	@Override
	public Member findMember(String username) {
		Member member = em.find(Member.class, username);
		if (member != null)
			return member;
		else
			return null;
	}

	@Override
	public boolean findMemberByUsername(String username) {
		Member member = em.find(Member.class, username);
		if (member != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean findMemberByEmail(String email) {
		List<Member> memberList = null;

		TypedQuery<Member> query = em.createQuery("Select m from BLOG_MEMBERS m where m.email = :email", Member.class)
				.setParameter("email", email);
		memberList = query.getResultList();
		if (memberList.size() > 0)
			return true;
		else
			return false;
	}

	@Override
	public long findNumberOfPostsByMember(Member member) {

		TypedQuery<Long> query = em
				.createQuery("Select count(b) from BLOG_BLOGS b group by b.member having b.member.username = :username",
						Long.class)
				.setParameter("username", member.getUsername());
		try {			
			long numberOfBlogs = query.getSingleResult();
			return numberOfBlogs;
		} catch (NoResultException e) {
			return 0;
		}
	}

	@Override
	public List<Member> listMembers() {
		List<Member> memberList = null;

		TypedQuery<Member> query = em.createQuery("Select m from BLOG_MEMBERS m", Member.class);
		memberList = query.getResultList();

		return memberList;
	}

	@Override
	public boolean removeMember(String username) {

		Member member = findMember(username);
		if (member != null) {
			em.getTransaction().begin();
			em.remove(member);
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}

	}

}
