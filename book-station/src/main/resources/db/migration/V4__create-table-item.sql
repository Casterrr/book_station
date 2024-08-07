CREATE TABLE TB_ITEM
(
   ID_ITEM              VARCHAR(255)              NOT NULL PRIMARY KEY,
   ID_EDITORA           INTEGER,
   ID_AUTOR             INTEGER,
   ID_GENERO            INTEGER,
   TITULO               VARCHAR(255)         NOT NULL,
   ANO_PUBLICACAO       INTEGER,
   IND_TIPO             VARCHAR(1)           DEFAULT 'L' NOT NULL,
   QTD_DISPONIVEL       INTEGER              NOT NULL,
   NUM_PAGINAS          INTEGER              NOT NULL,
   IND_DISPONIVEL       VARCHAR(1)           DEFAULT 'S',
   DTH_CADASTRO         TIMESTAMP            DEFAULT CURRENT_TIMESTAMP
);
