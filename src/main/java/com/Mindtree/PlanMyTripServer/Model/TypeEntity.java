package com.Mindtree.PlanMyTripServer.Model;

import javax.persistence.*;

@Entity
public class TypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tid", nullable = false)
    private Long tid;

    private String type;

    private  int tprice;

    public TypeEntity(Long tid, String type, int tprice) {
        this.tid = tid;
        this.type = type;
        this.tprice = tprice;
    }

    public int getTprice() {
        return tprice;
    }

    public void setTprice(int tprice) {
        this.tprice = tprice;
    }

    public TypeEntity() {
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTid() {
        return tid;
    }
}
