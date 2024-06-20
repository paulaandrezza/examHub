SELECT 
    f.id AS funcionario_id,
    f.pessoa_id,
    f.emailCorporativo,
    f.senha,
    f.tipoFuncionario,
    pe.id AS pessoa_id,
    pe.nome,
    pe.cpf,
    pe.rg,
    pe.dataNascimento,
    pe.celular,
    pe.telefone,
    pe.email,
    pe.genero,
    pe.endereco_id
FROM 
    Funcionario f
LEFT JOIN 
    Pessoa pe ON f.pessoa_id = pe.id
