package com.amazech.onsked.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

@Data
public class ServiceMaster implements Serializable {
    private String serviceCode;
    private List<MultipartFile> file1;
    private MultipartFile file2;
    private MultipartFile file3;
    private Integer loc_id;
    private String serviceName;
    private Integer categoryCode;
    private String description;
    private String isActive;
    private String categoryName;
    //From Resource Class
    private Integer bizId;
    private Integer resId;
    private Integer apptCount;
    //From service Class
    private String svcId;
    private String locSvcId;
    //From packages
    private String packageNames;
    private Integer apptCountCompleted;
    // From location to service
    private String clientLocation;
}
