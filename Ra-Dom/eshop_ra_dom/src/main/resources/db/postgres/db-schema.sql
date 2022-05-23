DROP TABLE IF EXISTS product_product_categories;
DROP TABLE IF EXISTS product;

CREATE TABLE product
(
    id                SERIAL PRIMARY KEY,
    product_id        UUID           NOT NULL,
    name              VARCHAR(200)   NOT NULL,
    quantity_in_stock INT            NOT NULL,
    price             DECIMAL(20, 2) NOT NULL,
    flavor            VARCHAR(100) DEFAULT NULL,
    description       VARCHAR(500) DEFAULT NULL
);
DROP TABLE IF EXISTS product_category;
CREATE TABLE product_category
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL
);

CREATE TABLE product_product_categories
(
    products_id           BIGINT,
    product_categories_id BIGINT,
    FOREIGN KEY (products_id) REFERENCES product (id),
    FOREIGN KEY (product_categories_id) REFERENCES product_category (id)
);

DROP TABLE IF EXISTS users CASCADE ;
CREATE TABLE users
(
    id           SERIAL PRIMARY KEY ,
    name         VARCHAR(20)  NOT NULL,
    surname      VARCHAR(50)  NOT NULL,
    email        VARCHAR(50)  NOT NULL,
    password     VARCHAR(255) NOT NULL,
    zip_code     VARCHAR(10)  NOT NULL,
    phone_Number VARCHAR(12)  NOT NULL

);

DROP TABLE IF EXISTS authority CASCADE;
CREATE TABLE authority
(
    id   SERIAL PRIMARY KEY ,
    name VARCHAR(100) NOT NULL
);
DROP TABLE IF EXISTS users_authorities CASCADE;
CREATE TABLE users_authorities
(
    user_id BIGINT not null ,
    authorities_id BIGINT not null,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (authorities_id) REFERENCES authority (id)
);
