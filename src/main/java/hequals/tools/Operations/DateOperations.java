package src.main.java.hequals.tools.Operations;

import static java.time.temporal.TemporalAdjusters.firstInMonth;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import src.main.java.hequals.tools.Objects.Tool;

public class DateOperations {

    public static int calculateChargeDays(Tool tool, LocalDate checkOutDate, int days) {
        int totalChargeDays = days;
        if(!tool.isHolidayCharge())
            totalChargeDays -= calculateHolidays(checkOutDate, days);
        if(!tool.isWeekendCharge())
            totalChargeDays -= calculateWeekendDays(checkOutDate, days);
        return totalChargeDays;
    }

    //determines how many of the specified holidays occur in the range
    //only to be used in calculateChargeDays
    public static int calculateHolidays(LocalDate checkOutDate, int days) {
        int holidayCount = 0;
        LocalDate dueDate = determineDueDate(checkOutDate, days);
        List<LocalDate> relevantHolidays = new ArrayList<LocalDate>();
        for(int i = 0; i <= dueDate.getYear() - checkOutDate.getYear(); i++) {
            int currentWorkingYear = checkOutDate.getYear() + i;
            LocalDate independenceDay = LocalDate.of(currentWorkingYear, 7, 4);
            if (independenceDay.getDayOfWeek() == DayOfWeek.SATURDAY) {
                independenceDay = independenceDay.minusDays(1); //it is observed that friday
            } else if (independenceDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
                independenceDay = independenceDay.plusDays(1); //it is observed that monday
            }
            LocalDate laborDay = LocalDate.of(currentWorkingYear, 9, 1); //set date to first of September
            laborDay = laborDay.with(firstInMonth(DayOfWeek.MONDAY)); //snap to the first monday that september
            //add both dates to the list, then proceed to the next year if there are more
            relevantHolidays.add(independenceDay);
            relevantHolidays.add(laborDay);
        }
        for(LocalDate holiday: relevantHolidays) {
            if(holiday.isAfter(checkOutDate) && holiday.isBefore(dueDate.plusDays(1))) 
                holidayCount++;
        }
        return holidayCount;
    }

    //determines how many weekend days occur in the range
    //only to be used in calculateChargeDays
    public static int calculateWeekendDays(LocalDate checkOutDate, int days) {
        LocalDate iterativeDate = checkOutDate;
        int weekendDaysCount = 0;
        for (int i = 1; i <= days; i++) {
            iterativeDate = iterativeDate.plusDays(1);
            DayOfWeek dayOfWeek = iterativeDate.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY)
                weekendDaysCount++;
        }
        return weekendDaysCount;
    }

    public static LocalDate determineDueDate(LocalDate checkOutDate, int days) {
        return checkOutDate.plusDays(days);
    }

    public static String formatDate(LocalDate date) {
        return DateTimeFormatter.ofPattern("mm/dd/yy", Locale.ENGLISH).format(date);
    }
}