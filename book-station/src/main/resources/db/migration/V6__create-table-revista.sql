CREATE TABLE TB_REVISTA
(
   ID_REVISTA           INTEGER              NOT NULL,
   ID_ITEM              INTEGER,
   ISSN                 VARCHAR(20)          NOT NULL,
   FREQUENCIA_PUBLICACAO VARCHAR(50)         NOT NULL,
   NUM_EDICAO           INTEGER              NOT NULL,
   VOLUME               INTEGER              NOT NULL,
   DESCRICAO            VARCHAR(200),
   CONSTRAINT PK_TB_REVISTA PRIMARY KEY (ID_REVISTA)
);
