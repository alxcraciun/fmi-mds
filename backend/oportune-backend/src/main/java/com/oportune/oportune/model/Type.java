package com.oportune.oportune.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oportune.oportune.model.Opportunity;
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
@Table(name="type")
public class Type {
    @Id
    @SequenceGenerator(
            name="type_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "type_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private int id;

    private String name;

    @Column(nullable = true)
    private String description;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Opportunity> opportunity;

}
