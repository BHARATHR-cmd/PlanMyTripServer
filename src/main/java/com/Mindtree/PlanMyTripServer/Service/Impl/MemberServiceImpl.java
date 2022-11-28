package com.Mindtree.PlanMyTripServer.Service.Impl;

import com.Mindtree.PlanMyTripServer.Model.MemberEntity;
import com.Mindtree.PlanMyTripServer.Model.OrderEntity;
import com.Mindtree.PlanMyTripServer.Repository.MemberRepository;
import com.Mindtree.PlanMyTripServer.Repository.OrderRepository;
import com.Mindtree.PlanMyTripServer.Service.MemberService;
import com.Mindtree.PlanMyTripServer.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public MemberEntity createMember(MemberEntity member) {
        return this.memberRepository.save(member);

    }

    @Override
    public MemberEntity updateMember(MemberEntity updatemember) {
        return this.memberRepository.save(updatemember);
    }

    @Override
    public MemberEntity getMember(long mid) {
        return this.memberRepository.findById(mid).get();
    }

    @Override
    public List<MemberEntity> getMembers() {
        return this.memberRepository.findAll();
    }

    @Override
    public void deleteMember(long mid) {
        this.memberRepository.deleteById(mid);

    }
}
