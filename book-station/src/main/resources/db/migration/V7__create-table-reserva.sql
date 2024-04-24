CREATE TABLE TB_RESERVA
(
   ID_RESERVA           INTEGER NOT NULL PRIMARY KEY IDENTITY,
   ID_USUARIO           INTEGER,
   ID_LIVRO             INTEGER,
   IND_ATENDIDA         VARCHAR(1)                                     NOT NULL,
   DTH_RESERVA          TIMESTAMP DEFAULT CURRENT_TIMESTAMP            NOT NULL,
   CONSTRAINT FK_TB_RESERVA_TB_USUARIO FOREIGN KEY (ID_USUARIO) REFERENCES TB_USUARIO (ID_USUARIO) ON DELETE RESTRICT ON UPDATE CASCADE,
   CONSTRAINT FK_TB_RESERVA_TB_LIVRO FOREIGN KEY (ID_LIVRO) REFERENCES TB_LIVRO (ID_LIVRO) ON DELETE RESTRICT ON UPDATE CASCADE
);
