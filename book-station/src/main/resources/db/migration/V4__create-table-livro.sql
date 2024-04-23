create table TB_LIVRO
(
   ID_LIVRO             INTEGER               not null,
   ID_EDITORA           INTEGER,
   ID_AUTOR             INTEGER,
   ID_GENERO            INTEGER,
   TITULO               VARCHAR(255)        not null,
   NUM_ISBN             VARCHAR(20)         not null,
   DAT_PUBLICACAO_LIVRO DATE                 not null,
   SINOPSE              VARCHAR(4000),
   NUM_PAGINAS          INTEGER               not null,
   IDIOMA               VARCHAR(50)         not null,
   QTD_DISPONIVEL       INTEGER               not null,
   IND_DISPONIVEL       VARCHAR(1),
   DTH_CADASTRO_LIVRO   DATE                 not null,
   constraint PK_TB_LIVRO primary key (ID_LIVRO),
   constraint FK_TB_LIVRO_REFERENCE_TB_EDITO foreign key (ID_EDITORA) references TB_EDITORA (ID_EDITORA) ON DELETE RESTRICT ON UPDATE CASCADE,
   constraint FK_TB_LIVRO_REFERENCE_TB_AUTOR foreign key (ID_AUTOR) references TB_AUTOR (ID_AUTOR) ON DELETE RESTRICT ON UPDATE CASCADE,
   constraint FK_TB_LIVRO_REFERENCE_TB_GENER foreign key (ID_GENERO) references TB_GENERO (ID_GENERO) ON DELETE RESTRICT ON UPDATE CASCADE
);