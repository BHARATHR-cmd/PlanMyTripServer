package com.Mindtree.PlanMyTripServer.Repository;


import com.Mindtree.PlanMyTripServer.Model.AttachmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface AttachmentRepository extends JpaRepository<AttachmentEntity, String> {
}