SELECT 
    ex.id AS exame_id,
    h.id AS holter_id,
    ex.agendamento_id,
    ex.peso,
    ex.medicoResponsavel_id,
    ex.conclusoes,
    ex.detalhes,
    ex.diagnosticoClinico,
    h.arritmia,
    h.isquemiaCardiaca,
    h.dcIntravicular,
    h.dcAtriovencular,
    h.apneiaSono
FROM
    Exame ex
RIGHT JOIN
    Holter h ON ex.id = h.exame_id
