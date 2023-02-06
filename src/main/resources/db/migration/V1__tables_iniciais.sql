CREATE TABLE DispositivoDeAcesso
(
    id       char(36)     NOT NULL,
    nome     VARCHAR(255) NULL,
    tipo     VARCHAR(255) NULL,
    metadata BLOB         NULL,
    CONSTRAINT pk_dispositivodeacesso PRIMARY KEY (id)
);

CREATE TABLE Efetivo
(
    id        char(36) NOT NULL,
    pessoa_id char(36) NULL,
    CONSTRAINT pk_efetivo PRIMARY KEY (id)
);

CREATE TABLE Pessoa
(
    id         char(36)     NOT NULL,
    nome       VARCHAR(255) NULL,
    cpf        VARCHAR(255) NULL,
    contato_id char(36)     NULL,
    sexo       VARCHAR(255) NULL,
    militar_id char(36)     NULL,
    CONSTRAINT pk_pessoa PRIMARY KEY (id)
);

CREATE TABLE Pessoa_dependentes
(
    Pessoa_id      char(36) NOT NULL,
    dependentes_id char(36) NOT NULL
);

CREATE TABLE Pessoa_setor
(
    Pessoa_id char(36) NOT NULL,
    setor_id  char(36) NOT NULL
);

CREATE TABLE Responsavel
(
    id        char(36) NOT NULL,
    pessoa_id char(36) NULL,
    CONSTRAINT pk_responsavel PRIMARY KEY (id)
);

CREATE TABLE Visita
(
    id                   char(36) NOT NULL,
    visitado_id          char(36) NULL,
    visitante_id         char(36) NULL,
    autorizador_id       char(36) NULL,
    cadastrador_id       char(36) NULL,
    entrada              datetime NULL,
    dataDeCriacao        datetime NULL,
    saida                datetime NULL,
    horarioLimiteDeSaida datetime NULL,
    tipoDeIdentificacao  INT      NULL,
    CONSTRAINT pk_visita PRIMARY KEY (id)
);

CREATE TABLE Visita_eventos
(
    Visita_id  char(36) NOT NULL,
    eventos_id char(36) NOT NULL
);

CREATE TABLE Visita_locaisLiberados
(
    Visita_id          char(36) NOT NULL,
    locaisLiberados_id char(36) NOT NULL
);

CREATE TABLE colaboradores
(
    id         char(36) NOT NULL,
    pessoa_id  char(36) NULL,
    empresa_id char(36) NULL,
    CONSTRAINT pk_colaboradores PRIMARY KEY (id)
);

CREATE TABLE contatos
(
    id             char(36)     NOT NULL,
    tipo           VARCHAR(255) NULL,
    valorDoContato VARCHAR(255) NULL,
    CONSTRAINT pk_contatos PRIMARY KEY (id)
);

CREATE TABLE dependentes
(
    id             char(36) NOT NULL,
    pessoa_id      char(36) NULL,
    responsavel_id char(36) NULL,
    CONSTRAINT pk_dependentes PRIMARY KEY (id)
);

CREATE TABLE empresas
(
    id         char(36)     NOT NULL,
    nome       VARCHAR(255) NULL,
    cnpj       VARCHAR(255) NULL,
    contato_id char(36)     NULL,
    CONSTRAINT pk_empresas PRIMARY KEY (id)
);

CREATE TABLE empresas_endereco
(
    Empresa_id  char(36) NOT NULL,
    endereco_id char(36) NOT NULL
);

CREATE TABLE enderecos
(
    id          char(36)     NOT NULL,
    cep         VARCHAR(255) NULL,
    logradouro  VARCHAR(255) NULL,
    complemento VARCHAR(255) NULL,
    numero      VARCHAR(255) NULL,
    estado      VARCHAR(255) NULL,
    cidade      VARCHAR(255) NULL,
    CONSTRAINT pk_enderecos PRIMARY KEY (id)
);

CREATE TABLE eventos
(
    id                  char(36)     NOT NULL,
    pessoa_id           char(36)     NULL,
    visita_id           char(36)     NULL,
    entrada             datetime     NULL,
    saida               datetime     NULL,
    tipoDeIdentificacao VARCHAR(255) NULL,
    CONSTRAINT pk_eventos PRIMARY KEY (id)
);

