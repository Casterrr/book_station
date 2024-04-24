create table TB_GENERO
(
   ID_GENERO            INTEGER NOT NULL PRIMARY KEY IDENTITY,
   NOME_GENERO          VARCHAR(20)                          not null,
   DTH_CADASTRO_GENERO  TIMESTAMP DEFAULT CURRENT_TIMESTAMP  not null,
);