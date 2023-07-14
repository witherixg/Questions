public class PrintDateTable{
	
	public static void printDateTable(int year, int month){
		int days = getDaysInMonth(year, month);
		int firstDay = getFirstDayOfMonth(year, month);
		System.out.println("\n\t\t" + year + "-" + getMonthName(month));
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
		for(int i = 0; i < firstDay; i++){
			System.out.print("    ");
		}
		for(int i = 1; i <= days; i++){
			System.out.printf("%3d ", i);
			if(((i + firstDay) % 7) == 0){
				System.out.println();
			}
		}
		System.out.println();
	}
	
	private static int getFirstDayOfMonth(int year, int month){
		int firstDay = 1;
		int totalDays = 0;
		for(int i = 1; i < month; i++){
			totalDays += getDaysInMonth(year, i);
		}
		firstDay = (totalDays + 6) % 7;
		return firstDay;
	}
	
	private static int getDaysInMonth(int year, int month){
		int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(month == 2 && isLeapYear(year)){
			return 29;
		}
		return daysInMonth[month - 1];
	}
	
	private static boolean isLeapYear(int year){
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	}
	
	private static String getMonthName(int month){
		String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		return monthNames[month - 1];
	}

	public static void main(String[] args){
		printDateTable(2016, 1);
		printDateTable(2022, 3);
	}
}