CREATE TABLE gerentes
(
    id        char(36) NOT NULL,
    pessoa_id char(36) NULL,
    CONSTRAINT pk_gerentes PRIMARY KEY (id)
);

CREATE TABLE gerentes_permissoesGerentesLocaaisAcessos
(
    Gerente_id                          char(36) NOT NULL,
    permissoesGerentesLocaaisAcessos_id char(36) NOT NULL
);

CREATE TABLE locais_de_acesso
(
    id   char(36)     NOT NULL,
    nome VARCHAR(255) NULL,
    CONSTRAINT pk_locais_de_acesso PRIMARY KEY (id)
);

CREATE TABLE locais_de_acesso_dispositivosDeAcesso
(
    PontoDeAcesso_id        char(36) NOT NULL,
    dispositivosDeAcesso_id char(36) NOT NULL
);

CREATE TABLE locais_de_acesso_permissoesGerentesLocaaisAcessos
(
    PontoDeAcesso_id                    char(36) NOT NULL,
    permissoesGerentesLocaaisAcessos_id char(36) NOT NULL
);

CREATE TABLE locais_de_acesso_secao
(
    PontoDeAcesso_id char(36) NOT NULL,
    secao_id         char(36) NOT NULL
);

CREATE TABLE militares
(
    id           char(36)     NOT NULL,
    saram        VARCHAR(255) NULL,
    pessoa_id    char(36)     NULL,
    nomeDeGuerra VARCHAR(255) NULL,
    om_id        char(36)     NULL,
    posto        VARCHAR(255) NULL,
    CONSTRAINT pk_militares PRIMARY KEY (id)
);

CREATE TABLE organizacoes_militares
(
    id    char(36)     NOT NULL,
    nome  VARCHAR(255) NULL,
    sigla VARCHAR(255) NULL,
    CONSTRAINT pk_organizacoes_militares PRIMARY KEY (id)
);

CREATE TABLE permissoes_gerente_local
(
    id         char(36) NOT NULL,
    gerente_id char(36) NULL,
    permissoes INT      NULL,
    CONSTRAINT pk_permissoes_gerente_local PRIMARY KEY (id)
);

CREATE TABLE permissoes_gerente_local_localDeAcesso
(
    PermissaoGerenteLocalAcesso_id char(36) NOT NULL,
    localDeAcesso_id               char(36) NOT NULL
);

CREATE TABLE secao
(
    id    char(36)     NOT NULL,
    nome  VARCHAR(255) NULL,
    sigla VARCHAR(255) NULL,
    CONSTRAINT pk_secao PRIMARY KEY (id)
);

CREATE TABLE secao_efetivo
(
    efetivo_id char(36) NOT NULL,
    secao_id   char(36) NOT NULL
);

CREATE TABLE secao_responsaveis
(
    responsaveis_id char(36) NOT NULL,
    secao_id        char(36) NOT NULL
);

ALTER TABLE empresas_endereco
    ADD CONSTRAINT uc_empresas_endereco_endereco UNIQUE (endereco_id);

ALTER TABLE gerentes_permissoesGerentesLocaaisAcessos
    ADD CONSTRAINT uc_gerentespermissoesgerentesloc_permissoesgerenteslocaaisaces UNIQUE (permissoesGerentesLocaaisAcessos_id);

ALTER TABLE locais_de_acesso_dispositivosDeAcesso
    ADD CONSTRAINT uc_locais_de_acesso_dispositivosdeacesso_dispositivosdeacesso UNIQUE (dispositivosDeAcesso_id);

ALTER TABLE locais_de_acesso_secao
    ADD CONSTRAINT uc_locais_de_acesso_secao_secao UNIQUE (secao_id);

ALTER TABLE locais_de_acesso_permissoesGerentesLocaaisAcessos
    ADD CONSTRAINT uc_locaisdeacessopermissoesgeren_permissoesgerenteslocaaisaces UNIQUE (permissoesGerentesLocaaisAcessos_id);

ALTER TABLE Pessoa_setor
    ADD CONSTRAINT uc_pessoa_setor_setor UNIQUE (setor_id);

ALTER TABLE secao_efetivo
    ADD CONSTRAINT uc_secao_efetivo_efetivo UNIQUE (efetivo_id);

ALTER TABLE Visita_eventos
    ADD CONSTRAINT uc_visita_eventos_eventos UNIQUE (eventos_id);

