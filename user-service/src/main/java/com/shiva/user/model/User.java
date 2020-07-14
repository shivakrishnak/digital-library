package com.shiva.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "user_generator")
    @TableGenerator(name = "user_generator", table = "user_id_generator")
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

}
