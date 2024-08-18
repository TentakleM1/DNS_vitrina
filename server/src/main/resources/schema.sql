DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE IF NOT EXISTS users
(
    id  INTEGER               NOT NULL AUTO_INCREMENT,
    name    CHARACTER VARYING(50) NOT NULL,
    password    CHARACTER VARYING(30) NOT NULL,
    last_name     CHARACTER VARYING(50) NOT NULL,
    root            BOOLEAN                 NOT NULL
--     CONSTRAINT user_pk PRIMARY KEY (id)
    );