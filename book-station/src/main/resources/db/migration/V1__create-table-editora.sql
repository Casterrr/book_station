create table TB_EDITORA
(
   ID_EDITORA           INTEGER                               not null,
   NOME_EDITORA         VARCHAR(100)                        not null,
   ENDERECO_EDITORA     VARCHAR(255)                        not null,
   TELEFONE_EDITORA     VARCHAR(255)                        not null,
   DTH_CADASTRO_EDITORA TIMESTAMP DEFAULT CURRENT_TIMESTAMP  not null,
   constraint PK_TB_EDITORA primary key (ID_EDITORA)
);