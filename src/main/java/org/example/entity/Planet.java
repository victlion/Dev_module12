package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "Planet")
@Data
public class Planet {
    @Id
    private String id;

    @Column(name = "name", length = 500)
    private String name;
}
