package com.Mindtree.PlanMyTripServer.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "oid", nullable = false)
    private Long oid;

    private Date startDateofVacation;
    private Date endDateofVacation;

    private Date orderDate_Time;

    public Date getOrderDate_Time() {
        return orderDate_Time;
    }

    public void setOrderDate_Time(Date orderDate_Time) {
        this.orderDate_Time = orderDate_Time;
    }

    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<MemberEntity> memberEntities= new LinkedHashSet<>();

    private int oprice;

    @ManyToOne
    @JoinColumn(name = "type_tid")
    private TypeEntity type;

    private int packageid;


    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "user_userid")
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public int getPackageid() {
        return packageid;
    }

    public void setPackageid(int packageid) {
        this.packageid = packageid;
    }


    public OrderEntity() {
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }


    public OrderEntity(Long oid, Date startDateofVacation, Date endDateofVacation, Date orderDate_Time, Set<MemberEntity> memberEntities, int oprice, TypeEntity type, int packageid, UserEntity user) {
        this.oid = oid;
        this.startDateofVacation = startDateofVacation;
        this.endDateofVacation = endDateofVacation;
        this.orderDate_Time = orderDate_Time;
        this.memberEntities = memberEntities;
        this.oprice = oprice;
        this.type = type;
        this.packageid = packageid;
        this.user = user;
    }

    public Date getStartDateofVacation() {
        return startDateofVacation;
    }

    public void setStartDateofVacation(Date startDateofVacation) {
        this.startDateofVacation = startDateofVacation;
    }

    public Date getEndDateofVacation() {
        return endDateofVacation;
    }

    public void setEndDateofVacation(Date endDateofVacation) {
        this.endDateofVacation = endDateofVacation;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Set<MemberEntity> getMemberEntities() {
        return memberEntities;
    }

    public void setMemberEntities(Set<MemberEntity> memberEntities) {
        this.memberEntities = memberEntities;
    }

    public int getOprice() {
        return oprice;
    }

    public void setOprice(int oprice) {
        this.oprice = oprice;
    }

    public void setType(TypeEntity type) {
        this.type = type;
    }

    public TypeEntity getType() {
        return type;
    }


    public Long getOid() {
        return oid;
    }





}
