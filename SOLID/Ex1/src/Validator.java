import java.util.ArrayList;
import java.util.List;

public class Validator {
    public List<String> validate(ParsedRecord  rec){
        // validation inline, printing inline
        List<String> errors = new ArrayList<>();
        if (rec.name.isBlank()) errors.add("name is required");
        if (rec.email.isBlank() || !rec.email.contains("@")) errors.add("email is invalid");
        if (rec.phone.isBlank() || !rec.phone.chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        if (!(rec.program.equals("CSE") || rec.program.equals("AI") || rec.program.equals("SWE"))) errors.add("program is invalid");

        return errors;
    }
}
