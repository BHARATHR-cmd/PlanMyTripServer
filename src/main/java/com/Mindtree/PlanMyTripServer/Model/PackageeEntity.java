package com.Mindtree.PlanMyTripServer.Model;

import javax.persistence.*;

@Entity
public class PackageeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pid", nullable = false)
    private Long pid;

    private String Ptilte;

    private String Pdescription;

    private String Pimage;

    @ManyToOne
    @JoinColumn(name = "category_cid")
    private CategoryEntity category;

    public CategoryEntity getCategory() {
        return category;
    }


    public Long getPid() {
        return pid;
    }

    public void setPid(Long eid) {
        this.pid = eid;
    }

    public String getPtilte() {
        return Ptilte;
    }

    public void setPtilte(String ptilte) {
        Ptilte = ptilte;
    }

    public String getPdescription() {
        return Pdescription;
    }

    public void setPdescription(String pdescription) {
        Pdescription = pdescription;
    }

    public String getPimage() {
        return Pimage;
    }

    public void setPimage(String pimage) {
        Pimage = pimage;
    }

    public PackageeEntity() {
    }

    public PackageeEntity(Long pid, String ptilte, String pdescription, String pimage) {
        this.pid = pid;
        Ptilte = ptilte;
        Pdescription = pdescription;
        Pimage = pimage;
    }
}
