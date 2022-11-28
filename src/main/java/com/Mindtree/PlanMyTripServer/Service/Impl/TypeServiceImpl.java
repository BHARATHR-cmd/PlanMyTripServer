package com.Mindtree.PlanMyTripServer.Service.Impl;

import com.Mindtree.PlanMyTripServer.Model.MemberEntity;
import com.Mindtree.PlanMyTripServer.Model.TypeEntity;
import com.Mindtree.PlanMyTripServer.Repository.MemberRepository;
import com.Mindtree.PlanMyTripServer.Repository.TypeRepository;
import com.Mindtree.PlanMyTripServer.Service.MemberService;
import com.Mindtree.PlanMyTripServer.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;


    @Override
    public TypeEntity createType(TypeEntity type) {
        return this.typeRepository.save(type);
    }

    @Override
    public TypeEntity updateType(TypeEntity updatetype) {
        return this.typeRepository.save(updatetype);
    }

    @Override
    public TypeEntity getType(long tid) {
        return this.typeRepository.findById(tid).get();
    }

    @Override
    public List<TypeEntity> getTypes() {
        System.out.println("impl");
        return this.typeRepository.findAll();
    }

    @Override
    public void deleteType(long tid) {
      this.typeRepository.deleteById(tid);

    }
}
