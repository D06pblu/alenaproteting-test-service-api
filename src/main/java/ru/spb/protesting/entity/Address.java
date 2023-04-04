package ru.spb.protesting.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @Table(name = "address")
@Getter @Setter @NoArgsConstructor
@Schema(description = "Customer's address")
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Address id")
    private Long id;

    @Schema(description = "Country")
    private String country;

    @Schema(description = "City")
    private String city;

    @Column(name = "line_one")
    @Schema(description = "Address line one")
    private String lineOne;

    @Column(name = "line_two")
    @Schema(description = "Address line two")
    private String lineTwo;

    @Column(name = "`index`")
    @Schema(description = "Index")
    private Long index;
}
