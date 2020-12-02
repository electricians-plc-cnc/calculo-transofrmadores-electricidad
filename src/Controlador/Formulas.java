package Controlador;

import java.text.DecimalFormat;

public class Formulas {
	
	public static double area(double lado, double ancho){
		
		double resultado = (lado*ancho)/100;
		return resultado;
		
	}
	
	public static double potencia(double num){
		
		int resultado = (int)Math.pow(num,2);
		return resultado;
		
	}
	
	public static double coeficienteAjuste(double num){
		
		double resultado = num/((double)1.2);
		return resultado;
		
	}
	
	public static double vueltasPrimario(double area, double coefK, double voltajeEntrada){
		
		double resultado = (coefK/area)*voltajeEntrada;
		return resultado;
		
	}
	
	public static double vueltasSecundario(double area, double coefK, double voltajeSalida){
		  
		double resultado = (coefK/area)*voltajeSalida;
		return resultado;
		
	}
	

public static double intensidadPrimario(double potencia, double voltajePrimario){
		
		double resultado = (potencia/voltajePrimario);
		return resultado;
		
	}

public static double intensidadSecundario(double potencia, double voltajeSecundario){
	
	double resultado = (potencia/voltajeSecundario);
	return resultado;
	
}

public static Double formatearDecimales(Double numero, Integer numeroDecimales) {

	return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
}


public static Double lado_nuevo(double lado_nuevo, double largoE, double ancho_nuevo) {

	double resultado = (lado_nuevo+((largoE - ancho_nuevo+5)-ancho_nuevo)/2);
	return resultado;
}


public static Double ancho_nuevo(double ancho_nuevo, double largoE, double lado_nuevo) {

	double resultado = (ancho_nuevo+((largoE - lado_nuevo+5)-lado_nuevo)/2);
	return resultado;
}


}
