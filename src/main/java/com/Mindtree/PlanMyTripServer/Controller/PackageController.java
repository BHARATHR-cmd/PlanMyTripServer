package com.Mindtree.PlanMyTripServer.Controller;


import com.Mindtree.PlanMyTripServer.Model.PackageeEntity;
import com.Mindtree.PlanMyTripServer.Service.PackageeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/package")
@CrossOrigin("*")

public class PackageController {

    @Autowired
    private PackageeService packageeService;

    @PostMapping("/")
    public PackageeEntity createpackagee(@RequestBody PackageeEntity packagee){

        return this.packageeService.createPackagee(packagee);

    }
    @GetMapping("/{pid}")
    public PackageeEntity getPackagee(@PathVariable Long pid){
        return this.packageeService.getPackagee(pid);
    }
    @GetMapping("/")
    public List<PackageeEntity> getPackages(){
        return this.packageeService.getPackagees();
    }

    @PutMapping("/{pid}")
    public PackageeEntity updatePackagee(@RequestBody PackageeEntity updatedpackagee,@PathVariable Long cid){
        PackageeEntity packagee=this.packageeService.getPackagee(cid);
        packagee.setPtilte(updatedpackagee.getPtilte());
        packagee.setPdescription(updatedpackagee.getPdescription());
        packagee.setPimage(updatedpackagee.getPimage());
        return this.packageeService.updatePackagee(packagee);

    }

    @DeleteMapping("/{pid}")
    public void  deletePackagee(@PathVariable Long pid){
        this.packageeService.deletePackagee(pid);
    }

}
