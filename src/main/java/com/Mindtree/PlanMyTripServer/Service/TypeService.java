package com.Mindtree.PlanMyTripServer.Service;

import com.Mindtree.PlanMyTripServer.Model.TypeEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TypeService {
    public TypeEntity createType(TypeEntity type);
    public TypeEntity updateType(TypeEntity updatetype);
    TypeEntity getType(long mid);
    public List<TypeEntity> getTypes();
    public void deleteType(long mid);
}
