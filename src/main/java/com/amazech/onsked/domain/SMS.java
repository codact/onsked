package com.amazech.onsked.domain;

import com.amazech.onsked.domain.SMSInterface;
import lombok.Data;

@Data
public class SMS implements SMSInterface {

	private String cellNumber;
	public void sendSMS(){
		System.out.println("This is just SMS dummy method for testing Spring" );

	}

	/**
	 * @return Returns the cellNumber.
	 */
	public String getCellNumber() {
		return cellNumber;
	}
	/**
	 * @param cellNumber The cellNumber to set.
	 */
	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}
}
