INSERT INTO Funcionario (pessoa_id, emailCorporativo, senha, tipoFuncionario)
VALUES (1, 'admin', 'password123', 1);

INSERT INTO Endereco (cep, estado, cidade, bairro, rua, numero, complemento)
VALUES (123456, 'SP', 'São Paulo', 'Vila Mariana', 'Rua Joaquim Távora', '123', 'Apt 45');

INSERT INTO Pessoa (nome, cpf, dataNascimento, celular, email, genero, endereco_id)
VALUES ('Paula Marinho', '123.456.789-09', '2000-03-25', '1140028922', 'paula.marinho@email.com', 2, 1);

INSERT INTO Funcionario (pessoa_id, emailCorporativo, senha, tipoFuncionario)
VALUES (1, 'paula.marinho@examhub.com', 'password123', 3);

INSERT INTO Medico (funcionario_id, especialidade)
VALUES (1, 1);

INSERT INTO HorarioAtendimento (medico_id, diaDaSemana, horarioInicio, horarioFim)
VALUES (3, 3, '08:00', '12:00');



INSERT INTO Endereco (cep, estado, cidade, bairro, rua, numero, complemento)
VALUES (123456, 'SP', 'São Paulo', 'Pinheiros', 'Rua dos Pinheiros', '1234', 'Apto 101');

INSERT INTO Convenio (numeroCarteirinha, prestadora, plano)
VALUES (98765, 'Unimed', 'Plano Ouro');

INSERT INTO HistoricoMedico (alergias, medicamentos, prescricao)
VALUES (NULL, 'Ibuprofeno', NULL);

INSERT INTO Pessoa (nome, cpf, dataNascimento, celular, email, genero, endereco_id)
VALUES ('Michele Nonato', '123.456.789-01', '2003-04-15', 11999887766, 'michele.nonato@example.com', 2, 2);

INSERT INTO Paciente (altura, fumante, marcaPasso, convenio_id, historicoMedico_id, pessoa_id)
VALUES (1.65, FALSE, FALSE, 1, 1, 2);
