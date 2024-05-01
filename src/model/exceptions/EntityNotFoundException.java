package model.exceptions;

public class EntityNotFoundException extends Exception {
	public EntityNotFoundException(int id, String tableName) {
        super("Entidade com ID " + id + " não foi encontrada na tabela " + tableName);
    }
}
