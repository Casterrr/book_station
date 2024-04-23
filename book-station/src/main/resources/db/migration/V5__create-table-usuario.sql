create table TB_USUARIO
(
   ID_USUARIO           NUMBER                               not null,
   NOME_USUARIO         VARHCAR2(100)                        not null,
   ENDERECO_USUARIO     VARCHAR2(255)                        not null,
   CPF                  VARCHAR2(11)                         not null,
   EMAIL                VARCHAR2(40)                         not null,
   TELEFONE_USUARIO     VARCHAR2(20)                         not null,
   DTH_CADASTRO_USUARIO TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null,
   constraint PK_TB_USUARIO primary key (ID_USUARIO)
);