package com.share.ftp.domain.guest;

public class LoginDTO {
	private String meberId;
	private int password;
	
	public String getMeberId() {
		return meberId;
	}
	public void setMeberId(String meberId) {
		this.meberId = meberId;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}

}
