package com.example.web.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.web.WebApplicationTests;
import com.example.web.domain.Member;

public class MemberRepositoryTests extends WebApplicationTests {
	
    @Autowired
    private MemberRepository memberRepository;
    
    @Test
    public void create() {
    	Member member = new Member();
    
    	member.setAccount("testId");
    	member.setPassword("testPw");
    	member.setName("testName");
    	
    	Member newMember = memberRepository.save(member);
    }
    
    @Test
    public void read() {
    	Optional<Member> member = memberRepository.findById(1L);
    	
    	member.ifPresent(selectMember ->{
    		System.out.println(selectMember.getName());
    		System.out.println(selectMember.getAccount());
    	});
    }
    
    @Test
    public void update() {
    	Optional<Member> member = memberRepository.findById(1L);
    	
    	member.ifPresent(selectMember ->{
    		selectMember.setName("������");
    		selectMember.setAccount("jinwoo1004");
    		memberRepository.save(selectMember);
    	});
    }

    @Test
    public void delete() {
    	Optional<Member> member = memberRepository.findById(1L);
    	
    	member.ifPresent(selectMember ->{
    		memberRepository.delete(selectMember);
    	});
    }
}