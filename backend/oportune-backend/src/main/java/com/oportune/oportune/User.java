package com.oportune.oportune;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oportune.oportune.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
    @SequenceGenerator(
            name="user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "user_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private int id;
    private String email;
    private String last_name;
    private String first_name;
    private String password;
    private Role role;

    @Column(nullable = true)
    private String photo;

    @Column(nullable = true)
    private int phone;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<City> city;
}
