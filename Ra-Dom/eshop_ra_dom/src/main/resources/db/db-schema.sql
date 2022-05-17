DROP TABLE IF EXISTS product_product_categories;

DROP TABLE IF EXISTS PRODUCT;

CREATE TABLE PRODUCT
(
    id                BIGINT PRIMARY KEY AUTO_INCREMENT,
    product_id        UUID           NOT NULL,
    name              VARCHAR(200)    NOT NULL,
    quantity_in_stock INT            NOT NULL,
    price             DECIMAL(20, 2) NOT NULL,
    flavor            VARCHAR(500) DEFAULT NULL
);
DROP TABLE IF EXISTS product_category;
CREATE TABLE product_category
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL
);

CREATE TABLE product_product_categories
(
    products_id           BIGINT,
    product_categories_id BIGINT,
    FOREIGN KEY (products_id) REFERENCES product (id),
    FOREIGN KEY (product_categories_id) REFERENCES product_category (id)
);
