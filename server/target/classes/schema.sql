
CREATE TABLE IF NOT EXISTS users
(
    id  INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name    TEXT NOT NULL,
    password    TEXT NOT NULL,
    last_name     TEXT NOT NULL,
    root   BOOLEAN  NOT NULL
    );

CREATE TABLE IF NOT EXISTS blocks
(
    id  INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name    TEXT NOT NULL,
    x    INTEGER NOT NULL,
    y     INTEGER NOT NULL,
    width   INTEGER NOT NULL,
    height INTEGER NOT NULL
    );

CREATE TABLE IF NOT EXISTS tasks
(
    id  INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name TEXT NOT NULL
    );

CREATE TABLE IF NOT EXISTS tasks_user
(
    tasks_id  INTEGER NOT NULL REFERENCES tasks (id)
    ON DELETE CASCADE ON UPDATE CASCADE,
    user_id INTEGER NOT NULL REFERENCES users (id)
    ON DELETE CASCADE ON UPDATE CASCADE
    );

CREATE TABLE IF NOT EXISTS blocks_user
(
    block_id  INTEGER NOT NULL REFERENCES blocks (id)
    ON DELETE CASCADE ON UPDATE CASCADE,
    user_id INTEGER NOT NULL REFERENCES users (id)
    ON DELETE CASCADE ON UPDATE CASCADE
    );


CREATE TABLE IF NOT EXISTS animals
(
    id  INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name TEXT NOT NULL,
    user_id INTEGER REFERENCES users (id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS colors
(
    id  INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    color TEXT NOT NULL,
    user_id INTEGER REFERENCES users (id)
    ON DELETE CASCADE ON UPDATE CASCADE
);
