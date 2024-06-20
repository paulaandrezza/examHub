SELECT 
    ex.id AS exame_id,
    el.id AS eletrocardiograma_id,
    ex.agendamento_id,
    ex.peso,
    ex.medicoResponsavel_id,
    ex.conclusoes,
    ex.detalhes,
    ex.diagnosticoClinico,
    el.ritmo,
    el.fc,
    el.ondaP,
    el.complexoQRS,
    el.eixoEletrico
FROM
    Exame ex
RIGHT JOIN
    Eletrocardiograma el ON ex.id = el.exame_id
