INSERT INTO PRODUCT (product_id, name, quantity_in_stock, one_portion_quantity, price, flavor, description, image_id)
VALUES ('e4dbc123-a7c2-4bee-a519-e1b9ba991341', 'Vanilla mousse cake', 10, 1, 6000.00,'Strawberry filled with vanilla mousse flavor', 'description', 1),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991388', 'Cupcakes Chocolate', 200, 20, 2000.00, 'Chocolate', 'description', 2),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991342', 'Chocolate brownie gnh', 12, 1, 5000.00, 'Chocolate brownie with gnash','description', 3),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991350', 'Cupcakes Chocolate', 240, 20, 2000.00, 'Chocolate', 'description', 12),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991344', 'Vanilla mousse cake', 11, 1, 6000.00,'Pistachio and raspberry filed with vanilla flavor', 'description', 4),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991345', 'Mousse Dessert', 30, 3, 2400.00,'Strawberry filled with vanilla mousse flavor', 'description', 5),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991346', 'Mousse Dessert', 35, 3, 2400.00,'Cherry filed with mascarpone vanilla mousse flavor', 'description', 6),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991347', 'Mousse Dessert', 31, 3, 2400.00,'Cherry filed with chocolate mousse flavor', 'description', 9),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991348', 'Muffin Chocolate', 60, 6, 3000.00, 'Chocolate', 'description', 8),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991358', 'Muffin Chocolate', 60, 6, 3000.00, 'Vanilla', 'description', 7),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991368', 'K-pop Dark', 50, 6, 1500.00, 'Dark beer filling', 'description', 10),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991378', 'K-pop Red', 55, 6, 1500.00, 'Red velvet filling', 'description', 10),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991349', 'Cupcakes Vanilla', 240, 20, 2000.00, 'Vanilla', 'description', 11);

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

INSERT INTO users(name, surname, email, password, phone_number)
VALUES ('Admin', 'Pavardenis', 'admin@eshop.lt', '{bcrypt}$2a$10$kf8cJpZFe1z3hrI9O/Cjnuh.SKShYOMEGlYigeKxRvwqBAQ4jKJze',
        ''), -- pass is admin
       ('User', 'Pavardenis', 'user@eshop.lt', '{bcrypt}$2a$10$auHiOfM5qK7.M2ghqP5X/.U2XOa2OjADI7X/6cM9MEI3HglrZuWLW',
        ''); -- pass is user

INSERT into authority(name)
VALUES ('ADMIN'),
       ('USER');

INSERT into users_authorities(user_id, authorities_id)
VALUES (1, 1),
       (2, 2),
       (1, 2);

INSERT into file(file_id, file_name, file_extension, media_type, size)
VALUES ('a05d3d32-fafd-4e7e-92d2-86a2b67257b9', 'blueBear', 'jpg', 'image/jpeg', 246433),
       ('8a8b4938-15ce-4470-8431-a2ba1dd3269b', 'cupCakesGreen', 'jpg', 'image/jpeg', 306395),
       ('4c89f990-c924-4ebe-980f-0dba76ad6233','brownie','jpg','image/jpeg',356699),
       ('e981fad5-4004-480c-be22-3b65e1180999','mouseCakeRedWhite','jpg','image/jpeg',233459),
       ('284bc026-a8ec-468a-a145-6a4902e99989','santaHats','jpg','image/jpeg',156686),
       ('8b3a7331-09d6-443a-829d-f6e1cfc97bcf','dessertsSpring','jpg','image/jpeg',270044),
       ('caf2cfa1-5bee-40e9-b647-3d1be1b27290','dessertsPink','jpg','image/jpeg',408318),
       ('4306db38-7de5-4d96-a7b7-a8b9680a64ab','muffinsRedChoko','jpg','image/jpeg',199771),
       ('39c75104-8aca-4a4c-aac7-b16988c75525','dessertWhite','jpg','image/jpeg',320923),
       ('15f85946-b978-441e-a052-a1a86d3d652f','k-pop','jpg','image/jpeg',132743),
       ('a191b0fd-486b-4ed6-893c-1fbf75287357','cupcakesWhite','jpg','image/jpeg',194412),
       ('d3aa7318-9de0-49a5-a809-2195bffa119a','cupCakesPastele','jpg','image/jpeg',380673);



