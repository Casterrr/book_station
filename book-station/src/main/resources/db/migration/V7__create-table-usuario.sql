create table TB_USUARIO
(
   ID_USUARIO           INTEGER NOT NULL PRIMARY KEY IDENTITY,
   NOME_USUARIO         VARCHAR(100)                        not null,
   EMAIL                VARCHAR(40)                         not null,
   SENHA_USUARIO        VARCHAR(255)                        not null,
   DTH_CADASTRO_USUARIO TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null
);