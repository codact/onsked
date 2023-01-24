package com.amazech.onsked.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class AppointmentSchedule implements Serializable {

    private Integer apptId;

    private long timeInMilliSecs;

    private String courseId;

    private Integer bizId;

    private Integer smsId;

    private Integer locId;

    private String svcId;

    private Integer resId;

    private String startTime;

    private String endTime;

    private String statusCode;

    private String statusReasonCode;

    private Integer userId;

    private Integer clientId;

    private String createdDt;

    private Integer createdBy;

    private String modifiedDt;

    private Integer modifiedBy;

    private String modifiedName;

    private String isActive;

    private String rejectReason;

    private String formattedDate;

    private Integer duration;
    
    private String isSynchronized;

    private String tax;

    private String countryCode;

    private String countryCallingCode;

    private String roleCode;

    private String durationInReport;

    private String notifyBySMS;

    private String userType;

    private String resourceCellPhone;

    private String groupPkgName;

    private String groupPkgTypeId;

    private String groupPkgId;

    private String groupPkgPurchaseId;

    private Integer repairFormId;

    private Integer techFormId;

    private String pickUp;

    private String formStatusCode;

    private String formStatusName;

    private String  deliveryDateTime;

    private String clientLocation;

    private String clientAddressLine1;

    private String clientAddressLine2;

    private String clientCity;

    private String clientStateCode;

    private String clientCountryCode;

    private String clientZipCode;

    private String clientStateName;

    private String clientCountryName;

    private String pendingApptId;

    private String operation;

    private String appointmentAddress;
}
