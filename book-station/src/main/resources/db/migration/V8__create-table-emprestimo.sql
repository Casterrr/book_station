CREATE TABLE TB_EMPRESTIMO
(
   ID_EMPRESTIMO           INTEGER NOT NULL PRIMARY KEY IDENTITY,
   ID_LIVRO                INTEGER,
   ID_USUARIO              INTEGER,
   DTH_EMPRESTIMO          TIMESTAMP DEFAULT CURRENT_TIMESTAMP            NOT NULL,
   DTH_DEVOLUCAO_PREVISTA  DATE                                           NOT NULL,
   CONSTRAINT FK_TB_EMPRESTIMO_TB_LIVRO FOREIGN KEY (ID_LIVRO) REFERENCES TB_LIVRO (ID_LIVRO) ON DELETE RESTRICT ON UPDATE CASCADE,
   CONSTRAINT FK_TB_EMPRESTIMO_TB_USUARIO FOREIGN KEY (ID_USUARIO) REFERENCES TB_USUARIO (ID_USUARIO) ON DELETE RESTRICT ON UPDATE CASCADE
);
