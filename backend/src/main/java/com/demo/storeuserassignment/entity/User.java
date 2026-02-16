package com.demo.storeuserassignment.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String pincode;

    private Double latitude;

    private Double longitude;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
