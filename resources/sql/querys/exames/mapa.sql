SELECT 
    ex.id AS exame_id,
    m.id AS mapa_id,
    ex.agendamento_id,
    ex.peso,
    ex.medicoResponsavel_id,
    ex.conclusoes,
    ex.detalhes,
    ex.diagnosticoClinico,
    m.mediaHoras,
    m.paVirgula,
    m.paSono
FROM
    Exame ex
RIGHT JOIN
    Mapa m ON ex.id = m.exame_id
