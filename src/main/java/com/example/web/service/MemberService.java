package com.example.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.web.repository.MemberRepository;
import com.example.web.domain.Member;
import org.springframework.stereotype.Service;


@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepo;

	public Member joinMember(Member member) {
		Member newMember = new Member();
		newMember = memberRepo.save(member); 
		return newMember;
	}
	
	public Optional<Member> searchId(Long id) {
		Optional<Member> memberList = null;
		memberList = memberRepo.findById(id);
		return memberList;
	}
	
	public Optional<Member> updateMember(Long id, Member member) {
		Optional<Member> updateMember = null;
		updateMember = memberRepo.findById(id);
    	updateMember.ifPresent(selectMember ->{
    		selectMember.setName(member.getName());
    		selectMember.setAccount(member.getAccount());
    		selectMember.setPassword(member.getPassword());
    		memberRepo.save(selectMember);
    	});
		return updateMember;
	}
	

	public Optional<Member> deleteMember(Long id, Member member) {
		Optional<Member> deleteMember = null;
		deleteMember = memberRepo.findById(id);
    	deleteMember.ifPresent(selectMember ->{
    		selectMember.setName(member.getName());
    		selectMember.setAccount(member.getAccount());
    		selectMember.setPassword(member.getPassword());
    		memberRepo.delete(selectMember);
    	});
		return deleteMember;
	}
}
