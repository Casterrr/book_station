CREATE TABLE TB_FUNCIONARIO
(
   ID_FUNCIONARIO       INTEGER NOT NULL PRIMARY KEY IDENTITY,
   ID_USUARIO           INTEGER,
   DSC_CARGO            VARCHAR(50)                                     NOT NULL,
   VLR_SALARIO          DECIMAL(10,2)                                   NOT NULL,
   NUM_CTPS             VARCHAR(11)                                     NOT NULL,
   DAT_ADMISSAO         TIMESTAMP  DEFAULT CURRENT_TIMESTAMP            NOT NULL,
   CONSTRAINT FK_TB_FUNCIONARIO_TB_USUARIO FOREIGN KEY (ID_USUARIO) REFERENCES TB_USUARIO (ID_USUARIO) ON DELETE RESTRICT ON UPDATE CASCADE
);
