package ru.spb.protesting.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @OneToOne
    @PrimaryKeyJoinColumn
    @JsonManagedReference
    private Address address;

}
