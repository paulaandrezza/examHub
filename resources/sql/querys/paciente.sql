SELECT 
    p.id AS paciente_id,

    pe.nome,
    pe.cpf,
    pe.dataNascimento,
    pe.celular,
    pe.telefone,
    pe.email,
    pe.genero,

    e.cep,
    e.estado,
    e.cidade,
    e.bairro,
    e.rua,
    e.numero,
    e.complemento,

    p.altura,
    p.fumante,
    p.marcaPasso,

    c.numeroCarteirinha,
    c.prestadora,
    c.plano,

    h.alergias,
    h.medicamentos,
    h.prescricao
FROM 
    Paciente p
    INNER JOIN Pessoa pe ON p.pessoa_id = pe.id
    LEFT JOIN Endereco e ON pe.endereco_id = e.id
    LEFT JOIN Convenio c ON p.convenio_id = c.id
    LEFT JOIN HistoricoMedico h ON p.historicoMedico_id = h.id;
