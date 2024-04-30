-- table Endereco
CREATE TABLE Endereco (
    id INT AUTO_INCREMENT PRIMARY KEY,
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
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    dataNascimento DATE NOT NULL,
    celular BIGINT,
    email VARCHAR(255) UNIQUE,
    genero INTEGER NOT NULL,
    endereco_id INT,
    FOREIGN KEY (endereco_id) REFERENCES Endereco(id)
);

-- table Convenio
CREATE TABLE Convenio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numeroCarteirinha INT NOT NULL,
    prestadora VARCHAR(255) NOT NULL,
    plano VARCHAR(255) NOT NULL
);

-- table HistoricoMedico
CREATE TABLE HistoricoMedico (
    id INT AUTO_INCREMENT PRIMARY KEY,
    alergias TEXT NOT NULL,
    medicamentos TEXT NOT NULL,
    prescricao TEXT NOT NULL
);

-- table Paciente
CREATE TABLE Paciente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    altura FLOAT NOT NULL,
    fumante BOOLEAN NOT NULL,
    marcaPasso BOOLEAN NOT NULL,
    convenio_id INT,
    historicoMedico_id INT,
    FOREIGN KEY (convenio_id) REFERENCES Convenio(id),
    FOREIGN KEY (historicoMedico_id) REFERENCES HistoricoMedico(id)
);

