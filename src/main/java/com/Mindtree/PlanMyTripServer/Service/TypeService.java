package com.Mindtree.PlanMyTripServer.Service;

import com.Mindtree.PlanMyTripServer.Model.MemberEntity;

import java.util.List;

public interface MemberService {
    public MemberEntity createMember(MemberEntity member);
    public MemberEntity updateMember(MemberEntity updatemember);
    MemberEntity getMember(long mid);
    public List<MemberEntity> getMembers();
    public void deleteMember(long mid);
}
