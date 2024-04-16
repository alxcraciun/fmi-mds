package com.oportune.oportune;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="city")
public class City {
    @Id
    @SequenceGenerator(
            name="city_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "city_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private int id;
    private String name;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<User> users;

}
