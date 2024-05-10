CREATE TABLE product (
 id VARCHAR(255) PRIMARY KEY,
 id_station VARCHAR(255) REFERENCES station(id),
 id_product_template VARCHAR(255) REFERENCES product_template(id)
);

INSERT INTO product
VALUES (
            'id_product_1',
           (SELECT id FROM station WHERE location = 'Analamahitsy'), -- Obtient l'ID de la station
           'id_1'
       );

INSERT INTO product
VALUES (
           'id_product_2',
           (SELECT id FROM station WHERE location = 'Analamahitsy'), -- Obtient l'ID de la station
           'id_2' -- ID du produit de type Essence
       );

INSERT INTO product
VALUES (
           'id_product_3',
           (SELECT id FROM station WHERE location = 'Analamahitsy'), -- Obtient l'ID de la station
           'id_3' -- ID du produit de type Pétrole
       );
