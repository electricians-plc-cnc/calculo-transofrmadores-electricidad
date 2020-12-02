package Controlador;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Codigo {
	//---------------------- FORMULOMETRO BRASIL ---------------------------//	
public static double multiplicacionPrimeraBr(double num1, double num2, double num3, double num4, double num5, double num6, double num7, double num8, double num9){

		// ------------------ ALGORITMO --------------------------
	
	double algoritmo_nro1 = 10;
	double algoritmo_nro2 = 9;
	double algoritmo_nro3 = 8;
	double algoritmo_nro4 = 7;
	double algoritmo_nro5 = 6;
	double algoritmo_nro6 = 5;
	double algoritmo_nro7 = 4;
	double algoritmo_nro8 = 3;
	double algoritmo_nro9 = 2;
		
		//int algoritmo_nro10 = 2;


		
		//--------------    MULTIPLICO   --------------------
		
	double resultado1 = num1*algoritmo_nro1;
	double resultado2 = num2*algoritmo_nro2;
	double resultado3 = num3*algoritmo_nro3;
	double resultado4 = num4*algoritmo_nro4;
	double resultado5 = num5*algoritmo_nro5;
	double resultado6 = num6*algoritmo_nro6;
	double resultado7 = num7*algoritmo_nro7;
	double resultado8 = num8*algoritmo_nro8;
	double resultado9 = num9*algoritmo_nro9;
		//int resultado10 = num10*algoritmo_nro10;
		
		
	double resultadoTotal = resultado1+ resultado2+resultado3+resultado4+
				resultado5+resultado6+resultado7+
				resultado8+resultado9;
		
		return  resultadoTotal;

	}
public static float sacarCodigoVerificadorPrimeroBr(double resultado){
	int resultadoVerificadorPrimero;

	double resultadoPrimero = (resultado*10)/11;
	double resultadoVerificador = resultadoPrimero%1;
	double resultadoPrimero2 = (resultadoVerificador*10);
	int resultadoVerificadorInt = (int)Math.ceil(resultadoPrimero2);
	
	
//	float resultadoSegundo = resultado - resultadoPrimero;
//				
		if(resultadoVerificadorInt==10){
			resultadoVerificadorPrimero =0;
		}else{
			resultadoVerificadorPrimero = resultadoVerificadorInt;
		}
		return resultadoVerificadorPrimero;

}
public static double multiplicacionSegundaBr(double num1, double num2, double num3, double num4, double num5, double num6, double num7, double num8, double num9){

	// ------------------ ALGORITMO --------------------------

double algoritmo_nro1 = 11;
double algoritmo_nro2 = 10;
double algoritmo_nro3 = 9;
double algoritmo_nro4 = 8;
double algoritmo_nro5 = 7;
double algoritmo_nro6 = 6;
double algoritmo_nro7 = 5;
double algoritmo_nro8 = 4;
double algoritmo_nro9 = 3;

	
	//int algoritmo_nro10 = 2;


	
	//--------------    MULTIPLICO   --------------------
	
double resultado1 = num1*algoritmo_nro1;
double resultado2 = num2*algoritmo_nro2;
double resultado3 = num3*algoritmo_nro3;
double resultado4 = num4*algoritmo_nro4;
double resultado5 = num5*algoritmo_nro5;
double resultado6 = num6*algoritmo_nro6;
double resultado7 = num7*algoritmo_nro7;
double resultado8 = num8*algoritmo_nro8;
double resultado9 = num9*algoritmo_nro9;
	//int resultado10 = num10*algoritmo_nro10;
	
	
double resultadoTotal = resultado1+ resultado2+resultado3+resultado4+
			resultado5+resultado6+resultado7+
			resultado8+resultado9;
	
	return  resultadoTotal;

}
public static float sacarCodigoVerificadorSegundoBr(double resultado){
int resultadoVerificadorPrimero;

double resultadoPrimero = (resultado*10)/11;
double resultadoVerificador = resultadoPrimero%1;
double resultadoPrimero2 = (resultadoVerificador*10);
int resultadoVerificadorInt = (int)Math.ceil(resultadoPrimero2);


//float resultadoSegundo = resultado - resultadoPrimero;
//			
	if(resultadoVerificadorInt==10){
		resultadoVerificadorPrimero =0;
	}else{
		resultadoVerificadorPrimero = resultadoVerificadorInt;
	}
	return resultadoVerificadorPrimero;

}
	
//---------------------- FORMULOMETRO ARGENTINA ---------------------------//	
	
public static int multiplicacionArg(int num1, int num2, int num3, int num4, int num5, int num6, int num7, int num8, int num9, int num10){

		// ------------------ ALGORITMO --------------------------
	
		int algoritmo_nro1 = 5;
		int algoritmo_nro2 = 4;
		int algoritmo_nro3 = 3;
		int algoritmo_nro4 = 2;
		int algoritmo_nro5 = 7;
		int algoritmo_nro6 = 6;
		int algoritmo_nro7 = 5;
		int algoritmo_nro8 = 4;
		int algoritmo_nro9 = 3;
		int algoritmo_nro10 = 2;
		
		//--------------    MULTIPLICO   --------------------
		
		int resultado1 = num1*algoritmo_nro1;
		int resultado2 = num2*algoritmo_nro2;
		int resultado3 = num3*algoritmo_nro3;
		int resultado4 = num4*algoritmo_nro4;
		int resultado5 = num5*algoritmo_nro5;
		int resultado6 = num6*algoritmo_nro6;
		int resultado7 = num7*algoritmo_nro7;
		int resultado8 = num8*algoritmo_nro8;
		int resultado9 = num9*algoritmo_nro9;
		int resultado10 = num10*algoritmo_nro10;
		
		
		int resultadoTotal = resultado1+ resultado2+resultado3+resultado4+
				resultado5+resultado6+resultado7+
				resultado8+resultado9+resultado10;
		
		return resultadoTotal;

	}
public static int sacarCodigoVerificadorArg(int resultado){
		
		int resultadoMultiplo10 = resultado %10;
		int resultadoRestaDelMultiplo = 10 - resultadoMultiplo10;
		
		if(11-resultadoRestaDelMultiplo==11){
			resultadoRestaDelMultiplo=0;
		} if (11-resultadoRestaDelMultiplo==10){
			resultadoRestaDelMultiplo=9;
		}else{
			resultadoRestaDelMultiplo = 11-resultadoRestaDelMultiplo;
		}
		return resultadoRestaDelMultiplo;

}
//---------------------- FORMULOMETRO URUGUAY ---------------------------//
	public static int multiplicacionUru(int num1, int num2, int num3, int num4, int num5, int num6, int num7){
		
		// ------------------ ALGORITMO --------------------------
		
				int algoritmo_nro1 = 2;
				int algoritmo_nro2 = 9;
				int algoritmo_nro3 = 8;
				int algoritmo_nro4 = 7;
				int algoritmo_nro5 = 6;
				int algoritmo_nro6 = 3;
				int algoritmo_nro7 = 4;
				
		//--------------    MULTIPLICO   --------------------
				
				int resultado1 = num1*algoritmo_nro1;
				int resultado2 = num2*algoritmo_nro2;
				int resultado3 = num3*algoritmo_nro3;
				int resultado4 = num4*algoritmo_nro4;
				int resultado5 = num5*algoritmo_nro5;
				int resultado6 = num6*algoritmo_nro6;
				int resultado7 = num7*algoritmo_nro7;
				
				int resultadoTotal = resultado1+ resultado2+resultado3+resultado4+
						resultado5+resultado6+resultado7;
				
				
				
				return resultadoTotal;
	}
	public static int sacarCodigoVerificadorUru(int resultado){
		
		int resultadoMultiplo10 = resultado %10;
		int resultadoRestaDelMultiplo = 10 - resultadoMultiplo10;
		
		return resultadoRestaDelMultiplo;
	}
//----------------------  SONIDOS ----------------------------------------//
	
	public Clip clip;
	public void sonidoDing () {

		try{
		clip=AudioSystem.getClip();
		clip.open(AudioSystem.getAudioInputStream(getClass().getResource("/Sonido/ding.wav")));
		clip.start();

		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e){

		}
		}
	public void sonidoCerrar () {
		try{
		clip=AudioSystem.getClip();
		clip.open(AudioSystem.getAudioInputStream(getClass().getResource("/Sonido/cerrar.wav")));
		clip.start();

		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e){

		}
		}
	public void sonidoLimpiar () {

		try{
		clip=AudioSystem.getClip();
		clip.open(AudioSystem.getAudioInputStream(getClass().getResource("/Sonido/limpiar.wav")));
		clip.start();

		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e){

		}
		}
	public void sonidoPasar () {

		try{
		clip=AudioSystem.getClip();
		clip.open(AudioSystem.getAudioInputStream(getClass().getResource("/Sonido/pasar.wav")));
		clip.start();

		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e){

		}
		}
	
	
	//**********************************************************************
	
	public double buscarConstantePOTENCIA_Ch(double area){
		double resultado = Math.pow(area, 2);
		return resultado;
	}
	
	public double potenciaReal_Ch(double area, double constante){
		double resultado = area/Math.pow(constante, 2);
		return resultado;
	}
	
	public double voltajeVueltaEspira_Ch(double areaTotal, double frecuencia, double gaus){
		double resultado = Math.pow(10, 8)/(4.44 * areaTotal * frecuencia * gaus);
		return resultado;
	}
	
	public double vueltasPrimario_Ch(double vueltaEspira, double voltajeEntrada){
		double resultado = vueltaEspira*voltajeEntrada;
		return resultado;
	}
	
	public double vueltasSecundario_Ch(double vueltaEspira, double voltajeEntrada){
		double resultado = vueltaEspira*voltajeEntrada;
		return resultado;
	}

}
