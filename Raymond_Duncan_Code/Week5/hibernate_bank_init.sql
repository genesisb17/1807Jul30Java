CREATE USER hibernate_bank_db
IDENTIFIED BY hbank;

GRANT CONNECT TO hibernate_bank_db;
GRANT RESOURCE TO hibernate_bank_db;

CONN hibernate_bank_db/hbank;

COMMIT;
EXIT;