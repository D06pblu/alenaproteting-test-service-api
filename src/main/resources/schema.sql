DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS address;

create table if not exists address
(
    id          serial8     not null,
    country     varchar(50) NOT NULL,
    city        varchar(50) NOT NULL,
    line_one    varchar(100),
    line_two    varchar(200),
    index       bigint         not null,
    constraint address_pk primary key (id)
);

create TABLE if not exists customer
(
    id         serial8     not null,
    first_name varchar(50) NOT NULL,
    last_name  varchar(50) NOT NULL,
    email      varchar(100),
    address_id bigint not null ,
    constraint customer_pk primary key (id),
    constraint address_fk foreign key (address_id) references address (id) on update cascade
);
