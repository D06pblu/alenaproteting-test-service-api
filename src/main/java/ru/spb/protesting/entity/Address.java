package ru.spb.protesting.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @Table(name = "address")
@Getter @Setter @NoArgsConstructor
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;

    private String city;

    @Column(name = "line_one")
    private String lineOne;

    @Column(name = "line_two")
    private String lineTwo;

    private Long index;
}
