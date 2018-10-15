
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		String lotepath="Lotes de Prueba/in/";
		String pruebas="Ejecucion de pruebas/out/";
		Almacenamiento a0 = new Almacenamiento(lotepath+"00_desborda");
		Almacenamiento a1 = new Almacenamiento(lotepath+"01_Nodesborda");
		Almacenamiento a2 = new Almacenamiento(lotepath+"02_mayorprofundidamenorsuperficie");
		Almacenamiento a3 = new Almacenamiento(lotepath+"03_todosiguales");
		a0.llenar();
		a1.llenar();
		a2.llenar();
		a3.llenar();
		a0.exportarDatos(pruebas+"00_desborda");
		a1.exportarDatos(pruebas+"01_Nodesborda");
		a2.exportarDatos(pruebas+"02_mayorprofundidamenorsuperficie");
		a3.exportarDatos(pruebas+"03_todosiguales");
	}

}
