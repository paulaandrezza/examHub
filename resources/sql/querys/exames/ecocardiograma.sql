SELECT 
    ex.id AS exame_id,
    ec.id AS ecocardiograma_id,
    ex.agendamento_id,
    ex.peso,
    ex.medicoResponsavel_id,
    ex.conclusoes,
    ex.detalhes,
    ex.diagnosticoClinico,
    ec.raizAorta,
    ec.atrioEsquerdo,
    ec.vdDiastolico,
    ec.veSistolico,
    ec.vePosterior,
    ec.septoIntraventricular,
    ec.fracaoEncurtamento,
    ec.fracaoEjecao
FROM
    Exame ex
RIGHT JOIN
    Ecocardiograma ec ON ex.id = ec.exame_id
