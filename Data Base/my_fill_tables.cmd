@set Path=%Path%;%cd%\bin
psql --username=root --password --dbname=cables --file=%cd%\my_fill_tables.sql