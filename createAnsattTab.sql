DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;

CREATE TABLE avdeling(
	avdelings_id SERIAL PRIMARY KEY,
	avdelingsnavn VARCHAR(40),
	sjef_id INT UNIQUE
);

CREATE TABLE ansatt (
    ansatt_id SERIAL PRIMARY KEY,
    brukernavn VARCHAR(4) UNIQUE NOT NULL,
    fornavn VARCHAR(50),
    etternavn VARCHAR(50),
    ansDato DATE,
    stilling VARCHAR(50),
    maanedslonn DECIMAL(10, 2),
	avdelings_id INT,
	FOREIGN KEY (avdelings_id) REFERENCES avdeling(avdelings_id)
);

CREATE TABLE prosjekt (
	prosjekt_id SERIAL PRIMARY KEY,
	prosjektnavn VARCHAR(40),
	beskrivelse VARCHAR(255)
);

CREATE TABLE prosjektdeltagelse (
	prosjektdeltagelse_id SERIAL PRIMARY KEY,
	ansatt_id INT NOT NULL,
	prosjekt_id INT NOT NULL,
	rolle VARCHAR(50),
	arbeidstimer DECIMAL(10,2),
	FOREIGN KEY (ansatt_id) REFERENCES ansatt(ansatt_id) ON DELETE CASCADE,
	FOREIGN KEY (prosjekt_id) REFERENCES prosjekt(prosjekt_id) ON DELETE CASCADE
);


ALTER TABLE avdeling ADD CONSTRAINT sjef FOREIGN KEY (sjef_id) REFERENCES ansatt(ansatt_id) ON DELETE SET NULL;

INSERT INTO avdeling (
	avdelingsnavn
) VALUES (
	'Angrep'
), (
	'Midtbane'
), (
	'Forsvar'
);

INSERT INTO ansatt (
    brukernavn,
    fornavn,
    etternavn,
    ansDato,
    stilling,
    maanedslonn,
	avdelings_id
) VALUES (
    'CR7',
    'Cristiano',
    'Ronaldo',
    '2020-12-16',
    'Toppscorer',
    172.80,
	1
), (
    'LM10',
    'Lionel',
    'Messi',
    '2022-11-30',
    'Driblefant',
    190.12,
	1
), (
	'SR4',
	'Sergio',
	'Ramos',
	'2021-10-31',
	'Murvegg',
	20546.03,
	3
), (
	'VJ7',
	'Vinicius',
	'Junior',
	'2019-08-09',
	'Speedy',
	22345.04,
	1
), (
	'JP23',
	'Jens-Petter',
	'Hauge',
	'2024-02-19',
	'Filmer',
	74734.02,
	2
), (
	'EH9',
	'Erling',
	'Haaland',
	'2017-03-07',
	'Maskin',
	99999999.99,
	1
), (
	'SF19',
	'Sondre',
	'Fet',
	'2023-09-11',
	'Benkvarmer',
	450564.03,
	2
), (
	'JB5',
	'Jude',
	'Bellingham',
	'2022-01-02',
	'Kjekkas',
	39321.99,
	2
), (
	'GB11',
	'Gareth',
	'Bale',
	'2025-05-19',
	'Manbun',
	1092848.30,
	1
), (
	'MO10',
	'Mesut',
	'Ozil',
	'2023-03-01',
	'Chopper',
	88392.40,
	2
);

INSERT INTO prosjekt (
	prosjektnavn,
	beskrivelse
) VALUES (
	'Champions League',
	'Vinne hele turneringen ubeseiret'
);

INSERT INTO prosjektdeltagelse (
	rolle,
	arbeidstimer
) VALUES (
	'Motivator',
	37.5
);

UPDATE avdeling SET sjef_id = (SELECT ansatt_id FROM ansatt WHERE brukernavn = 'EH9') WHERE avdelingsnavn = 'Angrep';
UPDATE avdeling SET sjef_id = (SELECT ansatt_id FROM ansatt WHERE brukernavn = 'JP23') WHERE avdelingsnavn = 'Midtbane';
UPDATE avdeling SET sjef_id = (SELECT ansatt_id FROM ansatt WHERE brukernavn = 'SR4') WHERE avdelingsnavn = 'Forsvar';