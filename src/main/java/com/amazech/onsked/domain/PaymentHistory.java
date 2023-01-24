package com.amazech.onsked.domain;

import java.io.Serializable;
import java.util.Date;
import com.amazech.onsked.domain.Business;
import lombok.Data;
//import sun.util.calendar.BaseCalendar.Date;

@Data
public class PaymentHistory implements Serializable {
	private static final long serialVersionUID = -2658809376558646712L;
	//package_name, amount, payment_dt, expiry_dt, level_desc, limit_appointments, 
    //limit_locations, limit_resources, limit_businesses, period_years, period_months, period_days
	//Date of purchase, Billed Amount, Billing mode(paypal, Creditcard, etc), duration, package name, expiry date
	//level_id, level_title, level_desc, limit_appointments, limit_locations, limit_resources, limit_businesses, period_years, period_months, period_days, is_active, cost;
	private String packageName;
	private float amount;
	private String paymentDt;
	private String expiryDt;
	private String levelDesc;
	private Integer limitAppointments;
	private Integer limitLocations;
	private Integer limitResources;
	private Integer limitBusinesses;
	private Integer periodYears;
	private Integer periodMonths;
	private Integer periodDays;
	private Integer duration;
	private String paymentMode;
	private Integer levelId;
	private Integer discount;
	private Integer discountType;

}