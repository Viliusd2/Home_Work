DROP TABLE IF EXISTS product_product_categories;
DROP TABLE IF EXISTS product;

CREATE TABLE product
(
    id                   BIGINT PRIMARY KEY AUTO_INCREMENT,
    product_id           UUID           NOT NULL,
    name                 VARCHAR(200)   NOT NULL,
    quantity_in_stock    INT            NOT NULL,
    one_portion_quantity INT            NOT NULL,
    price                DECIMAL(20, 2) NOT NULL,
    flavor               VARCHAR(100) DEFAULT NULL,
    description          VARCHAR(500) DEFAULT NULL
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

DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id           BIGINT PRIMARY KEY AUTO_INCREMENT,
    name         VARCHAR(20)  NOT NULL,
    surname      VARCHAR(50)  NOT NULL,
    email        VARCHAR(50)  NOT NULL,
    password     VARCHAR(255) NOT NULL,
    phone_Number VARCHAR(12)  NOT NULL,
    CONSTRAINT users_key UNIQUE (email)

);

DROP TABLE IF EXISTS authority;
CREATE TABLE authority
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    CONSTRAINT authority_key UNIQUE (name)
);
DROP TABLE IF EXISTS users_authorities;
CREATE TABLE users_authorities
(
    user_id        BIGINT not null,
    authorities_id BIGINT not null,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (authorities_id) REFERENCES authority (id)
);

DROP TABLE IF EXISTS cart cascade ;
CREATE TABLE cart
(
    id      BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT       not null,
    purchase_date DATE not null,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

DROP TABLE IF EXISTS cart_items cascade ;
CREATE TABLE cart_items
(
    id      BIGINT PRIMARY KEY AUTO_INCREMENT,
    product_id BIGINT not null,
    quantity   INT not null,
    original_price DECIMAL(20, 2) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product (id)
);

DROP TABLE IF EXISTS cart_cart_items ;
CREATE TABLE cart_cart_items
(
    cart_id    BIGINT not null,
    cart_items_id    BIGINT not null,
    FOREIGN KEY (cart_id) REFERENCES cart (id),
    FOREIGN KEY (cart_items_id) REFERENCES cart_items (id)
)
