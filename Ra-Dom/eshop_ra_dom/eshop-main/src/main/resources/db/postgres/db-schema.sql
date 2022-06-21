DROP TABLE IF EXISTS product cascade;

CREATE TABLE product
(
    id                   BIGSERIAL PRIMARY KEY,
    product_id           UUID           NOT NULL,
    name                 VARCHAR(200)   NOT NULL,
    quantity_in_stock    INT            NOT NULL,
    one_portion_quantity INT            NOT NULL,
    price                DECIMAL(20, 2) NOT NULL,
    flavor               VARCHAR(100) DEFAULT NULL,
    description          VARCHAR(500) DEFAULT NULL
);
DROP TABLE IF EXISTS product_category cascade;
CREATE TABLE product_category
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    CONSTRAINT product_category_key UNIQUE (name)
);
DROP TABLE IF EXISTS product_product_categories;
CREATE TABLE product_product_categories
(
    products_id           BIGINT,
    product_categories_id BIGINT,
    FOREIGN KEY (products_id) REFERENCES product (id),
    FOREIGN KEY (product_categories_id) REFERENCES product_category (id)
);

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users
(
    id           BIGSERIAL PRIMARY KEY,
    name         VARCHAR(20)  NOT NULL,
    surname      VARCHAR(50)  NOT NULL,
    email        VARCHAR(50)  NOT NULL,
    password     VARCHAR(255) NOT NULL,
    phone_Number VARCHAR(12)  NOT NULL,
    CONSTRAINT users_key UNIQUE (email)
);

DROP TABLE IF EXISTS authority CASCADE;
CREATE TABLE authority
(
    id   BIGSERIAL PRIMARY KEY,
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

DROP TABLE IF EXISTS cart CASCADE;
CREATE TABLE cart
(
    id            BIGSERIAL PRIMARY KEY,
    user_id       BIGINT not null,
    purchase_date DATE   not null,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

DROP TABLE IF EXISTS cart_items CASCADE;
CREATE TABLE cart_items
(
    id             BIGSERIAL PRIMARY KEY,
    product_id     BIGINT         not null,
    quantity       INT            not null,
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





