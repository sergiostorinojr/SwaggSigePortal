package br.com.swaggsige.model.service.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * SwaggSigePortal
 * @author Sérgio Junior - sergio.storinojr@gmail.com
 *
 * Responsável por Converter Data e Hora em String vice versa
 *
 */
public class ConverterDateTime {
	
	/**
	 * Método Static dado um Objeto do Tipo Date retorna a Data no formato String
	 * @param data
	 * @return
	 */
	public static String getConverterDateString(Date data){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateFormat = formatter.format(data);
		return dateFormat;
	}
	
	/**
	 * Método Conversor Dado uma String retorna um Objeto Date Formatado
	 * @param date
	 * @return
	 */
	public static Date getConverterStringDate(String date){
		  try {
			  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			  Date parse = (Date)formatter.parse(date);
		    return parse;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static Date getConverterStringDateBanco(String date){
		  try {
			  SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
			  Date parse = format.parse(date);
		    return parse;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
