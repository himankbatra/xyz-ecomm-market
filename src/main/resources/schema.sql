DROP TABLE IF EXISTS BRANDS;
CREATE TABLE BRANDS(ID BIGINT PRIMARY KEY, NAME VARCHAR(50));


DROP TABLE IF EXISTS SUPPLIERS;
CREATE TABLE SUPPLIERS(ID BIGINT PRIMARY KEY, NAME VARCHAR(50));

DROP TABLE IF EXISTS PRODUCT_TYPE;
CREATE TABLE PRODUCT_TYPE(ID BIGINT PRIMARY KEY, NAME VARCHAR(50));

DROP TABLE IF EXISTS PRODUCTS;
CREATE TABLE PRODUCTS(ID BIGINT PRIMARY KEY, NAME VARCHAR(50),
BRAND BIGINT, TYPE BIGINT, SUPPLIER BIGINT, AVAILABLE_COUNT INT,PRICE DECIMAL,SIZE INT,COLOR VARCHAR(20),
FOREIGN KEY (BRAND) REFERENCES BRANDS(ID),
FOREIGN KEY (TYPE) REFERENCES PRODUCT_TYPE(ID),
FOREIGN KEY (SUPPLIER) REFERENCES SUPPLIERS(ID));


