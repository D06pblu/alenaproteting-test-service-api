package ru.spb.protesting.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @Table(name = "customer")
@Getter @Setter @NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //без нее в getOneById добавлялось поле про лейзиИнишалайзер
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
/** дурацкая аннотация, если двусторонняя, то она соединяет только одинаковые id. с одной стороны id=1 и с другой
 * тоже должен быть 1, а если вдруг где-то в БД был пропущен id у одной из сущностей, то получится ошибка и попоболь
 * А при односторонней связи создание возможно только при CascadeType.ALL, но при этом при апдете создается каждый
 * раз новый адрес. Как побороть? */
    private Address address;

}
