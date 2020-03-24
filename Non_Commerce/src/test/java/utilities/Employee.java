package utilities;

public class Employee
{
	 public String email,password,firstname,lastname,gender,
	dateofbirth,companyname,taxexempt,newsletter,customerrole,manager,active,admincomment;
	public Employee(String email, String password,String firstname, String lastname, String gender,
			String dateofbirth,String companyname,String taxexempt,
			String newsletter,String customerrole,String manager,String active,String admincomment)
	{
		this.email=email;
		this.password=password;
		this.firstname=firstname;
		this.lastname=lastname;
		this.gender=gender;
		this.dateofbirth=dateofbirth;
		this.companyname=companyname;
		this.taxexempt=taxexempt;
		this.newsletter=newsletter;
		this.customerrole=customerrole;
		this.manager=manager;
		this.active=active;
		this.admincomment=admincomment;
	
	}
}
