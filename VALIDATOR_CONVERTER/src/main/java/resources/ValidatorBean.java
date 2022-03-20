package resources;

import java.io.Serializable;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ValidatorBean implements Serializable {
	
	private static final long serialVersionUID = 5774003536434038522L;
	
	
	private String greeting;
	private String email;
	
	@PostConstruct
	public void init() {
		this.greeting = "hello world";
	}
	
	public void showEmail() {
		System.out.println("Email: " + this.email + " is well formed");
	}
	
	public void validateEmail(FacesContext fc, UIComponent uic, Object object) throws ValidatorException {
		String value = (String) object;
		if(value.isEmpty()) {
			FacesMessage fm = new FacesMessage("Email is missing");
			throw new ValidatorException(fm);
		}
		if (!Pattern.matches("^[a-zA-Z0-9_.+-]+@[a-zA-z0-9- ]+\\.[a-zA-z0-9-.]+$", value)) {
			FacesMessage fm = new FacesMessage("Wrong email input");
			throw new ValidatorException(fm);
		}  		
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
	

}
