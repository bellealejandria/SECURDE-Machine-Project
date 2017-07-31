package org.mp.model;

public class Member {
	private int idnumber;
    private String firstName;
    private String midInitial; 
    private String lastName;
    private String birthday;
    private String email;
    private String password;
    private String secretQuestion;
    private String secretAns;
    private String role;
    
    public Member() {}
    
    public Member(int idnumber, String firstName, String midInitial, String lastName, String birthday, String email,
			String password, String secretQuestion, String secretAns, String role) {
		this.idnumber = idnumber;
		this.firstName = firstName;
		this.midInitial = midInitial;
		this.lastName = lastName;
		this.birthday = birthday;
		this.email = email;
		this.password = password;
		this.secretQuestion = secretQuestion;
		this.secretAns = secretAns;
		this.role = role;
	}
 
    public int getIdNumber() {
        return idnumber;
    }
    public void setIdNumber(int idnumber) {
        this.idnumber = idnumber;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMidInitial() {
        return midInitial;
    }
    public void setMidInitial(String midInitial) {
        this.midInitial = midInitial;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSecretQuestion() {
        return secretQuestion;
    }
    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }
    public String getSecretAns() {
        return secretAns;
    }
    public void setSecretAns(String secretAns) {
        this.secretAns = secretAns;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return "Student [idnumber=" + idnumber + ", firstName=" + firstName 
        		+ ", midInitial=" + midInitial + ", lastName=" + lastName + ", "
        		+ "birthday=" + birthday + ", email=" + email + ", password=" + password
        		+ ", secretQuestion=" + secretQuestion + ", secretAns=" + secretAns + ", "
        		+ "role=" + role +"]";
    }
 
}