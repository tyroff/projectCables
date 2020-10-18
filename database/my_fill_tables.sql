INSERT INTO "user"
(
"id",
"login",
"password",
"role"
) VALUES
(1, 'admin', 'admin', 0),
(2, 'VinokurovKA', 'hello', 1);
/*
0 -	org.itstep.vinokurov.domain.Role.ADMIN,
1 -	org.itstep.vinokurov.domain.Role.TECHNOLOGIST,
2 -	org.itstep.vinokurov.domain.Role.ECONOMIST
*/

INSERT INTO "cable_category"
(
"id",
"name"
) VALUES
(1, 'Силовые кабели на напряжение 0,66-6 кВ'),
(2, 'Провода бытового назначения'),
(3, 'Кабели контрольные');

INSERT INTO "brands"
(
"id",
"name"
) VALUES
(1, 'АВВГ'),
(2, 'ВВГ'),
(3, 'АПвВГ');

INSERT INTO "technical_normative_legal_act"
(
"id",
"code",
"name",
"date_start",
"date_end"
) VALUES
(1, 'ГОСТ 16442-80', 'Кабели силовые с пластмассовой изоляцией', '1980-05-22', '2020-12-31'),
(2, 'ГОСТ 1508-78', 'Кабели контрольные с резиновой и пластмассовой изоляцией', '1980-01-01', '2020-12-31'),
(3, 'Техническое соглашение №1', 'Кабели силовые и контольные с пластмассовой изоляцией по ТС№1', '2020-03-09', '2020-12-31');

INSERT INTO "technical_normative_legal_act_vs_cable_category"
(
"id_technical_normative_legal_act",
"id_cable_category"
) VALUES
(1, 1),
(2, 3),
(3, 1),
(3, 3);



INSERT INTO "parameters"
(
"id",
"name",
"units",
"print_to_task",
"read_by_the_formula"
) VALUES
(1, 'Номинальное сечение основной жилы', 'мм.кв.', true, false),
(2, 'Количество основных жил', 'шт.', true, false),
(3, 'Номинальное напряжение', 'кВ.', true, false),
(4, 'Материал токопроводящей жилы', NULL, false, false),
(5, 'Радиальная толщина изоляции', 'мм.', true, true),
(6, 'Радиальная толщина оболочки', 'мм.', true, true),
(7, 'Электрическое сопротивление изоляции', 'МОм', true, false),
(8, 'Плотность', 'г/см.куб.', false, false),
(9, 'Тип сырья', NULL, false, false),
(10, 'Внутренний диаметр', 'мм.', true, true),
(11, 'Тип жилы', NULL, true, true);

INSERT INTO "type_material"
(
"id",
"id_parameter",
"value"
) VALUES
(1, 9, ''),
(2, 9, 'поливинилхлоридный'),
(3, 9, 'полиэтилен'),
(4, 9, 'сшитый полиэтилен'),
(5, 9, 'краситель поливинилхлоридный');

INSERT INTO "nominal_cross_section"
(
"id",
"id_parameter",
"value"
) VALUES
(1,1,''),
(2,1,'0,5'),
(3,1,'0,75'),
(4,1,'1'),
(5,1,'1,5'),
(6,1,'2,5'),
(7,1,'4'),
(8,1,'6'),
(9,1,'10'),
(10,1,'16'),
(11,1,'25'),
(12,1,'35'),
(13,1,'50'),
(14,1,'70'),
(15,1,'95'),
(16,1,'120'),
(17,1,'150'),
(18,1,'185'),
(19,1,'240'),
(20,1,'300'),
(21,1,'400'),
(22,1,'500'),
(23,1,'630'),
(24,1,'800'),
(25,1,'1000'),
(26,1,'1000c'),
(27,1,'1200'),
(28,1,'1200c'),
(29,1,'1400c'),
(30,1,'1600c'),
(31,1,'2000c');

INSERT INTO "type_conductor"
(
"id",
"id_parameter",
"value"
) VALUES
(1,11,''),
(2,11,'ок'),
(3,11,'мк'),
(4,11,'ос'),
(5,11,'мс');

