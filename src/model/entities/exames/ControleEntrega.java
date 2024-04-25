package model.entities.exames;

import java.time.LocalDateTime;

import model.entities.Funcionario;

public class ControleEntrega {
	LocalDateTime dataEHorario;
	String retiradoPor;
	Funcionario entreguePor;
	Exame exame;
}
