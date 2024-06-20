SELECT 
    ex.id AS exame_id,
    a.id AS agendamento_id,
    ec.id AS ecocardiograma_id,
    el.id AS eletrocardiograma_id,
    h.id AS holter_id,
    m.id AS mapa_id,
    te.id AS testeErgometrico_id,

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
    ec.fracaoEjecao,

    el.ritmo,
    el.fc,
    el.ondaP,
    el.complexoQRS,
    el.eixoEletrico,

    h.arritmia,
    h.isquemiaCardiaca,
    h.dcIntravicular,
    h.dcAtriovencular,
    h.apneiaSono,


    m.mediaHoras,
    m.paVirgula,
    m.paSono,

    te.ritmo AS testeErgometrico_ritmo,
    te.fc AS testeErgometrico_fc,

    a.dataEhorario,
    a.paciente_id,
    a.medicoSolicitante,
    a.statusAgendamento,
    a.tipoExame


FROM
    Exame ex
LEFT JOIN agendamento a ON ex.agendamento_id = a.id
LEFT JOIN ecocardiograma ec ON ex.id = ec.exame_id
LEFT JOIN eletrocardiograma el ON ex.id = el.exame_id
LEFT JOIN holter h ON ex.id = h.exame_id
LEFT JOIN mapa m ON ex.id = m.exame_id
LEFT JOIN testeErgometrico te ON ex.id = te.exame_id