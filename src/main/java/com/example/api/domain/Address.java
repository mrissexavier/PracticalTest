package com.example.api.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long addressId;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    private String complement;

    @Column(nullable = false)
    private String postalCode;

}