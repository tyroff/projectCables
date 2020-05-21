@set Path=%Path%;%cd%\bin

@rem инициализация сервера
@rem %cd%\bin\initdb --auth=password --pgdata=%cd%\data --encoding=UTF8 --locale=Russian_Russia --username=root --pwprompt

@rem запуск сервера
%cd%\bin\pg_ctl --pgdata=%cd%\data --log=%cd%\logfile start

@echo Press Enter to stop server
@pause

@rem остановка сервера
%cd%\bin\pg_ctl --pgdata=%cd%\data stop

@rem пример выполнения SQL-запроса из файла
@rem psql --username=root --password --dbname=postgres --file=%cd%\create-database.sql
@rem psql --username=root --password --dbname=my_db --file=%cd%\create-structure.sql
@rem psql --username=root --password --dbname=my_db -c "\encoding UTF8" --file=%cd%\test-fill.sql
