package org.example.entity;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "Client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 200)
    private String name;
}
