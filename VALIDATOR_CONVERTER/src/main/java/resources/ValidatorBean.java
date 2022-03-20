package resources;

import java.io.Serializable;

import javax.annotation.PostConstruct;
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
		System.out.println("Email: ");		
		System.out.println(this.email);
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
