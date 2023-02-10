package com.amazech.onsked.service.impl;

import com.amazech.onsked.domain.AppointmentSchedule;
import com.amazech.onsked.domain.Payment;
import com.amazech.onsked.service.EaiSvc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

public class EaiSvcImpl implements EaiSvc {
    @Override
    public String makeDirectPayment(Payment payment) throws MalformedURLException, UnsupportedEncodingException, IOException {
        return null;
    }

    @Override
    public void sendSSLMessage(String recipient, String message, Integer userId, Object request, String firstName, String requestPath) {

    }

    @Override
    public void sendSMSAfterBookingAppointment(String cellPhone) {

    }

    @Override
    public void sendAlertSMS(List<AppointmentSchedule> appts) {

    }

    @Override
    public void sendSMSToBizAfterBookingAppointment(String cellPhone) {

    }
}
