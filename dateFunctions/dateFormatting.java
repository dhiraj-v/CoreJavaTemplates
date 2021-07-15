import java.util.HashMap;
class dateFormatting { 

	public static void main(String args[]) { 

		// Variable declaration
		String inputDateString = ""; 
		int yearInteger = 0;  
		boolean leapYearFlag = false; 
		//Jan 1 2020 Wednesday
		

		HashMap<String, String> dayMap = new HashMap<String, String>() {{
		    put("1","Sunday");
			put("2","Monday");
			put("3","Tuesday");
			put("4","Wednesday");
			put("5","Thursday");
			put("6","Friday");
			put("7","Saturday");
		}};


		// Zulu Sample
		inputDateString = "2012-06-11T20:17:46.384z";
		HashMap<String, String> zuluMap = new HashMap<String, String>(); 
		zuluMap = dateFormatterZulu(inputDateString);
		yearInteger = Integer.parseInt(zuluMap.get("year")); 
		leapYearFlag = leapYearCheck(yearInteger); 
		System.out.println(zuluMap); 
		System.out.println(leapYearFlag); 
	}
	private static HashMap dateFormatterZulu(String inputDateString){
		String year, month, date, monthName; 
		HashMap<String, String> monthMap = new HashMap<String, String>() {{
		    put("01","January");
			put("02","February");
			put("03","March");
			put("04","April");
			put("05","May");
			put("06","June");
			put("07","July");
			put("08","August");
			put("09","September");
			put("10","October");
			put("11","November");
			put("12","December");
		}};
		// string parsing the zulu formatted date to get 
		// year month and date. 
		// currently the time is not parsed. 
		year = (inputDateString.substring(0,4));
		month = (inputDateString.substring(5,7));
		date = (inputDateString.substring(8,10));
		monthName = monthMap.get(month); 
		HashMap<String, String> zuluMap = new HashMap<String, String>() {{
		    put("year", year);
			put("monthNum", month);
			put("monthName", monthName);
			put("date", date);
		}};
		return zuluMap; 
	}
	private static boolean leapYearCheck(int yearInteger) {
		if(yearInteger % 4 == 0) {
			return true; //0 is leap year
		} else {
			return false; //1 is nto leap year
		}
	}
}
