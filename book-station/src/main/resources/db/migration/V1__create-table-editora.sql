create table TB_EDITORA
(
   ID_EDITORA           NUMBER                               not null,
   NOME_EDITORA         VARCHAR2(100)                        not null,
   ENDERECO_EDITORA     VARCHAR2(255)                        not null,
   TELEFONE_EDITORA     VARCHAR2(255)                        not null,
   DTH_CADASTRO_EDITORA TIMESTAMP DEFAULT CURRENT_TIMESTAMP  not null,
   constraint PK_TB_EDITORA primary key (ID_EDITORA)
);