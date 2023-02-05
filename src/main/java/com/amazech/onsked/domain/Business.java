package com.amazech.onsked.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Business implements Serializable {
    private static final long serialVersionUID = 4861059402831272480L;
    private String onlinePayment;
    private Integer bizId;
    private String bizName;
    private String description;
    private String logo;
    private String categoryCode;
    private String contactFirstName;
    private String contactLastName;
    private String contactEmail;
    private String contactPhone;
    private String website;
    private String isActive;
    private String isSearchable;
    private Date createdDt;
    private Integer createdBy;
    private String modifiedDt;
    private Integer modifiedBy;
    private String isDeleted;
    private String allowUnregisteredUsers;
    private Boolean allowUnregisteredUsersFlag;
    private Boolean isSearchableFlag;
    private MultipartFile file;
    private List<MultipartFile> fileList;
    private String dateFormatId;
    private String reservationLeadTimeDays;
    private String reservationLeadTimeHours;
    private String reservationLeadTime;
    private String cancellationLeadTimeDays;
    private String cancellationLeadTimeHours;
    private String cancellationLeadTime;
    private Boolean notifyByEmailFlag;
    private Boolean displayCounterFlag;
    private Boolean notifyBySMSFlag;
    private Boolean notifyByPINFlag;
    private Boolean autoApproveRequestFlag;
    private String displayCounter;
    private String notifyByEmail;
    private String notifyBySMS;
    private String notifyByPIN;
    private String autoApproveRequest;
    private String bizIdList;
    private String bizNameList;
    private String bizAddressList;
    private Integer featuredBusinessListSize;
    private String bizWebsiteList;
    private String udf1;
    private String udf2;
    private String udf3;
    private String udf4;
    private String udf5;
    private String pageStatus;
    private Integer count;
    private String clientName;
    private Integer apptCount;
    private Integer locCount;
    private String countryCallingCode;

    private String categoryCodeSelected;

    private Integer userId;

    // Details of 'Location'
    private Integer locId;
    private String locName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String stateCode;
    private String zipCode;
    private String countryCode;
    private String currencyCode;
    private String timeZoneCode;
    private String phoneNumber1;
    private String phoneNumber2;
    private String faxNumber;
    private String isHeadquarters;
    private String isActiveLoc;

    // Details of 'Business Hours'
    private String dayOfWeek;
    private String isOpen;
    private String openTime;
    private String openTimeMin;
    private String openTimeAmPm;
    private String closeTime;
    private String closeTimeMin;
    private String closeTimeAmPm;
    private Integer day;
    private String packageName;
    private String serviceName;

    //Details of 'Category'
    private String categoryName;
    // page visits
    private Integer visitCount;
    //inventory
    private Boolean manageInventoryFlag;
    private String manageInventory;


    private Integer index;

    //promotion
    private String promotionName;
    private String promotionId;
    private String packageId;
    private Integer apptGranularity;

    // featured business
    private String bizIsActive;
    private String featuredBizIsActive;

    private String locIdList;
    private String svcIdList;
    private Integer pendingApptCount;
    private Integer upcomingApptCount;
    private String paypalHostedButtonId;
    private String authorizeApiLogInId;
    private String authorizeTransactionKey;

    // Google Maps for Android

    private String name;
    private String address;
    private String lat;
    private String lng;
    private String distance;

    //private String formattedDate;
    String monthsName[] = {"","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    public String formatDtFromyyyyMMddToMMMddyyyy(String frmDtFmt){
        return monthsName[Integer.parseInt(frmDtFmt.substring(5,7))]+"-"+frmDtFmt.substring(8, 10)+"-"+frmDtFmt.substring(0, 4);
    }
    //String monthsName[] = {"","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    public String formatDtFromMMddyyyyToMMMddyyyy(String frmDtFmt){
        return monthsName[Integer.parseInt(frmDtFmt.substring(0,2))]+"-"+frmDtFmt.substring(3,5)+"-"+frmDtFmt.substring(6,10);
    }

}
