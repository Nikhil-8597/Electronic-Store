package com.icwd.electronic.store.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="users")
public class User {
    @Id
    private String userid;
    @Column(name="user_name")
    private String name;
    @Column(name="user_email",unique = true)
    private String email;
    @Column(name = "user_password",length = 10)
    private  String password;
    @Column(name = "user_gender")
    private String gender;
    @Column(name = "user_about",length = 1000)
    private String about;
    @Column(name = "user_image_name")
    private String imagename;
}
