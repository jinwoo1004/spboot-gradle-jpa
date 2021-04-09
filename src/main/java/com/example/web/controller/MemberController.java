package com.example.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.web.domain.Member;
import com.example.web.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;
    
    /* JOIN PARAM
     	{
    	"account" : "jinwoo1004",
    	"password" : "1234",
    	"name" : "이진우"
		}
     */
	@PostMapping("/join")
	public String join(@RequestBody Member member) {
		System.out.println("JOIN START");
		Member newMember = new Member();
		try {
			//들어온 데이터 대하여 가공이 필요한 경우 컨트롤러 내 작성
			newMember = memberService.joinMember(member);
		} catch(Exception e) {
			System.out.println(newMember + "JOIN FAIL!!");
			return member.getName() + "is join fail!!";
		}
		System.out.println(newMember + "SUCCESE!!");
		return member.getName() + "is join succese!!";
	}

    /* READ PARAM
     * http://localhost:8080/member/read?id=1
     */
	@GetMapping("/read")
	public Member read(@RequestParam Long id) {
		System.out.println("READ START");
		Optional<Member> memberList = null;
		try {
			//들어온 데이터 대하여 가공이 필요한 경우 컨트롤러 내 작성
	    	memberList = memberService.searchId(id);
		} catch(Exception e) {
			System.out.println("READ FAIL!!");
			return memberList.get();
		}
		return memberList.get();
	}

    /* UPDATE PARAM
     	{
    	"account" : "jinwoo1004",
    	"password" : "1234",
    	"name" : "이진우"
		}
     */
	@PutMapping("/update")
	public Optional<Member> update(@RequestBody Long id, @RequestBody Member member) {
		System.out.println("UPDATE START");
		Optional<Member> updateMember = null;
		try {
			//들어온 데이터 대하여 가공이 필요한 경우 컨트롤러 내 작성
			updateMember = memberService.updateMember(id, member);
		} catch(Exception e) {
			System.out.println("UPDATE FAIL!!");
			return updateMember;
		}
		return updateMember;
	}

    /* DELETE PARAM
     	{
    	"account" : "jinwoo1004",
    	"password" : "1234",
    	"name" : "이진우"
		}
     */
	@PutMapping("/delete")
	public Optional<Member> delete(@RequestBody Long id, @RequestBody Member member) {
		System.out.println("DELETE START");
		Optional<Member> deleteMember = null;
		try {
			//들어온 데이터 대하여 가공이 필요한 경우 컨트롤러 내 작성
			deleteMember = memberService.deleteMember(id, member);
		} catch(Exception e) {
			System.out.println("DELETE FAIL!!");
			return deleteMember;
		}
		return deleteMember;
	}
}