ALTER TABLE Visita_locaisLiberados
    ADD CONSTRAINT uc_visita_locaisliberados_locaisliberados UNIQUE (locaisLiberados_id);

ALTER TABLE colaboradores
    ADD CONSTRAINT FK_COLABORADORES_ON_EMPRESA FOREIGN KEY (empresa_id) REFERENCES empresas (id);

ALTER TABLE colaboradores
    ADD CONSTRAINT FK_COLABORADORES_ON_PESSOA FOREIGN KEY (pessoa_id) REFERENCES Pessoa (id);

ALTER TABLE dependentes
    ADD CONSTRAINT FK_DEPENDENTES_ON_PESSOA FOREIGN KEY (pessoa_id) REFERENCES Pessoa (id);

ALTER TABLE dependentes
    ADD CONSTRAINT FK_DEPENDENTES_ON_RESPONSAVEL FOREIGN KEY (responsavel_id) REFERENCES Responsavel (id);

ALTER TABLE Efetivo
    ADD CONSTRAINT FK_EFETIVO_ON_PESSOA FOREIGN KEY (pessoa_id) REFERENCES Pessoa (id);

ALTER TABLE empresas
    ADD CONSTRAINT FK_EMPRESAS_ON_CONTATO FOREIGN KEY (contato_id) REFERENCES contatos (id);

ALTER TABLE eventos
    ADD CONSTRAINT FK_EVENTOS_ON_PESSOA FOREIGN KEY (pessoa_id) REFERENCES Pessoa (id);

ALTER TABLE eventos
    ADD CONSTRAINT FK_EVENTOS_ON_VISITA FOREIGN KEY (visita_id) REFERENCES Visita (id);

ALTER TABLE gerentes
    ADD CONSTRAINT FK_GERENTES_ON_PESSOA FOREIGN KEY (pessoa_id) REFERENCES Pessoa (id);

ALTER TABLE militares
    ADD CONSTRAINT FK_MILITARES_ON_OM FOREIGN KEY (om_id) REFERENCES organizacoes_militares (id);

ALTER TABLE militares
    ADD CONSTRAINT FK_MILITARES_ON_PESSOA FOREIGN KEY (pessoa_id) REFERENCES Pessoa (id);

ALTER TABLE permissoes_gerente_local
    ADD CONSTRAINT FK_PERMISSOES_GERENTE_LOCAL_ON_GERENTE FOREIGN KEY (gerente_id) REFERENCES gerentes (id);

ALTER TABLE Pessoa
    ADD CONSTRAINT FK_PESSOA_ON_CONTATO FOREIGN KEY (contato_id) REFERENCES contatos (id);

ALTER TABLE Pessoa
    ADD CONSTRAINT FK_PESSOA_ON_MILITAR FOREIGN KEY (militar_id) REFERENCES militares (id);

ALTER TABLE Responsavel
    ADD CONSTRAINT FK_RESPONSAVEL_ON_PESSOA FOREIGN KEY (pessoa_id) REFERENCES Pessoa (id);

ALTER TABLE Visita
    ADD CONSTRAINT FK_VISITA_ON_AUTORIZADOR FOREIGN KEY (autorizador_id) REFERENCES Pessoa (id);

ALTER TABLE Visita
    ADD CONSTRAINT FK_VISITA_ON_CADASTRADOR FOREIGN KEY (cadastrador_id) REFERENCES Pessoa (id);

ALTER TABLE Visita
    ADD CONSTRAINT FK_VISITA_ON_VISITADO FOREIGN KEY (visitado_id) REFERENCES Pessoa (id);

ALTER TABLE Visita
    ADD CONSTRAINT FK_VISITA_ON_VISITANTE FOREIGN KEY (visitante_id) REFERENCES Pessoa (id);

ALTER TABLE empresas_endereco
    ADD CONSTRAINT fk_empend_on_empresa FOREIGN KEY (Empresa_id) REFERENCES empresas (id);

ALTER TABLE empresas_endereco
    ADD CONSTRAINT fk_empend_on_endereco FOREIGN KEY (endereco_id) REFERENCES enderecos (id);

ALTER TABLE gerentes_permissoesGerentesLocaaisAcessos
    ADD CONSTRAINT fk_gerper_on_gerente FOREIGN KEY (Gerente_id) REFERENCES gerentes (id);

