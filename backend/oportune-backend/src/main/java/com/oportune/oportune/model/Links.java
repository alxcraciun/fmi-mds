package com.oportune.oportune.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oportune.oportune.enums.Platform;
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
@Table(name="links")
public class Links {
    @Id
    @SequenceGenerator(
            name="links_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "links_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private int id;

    @Enumerated(EnumType.STRING)
    private Platform platform;

    private String url;

    @OneToMany(mappedBy = "links", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Organizer> organizer;

}
