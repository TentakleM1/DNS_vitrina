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
VALUES ('Витрина КБТ',0,20,30,300),
    ('D',30,355,420,30),
    ('b',450,355,260,30),
    ('c',730,355,100,30),
    ('a',830,365,70,20),
    ('h',900,355,100,30),
    ('i',1000,355,120,30),
    ('k',1120,335,30,50),
    ('l',100,1,300,30),
    ('p',400,1,50,20),
    ('t',450,1,60,50),
    ('y',530,50,300,50),
    ('q',830,1,30,50),
    ('t',880,1,50,50),
    ('t',930,50,300,30),
    ('r',1230,80,30,220),
    ('e',1150,335,60,50),
    ('w',80,100,150,30),
    ('e',80,180,150,30),
    ('e',80,270,150,30),
    ('e',270,100,150,30),
    ('q',270,180,150,30),
    ('q',270,270,150,30),
    ('q',420,100,20,30),
    ('y',450,100,110,80),
    ('t', 450, 220, 130, 30),
    ('r', 620, 220, 130, 30),
    ('ctx', 620, 120, 130, 70),
    ('ctx', 790, 150, 100, 30),
    ('ctx', 790, 220, 100, 30),
    ('ctx', 930, 130, 100, 50), 
    ('ctx', 930, 220, 100, 30),
    ('ctx', 1080, 130, 100, 50),
    ('ctx', 1080, 220, 100, 30);
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
INSERT INTO color_user (color_id,user_id)
VALUES (2,2),
       (1,1);
INSERT INTO animal_user(animal_id,user_id)
VALUES (1,1),
       (4,2);
