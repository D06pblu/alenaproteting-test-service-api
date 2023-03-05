package ru.spb.protesting.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String country;

    private String city;

    @Column(name = "line_one")
    private String lineOne;

    @Column(name = "line_two")
    private String lineTwo;

    private long index;

    @OneToOne(mappedBy="address")
    @PrimaryKeyJoinColumn
    @JsonBackReference
    private Customer customer;
}
