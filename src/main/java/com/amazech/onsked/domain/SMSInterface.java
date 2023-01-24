package com.amazech.onsked.domain;


public interface SMSInterface {
	public void sendSMS();
    public String getCellNumber();
    public void setCellNumber(String cellNumber);
}