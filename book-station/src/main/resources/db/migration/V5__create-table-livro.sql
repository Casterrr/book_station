CREATE TABLE TB_LIVRO
(
   ID_LIVRO             INTEGER              NOT NULL,
   ID_ITEM              INTEGER,
   NUM_ISBN             VARCHAR(20)          NOT NULL,
   SINOPSE              VARCHAR(4000),
   IDIOMA               VARCHAR(50)          NOT NULL,
   CONSTRAINT PK_TB_LIVRO PRIMARY KEY (ID_LIVRO)
);