INSERT INTO "number_of_conductors"
(
"id",
"id_parameter",
"value"
) VALUES
(1,2,0),
(2,2,1),
(3,2,2),
(4,2,3),
(5,2,4),
(6,2,5);
INSERT INTO "number_of_conductors"
(
"id",
"value"
) VALUES
(1,2,0),
(2,2,1),
(3,2,2),
(4,2,3),
(5,2,4),
(6,2,5);

INSERT INTO "rated_voltage"
(
"id",
"id_parameter",
"value"
) VALUES
(1, 3, ''),
(2, 3, '0,38'),
(3, 3, '0,66'),
(4, 3, '1'),
(5, 3, '3'),
(6, 3, '6'),
(7, 3, '10'),
(8, 3, '15'),
(9, 3, '20'),
(10, 3, '30'),
(11, 3, '35'),
(12, 3, '45'),
(13, 3, '110'),
(14, 3, '220');

INSERT INTO "conductor_metal"
(
"id",
"id_parameter",
"value"
) VALUES
(1, 4, ''),
(2, 4, 'алюминий'),
(3, 4, 'алюминиевый сплав'),
(4, 4, 'алюмомедь'),
(5, 4, 'медь'),
(6, 4, 'сталь');

INSERT INTO "technological_stage"
(
"id",
"name"
) VALUES
(1, 'Волочение проволоки'),
(2, 'Скрутка жилы'),
(3, 'Опрессование токопроводящей жилы'),
(4, 'Скрутка опрессованных жил'),
(5, 'Опрессование кабеля');

INSERT INTO "type_of_material_value"
(
"id",
"name"
) VALUES
(1, 'Готовая продукция'),
(2, 'Полуфабрикаты'),
(3, 'Сырьё'),
(4, 'Сырьё-группа');

INSERT INTO "table_of_technical_normative_legal_act"
(
"id",
"id_technical_normative_legal_act",
"id_technological_stage",
"name"
) VALUES
(1, 1, 3, 'Номинальная радиальная толщина изоляции'),
(2, 1, 5, 'Номинальная радиальная толщина оболочки'),
(3, 2, 3, 'Номинальная радиальная толщина изоляции'),
(4, 2, 5, 'Номинальная радиальная толщина оболочки');

INSERT INTO "parameters_vs_table_of_technical_normative_legal_act"
(
"id",
"id_table_of_technical_normative_legal_act",
"id_parameter_result",
"id_parameter_determinant_1",
"id_parameter_determinant_2",
"id_parameter_determinant_3"
) VALUES
(1, 1, 5, 3, 1, 9),
(2, 1, 6, 10, NULL, NULL),
(3, 2, 5, 3, 1, 9),
(4, 2, 6, 10, 9, NULL);

