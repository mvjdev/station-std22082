CREATE TABLE produit_template (
      id VARCHAR(255) PRIMARY KEY,
      name VARCHAR(255) NOT NULL,
      price DECIMAL(18, 4) NOT NULL
);

INSERT INTO produit_template
VALUES (
           'id_1',
           'Gasoil',
            4900
       );

-- Insérer l'essence
INSERT INTO produit_template
VALUES (
           'id_2',
           'Essence',
           5900
       );

-- Insérer le pétrole
INSERT INTO produit_template
VALUES (
           'id_3',
           'Pétrole',
           2130
       );
