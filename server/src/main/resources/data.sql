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
INSERT INTO message (name)
VALUES ('Выставить товар со склада'),
    ('Поправить товар на витрине'),
    ('Сделать актуальность витрины'),
    ('Сделать инвентаризацию витрины'),
    ('Сделать переоценку витрины');
INSERT INTO block (name,x,y,length,height)
VALUES ('Витрина КБТ',
        10,
        10,
        20,
        30);