SELECT
    ex.id AS exame_id,
    te.id AS teste_ergometrico_id,
    ex.agendamento_id,
    ex.peso,
    ex.medicoResponsavel_id,
    ex.conclusoes,
    ex.detalhes,
    ex.diagnosticoClinico,
    te.ritmo,
    te.fc
FROM 
    Exame ex
RIGHT JOIN
    TesteErgometrico te ON ex.id = te.exame_id
