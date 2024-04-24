create table TB_AUTOR
(
   ID_AUTOR             INTEGER NOT NULL PRIMARY KEY IDENTITY,
   NOME_AUTOR           VARCHAR(255)                          not null,
   DAT_NASCIMENTO       DATE                                  not null,
   BIOGRAFIA            VARCHAR(255),
   DTH_CADASTRO_AUTOR   TIMESTAMP DEFAULT CURRENT_TIMESTAMP   not null,
);