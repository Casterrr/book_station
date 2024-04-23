create table TB_LIVRO
(
   ID_LIVRO             NUMBER               not null,
   ID_EDITORA           NUMBER,
   ID_AUTOR             NUMBER,
   ID_GENERO            NUMBER,
   TITULO               VARCHAR2(255)        not null,
   NUM_ISBN             VARCHAR2(20)         not null,
   DAT_PUBLICACAO_LIVRO DATE                 not null,
   SINOPSE              VARCHAR2(4000),
   NUM_PAGINAS          NUMBER               not null,
   IDIOMA               VARCHAR2(50)         not null,
   QTD_DISPONIVEL       NUMBER               not null,
   IND_DISPONIVEL       VARCHAR2(1),
   DTH_CADASTRO_LIVRO   DATE                 not null,
   constraint PK_TB_LIVRO primary key (ID_LIVRO),
   constraint FK_TB_LIVRO_REFERENCE_TB_EDITO foreign key (ID_EDITORA) references TB_EDITORA (ID_EDITORA) ON DELETE RESTRICT ON UPDATE CASCADE,
   constraint FK_TB_LIVRO_REFERENCE_TB_AUTOR foreign key (ID_AUTOR) references TB_AUTOR (ID_AUTOR) ON DELETE RESTRICT ON UPDATE CASCADE,
   constraint FK_TB_LIVRO_REFERENCE_TB_GENER foreign key (ID_GENERO) references TB_GENERO (ID_GENERO) ON DELETE RESTRICT ON UPDATE CASCADE
);