CREATE TABLE "user" (
	"id" SERIAL PRIMARY KEY,
	"login" TEXT NOT NULL UNIQUE,
	"password" TEXT NOT NULL,
	"role" INT NOT NULL CHECK ("role" IN (0, 1, 2, 3, 4))
);

CREATE TABLE "cable_category" (
	"id" SERIAL PRIMARY KEY,
	"name" TEXT NOT NULL UNIQUE
);

CREATE TABLE "brands" (
	"id" SERIAL PRIMARY KEY,
	"name" TEXT NOT NULL UNIQUE
);

CREATE TABLE "technical_normative_legal_act" (
	"id" SERIAL PRIMARY KEY,
	"code" TEXT NOT NULL UNIQUE,
	"name" TEXT NOT NULL UNIQUE,
	"date_start" DATE NOT NULL,
	"date_end" DATE DEFAULT NULL
);
CREATE TABLE "technical_normative_legal_act_vs_cable_category" (
	"id_technical_normative_legal_act" SMALLINT NOT NULL REFERENCES "technical_normative_legal_act" ON DELETE RESTRICT,
	"id_cable_category" SMALLINT NOT NULL REFERENCES "cable_category" ON DELETE RESTRICT,
	PRIMARY KEY (id_technical_normative_legal_act, id_cable_category)
);
CREATE TABLE "technological_stage" (
	"id" SMALLINT PRIMARY KEY CHECK ("id" IN (1, 2, 3, 4, 5)),
	"name" TEXT NOT NULL UNIQUE
);
CREATE TABLE "parameters" (
	"id" SERIAL PRIMARY KEY,
	"name" TEXT NOT NULL UNIQUE,
	"units" TEXT,
	"print_to_task" BOOLEAN NOT NULL,
	"read_by_the_formula" BOOLEAN NOT NULL
);
CREATE TABLE "type_of_material_value" (
	"id" SERIAL PRIMARY KEY,
	"name" TEXT NOT NULL UNIQUE
);
CREATE TABLE "manufacturer's_raw_materials" (
	"id" SERIAL PRIMARY KEY,
	"id_type_of_material_value" SMALLINT NOT NULL REFERENCES "type_of_material_value" ON DELETE RESTRICT,
	"name" TEXT NOT NULL,
	"name_manufacturer" TEXT NOT NULL,
	"price" BIGINT NOT NULL CHECK ("price" > 0)
);
CREATE TABLE "raw_materials_group" (
	"id" SERIAL PRIMARY KEY,
	"id_type_of_material_value" SMALLINT NOT NULL REFERENCES "type_of_material_value" ON DELETE RESTRICT,
	"name" TEXT NOT NULL UNIQUE
);
CREATE TABLE "raw_materials_group_vs_manufacturer's_raw_materials" (
	"id_raw_materials_group" INTEGER NOT NULL REFERENCES "raw_materials_group" ON DELETE RESTRICT,
	"id_manufacturer's_raw_materials" INTEGER NOT NULL REFERENCES "manufacturer's_raw_materials" ON DELETE RESTRICT,
	"ratio" REAL NOT NULL
);
CREATE TABLE "parameters_vs_materials" (
	"id_material" INTEGER NOT NULL REFERENCES "manufacturer's_raw_materials" ON DELETE CASCADE,
	"id_parameter" INTEGER NOT NULL REFERENCES "parameters" ON DELETE CASCADE,
	"value_nominal" REAL NULL,
	"value_minimum" REAL NULL,
	"value_maximum" REAL NULL,
	"value" TEXT NULL
);
CREATE TABLE "parameters_vs_materials_group" (
	"id_material_group" INTEGER NOT NULL REFERENCES "raw_materials_group" ON DELETE CASCADE,
	"id_parameter" INTEGER NOT NULL REFERENCES "parameters" ON DELETE CASCADE,
	"value_nominal" REAL NULL,
	"value_minimum" REAL NULL,
	"value_maximum" REAL NULL,
	"value" TEXT NULL
);
CREATE TABLE "conductor_metal" (
	"id" SERIAL PRIMARY KEY,
	"id_parameter" INTEGER NOT NULL REFERENCES "parameters" ON DELETE CASCADE,
	"value" TEXT NOT NULL
);
CREATE TABLE "number_of_conductors" (
	"id" SERIAL PRIMARY KEY,
	"id_parameter" INTEGER NOT NULL REFERENCES "parameters" ON DELETE CASCADE,
	"value" SMALLINT NOT NULL
);
CREATE TABLE "nominal_cross_section" (
	"id" SERIAL PRIMARY KEY,
	"id_parameter" INTEGER NOT NULL REFERENCES "parameters" ON DELETE CASCADE,
	"value" TEXT NOT NULL
);
CREATE TABLE "type_conductor" (
	"id" SERIAL PRIMARY KEY,
	"id_parameter" INTEGER NOT NULL REFERENCES "parameters" ON DELETE CASCADE,
	"value" TEXT NOT NULL
);
CREATE TABLE "type_material" (
	"id" SERIAL PRIMARY KEY,
	"id_parameter" INTEGER NOT NULL REFERENCES "parameters" ON DELETE CASCADE,
	"value" TEXT NOT NULL
);
CREATE TABLE "rated_voltage" (
	"id" SERIAL PRIMARY KEY,
	"id_parameter" INTEGER NOT NULL REFERENCES "parameters" ON DELETE CASCADE,
	"value" TEXT NOT NULL
);
CREATE TABLE "table_of_technical_normative_legal_act" (
	"id" SERIAL PRIMARY KEY,
	"id_technical_normative_legal_act" INTEGER NOT NULL REFERENCES "technical_normative_legal_act" ON DELETE CASCADE,
	"id_technological_stage" INTEGER NOT NULL REFERENCES "technological_stage" ON DELETE CASCADE,
	"name" TEXT NOT NULL
);
CREATE TABLE "parameters_vs_table_of_technical_normative_legal_act" (
	"id" SERIAL PRIMARY KEY,
	"id_table_of_technical_normative_legal_act" INTEGER NOT NULL REFERENCES "table_of_technical_normative_legal_act" ON DELETE CASCADE,
	"id_parameter_result" INTEGER NOT NULL,
	"id_parameter_determinant_1" INTEGER NOT NULL,
	"id_parameter_determinant_2" INTEGER NULL,
	"id_parameter_determinant_3" INTEGER NULL
);
CREATE TABLE "technical_normative_legal_act_vs_parameters" (
	"line_number" INTEGER NOT NULL,
	"id_parameters_vs_table" INTEGER NOT NULL REFERENCES "parameters_vs_table_of_technical_normative_legal_act" ON DELETE RESTRICT,
	"id_parameter" INTEGER NOT NULL REFERENCES "parameters" ON DELETE RESTRICT,
	"value_nominal" REAL NULL,
	"value_minimum" REAL NULL,
	"value_maximum" REAL NULL,
	"value" TEXT NULL
);
CREATE TABLE "half-stuff_or_finished_product" (
	"id" SERIAL PRIMARY KEY,
	"id_type_of_material_value" SMALLINT NOT NULL REFERENCES "type_of_material_value" ON DELETE RESTRICT,
	"id_technological_stages" SMALLINT NOT NULL REFERENCES "technological_stage" ON DELETE RESTRICT,
	"name" TEXT NOT NULL UNIQUE,
	"id_technical_normative_legal_act" INTEGER NOT NULL REFERENCES "technical_normative_legal_act" ON DELETE RESTRICT,
	"id_conductor_metal" SMALLINT NOT NULL REFERENCES "conductor_metal" ON DELETE RESTRICT,
	"id_number_of_conductors" SMALLINT NOT NULL REFERENCES "number_of_conductors" ON DELETE RESTRICT,
	"id_nominal_cross_section" SMALLINT NOT NULL REFERENCES "nominal_cross_section" ON DELETE RESTRICT,
	"id_type_conductor" SMALLINT NOT NULL REFERENCES "type_conductor" ON DELETE RESTRICT,
	"id_type_material" SMALLINT NOT NULL REFERENCES "type_material" ON DELETE RESTRICT,
	"id_rated_voltage" SMALLINT NOT NULL REFERENCES "rated_voltage" ON DELETE RESTRICT
);
CREATE TABLE "formulas" (
	"id" SERIAL PRIMARY KEY,
	"name" TEXT NOT NULL UNIQUE,
	"id_technological_stages" SMALLINT NOT NULL REFERENCES "technological_stage" ON DELETE RESTRICT,
	"id_parameters" INTEGER NOT NULL REFERENCES "parameters" ON DELETE RESTRICT
);
CREATE TABLE "parameters_half-stuff_or_finished_product" (
	"id_half-stuff_or_finished_product" INTEGER NOT NULL REFERENCES "half-stuff_or_finished_product" ON DELETE RESTRICT,
	"id_formula" INTEGER NULL REFERENCES "formulas" ON DELETE RESTRICT,
	"id_parameter" INTEGER NOT NULL REFERENCES "parameters" ON DELETE RESTRICT
);
CREATE TABLE "raw_materials_group_half-stuff_or_finished_product" (
	"id_half-stuff_or_finished_product" INTEGER NOT NULL REFERENCES "half-stuff_or_finished_product" ON DELETE RESTRICT,
	"id_formula" INTEGER NOT NULL REFERENCES "formulas" ON DELETE RESTRICT,
	"id_raw_materials_group" INTEGER NOT NULL REFERENCES "raw_materials_group" ON DELETE RESTRICT
);