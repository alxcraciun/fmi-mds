package com.oportune.oportune;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne
    private User user;
}
