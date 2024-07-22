package com.myApp.Dto;

public class UpdatePasswordDTO {

	private String password;
	private String newPassword;
	private String retypePassword;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getRetypePassword() {
		return retypePassword;
	}
	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}
	@Override
	public String toString() {
		return "UpdatePasswordDTO [password=" + password + ", newPassword=" + newPassword + ", retypePassword="
				+ retypePassword + "]";
	}
	
	
}
