import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Almacenamiento {
	
	private Deposito [] depositos;
	private int volumenmax;
	private int profundidadalsuelo;
	private int depositosusados;
	private int volumendesbordado;
	private int volumenallenar;
	
	
	private int  calcularvolumenmax(){
		int cant = 0;
		for (Deposito deposito : depositos) {
			cant+=deposito.getCantidadMax();
		}
		return cant;
	}
	
	public void exportarDatos(String archivo) throws IOException{
		PrintWriter out = new PrintWriter(new File(archivo+".out"));
		if(volumendesbordado>0){
			out.print("Rebasan:"+volumendesbordado);
			out.close();
			return;
		}
		out.println(depositosusados);
		out.print(profundidadalsuelo);
		out.close();
		
		
	}
	
	public void  llenar() {
		 this.volumendesbordado=this.volumenallenar-this.volumenmax;
		if(volumendesbordado>0)
			return;
		int volumenllenado=0;
		int profundidadactual=depositos[0].getP();
		int depos=0;
		while(volumenallenar>volumenllenado) {
			depos=0;
			profundidadactual--;
			for (Deposito deposito : depositos) {
				if(deposito.getCantidadVPorP(profundidadactual)>0)
					depos++;
				volumenllenado+=deposito.getCantidadVPorP(profundidadactual);
			}
			
		}
		this.profundidadalsuelo=profundidadactual;
		this.depositosusados=depos;
	}
	
	public Almacenamiento(String archivo) throws FileNotFoundException {
		super();
		Scanner in = new Scanner(new File(archivo+".in"));
		this.depositos= new Deposito[in.nextInt()];
		for (int i = 0; i < depositos.length; i++) {
			depositos[i]=new Deposito(in.nextInt(),in.nextInt());
		}
		volumenallenar=in.nextInt();
		in.close();
		this.volumenmax = calcularvolumenmax();
	}

}