INSERT INTO "technical_normative_legal_act_vs_parameters"
(
"line_number",
"id_parameters_vs_table",
"id_parameter",
"value_nominal",
"value_minimum",
"value_maximum",
"value"
) VALUES
(1, 1, 5, 0.6, 0.4, NULL, NULL),
(1, 1, 3, NULL, NULL, NULL, '0,66'),
(1, 1, 1, NULL, NULL, NULL, '1'),
(1, 1, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(2, 1, 5, 0.6, 0.4, NULL, NULL),
(2, 1, 3, NULL, NULL, NULL, '0.66'),
(2, 1, 1, NULL, NULL, NULL, '1.5'),
(2, 1, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(3, 1, 5, 0.6, 0.4, NULL, NULL),
(3, 1, 3, NULL, NULL, NULL, '0.66'),
(3, 1, 1, NULL, NULL, NULL, '2.5'),
(3, 1, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(4, 1, 5, 0.7, 0.5, NULL, NULL),
(4, 1, 3, NULL, NULL, NULL, '0.66'),
(4, 1, 1, NULL, NULL, NULL, '4'),
(4, 1, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(5, 1, 5, 0.7, 0.5, NULL, NULL),
(5, 1, 3, NULL, NULL, NULL, '0.66'),
(5, 1, 1, NULL, NULL, NULL, '6'),
(5, 1, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(6, 1, 5, 0.9, 0.7, NULL, NULL),
(6, 1, 3, NULL, NULL, NULL, '0.66'),
(6, 1, 1, NULL, NULL, NULL, '10'),
(6, 1, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(7, 1, 5, 0.9, 0.7, NULL, NULL),
(7, 1, 3, NULL, NULL, NULL, '0.66'),
(7, 1, 1, NULL, NULL, NULL, '16'),
(7, 1, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(8, 1, 5, 1.1, 0.9, NULL, NULL),
(8, 1, 3, NULL, NULL, NULL, '0.66'),
(8, 1, 1, NULL, NULL, NULL, '25'),
(8, 1, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(9, 1, 5, 1.1, 0.9, NULL, NULL),
(9, 1, 3, NULL, NULL, NULL, '0.66'),
(9, 1, 1, NULL, NULL, NULL, '35'),
(9, 1, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(10, 1, 5, 1.3, 1.1, NULL, NULL),
(10, 1, 3, NULL, NULL, NULL, '0.66'),
(10, 1, 1, NULL, NULL, NULL, '50'),
(10, 1, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(1, 2, 6, 1.2, 0.9, NULL, NULL),
(1, 2, 10, NULL, 0, 6, NULL),
(2, 2, 6, 1.5, 1.2, NULL, NULL),
(2, 2, 10, NULL, 6, 15, NULL),
(3, 2, 6, 1.7, 1.3, NULL, NULL),
(3, 2, 10, NULL, 15, 20, NULL),
(4, 2, 6, 1.9, 1.5, NULL, NULL),
(4, 2, 10, NULL, 20, 30, NULL),
(5, 2, 6, 2.1, 1.7, NULL, NULL),
(5, 2, 10, NULL, 30, 40, NULL),
(6, 2, 6, 2.3, 1.9, NULL, NULL),
(6, 2, 10, NULL, 40, 50, NULL),
(7, 2, 6, 2.5, 2, NULL, NULL),
(7, 2, 10, NULL, 50, 60, NULL),
(8, 2, 6, 3, 2.5, NULL, NULL),
(8, 2, 10, NULL, 60, 666, NULL),
(1, 3, 5, 0.5, 0.3, NULL, NULL),
(1, 3, 3, NULL, NULL, NULL, '0,66'),
(1, 3, 1, NULL, NULL, NULL, '1'),
(1, 3, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(2, 3, 5, 0.5, 0.3, NULL, NULL),
(2, 3, 3, NULL, NULL, NULL, '0.66'),
(2, 3, 1, NULL, NULL, NULL, '1.5'),
(2, 3, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(3, 3, 5, 0.5, 0.3, NULL, NULL),
(3, 3, 3, NULL, NULL, NULL, '0.66'),
(3, 3, 1, NULL, NULL, NULL, '2.5'),
(3, 3, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(4, 3, 5, 0.6, 0.4, NULL, NULL),
(4, 3, 3, NULL, NULL, NULL, '0.66'),
(4, 3, 1, NULL, NULL, NULL, '4'),
(4, 3, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(5, 3, 5, 0.6, 0.4, NULL, NULL),
(5, 3, 3, NULL, NULL, NULL, '0.66'),
(5, 3, 1, NULL, NULL, NULL, '6'),
(5, 3, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(6, 3, 5, 0.8, 0.6, NULL, NULL),
(6, 3, 3, NULL, NULL, NULL, '0.66'),
(6, 3, 1, NULL, NULL, NULL, '10'),
(6, 3, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(7, 3, 5, 0.8, 0.6, NULL, NULL),
(7, 3, 3, NULL, NULL, NULL, '0.66'),
(7, 3, 1, NULL, NULL, NULL, '16'),
(7, 3, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(8, 3, 5, 1, 0.8, NULL, NULL),
(8, 3, 3, NULL, NULL, NULL, '0.66'),
(8, 3, 1, NULL, NULL, NULL, '25'),
(8, 3, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(9, 3, 5, 1, 0.8, NULL, NULL),
(9, 3, 3, NULL, NULL, NULL, '0.66'),
(9, 3, 1, NULL, NULL, NULL, '35'),
(9, 3, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(10, 3, 5, 1.2, 1, NULL, NULL),
(10, 3, 3, NULL, NULL, NULL, '0.66'),
(10, 3, 1, NULL, NULL, NULL, '50'),
(10, 3, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(1, 4, 6, 1.1, 0.8, NULL, NULL),
(1, 4, 10, NULL, 0, 6, NULL),
(2, 4, 6, 1.3, 1, NULL, NULL),
(2, 4, 10, NULL, 6, 15, NULL),
(3, 4, 6, 1.6, 1.2, NULL, NULL),
(3, 4, 10, NULL, 15, 20, NULL),
(4, 4, 6, 1.8, 1.4, NULL, NULL),
(4, 4, 10, NULL, 20, 30, NULL),
(5, 4, 6, 2, 1.6, NULL, NULL),
(5, 4, 10, NULL, 30, 40, NULL),
(6, 4, 6, 2.2, 1.8, NULL, NULL),
(6, 4, 10, NULL, 40, 50, NULL),
(7, 4, 6, 2.4, 2, NULL, NULL),
(7, 4, 10, NULL, 50, 60, NULL),
(8, 4, 6, 3, 2.5, NULL, NULL),
(8, 4, 10, NULL, 60, 666, NULL);

INSERT INTO "manufacturer's_raw_materials"
(
"id",
"id_type_of_material_value",
"name", "name_manufacturer",
"price"
) VALUES
(3000001, 3, 'Поливинилхлоридный пластикат изоляционный - марки И 40-14 ГОСТ 16336', 'ОДО ФТОРОТЕКС', 9.99),
(3000002, 3, 'Поливинилхлоридный пластикат изоляционный - марки И 40-13 ГОСТ 16336', 'ООО Пластинвест', 10.09),
(3000003, 3, 'Поливинилхлоридный пластикат изоляционный - марки И 40-13 ГОСТ 16336', 'ОДО ФТОРОТЕКС', 8.88),
(3000004, 3, 'Катанка алюминиевая ГОСТ 13843', 'ООО БВБ-Альянс, Москва', 3000),
(3000005, 3, 'Катанка алюминиевая ГОСТ 13843', 'OBO Bettermann, Germany', 4409),
(3000006, 3, 'Катанка алюминиевая ГОСТ 13843', 'Добро, ЧП, Одесса', 2550),
(3000007, 3, 'Катанка медная ТУ 16 К71.003-87', 'Цветмет, Минск', 6666),
(3000008, 3, 'Катанка медная ТУ 16 К71.003-87', 'Монарх, ООО, Ревда (Сверд)', 8875),
(3000009, 3, 'Катанка медная ТУ 16 К71.003-87', 'UzKimyoINC', 7705),
(3000010, 3, 'Поливинилхлоридный пластикат для оболочки - марки О-40 по ГОСТ 5960', 'ОДО ФТОРОТЕКС', 705),
(3000011, 3, 'Краситель поливинилхлоридный чёрный', 'ОДО ФТОРОТЕКС', 2000),
(3000012, 3, 'Краситель поливинилхлоридный синий', 'ОДО ФТОРОТЕКС', 1999),
(3000013, 3, 'Краситель поливинилхлоридный серый', 'ОДО ФТОРОТЕКС', 2100),
(3000014, 3, 'Краситель поливинилхлоридный коричневый', 'ОДО ФТОРОТЕКС', 1950);

INSERT INTO "raw_materials_group"
(
"id",
"id_type_of_material_value",
"name"
) VALUES
(4000001, 4, 'ИЗОЛЯЦИЯ ПОЛИВИНИЛХЛОРИДНАЯ'),
(4000002, 4, 'ОБОЛОЧКА ПОЛИВИНИЛХЛОРИДНАЯ'),
(4000003, 4, 'КАТАНКА АЛЮМИНИЕВАЯ'),
(4000004, 4, 'КАТАНАКА МЕДНАЯ'),
(4000005, 4, 'КРАСИТЕЛЬ ПОЛИВИНИЛХЛОРИДНЫЙ');

INSERT INTO "parameters_vs_materials"
(
"id_material",
"id_parameter",
"value_nominal",
"value_minimum",
"value_maximum",
"value") VALUES
(3000001, 8, 1.35, NULL, NULL, NULL),
(3000001, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(3000002, 8, 1.35, NULL, NULL, NULL),
(3000002, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(3000003, 8, 1.36, NULL, NULL, NULL),
(3000003, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(3000004, 8, 2.7, NULL, NULL, NULL),
(3000004, 9, NULL, NULL, NULL, 'катанка алюминиевая'),
(3000005, 8, 2.7, NULL, NULL, NULL),
(3000005, 9, NULL, NULL, NULL, 'катанка алюминиевая'),
(3000006, 8, 2.7, NULL, NULL, NULL),
(3000006, 9, NULL, NULL, NULL, 'катанка алюминиевая'),
(3000007, 8, 8.89, NULL, NULL, NULL),
(3000007, 9, NULL, NULL, NULL, 'катанка медная'),
(3000008, 8, 8.89, NULL, NULL, NULL),
(3000008, 9, NULL, NULL, NULL, 'катанка медная'),
(3000009, 8, 8.89, NULL, NULL, NULL),
(3000009, 9, NULL, NULL, NULL, 'катанка медная'),
(3000010, 9, NULL, NULL, NULL, 'поливинилхлоридный'),
(3000010, 8, 1.5, NULL, NULL, NULL),
(3000011, 8, 1.55, NULL, NULL, NULL),
(3000012, 8, 1.55, NULL, NULL, NULL),
(3000013, 8, 1.55, NULL, NULL, NULL),
(3000014, 8, 1.55, NULL, NULL, NULL);

INSERT INTO "parameters_vs_materials_group"
(
"id_material_group",
"id_parameter",
"value_nominal",
"value_minimum",
"value_maximum",
"value"
) VALUES
(4000001, 8, 1.34, NULL, NULL, NULL),
(4000002, 8, 1.3, NULL, NULL, NULL),
(4000003, 8, 2.7, NULL, NULL, NULL),
(4000004, 8, 8.89, NULL, NULL, NULL);

INSERT INTO "raw_materials_group_vs_manufacturer's_raw_materials"
(
"id_raw_materials_group",
"id_manufacturer's_raw_materials",
"ratio"
) VALUES
(4000001, 3000001, 1.00),
(4000001, 3000002, 1.34),
(4000001, 3000003, 1.11),
(4000002, 3000010, 1.00),
(4000002, 3000011, 0.89),
(4000003, 3000004, 1.00),
(4000003, 3000005, 1.23),
(4000003, 3000006, 0.99),
(4000004, 3000007, 1.00),
(4000004, 3000008, 0.88),
(4000004, 3000009, 1.05);

INSERT INTO "half-stuff_or_finished_product"
(
"id",
"id_type_of_material_value",
"id_technological_stages",
"name",
"id_technical_normative_legal_act",
"id_conductor_metal",
"id_number_of_conductors",
"id_nominal_cross_section",
"id_type_conductor",
"id_type_material",
"id_rated_voltage"
) VALUES
(20000001, 2, 1, 'проволока АТ 2,26', 1, 2, 1, 7, 2, 1, 1),
(20000002, 2, 3, 'жила опрессованная АВ 4ок - 0,66 ЧЕР ГОСТ 16442-80', 1, 2, 2, 7, 2, 2, 3),
(20000003, 1, 5, 'Кабель АВВГ 1х4ок - 0,66 ГОСТ 16442-80', 1, 2, 2, 7, 2, 2, 3),
(20000004, 2, 1, 'проволока МТ 1,77', 1, 5, 1, 10, 1, 1, 1),
(20000005, 2, 2, 'жила скрученная медная 16мк упл.', 1, 5, 2, 10, 3, 1, 1),
(20000006, 2, 3, 'жила опрессованная В 16мк - 1 СЕР ГОСТ 16442-80', 1, 5, 2, 10, 3, 2, 4),
(20000007, 2, 3, 'жила опрессованная В 16мк - 1 КОР ГОСТ 16442-80', 1, 5, 2, 10, 3, 2, 4),
(20000008, 2, 3, 'жила опрессованная В 16мк - 1 ЧЕР ГОСТ 16442-80', 1, 5, 2, 10, 3, 2, 4),
(20000009, 2, 3, 'жила опрессованная В 16мк - 1 СИН ГОСТ 16442-80', 1, 5, 2, 10, 3, 2, 4),
(20000010, 2, 4, 'заготовка скрученная В 4х16мк (N) - 1 ГОСТ 16442-80', 1, 5, 5, 10, 3, 1, 4),
(20000011, 1, 5, 'Кабель ВВГ 4х16мк (N) - 1 ГОСТ 16442-80', 1, 5, 5, 10, 3, 2, 4);
