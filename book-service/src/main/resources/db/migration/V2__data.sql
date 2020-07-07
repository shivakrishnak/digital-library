Insert into book_id_generator(sequence_name, next_val) values ('book',0);

Insert into category (id, name) values (100, 'Fiction');
Insert into category (id, name) values (101, 'Non-Fiction');
Insert into category (id, name) values (102, 'Software Development');


Insert into book (category_id, isbn, name, year, id) values (100, '32cd-of72-25el', 'Lord of the Rings', '1954', 1);
Insert into author (first_name, last_name, id) values ('Tolkien', 'J R R', 1);
Insert into book_authors (book_id, authors_id) values (1, 1);

Insert into book (category_id, isbn, name, year, id) values (101, 'ie73-11ea-b3de', 'The Theory of Everything', '2002', 2);
Insert into author (first_name, last_name, id) values ('Stephen', 'Hawking', 2);
Insert into book_authors (book_id, authors_id) values (2, 2);

Insert into book (category_id, isbn, name, year, id) values (102, 'fe62-47dj-82wm', 'Effective Java', '2001', 3);
Insert into author (first_name, last_name, id) values ('Joshua', 'Bloch', 3);
Insert into book_authors (book_id, authors_id) values (3, 3);