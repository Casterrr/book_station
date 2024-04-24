create table TB_USUARIO
(
   ID_USUARIO           INTEGER NOT NULL PRIMARY KEY IDENTITY,
   NOME_USUARIO         VARCHAR(100)                        not null,
   ENDERECO_USUARIO     VARCHAR(255)                        not null,
   CPF                  VARCHAR(11)                         not null,
   EMAIL                VARCHAR(40)                         not null,
   TELEFONE_USUARIO     VARCHAR(20)                         not null,
   DTH_CADASTRO_USUARIO TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null
);