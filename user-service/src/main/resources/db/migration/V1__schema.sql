create table user (
        id bigint not null,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        phone_number varchar(255),
        primary key (id)
);

create table user_id_generator (sequence_name varchar(255) not null, next_val bigint, primary key (sequence_name));