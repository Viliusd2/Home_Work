INSERT INTO PRODUCT (product_id, name, quantity_in_stock,one_portion_quantity, price, flavor, description)
VALUES ('e4dbc123-a7c2-4bee-a519-e1b9ba991341', 'Vanilla mousse cake', 10,1, 6000.00,'Strawberry filled with vanilla mousse flavor', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991342', 'Chocolate brownie gnh', 12,1, 5000.00, 'Chocolate brownie with gnash',''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991343', 'Chocolate brownie msc', 15,1, 5000.00,'Chocolate brownie with mascarpone cream', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991344', 'Vanilla mousse cake', 11,1, 6000.00,'Pistachio and raspberry filed with vanilla flavor', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991345', 'Mousse Dessert', 30,3, 2400.00,'Strawberry filled with vanilla mousse flavor', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991346', 'Mousse Dessert', 35,3, 2400.00,'Cherry filed with mascarpone vanilla mousse flavor', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991347', 'Mousse Dessert', 31,3, 2400.00,'Cherry filed with chocolate mousse flavor', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991348', 'Muffin Chocolate', 60,6, 3000.00, 'Chocolate', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991358', 'Muffin Vanilla', 60,6, 3000.00, 'Vanilla', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991368', 'K-pop Dark', 50,6, 1500.00, 'Dark beer filling', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991378', 'K-pop Red', 55,6, 1500.00, 'Red velvet filling', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991388', 'Cupcakes Chocolate', 200,20, 2000.00, 'Chocolate', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991349', 'Cupcakes Vanilla', 240,20, 2000.00, 'Vanilla', '');

INSERT INTO product_category(name)
VALUES ('Cakes'),
       ('Deserts'),
       ('Cupcakes'),
       ('Pies'),
       ('Other');

INSERT INTO product_product_categories(products_id, product_categories_id)
VALUES (1, 1),
       (2, 4),
       (3, 4),
       (4, 4),
       (5, 1),
       (6, 2),
       (7, 2),
       (8, 3),
       (9, 3),
       (10, 5),
       (11, 5),
       (12, 3),
       (13, 3);

INSERT INTO users(name, surname, email, password, zip_code, phone_number)
VALUES ('Admin', 'Pavardenis', 'admin@eshop.lt', '{bcrypt}$2a$10$kf8cJpZFe1z3hrI9O/Cjnuh.SKShYOMEGlYigeKxRvwqBAQ4jKJze', 'LT-00001', ''), -- pass is admin
       ('User', 'Pavardenis', 'user@eshop.lt', '{bcrypt}$2a$10$auHiOfM5qK7.M2ghqP5X/.U2XOa2OjADI7X/6cM9MEI3HglrZuWLW', 'LT-00001', ''); -- pass is user

INSERT into authority(name)
VALUES ('ADMIN'),
       ('USER');

INSERT into users_authorities(user_id, authorities_id)
VALUES (1, 1),
       (2, 2),
       (1, 2);