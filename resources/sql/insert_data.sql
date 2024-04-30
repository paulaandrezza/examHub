INSERT INTO Pessoa (nome, cpf, dataNascimento, celular, email, genero)
VALUES ('Paula Marinho', '123.456.789-09', '2000-03-25', '1140028922', 'paula.marinho@email.com', 2);

INSERT INTO Funcionario (pessoa_id, emailCorporativo, senha)
VALUES (1, 'paula.marinho@examhub.com', 'password123');

INSERT INTO Medico (funcionario_id, especialidade)
VALUES (1, 1);

INSERT INTO HorarioAtendimento (medico_id, diaDaSemana, horarioInicio, horarioFim)
VALUES (3, 3, '08:00', '12:00');
