package perscholas.mycasestudy.form;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import perscholas.mycasestudy.validation.EmailUnique;
import perscholas.mycasestudy.validation.TwoFieldsAreEqual;

@Getter
@Setter
@TwoFieldsAreEqual(fieldOneName = "confirmPassword", fieldTwoName = "password", message = "Password and Conform Password must be the same.")

public class RegisterFormBean {

	@Id
	public Integer id;

	@Length(min = 1, max = 50, message = "FirstName must be between 1 and 50 characters in length.")
	private String firstName;

	@Length(min = 1, max = 50, message = "lastName must be between 1 and 50 characters in length.")
	private String lastName;

	@EmailUnique(message = "email must be unique")
	@NotEmpty(message = "You cant leave email field empty.")
	private String email;

	@NotEmpty(message = "You cant leave phone field empty.")
	private String phone;

	@NotEmpty(message = "You cant leave password field empty.")
	private String password;

	@NotEmpty(message = "You cant leave this field empty.")
	private String confirmPassword;


	private String userType;

	private List<String> errorMessages = new ArrayList<>();


}
