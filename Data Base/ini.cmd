@echo off
set Path=%Path%;D:\Tyroff\DataBase\pgsql\bin
psql --username=root --password --dbname=postgres --command="\encoding UTF8" --file=my_drop_and_create_db.cmd
@rem psql --username=root --password --dbname=my_db --command="\encoding UTF8" --file=create_tables.sql
@rem psql --username=root --password --dbname=my_db -c "\encoding UTF8" --file=test-fill.sql
pause