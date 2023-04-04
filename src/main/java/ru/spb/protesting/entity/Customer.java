package ru.spb.protesting.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @Table(name = "customer")
@Getter @Setter @NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //без нее в getOneById добавлялось поле про лейзиИнишалайзер
@Schema(description = "Customer")
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Customer id")
    private Long id;

    @Column(name = "first_name")
    @Schema(description = "Customer first name")
    private String firstName;

    @Column(name = "last_name")
    @Schema(description = "Customer last name")
    private String lastName;

    @Schema(description = "Customer email")
    private String email;

    @OneToOne(cascade = CascadeType.MERGE)
/** дурацкая аннотация, если двусторонняя, то она соединяет только одинаковые id. с одной стороны id=1 и с другой
 * тоже должен быть 1, а если вдруг где-то в БД был пропущен id у одной из сущностей, то получится ошибка и попоболь
 * А при односторонней связи создание возможно только при CascadeType.ALL, но при этом при апдете создается каждый
 * раз новый адрес. Как побороть? */
    @Schema(description = "Customer address")
    private Address address;

}
