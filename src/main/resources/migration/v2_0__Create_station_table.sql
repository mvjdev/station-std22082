CREATE TABLE station (
                         id VARCHAR(255) PRIMARY KEY,
                         location VARCHAR(255) NOT NULL,
                         create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                         update_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

INSERT INTO station
VALUES (
        'uuid_generate_v4()',
        'Analamahitsy',
        '2019-05-10 04:15:30',
        '2024-05-10 14:03:57'
       );

