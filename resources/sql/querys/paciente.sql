SELECT 
    pe.id AS pessoa_id,
    pe.nome,
    pe.cpf,
    pe.rg,
    pe.dataNascimento,
    pe.celular,
    pe.telefone,
    pe.email,
    pe.genero,

    e.id AS endereco_id,
    e.cep,
    e.estado,
    e.cidade,
    e.bairro,
    e.rua,
    e.numero,
    e.complemento,

    p.id AS paciente_id,
    p.altura,
    p.fumante,
    p.marcaPasso,

    c.id AS convenio_id,
    c.numeroCarteirinha,
    c.prestadora,
    c.plano,

    h.id AS historicoMedico_id,
    h.alergias,
    h.medicamentos,
    h.condicaoMedica
FROM 
    Paciente p
    INNER JOIN Pessoa pe ON p.pessoa_id = pe.id
    LEFT JOIN Endereco e ON pe.endereco_id = e.id
    LEFT JOIN Convenio c ON p.convenio_id = c.id
    LEFT JOIN HistoricoMedico h ON p.historicoMedico_id = h.id
WHERE isDeleted is false