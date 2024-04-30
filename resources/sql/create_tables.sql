-- table Endereco
CREATE TABLE IF NOT EXISTS Endereco (
    id INTEGER PRIMARY KEY,
    cep INT NOT NULL,
    estado VARCHAR(2) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    rua VARCHAR(100) NOT NULL,
    numero VARCHAR(10),
    complemento VARCHAR(255)
);

-- table Pessoa
CREATE TABLE IF NOT EXISTS Pessoa (
    id INTEGER PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    dataNascimento DATE NOT NULL,
    celular BIGINT,
    email VARCHAR(255) UNIQUE,
    genero INT NOT NULL,
    endereco_id INT,
    FOREIGN KEY (endereco_id) REFERENCES Endereco(id)
);

-- table Convenio
CREATE TABLE IF NOT EXISTS Convenio (
    id INTEGER PRIMARY KEY,
    numeroCarteirinha INT NOT NULL,
    prestadora VARCHAR(255) NOT NULL,
    plano VARCHAR(255) NOT NULL
);

-- table HistoricoMedico
CREATE TABLE IF NOT EXISTS HistoricoMedico (
    id INTEGER PRIMARY KEY,
    alergias TEXT,
    medicamentos TEXT,
    prescricao TEXT
);

-- table Paciente
CREATE TABLE IF NOT EXISTS Paciente (
    id INTEGER PRIMARY KEY,
    altura FLOAT NOT NULL,
    fumante BOOLEAN NOT NULL,
    marcaPasso BOOLEAN NOT NULL,
    convenio_id INT,
    historicoMedico_id INT,
    FOREIGN KEY (convenio_id) REFERENCES Convenio(id),
    FOREIGN KEY (historicoMedico_id) REFERENCES HistoricoMedico(id)
);

-- table Funcionario
CREATE TABLE IF NOT EXISTS Funcionario (
    id INTEGER PRIMARY KEY,
    pessoa_id INT,
    emailCorporativo VARCHAR(50) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    FOREIGN KEY (pessoa_id) REFERENCES Pessoa(id)
);

-- table Medico
CREATE TABLE IF NOT EXISTS Medico (
    id INTEGER PRIMARY KEY,
    funcionario_id INT,
    especialidade INT NOT NULL,
    FOREIGN KEY (funcionario_id) REFERENCES Funcionario(id)
);

-- table HorarioAtendimento
CREATE TABLE IF NOT EXISTS HorarioAtendimento (
    id INTEGER PRIMARY KEY,
    medico_id INT,
    diaDaSemana INT NOT NULL,
    horarioInicio TIME NOT NULL,
    horarioFim TIME NOT NULL,
    FOREIGN KEY (medico_id) REFERENCES Medico(id)
);


-- table Exame
CREATE TABLE IF NOT EXISTS Exame (
    id INTEGER PRIMARY KEY,
    peso FLOAT NOT NULL,
    medicoResponsavel_id INT NOT NULL,
    conclusoes TEXT,
    detalhes TEXT,
    diagnosticoClinico INT,
    FOREIGN KEY (medicoResponsavel_id) REFERENCES Medico(id)
);

-- table HorarioExame 
CREATE TABLE IF NOT EXISTS HorarioExame (
    id INTEGER PRIMARY KEY,
    dataEhorario DATETIME NOT NULL,
    paciente_id INT NOT NULL,
    medicoSolicitante_id INT NOT NULL,
    FOREIGN KEY (paciente_id) REFERENCES Paciente(id),
    FOREIGN KEY (medicoSolicitante_id) REFERENCES Medico(id)
);

-- table ControleEntrega
CREATE TABLE IF NOT EXISTS ControleEntrega (
    id INTEGER PRIMARY KEY,
    dataEHorario DATETIME NOT NULL,
    retiradoPor VARCHAR(255) NOT NULL,
    entreguePor_id INT NOT NULL,
    exame_id INT NOT NULL,
    FOREIGN KEY (entreguePor_id) REFERENCES Funcionario(id),
    FOREIGN KEY (exame_id) REFERENCES Exame(id)
);

-- table Ecocardiograma
CREATE TABLE IF NOT EXISTS Ecocardiograma (
    id INTEGER PRIMARY KEY,
    raizAorta INT NOT NULL,
    atrioEsquerdo INT NOT NULL,
    vdDiastolico INT NOT NULL,
    veSistolico INT NOT NULL,
    vePosterior INT NOT NULL,
    septoIntraventricular INT NOT NULL,
    fracaoEncurtamento INT NOT NULL,
    fracaoEjecao FLOAT NOT NULL,
    exame_id INT NOT NULL,
    FOREIGN KEY (exame_id) REFERENCES Exame(id)
);

-- table Eletrocardiograma
CREATE TABLE IF NOT EXISTS Eletrocardiograma (
    id INTEGER PRIMARY KEY,
    ritmo VARCHAR(255) NOT NULL,
    fc INT NOT NULL,
    ondaP FLOAT NOT NULL,
    complexoQRS INT NOT NULL,
    eixoEletrico INT NOT NULL,
    exame_id INT NOT NULL,
    FOREIGN KEY (exame_id) REFERENCES Exame(id)
);

-- table Holter
CREATE TABLE IF NOT EXISTS Holter (
    id INTEGER PRIMARY KEY,
    arritmia INT NOT NULL,
    isquemiaCardiaca INT NOT NULL,
    dcIntravicular INT NOT NULL,
    dcAtriovencular INT NOT NULL,
    apneiaSono BOOLEAN NOT NULL,
    exame_id INT NOT NULL,
    FOREIGN KEY (exame_id) REFERENCES Exame(id)
);

-- table Mapa
CREATE TABLE IF NOT EXISTS Mapa (
    id INTEGER PRIMARY KEY,
    mediaHoras VARCHAR(255) NOT NULL,
    paVirgula VARCHAR(255) NOT NULL,
    paSono VARCHAR(255) NOT NULL,
    exame_id INT NOT NULL,
    FOREIGN KEY (exame_id) REFERENCES Exame(id)
);

-- table TesteErgometrico
CREATE TABLE IF NOT EXISTS TesteErgometrico (
    id INTEGER PRIMARY KEY,
    ritmo INT NOT NULL,
    fc INT NOT NULL,
    detalhes TEXT,
    conclusoes TEXT,
    diagnosticoClinico INT NOT NULL,
    exame_id INT NOT NULL,
    FOREIGN KEY (exame_id) REFERENCES Exame(id),
    FOREIGN KEY (diagnosticoClinico) REFERENCES Diagnostico(id)
);

