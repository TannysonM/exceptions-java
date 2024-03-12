package model.exceptions;
//Extensão
public class DomainException extends RuntimeException {

	/**
	 * Declaração de uma classe serialAlice
	 */
	private static final long serialVersionUID = 1L;
 //RuntimeException = exceção que o compilador não obrigar o programador tratar
//Exception = exceção que o compilador obriga tratar
	
	//Permite o instanciamento da exceção personalizada passando uma mensagem para ela
	public DomainException(String msg) {
		super(msg);
	}
}
