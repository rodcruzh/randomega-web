-- postgres post randomega sec

-- Login as root $ sudo -i
-- Edit # vim /etc/yum.repos.d/fedora.repo add exclude=postgresql* on [exclude]
-- Install repository # dnf install https://download.postgresql.org/pub/repos/yum/10/fedora/fedora-27-x86_64/pgdg-fedora10-10-4.noarch.rpm
-- Install PostgreSQL # dnf install postgresql10 postgresql10-server
-- Initialize cluster # /usr/pgsql-10/bin/postgresql-10-setup initdb
-- Edit # vim /var/lib/pgsql/10/data/postgresql.conf modify listen_addresses = '*' port 5432
-- Set permission # vim /var/lib/pgsql/10/data/pg_hba.conf host all all xx.xx.xx.xx/xx md5
-- Start PostgreSQL # systemctl start postgresql-10.service systemctl enable postgresql-10.service
-- Create database # su postgres # createdb test
-- Login and create role # psql test # CREATE ROLE testuser WITH SUPERUSER LOGIN PASSWORD '<password here>';
-- Test connection $ psql -h localhost -U testuser test

CREATE TABLE sec_profile (
    id_profile bigint CONSTRAINT pk_sec_profile PRIMARY KEY,
    name varchar(100) NOT NULL,
    active bool NOT NULL
);

CREATE TABLE sec_user (
    id_user	bigint CONSTRAINT pk_sec_user PRIMARY KEY,
    name varchar(100) NOT NULL,
    username varchar(50) NOT NULL,
    password varchar(250) NOT NULL,
    active bool NOT NULL
);

CREATE TABLE sec_profile_user (
    id_profile_user	bigint CONSTRAINT pk_sec_profile_user PRIMARY KEY,
    id_profile bigint NOT NULL,
    id_user	bigint NOT NULL
);

ALTER TABLE sec_profile_user
ADD CONSTRAINT fk_sec_profi_user_01 FOREIGN KEY (id_profile) REFERENCES sec_profile (id_profile);
ALTER TABLE sec_profile_user
ADD CONSTRAINT fk_sec_profi_user_02 FOREIGN KEY (id_user) REFERENCES sec_user (id_user);

CREATE TABLE sec_operation (
    id_operation bigint CONSTRAINT pk_sec_operation PRIMARY KEY,
    name varchar(100) NOT NULL,
    active bool NOT NULL
);

CREATE TABLE sec_module (
    id_module bigint CONSTRAINT pk_sec_module PRIMARY KEY,
    name varchar(100) NOT NULL,
    id_father_module bigint,
    active bool NOT NULL
);

ALTER TABLE sec_module
ADD CONSTRAINT fk_sec_modul_01 FOREIGN KEY (id_father_module) REFERENCES sec_module (id_module);

CREATE TABLE sec_page (
    id_page	bigint CONSTRAINT pk_sec_page PRIMARY KEY,
    name varchar(100) NOT NULL,
    menu_item bool NOT NULL,
    id_father_page bigint,
    id_module bigint NOT NULL
);

ALTER TABLE sec_page
ADD CONSTRAINT fk_sec_page_01 FOREIGN KEY (id_father_page) REFERENCES sec_page (id_page);
ALTER TABLE sec_page
ADD CONSTRAINT fk_sec_page_02 FOREIGN KEY (id_module) REFERENCES sec_module (id_module);

CREATE TABLE sec_profile_module (
    id_profile_module bigint CONSTRAINT pk_sec_profile_module PRIMARY KEY,
    id_profile bigint NOT NULL,
    id_module bigint NOT NULL
);

ALTER TABLE sec_profile_module
ADD CONSTRAINT fk_sec_profi_modul_01 FOREIGN KEY (id_profile) REFERENCES sec_profile (id_profile);
ALTER TABLE sec_profile_module
ADD CONSTRAINT fk_sec_profi_modul_02 FOREIGN KEY (id_module) REFERENCES sec_module (id_module);

CREATE TABLE sec_profile_page (
    id_profile_page	bigint CONSTRAINT pk_sec_profile_page PRIMARY KEY,
    id_profile bigint NOT NULL,
    id_page	bigint NOT NULL
);

ALTER TABLE sec_profile_page
ADD CONSTRAINT fk_sec_profi_page_01 FOREIGN KEY (id_profile) REFERENCES sec_profile (id_profile);
ALTER TABLE sec_profile_page
ADD CONSTRAINT fk_sec_profi_page_02 FOREIGN KEY (id_page) REFERENCES sec_page (id_page);

CREATE TABLE sec_operation_page (
    id_operation_page bigint CONSTRAINT pk_sec_operation_page PRIMARY KEY,
    id_operation bigint	NOT NULL,
    id_page	bigint NOT NULL
);

ALTER TABLE sec_operation_page
ADD CONSTRAINT fk_sec_opera_page_01 FOREIGN KEY (id_operation) REFERENCES sec_operation (id_operation);
ALTER TABLE sec_operation_page
ADD CONSTRAINT fk_sec_opera_page_02 FOREIGN KEY (id_page) REFERENCES sec_page (id_page);

CREATE TABLE sec_profile_operation (
    id_profile_operation bigint CONSTRAINT pk_sec_profile_operation PRIMARY KEY,
    id_profile bigint NOT NULL,
    id_operation bigint	NOT NULL
);

ALTER TABLE sec_profile_operation
ADD CONSTRAINT fk_sec_profi_opera_01 FOREIGN KEY (id_profile) REFERENCES sec_profile (id_profile);
ALTER TABLE sec_profile_operation
ADD CONSTRAINT fk_sec_profi_opera_02 FOREIGN KEY (id_operation) REFERENCES sec_operation (id_operation);