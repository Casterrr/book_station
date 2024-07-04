CREATE TABLE TB_LIVRO
(
   ID_LIVRO             INTEGER NOT NULL PRIMARY KEY IDENTITY,
   ID_ITEM              INTEGER NOT NULL,
   NUM_ISBN             VARCHAR(20)                    NOT NULL,
   DAT_PUBLICACAO_LIVRO DATE                           NOT NULL,
   SINOPSE              VARCHAR(4000),
   NUM_PAGINAS          INTEGER                        NOT NULL,
   IDIOMA               VARCHAR(50)                    NOT NULL,
   DTH_CADASTRO_LIVRO   DATE                           NOT NULL,
   CONSTRAINT FK_TB_LIVRO_TB_ITEM FOREIGN KEY (ID_ITEM) REFERENCES TB_ITEM (ID_ITEM)
);