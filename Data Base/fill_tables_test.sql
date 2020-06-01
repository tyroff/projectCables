INSERT INTO "category"
---------------------------------------------------
("id", "name"                 , "parent_id") VALUES
---------------------------------------------------
(   1, 'Рабочие'              , NULL       ),
(   2,     'Учебные'          , 1          ),
(   3,         'Дисциплины'   , 2          ),
(   4,         'Курсовые'     , 2          ),
(   5,         'Дипломные'    , 2          ),
(   6,     'Научные'          , 1          ),
(   7,     'Административные' , 1          ),
(   8, 'Домашние'             , NULL       ),
(   9,     'Покупки'          , 8          ),
(  10,     'Ремонт'           , 8          ),
(  11, 'Личные'               , NULL       ),
(  12,     'Фильмы'           , 11         ),
(  13,     'Самообучение'     , 11         );

INSERT INTO "note"
------------------------------------------------------------------------------------------------------------------------
("id", "title"                                     , "text"                                      , "category_id") VALUES
------------------------------------------------------------------------------------------------------------------------
(   1, 'Заполнить журнал'                          , 'Внести в журнал нагрузки занятия за ноябрь', 2            ),
(   2, 'Подготовить лекцию по PostgreSQL'          , 'План:
1. DDL
    1.1. Автоинкрементные идентификаторы
    1.2. Наследование таблиц
2. Типы данных
    2.1. Числа, строки, даты
    2.2. Массивы, структуры
3. DML
4. Доступ к БД в Node.js и Java'                                                                 , 3            ),
(   3, 'Подготовить задание на лабораторные по ППС', 'Включить задание по UML диаграммам'        , 3            ),
(   4, 'Прочитать куровые работы перед защитой'    , NULL                                        , 4            ),
(   5, 'Диплом Веры'                               , 'Оценить схему базы данных'                 , 5            ),
(   6, 'Диплом Нади'                               , 'Забрать заявку у заказчика'                , 5            ),
(   7, 'Диплом Любы'                               , 'Проанализировать интерфейс'                , 5            ),
(   8, 'Доработать анализатор SDO'                 , 'Сделать выгрузку оценок в eluni.vsu.by'    , 6            ),
(   9, 'Подготовить статью'                        , 'Учебный ORM-framework'                     , 6            ),
(  10, 'Проработать требования к приложению'       , '1. Физическая активность
2. Дневник питания'                                                                              , 6            ),
(  11, 'Подготовить отчёт по науке'                , 'Добавить итоги конкурса проектов'          , 7            ),
(  12, 'Сделать план перенастройки сервера'        , 'Подготовить и расшарить Google-документ'   , 7            ),
(  13, 'Разобрать вещи на балконе'                 , '1. Убрать старые доски
2. Выбросить пустые банки из-под закаток'                                                        , 8            ),
(  14, 'Купить новый шкаф в спальню'               , NULL                                        , 9            ),
(  15, 'Купить полочку под зеркало в прихожую'     , NULL                                        , 9            ),
(  16, 'Починить кран в кухне'                     , NULL                                        , 10           ),
(  17, 'Посмотреть сериал «Бесы»'                  , 'По роману Достоевского'                    , 12           ),
(  18, 'Пересмотреть «Люди X»'                     , 'Показать ребёнку'                          , 12           ),
(  19, 'Подготовиться к сертификации по .Net'      , 'Изучить Exam Ref 70-486'                   , 13           );

INSERT INTO "task"
--------------------------------------------------------------------------------------------------------------------
("id", "title"                    , "text"                            , "category_id", "date"               ) VALUES
--------------------------------------------------------------------------------------------------------------------
(  20, 'Защита курсовых работ'    , 'Место: аудитория 308. Защищаются:
1. Иванов А. Б.
2. Петров В. Г.
3. Сидоров Д. Е.'                                                     , 4            , '2018-12-07 14:30:00'),
(  21, 'Совещание в деканате'     , NULL                              , 7            , '2018-12-06 10:55:00'),
(  22, 'Купить лекарства в аптеке', '1. Аспирин
2. Сироп от кашля
3. Капли в нос
4. Аскорбиновая кислота'                                              , 9            , '2018-12-08 16:30:00');

INSERT INTO "user"
---------------------------------------------
("id", "login"   , "password", "role") VALUES
---------------------------------------------
(   1, 'root'    , 'root'    , 0     ),
(   2, 'admin'   , 'admin'   , 0     ),
(   3, 'vera'    , '12345'   , 1     ),
(   4, 'nadezhda', '12345'   , 1     ),
(   5, 'lubov'   , '12345'   , 1     );

INSERT INTO "admin"
----------------------------------
("id", "hardware_key"     ) VALUES
----------------------------------
(   1, 'ROOT_HARDWARE_KEY'),
(   2, 'ADMN_HARDWARE_KEY');

INSERT INTO "client"
--------------------------------------------------------
("id", "email"           , "phone"              ) VALUES
--------------------------------------------------------
(   3, 'vera@gmail.com'  , '+375 (29) 123-45-67'),
(   4, 'nadezhda@mail.ru', '+375 (33) 987-65-43'),
(   5, 'lubov@tut.by'    , '+375 (25) 555-55-55');
