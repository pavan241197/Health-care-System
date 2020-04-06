package Userprogram;

public class Validation {
public static boolean firstnameValidation(String firstname)
{
String pattern="[A-Z]{1}[a-z]{2,6}";
if(firstname.matches(pattern))
	return true;
else
	return false;
}
public static boolean contactNumberValidate(String contactNo) {
	String pattern1 = "[0-9]{10}";
	if(contactNo.matches(pattern1))
		return true;
	return false;
}
public static boolean validatepassword(String password)
{
	String pattern2=("^" +
					"(?=.*[0-9])"+    //at least 1 digit
					"(?=.*[a-z])"+    //at least 1 lower case letter
					"(?=.*[A-Z])"+     //at least 1 upper case letter
					"(?=.*[@#$%^&+=])"+ // at least 1 special character
					"(?=\\S+$)"+        // no white space
					".(6,)"+            //at least 6 characters
					"$");
	if(password.matches(pattern2))
		return true;
	else
		return false;
}

public static boolean validateeamilId(String emailid)
{
	String pattern3=(
			"[a-zA=Z0-9\\+\\.\\_\\%\\-\\+]{1,256}"+
					"\\@"+
					"[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}"+
					"("+
					"\\."+
					"[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}"
							);
			
			if(emailid.matches(pattern3))
				return true;
			else
				return false;
			
}
			
}

