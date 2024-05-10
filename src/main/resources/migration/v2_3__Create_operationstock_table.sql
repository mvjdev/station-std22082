CREATE TABLE operation_stock (
     id VARCHAR(255) PRIMARY KEY,
     id_product VARCHAR(255) REFERENCES product(id),
     quantity DECIMAL(15,5) NOT NULL,
     date_time TIMESTAMP NOT NULL,
     type VARCHAR(10) CHECK (type IN ('entree', 'sortie'))
);

INSERT INTO operation_stock (id, id_product, quantity, date_time, type)
VALUES (
           'id_operation_1',
           (SELECT id FROM product WHERE id = 'id_product_1'),
           100,
           '2024-05-10 08:00:00',
           'entree'
       );

INSERT INTO operation_stock (id, id_product, quantity, date_time, type)
VALUES (
           'id_operation_2',
           (SELECT id FROM product WHERE id = 'id_product_2'),
           10,
           '2024-05-10 12:00:00',
           'sortie'
       );

INSERT INTO operation_stock (id, id_product, quantity, date_time, type)
VALUES (
           'id_operation_3',
           (SELECT id FROM product WHERE id = 'id_product_3'),
           75,
           '2024-05-10 15:00:00',
           'entree'
       );

