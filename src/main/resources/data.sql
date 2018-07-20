/**
 * CREATE Script for init of DB
 */

-- Creating Ingredients

insert into ingredient (id, date_created, date_updated, name, price) values (1, now(), now(), 'Alface', 0.40);
insert into ingredient (id, date_created, date_updated, name, price) values (2, now(), now(), 'Bacon', 2.00);
insert into ingredient (id, date_created, date_updated, name, price) values (3, now(), now(), 'Hamburger', 3.00);
insert into ingredient (id, date_created, date_updated, name, price) values (4, now(), now(), 'Ovo', 0.80);
insert into ingredient (id, date_created, date_updated, name, price) values (5, now(), now(), 'Queijo', 1.50);





-- Create Sandwiches

insert into sandwich (id, date_created, date_updated, name) values (1, now(), now(), 'X-Bacon');
insert into sandwich (id, date_created, date_updated, name) values (2, now(), now(), 'X-Burger');
insert into sandwich (id, date_created, date_updated, name) values (3, now(), now(), 'X-Egg');
insert into sandwich (id, date_created, date_updated, name) values (4, now(), now(), 'X-Egg Bacon');

-- Creating X-Bacon
insert into sandwich_ingredient (date_created, date_updated, sandwich_id, ingredient_id, quantity) values (now()
   , now(), 1, 2, 1);
insert into sandwich_ingredient (date_created, date_updated, sandwich_id, ingredient_id, quantity) values (now()
   , now(), 1, 3, 1);
insert into sandwich_ingredient (date_created, date_updated, sandwich_id, ingredient_id, quantity) values (now()
   , now(), 1, 5, 1);

-- Creating X-Burger
insert into sandwich_ingredient (date_created, date_updated, sandwich_id, ingredient_id, quantity) values (now
(), now(), 2, 3, 1);

insert into sandwich_ingredient (date_created, date_updated, sandwich_id, ingredient_id, quantity) values (now
(),  now(), 2, 5, 1);

-- Creating X-Egg
insert into sandwich_ingredient (date_created, date_updated, sandwich_id, ingredient_id, quantity) values (now
(),  now(), 3, 4, 1);

insert into sandwich_ingredient (date_created, date_updated, sandwich_id, ingredient_id, quantity) values (now
(),  now(), 3, 3, 1);

insert into sandwich_ingredient (date_created, date_updated, sandwich_id, ingredient_id, quantity) values (now
(),  now(), 3, 5, 1);

-- Creating X-Egg Bacon
insert into sandwich_ingredient (date_created, date_updated, sandwich_id, ingredient_id, quantity) values (now
(),  now(), 4, 2, 1);

insert into sandwich_ingredient (date_created, date_updated, sandwich_id, ingredient_id, quantity) values (now
(),  now(), 4, 3, 1);

insert into sandwich_ingredient (date_created, date_updated, sandwich_id, ingredient_id, quantity) values (now
(),  now(), 4, 4, 1);

insert into sandwich_ingredient (date_created, date_updated, sandwich_id, ingredient_id, quantity) values (now
(),  now(), 4, 5, 1);










