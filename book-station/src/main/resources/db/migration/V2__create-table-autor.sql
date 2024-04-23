create table TB_AUTOR
(
   ID_AUTOR             INTEGER                                not null,
   NOME_AUTOR           VARCHAR(255)                         not null,
   DAT_NASCIMENTO       DATE                                  not null,
   BIOGRAFIA            VARCHAR(255),
   DTH_CADASTRO_AUTOR   TIMESTAMP DEFAULT CURRENT_TIMESTAMP   not null,
   constraint PK_TB_AUTOR primary key (ID_AUTOR)
);