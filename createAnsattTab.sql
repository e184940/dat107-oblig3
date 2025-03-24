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
    maanedslonn DECIMAL(10, 2)
);

CREATE TABLE avdeling(
	avdelings_id SERIAL PRIMARY KEY,
	avdelingsnavn VARCHAR(40),
	sjef_id SERIAL,
	FOREIGN KEY (sjef_id) REFERENCES ansatt(ansatt_id)
);

INSERT INTO ansatt (
    brukernavn,
    fornavn,
    etternavn,
    ansDato,
    stilling,
    maanedslonn
) VALUES (
    'CR7',
    'Cristiano',
    'Ronaldo',
    '2020-12-16',
    'Toppscorer',
    172.80 
), (
    'LM10',
    'Lionel',
    'Messi',
    '2022-11-30',
    'Driblefant',
    190.12 
), (
	'SR4',
	'Sergio',
	'Ramos',
	'2021-10-31',
	'Murvegg',
	20546.03
), (
	'VJ7',
	'Vinicius',
	'Junior',
	'2019-08-09',
	'Speedy',
	22345.04
), (
	'JP23',
	'Jens-Petter',
	'Hauge',
	'2024-02-19',
	'Filmer',
	74734.02
), (
	'EH9',
	'Erling',
	'Haaland',
	'2017-03-07',
	'Sjef',
	99999999.99
), (
	'SF19',
	'Sondre',
	'Fet',
	'2023-09-11',
	'Benkvarmer',
	450564.03
), (
	'JB5',
	'Jude',
	'Bellingham',
	'2022-01-02',
	'Kjekkas',
	39321.99
), (
	'GB11',
	'Gareth',
	'Bale',
	'2025-05-19',
	'Manbun',
	1092848.30
), (
	'MO10',
	'Mesut',
	'Ozil',
	'2023-03-01',
	'Chopper',
	88392.40
);

INSERT INTO avdeling (
	avdelingsnavn
) VALUES (
	'Angrep'
), (
	'Midtbane'
), (
	'Forsvar'
);