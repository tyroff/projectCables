CREATE SEQUENCE "category_id_sequence" START 100;

CREATE TABLE "category" (
	"id" INTEGER PRIMARY KEY DEFAULT nextval('category_id_sequence'),
	"name" TEXT NOT NULL,
	"parent_id" INTEGER REFERENCES "category" ON DELETE CASCADE
);

CREATE SEQUENCE "note_id_sequence" START 100;

CREATE TABLE "note" (
	"id" INTEGER PRIMARY KEY DEFAULT nextval('note_id_sequence'),
	"title" TEXT NOT NULL,
	"text" TEXT,
	"category_id" INTEGER NOT NULL REFERENCES "category" ON DELETE RESTRICT
);

CREATE TABLE "task" (
	"date" TIMESTAMP NOT NULL,
	PRIMARY KEY("id"),
	FOREIGN KEY ("category_id") REFERENCES "category"
) INHERITS ("note");

CREATE SEQUENCE "user_id_sequence" START 100;

CREATE TABLE "user" (
	"id" INTEGER PRIMARY KEY DEFAULT nextval('user_id_sequence'),
	"login" TEXT NOT NULL,
	"password" TEXT NOT NULL,
	"role" SMALLINT CHECK ("role" IN (0, 1))
);

CREATE TABLE "admin" (
	"id" INTEGER PRIMARY KEY,
	"hardware_key" TEXT NOT NULL,
	FOREIGN KEY ("id") REFERENCES "user" ON DELETE CASCADE
);

CREATE TABLE "client" (
	"id" INTEGER PRIMARY KEY,
	"email" TEXT NOT NULL,
	"phone" TEXT NOT NULL,
	FOREIGN KEY ("id") REFERENCES "user" ON DELETE CASCADE
);