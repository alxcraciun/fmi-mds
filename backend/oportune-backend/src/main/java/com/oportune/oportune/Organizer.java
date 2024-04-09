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
@Table(name="organizer")
public class Organizer {
    @Id
    @SequenceGenerator(
            name="organizer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "organizer_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private int id;
    private String name;
    private String description;
}
