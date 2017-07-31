package org.mp.dao;

import org.mp.model.Member;

public interface MemberDAO {
	public Member getMember(int idnumber);
	public void addMember(Member member);
}
