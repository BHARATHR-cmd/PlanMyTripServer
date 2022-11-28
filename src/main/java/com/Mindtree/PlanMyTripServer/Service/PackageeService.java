package com.Mindtree.PlanMyTripServer.Service;

import com.Mindtree.PlanMyTripServer.Model.PackageeEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service

public interface PackageeService {
    public PackageeEntity createPackagee(PackageeEntity packagee);
    public PackageeEntity updatePackagee(PackageeEntity updatepackagee);
    PackageeEntity getPackagee(long pid);
    public List<PackageeEntity> getPackagees();
    public void deletePackagee(long pid);
}
