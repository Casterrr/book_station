create table TB_GENERO
(
   ID_GENERO            NUMBER                               not null,
   NOME_GENERO          VARCHAR2(20)                         not null,
   DTH_CADASTRO_GENERO  TIMESTAMP DEFAULT CURRENT_TIMESTAMP  not null,
   constraint PK_TB_GENERO primary key (ID_GENERO)
);