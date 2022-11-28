package com.Mindtree.PlanMyTripServer.Controller;


import com.Mindtree.PlanMyTripServer.Model.MemberEntity;
import com.Mindtree.PlanMyTripServer.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@CrossOrigin("*")

public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/")
    public MemberEntity createmember(@RequestBody MemberEntity member){

        return this.memberService.createMember(member);

    }
    @GetMapping("/{mid}")
    public MemberEntity getMember(@PathVariable Long mid){
        return this.memberService.getMember(mid);
    }
    @GetMapping("/")
    public List<MemberEntity> getPackages(){
        return this.memberService.getMembers();
    }

    @PutMapping("/")
    public MemberEntity updateMember(@RequestBody MemberEntity updatedmember){

        return this.memberService.updateMember(updatedmember);

    }

    @DeleteMapping("/{mid}")
    public void  deleteMember(@PathVariable Long mid){
        this.memberService.deleteMember(mid);
    }

}
