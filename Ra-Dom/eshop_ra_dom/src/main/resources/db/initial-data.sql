INSERT INTO PRODUCT (product_id, name, quantity_in_stock, price, flavor, description)
VALUES ('e4dbc123-a7c2-4bee-a519-e1b9ba991341', 'Vanilla mousse cake', 10, 6000.00,
        'Strawberry filled with vanilla mousse flavor', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991342', 'Chocolate brownie gnh', 12, 5000.00, 'Chocolate brownie with gnash',
        ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991343', 'Chocolate brownie msc', 15, 5000.00,
        'Chocolate brownie with mascarpone cream', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991344', 'Vanilla mousse cake', 11, 6000.00,
        'Pistachio and raspberry filed with vanilla flavor', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991345', 'Mousse Dessert', 30, 2400.00,
        'Strawberry filled with vanilla mousse flavor', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991346', 'Mousse Dessert', 35, 2400.00,
        'Cherry filed with mascarpone vanilla mousse flavor', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991347', 'Mousse Dessert', 31, 2400.00,
        'Cherry filed with chocolate mousse flavor', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991348', 'Muffin Chocolate', 60, 3000.00, 'Chocolate', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991358', 'Muffin Vanilla', 60, 3000.00, 'Vanilla', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991368', 'K-pop Dark', 50, 1500.00, 'Dark beer filling', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991378', 'K-pop Red', 55, 1500.00, 'Red velvet filling', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991388', 'Cupcakes Chocolate', 200, 2000.00, 'Chocolate', ''),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991349', 'Cupcakes Vanilla', 240, 2000.00, 'Vanilla', '');

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
VALUES ('Vardenis', 'Pavardenis', 'vp@eshop.lt', '{bcrypt}$2a$10$C3lEG9nvR9B0aFngwf.Ilup4oBj/OcDb2RJYABIvGo1.2Omp7zGlS',
        'LT-00001', ''),
       ('Vardenis', 'Pavardenis', 'user@eshop.lt',
        '{bcrypt}$2a$12$aN8h.f9y3IRQMym392Lvq..ck/2Fdc1VoyK/tOPlsFNkg4O3AWGga', 'LT-00001', ''),
       ('Vardenis', 'Pavardenis', 'admin@eshop.lt',
        '{bcrypt}$2a$12$kshjMkqTj4axeEk2RLKOkOw6924afd0JMqjkaV5fAC.mgQ6Vk1ova', 'LT-00001', ''); -- pass is vp

INSERT into authority(name)
VALUES ('ADMIN'),
       ('USER');
INSERT into users_authorities(user_id, authorities_id)
VALUES (1, 1),
       (2, 1),
       (3, 2),
       (3, 1);