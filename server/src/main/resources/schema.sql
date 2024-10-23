CREATE TABLE IF NOT EXISTS users
(
    id        INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    password  VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    root      BOOLEAN      NOT NULL,
    color_id  INTEGER  NOT NULL,
    animal_id INTEGER  NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id),
    FOREIGN KEY (color_id) REFERENCES colors (id) ON DELETE CASCADE,
    FOREIGN KEY (animal_id) REFERENCES animals (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS blocks
(
    id     INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    x      INTEGER NOT NULL,
    y      INTEGER NOT NULL,
    width  INTEGER NOT NULL,
    height INTEGER NOT NULL,
    CONSTRAINT pk_block PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tasks
(
    id   INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_task PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS vitrins
(
    id       INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    block_id INTEGER      NOT NULL,
    user_id  INTEGER,
    CONSTRAINT pk_vitrina PRIMARY KEY (id),
    FOREIGN KEY (block_id) REFERENCES blocks (id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS animals
(
    id   INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR(39) NOT NULL,
    CONSTRAINT pk_animal PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS colors
(
    id    INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    color VARCHAR(30) NOT NULL,
    CONSTRAINT pk_color PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS epics
(
    id             BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    task_id        INTEGER,
    user_id        INTEGER,
    description    VARCHAR(255),
    color_priority VARCHAR(10),
    FOREIGN KEY (task_id) REFERENCES tasks (id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS success_epic
(
    id             BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    task_id        INTEGER,
    user_id        INTEGER,
    description    VARCHAR(255),
    color_priority VARCHAR(10),
    FOREIGN KEY (task_id) REFERENCES tasks (id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE

);


