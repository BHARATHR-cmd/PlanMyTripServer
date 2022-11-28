package com.Mindtree.PlanMyTripServer.Repository;

import com.Mindtree.PlanMyTripServer.Model.MemberEntity;
import com.Mindtree.PlanMyTripServer.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
}
