package gui;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class GetDateInJava extends SimpleDateFormat{
	public String GetDateInJava () {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String currentData = df.format(new Date());
		return currentData;
	}
}	
	

