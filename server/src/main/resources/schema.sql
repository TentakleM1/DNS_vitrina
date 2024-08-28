
CREATE TABLE IF NOT EXISTS users
(
    id  INTEGER               NOT NULL AUTO_INCREMENT,
    name    CHARACTER VARYING(50) NOT NULL,
    password    CHARACTER VARYING(30) NOT NULL,
    last_name     CHARACTER VARYING(50) NOT NULL,
    root            BOOLEAN                 NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS block
(
    id  INTEGER               NOT NULL AUTO_INCREMENT,
    name    CHARACTER VARYING(100) NOT NULL,
    x    INTEGER NOT NULL,
    y     INTEGER NOT NULL,
    length   INTEGER NOT NULL,
    height INTEGER NOT NULL,
    CONSTRAINT block_pk PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS message
(
    id  INTEGER               NOT NULL AUTO_INCREMENT,
    name    CHARACTER VARYING(250) NOT NULL,
    CONSTRAINT message_pk PRIMARY KEY (id)
    );
CREATE TABLE IF NOT EXISTS message_user
(
    message_id  INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    CONSTRAINT user_message_pk PRIMARY KEY (user_id, message_id),
    CONSTRAINT user_message_fk FOREIGN KEY (user_id) REFERENCES users (id)
    ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT user_message_fk_1 FOREIGN KEY (message_id) REFERENCES message (id)
    ON DELETE CASCADE ON UPDATE CASCADE
    );
CREATE TABLE IF NOT EXISTS block_user
(
    block_id  INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    CONSTRAINT user_block_pk PRIMARY KEY (user_id, block_id),
    CONSTRAINT user_block_fk FOREIGN KEY (user_id) REFERENCES users (id)
    ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT user_block_fk_1 FOREIGN KEY (block_id) REFERENCES block (id)
    ON DELETE CASCADE ON UPDATE CASCADE
    );
