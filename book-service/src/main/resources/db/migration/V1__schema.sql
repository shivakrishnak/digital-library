create table author (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id))

create table book (id bigint not null, isbn varchar(255), name varchar(255), year varchar(255), category_id bigint, primary key (id))

create table category (id bigint not null, name varchar(255), primary key (id))

create table book_authors (book_id bigint not null, authors_id bigint not null)

create table book_id_generator (sequence_name varchar(255) not null, next_val bigint, primary key (sequence_name))

alter table book add constraint book_category_fk foreign key (category_id) references category
alter table book_authors add constraint book_authors_uk unique (authors_id)
alter table book_authors add constraint book_authors_authors_id_fk foreign key (authors_id) references author
alter table book_authors add constraint book_authors_book_id_fk foreign key (book_id) references book