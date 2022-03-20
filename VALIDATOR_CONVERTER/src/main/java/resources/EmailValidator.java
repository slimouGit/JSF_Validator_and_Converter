package resources;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "emailValidator")
public class EmailValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent uic, Object object) throws ValidatorException {

		String value = (String) object;
		final String EMAIL_PATTERN = "^[a-zA-Z0-9_.+-]+@[a-zA-z0-9- ]+\\.[a-zA-z0-9-.]+$";
		
		if(value.isEmpty()) {
			FacesMessage fm = new FacesMessage("Email is missing");
			throw new ValidatorException(fm);
		}
		if (!Pattern.matches(EMAIL_PATTERN, value)) {
			FacesMessage fm = new FacesMessage("Wrong email input");
			throw new ValidatorException(fm);
		}  
	}

}
