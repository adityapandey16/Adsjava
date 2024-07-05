package com.app.prev;

//Custom exception for invalid index
public class InvalidIndexException extends RuntimeException {
	 public InvalidIndexException(String message) {
	        super(message);
	    }
}
