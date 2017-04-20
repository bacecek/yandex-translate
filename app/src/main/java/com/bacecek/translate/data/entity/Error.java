package com.bacecek.translate.data.entity;

/**
 * Created by Denis Buzmakov on 15/04/2017.
 * <buzmakov.da@gmail.com>
 */

public class Error {
	private int code;
	private String message;

	public Error() {
	}

	public Error(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}