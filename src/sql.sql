create table "project".parents (
                                   id serial unique primary key,
                                   fio varchar not null,
                                   birthday date not null,
                                   inn int not null unique,
                                   address varchar not null,
                                   email varchar not null unique,
                                   password varchar not null unique
);

create table "project".children (
                                    id serial unique primary key,
                                    fio varchar not null,
                                    inn int not null unique,
                                    birthday date not null,
                                    address varchar not null unique,
                                    parent_id int references "project".parents(id),
                                    class_id int references "project".classes(id),
                                    group_id int references "project".groups(id)
);

create table "project".schools (
                                   id serial unique primary key,
                                   address varchar not null unique,
                                   name_school varchar not null unique,
                                   description varchar not null,
                                   rayon_id int references "project".rayons(id),
                                   administrator_id int references "project".administrators(id)
);

create table "project".classes (
                                   id serial unique primary key ,
                                   class_numb smallint not null,
                                   class_letter varchar(1) not null unique,
                                   head_teacher_fio varchar not null,
                                   school_id int references "project".schools(id)
);

create table "project".kindergarten (
                                        id serial unique primary key,
                                        name_kindergarten varchar not null,
                                        address varchar not null unique,
                                        description varchar not null,
                                        rayon_id int references "project".rayons(id),
                                        administrator_id int references "project".administrators(id)
);

create table "project".groups (
                                  id serial unique primary key,
                                  group_name varchar not null unique,
                                  head_educator_fio varchar not null,
                                  kindergarten_id int references "project".kindergarten(id)
);

create table "project".rayons (
                                       id serial unique primary key,
                                       name_rayon varchar not null unique
);

create table "project".administrators(
id serial primary key,
fio varchar not null,
email varchar unique,
login varchar not null,
password varchar not null
);

insert into project.rayons(name_rayon) values ('Свердловский');
insert into project.rayons(name_rayon) values ('Первомайский');
insert into project.rayons(name_rayon) values ('Аламединский');

insert into project.administrators(fio, email, login, password) VALUES ('Саят Саятов Саматович', 'sayat@gmail.com', 'sayat', 'sayat1');
insert into project.administrators(fio, email, login, password) VALUES ('Азамат Азаматов Ерланович', 'azamat@gmail.com', 'azamat', 'azamat2');

insert into project.schools(address, name_school, description, rayon_id, administrator_id) VALUES ('Гоголя 59', 'Школа №65', 'Эколого экономический лицей', 1, 1);
insert into project.schools(address, name_school, description, rayon_id, administrator_id) VALUES ('Чуй 56', 'Школа №12', 'Гимназия', 1, 1);
insert into project.schools(address, name_school, description, rayon_id, administrator_id) VALUES ('Боконбаева 16', 'Школа №67', 'Гимназия', 1, 1);
insert into project.schools(address, name_school, description, rayon_id, administrator_id) VALUES ('Азовская 5А', 'Школа №41', 'Средняя школа', 2, 1);
insert into project.schools(address, name_school, description, rayon_id, administrator_id) VALUES ('Айни 13', 'Школа №69', 'Гимназия', 2, 1);
insert into project.schools(address, name_school, description, rayon_id, administrator_id) VALUES ('Тыныстынова  110', 'Школа №24', 'Гимназия', 2, 1);
insert into project.schools(address, name_school, description, rayon_id, administrator_id) VALUES ('Аламедин-1', 'Школа №38', 'Гимназия', 3, 1);
insert into project.schools(address, name_school, description, rayon_id, administrator_id) VALUES ('Семёна Будённого 134', 'Школа №51', 'Гимназия', 3, 1);
insert into project.schools(address, name_school, description, rayon_id, administrator_id) VALUES ('Салиева №45', 'Школа №45', 'Средняя школа', 3, 1);

