public class Validations {

    private String REGEX_INTEGER = "^-?\\d+$";
    private String REGEX_DOUBLE = "^-?\\d+(\\.\\d+)?$";
    private String REGEX_VALIDNAME = "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü ]+$";
    private String REGEX_POSITIVENUMBERS = "^\\d+(\\.\\d+)?$";
    private String REGEX_STRINGSWITHLENGTH = "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü ]{1,50}$";

    public boolean isInteger(String number){
        return number.matches(REGEX_INTEGER);
    }

    public boolean isDouble(String number){
        return number.matches(REGEX_DOUBLE);
    }

    public boolean isPositive(String number){
        return number.matches(REGEX_POSITIVENUMBERS);
    }

    public boolean isValidName(String string){
        return string.matches(REGEX_VALIDNAME);
    }

    public boolean isNameWithLength(String string){
        return string.matches(REGEX_STRINGSWITHLENGTH);
    }

    public boolean isPositiveWithNumber(int number){
        return number > 0;
    }
}
