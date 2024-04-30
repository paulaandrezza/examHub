INSERT INTO Endereco (cep, estado, cidade, bairro, rua, numero, complemento)
VALUES (123456, 'SP', 'São Paulo', 'Vila Mariana', 'Rua Joaquim Távora', '123', 'Apt 45');

INSERT INTO Pessoa (nome, cpf, dataNascimento, celular, email, genero, endereco_id)
VALUES ('Paula Marinho', '123.456.789-09', '2000-03-25', '1140028922', 'paula.marinho@email.com', 2, 1);

INSERT INTO Funcionario (pessoa_id, emailCorporativo, senha)
VALUES (1, 'paula.marinho@examhub.com', 'password123');

INSERT INTO Medico (funcionario_id, especialidade)
VALUES (1, 1);

INSERT INTO HorarioAtendimento (medico_id, diaDaSemana, horarioInicio, horarioFim)
VALUES (3, 3, '08:00', '12:00');
