package br.com.loja.infrastructure.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * The Class DateUtil.
 */
public class DateUtil {

    /**
     * The Constant LOGGER.
     */
    static final Logger LOGGER = Logger.getLogger(DateUtil.class.getName());
    public static final String OLDFORMAT = "dd-MM-yyyy HH:mm:ss";
    public static final String NEWFORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final SimpleDateFormat FORMATADOR_DD_MM_YYYY_HH_SS = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static final SimpleDateFormat FORMATADOR_YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    
    public static final SimpleDateFormat SDFYYYY_MM_DD_HH_MM_SS = new SimpleDateFormat(NEWFORMAT);
    public static final SimpleDateFormat SDF_DD_MM_YYYY_HH_MM_SS = new SimpleDateFormat(OLDFORMAT);


    /**
     * Now.
     *
     * @return the date
     */
    public static Date now() {
        return new Date();
    }

    /**
     * Converte uma data atraves de uma string (dd/MM/yyyy) <br>
     * Se a string estiver invalida, retornara null.
     *
     * @param date   Uma data valida.
     * @param format String do formato desejado.
     * @return String convertida.
     */
    public static String formatDate(final Date date, final String format) {

        if (date == null) {
            return null;
        }

        final DateFormat df = new SimpleDateFormat(format);
        String dateFormat;
        dateFormat = df.format(date);

        return dateFormat;
    }


    /**
     * Converte String para Date.
     *
     * @param str str
     * @return Date Date
     * @throws ParseException ParseException
     */
    public static Date stringToDate(final String str) {
        try {
            return FORMATADOR_DD_MM_YYYY_HH_SS.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String stringFormatDate(final String str) {
        try {
            return FORMATADOR_DD_MM_YYYY_HH_SS.format(SDFYYYY_MM_DD_HH_MM_SS.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
            return str;
        }
    }
    
    
    public static String stringFormatNowDateISO8691() {
        try {
        	Calendar data = Calendar.getInstance();
        	data.add(Calendar.SECOND, 5);
            return FORMATADOR_YYYY_MM_DD_HH_MM_SS.format(data.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
	public static XMLGregorianCalendar toXmlGregorianCalendar(final Date data) {
		if (data != null) {
			final GregorianCalendar gCalendar = new GregorianCalendar();
			gCalendar.setTime(data);
			XMLGregorianCalendar xmlCalendar = null;

			try {
				xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
			} catch (final DatatypeConfigurationException ex) {
				LOGGER.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
			}
			return xmlCalendar;
		}
		return null;
	}

	
    public static Date toDate(final XMLGregorianCalendar calendar) {
        if (calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().getTime();
    }    

}