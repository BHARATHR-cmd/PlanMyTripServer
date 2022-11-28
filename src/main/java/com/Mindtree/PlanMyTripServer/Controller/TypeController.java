package com.Mindtree.PlanMyTripServer.Controller;


import com.Mindtree.PlanMyTripServer.Model.TypeEntity;
import com.Mindtree.PlanMyTripServer.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
@CrossOrigin("*")

public class TypeController {

    @Autowired
    private TypeService typeService;

    @PostMapping("/")
    public TypeEntity createtype(@RequestBody TypeEntity type){

        return this.typeService.createType(type);

    }
    @GetMapping("/{tid}")
    public TypeEntity getType(@PathVariable Long tid){
        return this.typeService.getType(tid);
    }
    @GetMapping("/")
    public List<TypeEntity> getPackages(){
        System.out.println("controller");
        return this.typeService.getTypes();
    }

    @PutMapping("/")
    public TypeEntity updateType(@RequestBody TypeEntity updatedtype){

        return this.typeService.updateType(updatedtype);

    }

    @DeleteMapping("/{tid}")
    public void  deleteType(@PathVariable Long tid){
        this.typeService.deleteType(tid);
    }

}