insert into project.kindergarten(name_kindergarten, address, description, rayon_id, administrator_id) VALUES ('ABC kids', 'Токтогула 45', 'Частный детский сад', 1, 2);
insert into project.kindergarten(name_kindergarten, address, description, rayon_id, administrator_id) VALUES ('KIDS ACADEMY', 'Баялинова 57', 'Частный детский сад', 1, 2);
insert into project.kindergarten(name_kindergarten, address, description, rayon_id, administrator_id) VALUES ('Toddlers', 'Будённого 57', 'Образовательный детский сад', 1, 2);
insert into project.kindergarten(name_kindergarten, address, description, rayon_id, administrator_id) VALUES ('Clever kids', 'Оренбургская 42', 'Частный детский сад', 2, 2);
insert into project.kindergarten(name_kindergarten, address, description, rayon_id, administrator_id) VALUES ('Фламинго', 'Панфилова 98', 'Частный детский сад', 2, 2);
insert into project.kindergarten(name_kindergarten, address, description, rayon_id, administrator_id) VALUES ('Тополёк', 'Карагайский переулок 33а', 'Дошкольная образовательная организация', 2, 2);
insert into project.kindergarten(name_kindergarten, address, description, rayon_id, administrator_id) VALUES ('Белочка', 'Курманджан Датка 279', 'Частный детский сад', 3, 2);
insert into project.kindergarten(name_kindergarten, address, description, rayon_id, administrator_id) VALUES ('Бал Бобок', 'Алма-Атинская 559', 'Дошкольное учреждение', 3, 2);
insert into project.kindergarten(name_kindergarten, address, description, rayon_id, administrator_id) VALUES ('Кораблик', 'Садовая 9', 'Частный детский сад', 3, 2);

insert into project.groups(group_name, head_educator_fio, kindergarten_id) VALUES ('Пчелка', 'Покровская Арина Руслановна', 1);
insert into project.groups(group_name, head_educator_fio, kindergarten_id) VALUES ('Смешарики', 'Пономарева Татьяна Кирилловна', 1);
insert into project.groups(group_name, head_educator_fio, kindergarten_id) VALUES ('Паровозик', 'Дроздова Виктория Максимовна', 2);
insert into project.groups(group_name, head_educator_fio, kindergarten_id) VALUES ('Капитошка', 'Назарова София Александровна', 2);
insert into project.groups(group_name, head_educator_fio, kindergarten_id) VALUES ('Веселые ребята', 'Фролова Дарья Олеговна', 3);
insert into project.groups(group_name, head_educator_fio, kindergarten_id) VALUES ('Солнышко', 'Михайлова Таисия Никитична', 3);
insert into project.groups(group_name, head_educator_fio, kindergarten_id) VALUES ('Весёлые гномики', 'Сергеева Милана Михайловна', 4);
insert into project.groups(group_name, head_educator_fio, kindergarten_id) VALUES ('Белочка', 'Григорьева Ярослава Максимовна', 4);
insert into project.groups(group_name, head_educator_fio, kindergarten_id) VALUES ('Буратино', 'Ширяева Ангелина Арсентьевна', 5);
insert into project.groups(group_name, head_educator_fio, kindergarten_id) VALUES ('звездочка', 'Фролова Алёна Андреевна', 5);
insert into project.groups(group_name, head_educator_fio, kindergarten_id) VALUES ('радуга', 'Новикова Арина Кирилловна', 6);
insert into project.groups(group_name, head_educator_fio, kindergarten_id) VALUES ('Непоседы', 'Измайлова Вероника Александровна', 6);
insert into project.groups(group_name, head_educator_fio, kindergarten_id) VALUES ('Путин', 'Орлова Алина Константиновна', 7);
insert into project.groups(group_name, head_educator_fio, kindergarten_id) VALUES ('Трамп', 'Толкачева Татьяна Ильинична', 7);
insert into project.groups(group_name, head_educator_fio, kindergarten_id) VALUES ('Обама', 'Прохорова Анна Святославовна', 8);
insert into project.groups(group_name, head_educator_fio, kindergarten_id) VALUES ('Садыр', 'Маркова Мирослава Матвеевна', 8);
insert into project.groups(group_name, head_educator_fio, kindergarten_id) VALUES ('Токаев', 'Федосеева Малика Артёмовна', 9);
insert into project.groups(group_name, head_educator_fio, kindergarten_id) VALUES ('Байден', 'Чернова Виктория Романовна', 9);