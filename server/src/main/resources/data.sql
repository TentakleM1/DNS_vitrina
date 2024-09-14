INSERT INTO users (name,password,last_name,root)
VALUES ('Ирина',
       '123456',
       'Поливаева',
       'true');
INSERT INTO users (name,password,last_name,root)
VALUES ('Сергей',
       '123456',
       'Горячих',
       'true');
INSERT INTO tasks (name)
VALUES ('Выставить товар со склада'),
    ('Поправить товар на витрине'),
    ('Сделать актуальность витрины'),
    ('Сделать инвентаризацию витрины'),
    ('Сделать переоценку витрины');
INSERT INTO blocks (name,x,y,width,height)
VALUES ('Витрина КБТ',
        10,
        10,
        20,
        30);
INSERT INTO animals (name)
VALUES ('FOX'),
       ('WOLF'),
       ('DOG'),
       ('BEAR'),
       ('ELEPHANT'),
       ('RABBIT'),
       ('PANDA'),
       ('ZEBRA'),
       ('CAT'),
       ('HAMSTER'),
       ('RACCOON');
INSERT INTO colors (color)
VALUES ('TURQUOISE'),
       ('BLUE'),
       ('RED'),
       ('PURPLE'),
       ('PINK'),
       ('YELLOW'),
       ('GREEN'),
       ('LIGHT BLUE'),
       ('LIGHT GREEN'),
       ('LIGHT RED'),
       ('LIGHT PURPLE');
