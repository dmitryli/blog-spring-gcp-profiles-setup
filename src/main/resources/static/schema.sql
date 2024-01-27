CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table "siusoon".app_users (
    id uuid DEFAULT uuid_generate_v4 (),
	first_name varchar(40),
	middle_name varchar(40),
	last_name varchar(40),
	email varchar(60) NOT NULL UNIQUE
)
