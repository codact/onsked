package com.amazech.onsked.service;

import com.amazech.onsked.domain.AppointmentSchedule;
import com.amazech.onsked.domain.Payment;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

public interface EaiSvc {
    public String makeDirectPayment(Payment payment) throws  MalformedURLException, UnsupportedEncodingException, IOException;
    public void sendSSLMessage( String recipient,
                                String message,Integer userId,Object request,String firstName,String requestPath);
    public void sendSMSAfterBookingAppointment(String cellPhone);

    public void sendAlertSMS(List<AppointmentSchedule> appts);

    public void sendSMSToBizAfterBookingAppointment(String cellPhone);
}
