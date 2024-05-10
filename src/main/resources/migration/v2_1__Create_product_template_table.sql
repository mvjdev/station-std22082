CREATE TABLE product_template (
                                  id VARCHAR(255) PRIMARY KEY,
                                  name VARCHAR(255) NOT NULL,
                                  price DECIMAL(18, 2) NOT NULL,
                                  stock_quantity DECIMAL(15, 4) DEFAULT 0
);

INSERT INTO product_template
VALUES (
           'id_1',
           'Gasoil',
           4900,
           150.00
       );

INSERT INTO product_template
VALUES (
           'id_2',
           'Essence',
           5900,
           200.00
       );

INSERT INTO product_template
VALUES (
           'id_3',
           'Pétrole',
           2130,
           100.00
       );
