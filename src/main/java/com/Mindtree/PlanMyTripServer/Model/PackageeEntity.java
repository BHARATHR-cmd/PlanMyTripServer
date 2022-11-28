package com.Mindtree.PlanMyTripServer.Model;

import javax.persistence.*;

@Entity
public class PackageeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pid", nullable = false)
    private Long pid;

    private String Ptilte;
    @Column (columnDefinition = "TEXT")
    private String Pdescription;

    private String Pimage;

    @ManyToOne(fetch = FetchType.EAGER )
    private CategoryEntity category;

    private double pprice;

    public double getPprice() {
        return pprice;
    }

    public void setPprice(double pprice) {
        this.pprice = pprice;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
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

    public PackageeEntity(Long pid, String ptilte, String pdescription, String pimage, CategoryEntity category, double pprice) {
        this.pid = pid;
        Ptilte = ptilte;
        Pdescription = pdescription;
        Pimage = pimage;
        this.category = category;
        this.pprice = pprice;
    }
}
