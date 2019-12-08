package com.bugsbunnywyunj.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_info")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="lasr_name",length = 50)
    private String lastname;
    @Column(name="phone",length = 50)
    private String phone;
    @Column(name="pass_word",length =50)
    private  String passWord;
    @Column(name="ID_cd_number",length = 50)
    private  String IDcdNumber;
    @Column(name="true_name",length = 50)
    private String trueName;
    @Column(name="address",length = 50)
    private  String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getIDcdNumber() {
        return IDcdNumber;
    }

    public void setIDcdNumber(String IDcdNumber) {
        this.IDcdNumber = IDcdNumber;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
