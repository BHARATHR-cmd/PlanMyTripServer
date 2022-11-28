package com.Mindtree.PlanMyTripServer.Service.Impl;

import com.Mindtree.PlanMyTripServer.Model.PackageeEntity;
import com.Mindtree.PlanMyTripServer.Repository.PackageeRepository;
import com.Mindtree.PlanMyTripServer.Service.PackageeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Component

public class PackageServiceImpl implements PackageeService {
    @Autowired
    private PackageeRepository packageeRepository;


    @Override
    public PackageeEntity createPackagee(PackageeEntity packagee) {
        return  this.packageeRepository.save(packagee);
    }

    @Override
    public PackageeEntity updatePackagee(PackageeEntity updatedpackagee) {

        return this.packageeRepository.save(updatedpackagee);
    }

    public PackageeEntity getPackagee(long pid) {
        Optional<PackageeEntity> local =this.packageeRepository.findById(pid);
        return local.get();

    }

    @Override
    public List<PackageeEntity> getPackagees() {
        return  this.packageeRepository.findAll();
    }

    @Override
    public void deletePackagee(long pid) {
        this.packageeRepository.deleteById(pid);
        System.out.println("Package Deleted******************** ");

    }
}
