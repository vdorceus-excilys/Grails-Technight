package technight.utils;

import java.time.ZoneId;
import java.time.LocalDate;
import java.util.Date;

class DateValidator {

    public static boolean isIntroducedValid(Date introduced, Date discontinued){
        if(introduced == null || discontinued == null){
            return true;
        }
        else{
            LocalDate first = toLocalDate(introduced);
            LocalDate second = toLocalDate(discontinued);
            return first.isBefore(second) ;
        }           
    }

    public static boolean isDiscontinuedValid(Date introduced, Date discontinued){
        if(introduced == null && discontinued == null){
            return true;
        }else {
            LocalDate first = toLocalDate(introduced);
            LocalDate second = toLocalDate(discontinued);
            return first.isBefore(second);
        }
    }

    private static LocalDate toLocalDate(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

}