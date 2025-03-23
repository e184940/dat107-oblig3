DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;

CREATE TABLE ansatt (
    ansatt_id SERIAL PRIMARY KEY,
    brukernavn VARCHAR(4) UNIQUE NOT NULL,
    fornavn VARCHAR(50),
    etternavn VARCHAR(50),
    ansDato DATE,
    stilling VARCHAR(50),
    månedslønn DECIMAL(10, 2)
);