ALTER TABLE gerentes_permissoesGerentesLocaaisAcessos
    ADD CONSTRAINT fk_gerper_on_permissao_gerente_local_acesso FOREIGN KEY (permissoesGerentesLocaaisAcessos_id) REFERENCES permissoes_gerente_local (id);

ALTER TABLE locais_de_acesso_dispositivosDeAcesso
    ADD CONSTRAINT fk_locdeacedis_on_dispositivo_de_acesso FOREIGN KEY (dispositivosDeAcesso_id) REFERENCES DispositivoDeAcesso (id);

ALTER TABLE locais_de_acesso_dispositivosDeAcesso
    ADD CONSTRAINT fk_locdeacedis_on_ponto_de_acesso FOREIGN KEY (PontoDeAcesso_id) REFERENCES locais_de_acesso (id);

ALTER TABLE locais_de_acesso_permissoesGerentesLocaaisAcessos
    ADD CONSTRAINT fk_locdeaceper_on_permissao_gerente_local_acesso FOREIGN KEY (permissoesGerentesLocaaisAcessos_id) REFERENCES permissoes_gerente_local (id);

ALTER TABLE locais_de_acesso_permissoesGerentesLocaaisAcessos
    ADD CONSTRAINT fk_locdeaceper_on_ponto_de_acesso FOREIGN KEY (PontoDeAcesso_id) REFERENCES locais_de_acesso (id);

ALTER TABLE locais_de_acesso_secao
    ADD CONSTRAINT fk_locdeacesec_on_ponto_de_acesso FOREIGN KEY (PontoDeAcesso_id) REFERENCES locais_de_acesso (id);

ALTER TABLE locais_de_acesso_secao
    ADD CONSTRAINT fk_locdeacesec_on_secao FOREIGN KEY (secao_id) REFERENCES secao (id);

ALTER TABLE permissoes_gerente_local_localDeAcesso
    ADD CONSTRAINT fk_pergerlocloc_on_permissao_gerente_local_acesso FOREIGN KEY (PermissaoGerenteLocalAcesso_id) REFERENCES permissoes_gerente_local (id);

ALTER TABLE permissoes_gerente_local_localDeAcesso
    ADD CONSTRAINT fk_pergerlocloc_on_ponto_de_acesso FOREIGN KEY (localDeAcesso_id) REFERENCES locais_de_acesso (id);

ALTER TABLE Pessoa_dependentes
    ADD CONSTRAINT fk_pesdep_on_dependente FOREIGN KEY (dependentes_id) REFERENCES dependentes (id);

ALTER TABLE Pessoa_dependentes
    ADD CONSTRAINT fk_pesdep_on_pessoa FOREIGN KEY (Pessoa_id) REFERENCES Pessoa (id);

ALTER TABLE Pessoa_setor
    ADD CONSTRAINT fk_pesset_on_pessoa FOREIGN KEY (Pessoa_id) REFERENCES Pessoa (id);

ALTER TABLE Pessoa_setor
    ADD CONSTRAINT fk_pesset_on_secao FOREIGN KEY (setor_id) REFERENCES secao (id);

ALTER TABLE secao_efetivo
    ADD CONSTRAINT fk_secefe_on_efetivo FOREIGN KEY (efetivo_id) REFERENCES Efetivo (id);

ALTER TABLE secao_efetivo
    ADD CONSTRAINT fk_secefe_on_secao FOREIGN KEY (secao_id) REFERENCES secao (id);

ALTER TABLE secao_responsaveis
    ADD CONSTRAINT fk_secres_on_responsavel FOREIGN KEY (responsaveis_id) REFERENCES Responsavel (id);

ALTER TABLE secao_responsaveis
    ADD CONSTRAINT fk_secres_on_secao FOREIGN KEY (secao_id) REFERENCES secao (id);

ALTER TABLE Visita_eventos
    ADD CONSTRAINT fk_viseve_on_evento FOREIGN KEY (eventos_id) REFERENCES eventos (id);

ALTER TABLE Visita_eventos
    ADD CONSTRAINT fk_viseve_on_visita FOREIGN KEY (Visita_id) REFERENCES Visita (id);

ALTER TABLE Visita_locaisLiberados
    ADD CONSTRAINT fk_visloc_on_secao FOREIGN KEY (locaisLiberados_id) REFERENCES secao (id);

ALTER TABLE Visita_locaisLiberados
    ADD CONSTRAINT fk_visloc_on_visita FOREIGN KEY (Visita_id) REFERENCES Visita (id);