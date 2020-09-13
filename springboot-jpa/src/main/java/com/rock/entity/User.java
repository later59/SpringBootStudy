package com.rock.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

//使用JPA注解配置映射关系
@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "tal_user") //@Table来指定和哪个数据表对应；如果省略默认表名就是user
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class User {

    @Id //表示这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;

    @Column(name = "last_name",length = 50)//
    private String lastName;

    @Column
    private String email;

    @Column
    private String userBir;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserBir() {
        return userBir;
    }

    public void setUserBir(String userBir) {
        this.userBir = userBir;
    }
}
