package exceptions;

public class ErrorFuenteDatosException extends Exception {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "No se ha podido acceder al fichero donde están las notas";
	}

}
