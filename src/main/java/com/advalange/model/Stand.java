package com.advalange.model;

public class Stand {
	private final String name;
	private final String ip;
	private final String username;
	private final String password;
	private final boolean busy;
	
	
	public Stand(String name, String ip, String username, String password, boolean busy) {
		super();
		this.name = name;
		this.ip = ip;
		this.username = username;
		this.password = password;
		this.busy = busy;
	}


	public String getName() {
		return name;
	}


	public String getIp() {
		return ip;
	}


	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}


	public boolean getBusy() {
		return busy;
	}
	
	
	
}