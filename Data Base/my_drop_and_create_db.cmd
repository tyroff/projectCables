@set Path=%Path%;%cd%\bin
psql --username=root --password --dbname=cables --file=%cd%\my_drop_and_create_db.sql
@rem psql --username=root --password --dbname=my_db --file=%cd%\create-structure.sql
@rem psql --username=root --password --dbname=my_db -c "\encoding UTF8" --file=%cd%\test-fill.sql
