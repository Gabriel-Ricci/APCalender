public class APCalendar {
    
    private static boolean isLeapYear(int year) {
        
        return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }
    
    
    public static int numberOfLeapYears(int year1, int year2) {
        int count = 0;
        
        for (int year = year1; year <= year2; year++) {
            if (isLeapYear(year)) {
                count++;
            }
        }
        
        return count;
    }
    
    
    private static int firstDayOfYear(int year) {
        
        int m = 13; 
        int k = (year - 1) % 100;
        int j = (year - 1) / 100;
        
        int dayOfWeek = (1 + (26 * (m + 1)) / 10 + k + k/4 + j/4 + 5*j) % 7;
        
        
        dayOfWeek = (dayOfWeek + 6) % 7;
        
        return dayOfWeek;
    }
    
    
    private static int dayOfYear(int month, int day, int year) {
        
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (isLeapYear(year)) {
            daysInMonth[2] = 29;
        }
        
        int dayCount = day;
        
        for (int i = 1; i < month; i++) {
            dayCount += daysInMonth[i];
        }
        
        return dayCount;
    }
    
    
    public static int dayOfWeek(int month, int day, int year) {
        int firstDay = firstDayOfYear(year);
        int dayNum = dayOfYear(month, day, year);
        
        
        return (firstDay + (dayNum - 1)) % 7;
    }
}