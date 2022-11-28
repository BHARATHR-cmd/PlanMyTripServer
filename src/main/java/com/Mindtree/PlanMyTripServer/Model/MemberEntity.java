package com.Mindtree.PlanMyTripServer.Model;


import javax.persistence.*;

@Entity
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mid", nullable = false)
    private Long mid;

    private  String mname;

    private String mgender;

    private String mage;
    @ManyToOne
    @JoinColumn(name = "order_oid")
    private OrderEntity order;


    public MemberEntity() {
    }

    public MemberEntity(Long mid, String mname, String mgender, String mage, OrderEntity order) {
        this.mid = mid;
        this.mname = mname;
        this.mgender = mgender;
        this.mage = mage;
        this.order = order;
    }

    public String getMgender() {
        return mgender;
    }

    public void setMgender(String mgender) {
        this.mgender = mgender;
    }

    public String getMage() {
        return mage;
    }

    public void setMage(String mage) {
        this.mage = mage;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }



    public void setOrder(OrderEntity order) {
        this.order = order;
    }



    public OrderEntity getOrder() {
        return order;
    }


    public Long getMid() {
        return mid;
    }
}
