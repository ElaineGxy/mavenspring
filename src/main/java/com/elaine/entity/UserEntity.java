package com.elaine.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    private Long id;
    private String userName;
    private String userPwd;

    public UserEntity(){}
    public UserEntity(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String phone) {
        this.userPwd = phone;
    }

}
