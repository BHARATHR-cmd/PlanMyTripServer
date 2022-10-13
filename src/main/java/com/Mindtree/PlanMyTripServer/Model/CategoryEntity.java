package com.Mindtree.PlanMyTripServer.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cid", nullable = false)
    private Long cid;

    private String Ctitle;

    private  String CDescription;

    private String CImage;

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<PackageeEntity> packages = new LinkedHashSet<>();

    public Set<PackageeEntity> getPackages() {
        return packages;
    }


    public void setPackages(Set<PackageeEntity> packages) {
        this.packages = packages;
    }

    public Long getCid() {
        return cid;
    }



    public String getCtitle() {
        return Ctitle;
    }

    public void setCtitle(String ctitle) {
        Ctitle = ctitle;
    }

    public String getCDescription() {
        return CDescription;
    }

    public void setCDescription(String CDescription) {
        this.CDescription = CDescription;
    }

    public String getCImage() {
        return CImage;
    }

    public void setCImage(String CImage) {
        this.CImage = CImage;
    }
}
