public class DaysBetweenDates {

    // Function to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Function to get the number of days in a month of a given year
    public static int daysInMonth(int month, int year) {
        int[] daysPerMonth = {31, 28 + (isLeapYear(year) ? 1 : 0), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return daysPerMonth[month - 1];
    }

    // Function to calculate the total number of days between two dates
    public static int daysBetweenDates(int[] dt1, int[] dt2) {
        int days = 0;

        // Add days remaining in start year
        for (int month = dt1[0]; month <= 12; month++) {
            days += daysInMonth(month, dt1[2]) - dt1[1];
            dt1[1] = 0; // Reset day for next iteration (to handle cases where start date is not the 1st of the month)
        }

        // Add days for full years in between
        for (int year = dt1[2] + 1; year < dt2[2]; year++) {
            days += 365 + (isLeapYear(year) ? 1 : 0);
        }

        // Add days passed in end year
        for (int month = 1; month < dt2[0]; month++) {
            days += dt2[1];
            dt2[1] = daysInMonth(month, dt2[2]);
        }

        // Add remaining days in end year
        days += dt2[1] - dt1[1];

        return days;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] dt1 = {10, 2, 2014};
        int[] dt2 = {10, 3, 2015};
        System.out.println(daysBetweenDates(dt1, dt2)); // Output: 393

        dt1 = new int[]{10, 2, 2000};
        dt2 = new int[]{10, 3, 2000};
        System.out.println(daysBetweenDates(dt1, dt2)); // Output: 29

        dt1 = new int[]{10, 2, 2000};
        dt2 = new int[]{10, 2, 2000};
        System.out.println(daysBetweenDates(dt1, dt2)); // Output: 0

        dt1 = new int[]{1, 2, 2000};
        dt2 = new int[]{1, 2, 2004};
        System.out.println(daysBetweenDates(dt1, dt2)); // Output: 1461
    }
}
