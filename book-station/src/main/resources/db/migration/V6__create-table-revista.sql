CREATE TABLE TB_REVISTA
(
   ID_REVISTA           VARCHAR(255)             NOT NULL,
   ID_ITEM              VARCHAR(255),
   ISSN                 VARCHAR(20)          NOT NULL,
   FREQUENCIA_PUBLICACAO VARCHAR(50)         NOT NULL,
   NUM_EDICAO           INTEGER              NOT NULL,
   VOLUME               INTEGER              NOT NULL,
   DESCRICAO            VARCHAR(200),
   CONSTRAINT PK_TB_REVISTA PRIMARY KEY (ID_REVISTA),
   CONSTRAINT FK_TAB_REVISTA_ITEM FOREIGN KEY (ID_ITEM) REFERENCES TB_ITEM (ID_ITEM) ON DELETE CASCADE ON UPDATE CASCADE
);
