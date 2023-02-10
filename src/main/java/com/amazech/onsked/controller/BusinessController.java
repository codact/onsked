package com.amazech.onsked.controller;

import com.amazech.onsked.domain.*;
import com.amazech.onsked.exceptions.DataAccessException;
import com.amazech.onsked.service.BusinessSvc;
import com.amazech.onsked.service.UserSvc;
import com.amazech.onsked.util.OnskedList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.lang.Package;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

@Slf4j
@RestController
@RequestMapping("/api/v1/business")
public class BusinessController {

    @Autowired
    private BusinessSvc businessSvc;

    
    public ResponseEntity<Object> getCourseListForClient(Integer biz) {
        try {
             List<CourseSchedule> result = businessSvc.getCourseListForClient(biz);
            if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }
    
    public ResponseEntity<Object> addBusiness(Business business) {
        try {
                businessSvc.addBusiness(business);
                return new ResponseEntity<>(business, HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> addRepairForm(RepairForm repairForm, AppointmentSchedule appointmentSchedule, String requestPath) {
        try {
                String result = businessSvc.addRepairForm(repairForm, appointmentSchedule, requestPath);
            if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> updateRepairForm(RepairForm repairForm,AppointmentSchedule appointmentSchedule,RepairForm repairFormForUpdate,String requestPath) {
        try {
            String result = businessSvc.updateRepairForm(repairForm, appointmentSchedule, repairFormForUpdate,requestPath );
            if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Update details of existing Business
    
    public ResponseEntity<Object> updateBusiness(Business business) {
        try {
                businessSvc.updateBusiness( business);
                return new ResponseEntity<>(business, HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Update Basic Business details
    
    public ResponseEntity<Object> updateBasicBusinessDetails(Business business) {
        try {
                businessSvc.updateBasicBusinessDetails(business);
              if(business!=null)
                return new ResponseEntity<>(business, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the Businesses registered by a user using bizId
    
    public ResponseEntity<Object> getBusinessByBizId(Integer bizId) {
        try {
            Business result = businessSvc.getBusinessByBizId(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getLocationsByBizId(Integer bizId, Integer pageSize, Integer pageNo, String sortBy, String sort) {
        try {
                OnskedList result = businessSvc.getLocationsByBizId(bizId, pageSize, pageNo, sortBy, sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getResourcesByBizId(Integer bizId, Integer pageSize, Integer pageNo, String sortBy, String sort) {
        try {
                OnskedList result = businessSvc.getResourcesByBizId(bizId, pageSize, pageNo, sortBy,sort );
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the Businesses registered by a user using bizId
    
    public ResponseEntity<Object> getBusinessForAppoitmentByUserId(Integer userId) {
        try {
                List<Business> result = businessSvc.getBusinessForAppoitmentByUserId(userId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the Businesses registered by a user.(Checked for the location to be active as well)
    
    public ResponseEntity<Object> getBusiness(Integer userId) {
        try {
                Business result = businessSvc.getBusiness(userId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the Businesses registered by a user
    
    public ResponseEntity<Object> getBusinesses(Integer userId) {
        try {
                List<Business> result = businessSvc.getBusinesses(userId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getAllBusinessEntries(Integer userId) {
        try {
                List<Business> result = businessSvc.getAllBusinessEntries(userId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the Location for a User Business
    
    public ResponseEntity<Object> getLocation(Integer bizId) {
        try {
                Location result = businessSvc.getLocation(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the HeadquartersLocation for a User Business (Not to be a list actually)
    
    public ResponseEntity<Object> getHeadquartersLocation(Integer bizId) {
        try {
            Location result = businessSvc.getHeadquartersLocation(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the Location Details for based on locId
    
    public ResponseEntity<Object> getBusinessLocation(Integer locId) {
        try {
            Location result = businessSvc.getBusinessLocation(locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the Location Details by locId for location edit(Original Country and State Code)
    
    public ResponseEntity<Object> getBusinessLocationByLocId(Integer locId) {
        try {
            Location result = businessSvc.getBusinessLocationByLocId(locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get Master Services for a Given categoryCode
    
    public ResponseEntity<Object> getMasterServices(Integer categoryCode) {
        try {
            List<ServiceMaster> result = businessSvc.getMasterServices(categoryCode);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get Master Services for a Given bizId
    
    public ResponseEntity<Object> getBusinessMasterServices(Integer bizId) {
        try {
            List<ServiceMaster> result = businessSvc.getBusinessMasterServices(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get Unselected Business Master Services for a Given bizId
    
    public ResponseEntity<Object> getBusinessMasterServicesUnselected(Integer bizId,Integer categoryCode) {
        try {
            List<ServiceMaster> result = businessSvc.getBusinessMasterServicesUnselected(bizId, categoryCode);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get Resource Master Services for a Given resId
    
    public ResponseEntity<Object> getResourceMasterServices(Integer resId) {
        try {
            List<ServiceMaster> result = businessSvc.getResourceMasterServices(resId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get Resource Master Services which have not been previously opted for a Given resId
    
    public ResponseEntity<Object> getResourceMasterServicesUnselected(Integer bizId,Integer resId) {
        try {
            List<ServiceMaster> result = businessSvc.getResourceMasterServicesUnselected(bizId, resId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get Resource Master Services for a Given resId
    
    public ResponseEntity<Object> getResourceServices(Integer resId,Integer locId) {
        try {
            List<ServiceMaster> result = businessSvc.getResourceServices(resId, locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get Resource Master Services which have not been previously opted for a Given resId
    
    public ResponseEntity<Object> getResourceServicesUnselected(Integer locId,Integer resId) {
        try {
            List<ServiceMaster> result = businessSvc.getResourceServicesUnselected(locId, resId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get Services for a Business Resources Given bizId
    
    public ResponseEntity<Object> getResourceSvcByBizId(Integer bizId) {
        try {
            List<ServiceMaster> result = businessSvc.getResourceSvcByBizId(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get Location for a Business Resource Given bizId
    
    public ResponseEntity<Object> getResourceLocByBizId(Integer bizId) {
        try {
                List<Location> result = businessSvc.getResourceLocByBizId(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get Location for a Business Resource Given resId
    
    public ResponseEntity<Object> getResourceLocByResId(Integer resId){
        try {
                List<Location> result = businessSvc.getResourceLocByResId(resId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Add Master Services that are provided for a particular Business
    
    public ResponseEntity<Object> addBusinessMasterServices(ServiceMaster masterServices,Integer bizId) {
        try {
                businessSvc.addBusinessMasterServices(masterServices, bizId);
              if(masterServices!=null)
                return new ResponseEntity<>(masterServices, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Delete Master Services that are provided for a particular Business
    
    public ResponseEntity<Object> deleteBusinessMasterServices(String svcId,Integer loc,Integer modifiedBy) {
        try {
                businessSvc.deleteBusinessMasterServices(svcId, loc, modifiedBy);
              if(svcId!=null)
                return new ResponseEntity<>(svcId, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Add Master Services that are provided for a particular Business location
    
    public ResponseEntity<Object> addResourceMasterServices(Resource resource) {
        try {
                businessSvc.addResourceMasterServices(resource);
              if(resource!=null)
                return new ResponseEntity<>(resource, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Update Master Services that are provided for a particular Business location
    
    public ResponseEntity<Object> updateResourceMasterServices(Resource resource) {
        try {
                businessSvc.updateResourceMasterServices(resource);
              if(resource!=null)
                return new ResponseEntity<>(resource, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Remove Service provided for a Business by svcId
    
    public ResponseEntity<Object> removeServicesProvided(Integer svcId) {
        try {
               businessSvc.removeServicesProvided(svcId);
              if(svcId!=null)
                return new ResponseEntity<>(svcId, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the details for a given Resource
    
    public ResponseEntity<Object> getResource(Integer resId) {
        try {
                Resource result = businessSvc.getResource(resId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the  Resource by nick name
    
    public ResponseEntity<Object> getResourceByNickName(String nickName,Integer locId,Integer bizId) {
        try {
            Resource result = businessSvc.getResourceByNickName(nickName, locId, bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the resource by onsked user id
    
    public ResponseEntity<Object> getResourceByOnskedUserId(String onskedUserId) {
        try {
            List<Resource> result = businessSvc.getResourceByOnskedUserId(onskedUserId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Add a Resource to database
    
    public ResponseEntity<Object> addResource(Resource resource,String bizIsActive) {
        try {
                businessSvc.addResource(resource, bizIsActive);
              if(resource!=null)
                return new ResponseEntity<>(resource, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> saveResourceRatePerHour(Resource resource) {
        try {
                businessSvc.saveResourceRatePerHour(resource);
              if(resource!=null)
                return new ResponseEntity<>(resource, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> saveResourcePayoutPercentage(Resource resource) {
        try {
                businessSvc.saveResourcePayoutPercentage(resource);
              if(resource!=null)
                return new ResponseEntity<>(resource, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Add a Location to database
    
    public ResponseEntity<Object> addLocation(Location location,String bizIsActive) {
        try {
               businessSvc.addLocation(location, bizIsActive);
                return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Update details of Resource
    
    public ResponseEntity<Object> updateResource(Resource resource) {
        try {
                businessSvc.updateResource(resource);
              if(resource!=null)
                return new ResponseEntity<>(resource, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Update details of Resource
    
    public ResponseEntity<Object> updateBusinessResource(Resource resource,Integer locId) {
        try {
                businessSvc.updateBusinessResource(resource, locId);
              if(resource!=null)
                return new ResponseEntity<>(resource, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Update details of Business Location
    
    public ResponseEntity<Object> updateBusinessLocation(Location location) {
        try {
               businessSvc.updateBusinessLocation(location);
              if(location!=null)
                return new ResponseEntity<>(location, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the resources for a given business
    
    public ResponseEntity<Object> getResources(Integer bizId) {
        try {
            List<Resource> result = businessSvc.getResources(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get all the resources (including inactive and deleted) for a given business by biz id
    
    public ResponseEntity<Object> getAllResourcesOfBusinessByBizId(Integer bizId) {
        try {
            List<Resource> result = businessSvc.getAllResourcesOfBusinessByBizId(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the resources for a given Business Location by LocId
    
    public ResponseEntity<Object> getResourcesByLocId(Integer locId) {
        try {
            List<Resource> result = businessSvc.getResourcesByLocId(locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the locations for a given business
    
    public ResponseEntity<Object> getLocations(Integer bizId) {
        try {
                List<Location> result = businessSvc.getLocations(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

	/*	// Get the location for Business resources using bizId
	
    public ResponseEntity<Object> getResourceLocations(Integer bizId){
        try {
                String result = businessSvc.;
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }*/

    // Delete a Resource from database
    
    public ResponseEntity<Object> deleteResource(Integer resId,String bizIsActive,Integer locId,Integer userId) {
        try {
                businessSvc.deleteResource(resId, bizIsActive, locId, userId);
              if(resId!=null)
                return new ResponseEntity<>(resId, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Delete a Location from database
    
    public ResponseEntity<Object> deleteBusinessLocation(Integer locId,String bizIsActive,String userId) {
        try {
              businessSvc.deleteBusinessLocation(locId, bizIsActive, userId);
              if(locId!=null)
                return new ResponseEntity<>(locId, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> deleteCourseWithAppointment(String courseId,Integer userId, String requestPath) {
        try {
                businessSvc.deleteCourseWithAppointment(courseId, userId, requestPath);
              if(courseId!=null)
                return new ResponseEntity<>(courseId, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Add working hours of a Business to database
    
    public ResponseEntity<Object> addBusinessHours(BusinessHours businessHours) {
        try {
                businessSvc.addBusinessHours(businessHours);
              if(businessHours!=null)
                return new ResponseEntity<>(businessHours, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Add working hours of a Business to database
    
    public ResponseEntity<Object> addBusinessBasicHours(Business business) {
        try {
                businessSvc.addBusinessBasicHours(business);
              if(business!=null)
                return new ResponseEntity<>(business, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Add Working hours of a Business Location to the database
    
    public ResponseEntity<Object> addLocationHours(Location location) {
        try {
               businessSvc.addLocationHours(location);
              if(location!=null)
                return new ResponseEntity<>(location, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the working hours for a given Business
    
    public ResponseEntity<Object> getBasicBusinessHours(Integer bizId) {
        try {
            List<BusinessHours> result = businessSvc.getBasicBusinessHours(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the working hours for a given business location by bizId
    
    public ResponseEntity<Object> getLocationHoursByBizId(Integer bizId) {
        try {
            List<LocationHours> result = businessSvc.getLocationHoursByBizId(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the working hours for a given Business location
    
    public ResponseEntity<Object> getLocationHours(Integer locId) {
        try {
            List<LocationHours> result = businessSvc.getLocationHours(locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Add a Business Holiday to database
    
    public ResponseEntity<Object> addBusinessHoliday(BusinessHoliday businessHoliday) {
        try {
                businessSvc.addBusinessHoliday(businessHoliday);
              if(businessHoliday!=null)
                return new ResponseEntity<>(businessHoliday, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Delete a Holiday from Database
    
    public ResponseEntity<Object> deleteHoliday(Integer bizId, Integer locId) {
        try {
                businessSvc.deleteHoliday(bizId, locId);
              if(bizId!=null)
                return new ResponseEntity<>(bizId, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the Holidays for a given business location
    
    public ResponseEntity<Object> getHolidays(Integer bizId, Integer locId) {
        try {
            List<BusinessHoliday> result = businessSvc.getHolidays(bizId, locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the Holidays for a Business Holidays for a particular Location
    
    public ResponseEntity<Object> getBusinessLocationHolidaysHQ(Integer bizId, Integer locId) {
        try {
            List<BusinessHoliday> result = businessSvc.getBusinessLocationHolidaysHQ(bizId, locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the Holidays for a Business Holidays for a Business
    
    public ResponseEntity<Object> getHolidays(Integer bizId) {
        try {
            List<BusinessHoliday> result = businessSvc.getHolidays(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the Holiday registered for a business
    
    public ResponseEntity<Object> getHoliday(Integer bizId, Integer locId) {
        try {
            BusinessHoliday result = businessSvc.getHoliday(bizId, locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Update details of a Holiday in database
    
    public ResponseEntity<Object> updateHoliday(BusinessHoliday businessHoliday) {
        try {
                businessSvc.updateHoliday(businessHoliday);
              if(businessHoliday!=null)
                return new ResponseEntity<>(businessHoliday, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Update Business table; Set Business as Active
    
    public ResponseEntity<Object> setBusinessActive(Integer bizId,Integer userId) {
        try {
                businessSvc.setBusinessActive(bizId, userId);
              if(bizId!=null)
                return new ResponseEntity<>(bizId, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Update Business table; Set Business as InActive
    
    public ResponseEntity<Object> setBusinessInActive(Integer userId) {
        try {
               businessSvc.setBusinessInActive( userId);
                return new ResponseEntity<>(userId, HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get the Holiday registered for a business
    
    public ResponseEntity<Object> getHolidayByBizIdLocIdDate(Integer holidayId) {
        try {
                BusinessHoliday result = businessSvc.getHolidayByBizIdLocIdDate(holidayId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get the Holidaylist registered for a business
    
    public ResponseEntity<Object> getHolidayByHolidayId(Integer bizId, Integer locId) {
        try {
                List<BusinessHoliday> result = businessSvc.getHolidayByHolidayId(bizId, locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Delete the Holiday of particular location from database
    
    public ResponseEntity<Object> deleteHolidayByBizIdLocIdDate(Integer holidayId,Integer userId) {
        try {
                businessSvc.deleteHolidayByBizIdLocIdDate(holidayId, userId);

                return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Delete the Holiday of particular location from database
    
    public ResponseEntity<Object> deleteHolidayByBizIdLocIdHolidayDate(BusinessHoliday businessHoliday) {
        try {
               businessSvc.deleteHolidayByBizIdLocIdHolidayDate(businessHoliday);
                return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Update details of a Holiday in database
    
    public ResponseEntity<Object> updateHolidayByBizIdLocIdDate(BusinessHoliday businessHoliday) {
        try {
             businessSvc.updateHolidayByBizIdLocIdDate(businessHoliday);
             return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get service names
    
    public ResponseEntity<Object> getServiceNames(Integer bizId) {
        try {
            List<ServiceMaster> result = businessSvc.getServiceNames(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getServicesByLocIdBizId(Integer locId,Integer bizId) {
        try {
            List<ServiceListFromOutside> result = businessSvc.getServicesByLocIdBizId( locId, bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get locId by bizId
    
    public ResponseEntity<Object> getLocIdByBizId(Integer bizId) {
        try {
            Location result = businessSvc.getLocIdByBizId( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the working hours for a given Business location
    
    public ResponseEntity<Object> getBusinessHours(Integer bizId, String tmZnCode) {
        try {
            List<BusinessHours> result = businessSvc.getBusinessHours(bizId, tmZnCode);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // add location to service
    
    public ResponseEntity<Object> addLocationToService(LocationToService locationToService) {
        try {
                 businessSvc.addLocationToService(locationToService);
                 return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //update location to service
    
    public ResponseEntity<Object> updateLocationToService(LocationToService locationToService) {
        try {
                businessSvc.updateLocationToService(locationToService);

                return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the locationtoservice list using bizId
    
    public ResponseEntity<Object> getBusinessLocationToService(Integer bizId) {
        try {
            List<LocationToService>  result = businessSvc.getBusinessLocationToService( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the package details
    
    public ResponseEntity<Object> getPackageDetails(Integer bizId) {
        try {
            PackageDetails result = businessSvc.getPackageDetails( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the unique location to service to display it in package page
    
    public ResponseEntity<Object> getUniqueLocationToService(Integer bizId) {
        try {
            List<LocationToService> result = businessSvc.getUniqueLocationToService( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the unique location
    
    public ResponseEntity<Object> getUniqueLocation(Integer bizId) {
        try {
            List<LocationToService> result = businessSvc.getUniqueLocation(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the unique location to service using locId and bizId
    
    public ResponseEntity<Object> getUniqueLocationToServiceByLocIdBizId(Integer locId,Integer bizId) {
        try {
            List<ServiceMaster> result = businessSvc.getUniqueLocationToServiceByLocIdBizId( locId, bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getServiceListByBizIdCategoryCodeLocId(Integer bizId,Integer categoryCode,Integer locId) {
        try {
            List<ServiceMaster> result = businessSvc.getServiceListByBizIdCategoryCodeLocId( bizId, categoryCode, locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // delete location to service of business
    
    public ResponseEntity<Object> deleteLocationToService(Integer bizId) {
        try {
               businessSvc.deleteLocationToService( bizId);

                return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // delete location to service using locId and svcId
    
    public ResponseEntity<Object> deleteLocationToServiceBySvcIdLocId(Integer locId,Integer svcId,Integer userId) {
        try {
               businessSvc.deleteLocationToServiceBySvcIdLocId( locId, svcId, userId);

                return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the locations for a adding service
    
    public ResponseEntity<Object> getLocationListForAddingSvc(Integer bizId) {
        try {
                List<Location> result = businessSvc.getLocationListForAddingSvc( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // delete resource to service using resId and svcId
    
    public ResponseEntity<Object> deleteResourceToServiceByResIdSvcId(Integer resId,Integer svcId, Integer locId,Integer userId) {
        try {
            businessSvc.deleteResourceToServiceByResIdSvcId( resId, svcId,  locId, userId);
             return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the resource to service by resId
    
    public ResponseEntity<Object> getResourceToServiceByResId(Integer resId) {
        try {
            List<Resource> result = businessSvc.getResourceToServiceByResId(resId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the location by using its nick name.. used to store the unique location nick name for location
    
    public ResponseEntity<Object> getLocationByNickName(String locName, Integer bizId) {
        try {
            Location result = businessSvc.getLocationByNickName( locName,  bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the business by using its name and email.. used to store the unique business name for location
    
    public ResponseEntity<Object>  getBusinessByBizNameEmail(String bizName,String email) {
        try {
            Business result = businessSvc.getBusinessByBizNameEmail( bizName, email);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get user by userId
    
    public ResponseEntity<Object> getUserByUserId(Integer userId) {
        try {
            Resource result = businessSvc.getUserByUserId( userId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the user by his email id
    
    public ResponseEntity<Object> getUserByEmailId(String emailId) {
        try {
            Resource result = businessSvc.getUserByEmailId( emailId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Add Working hours of a resource to the database
    
    public ResponseEntity<Object> addResourceHours(Resource resource) {
        try {
                businessSvc.addResourceHours( resource);

                return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> addResourceCertificate(ResourceCertificate resourceCertificate) {
        try {
              businessSvc.addResourceCertificate(resourceCertificate);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the list of resource hours using resId
    
    public ResponseEntity<Object> getResourceHours(Integer resId) {
        try {
            List<ResourceHours> result = businessSvc.getResourceHours( resId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the list of resource hours using bizId
    
    public ResponseEntity<Object> getResourceHoursByBizId(Integer bizId) {
        try {
            List<ResourceHours> result = businessSvc.getResourceHoursByBizId( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getResHoursByBizId(Integer bizId){
        try {
                List<ResourceHours> result = businessSvc.getResHoursByBizId(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // function to get the default holidays for the branches
    
    public ResponseEntity<Object> getDefaultHolidayForBranches(String locId, String countryCode) {
        try {
            List<BusinessHoliday> result = businessSvc.getDefaultHolidayForBranches( locId,  countryCode);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the business holidays by its country code
    
    public ResponseEntity<Object> getHolidaysByCountryCode(String countryCode) {
        try {
            List<Holiday> result = businessSvc.getHolidaysByCountryCode( countryCode);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // function to get the default holidays for the branches in date and month format
    
    public ResponseEntity<Object> getDefaultHolidayForBranchesInDateNMonth(String locId, String countryCode) {
        try {
            List<BusinessHoliday> result = businessSvc.getDefaultHolidayForBranchesInDateNMonth( locId,  countryCode);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Add the Service offered by business to database
    
    public ResponseEntity<Object> addService(Service service) {
        try {
            businessSvc.addService(service);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Update the Services for a given blsId
    
    public ResponseEntity<Object> updateService(Service service) {
        try {
              businessSvc.updateService( service);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Delete a Service from database
    
    public ResponseEntity<Object> deleteService(Integer svcId) {
        try {
              businessSvc.deleteService(svcId);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the Services for a given blsId
    
    public ResponseEntity<Object> getService(Integer svcId) {
        try {
            Service result = businessSvc.getService(svcId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the Services offered by a given business
    
    public ResponseEntity<Object> getServices(Integer bizId) {
        try {
            List<Service> result = businessSvc.getServices(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get list of business holiday uisng locId
    
    public ResponseEntity<Object> getHolidayByLocId(Integer locId) {
        try {
            List<BusinessHoliday> result = businessSvc.getHolidayByLocId(locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the list of business holiday in format yyyyMMdd using locID
    
    public ResponseEntity<Object> getHolidayByLocIdInFormatyyyyMMdd(Integer locId) {
        try {
            List<BusinessHoliday> result = businessSvc.getHolidayByLocIdInFormatyyyyMMdd(locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the business holiday by bizId and locId
    
    public ResponseEntity<Object> getBusinessHolidayByBizIdLocId(Integer bizId,Integer locId) {
        try {
            List<BusinessHoliday> result = businessSvc.getBusinessHolidayByBizIdLocId( bizId, locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the location to service list using the locId and svcId
    
    public ResponseEntity<Object> getLocationToServiceByLocIdSvcId(Integer locId,Integer svcId) {
        try {
            List<LocationToService> result = businessSvc.getLocationToServiceByLocIdSvcId( locId, svcId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // update isDeleted flag of business to delete the business
    
    public ResponseEntity<Object> deleteBusiness(Integer bizId,Integer userId) {
        try {
               businessSvc.deleteBusiness( bizId, userId);
             return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> deleteBusinessByDownGrade(String bizId,Integer userId) {
        try {
            businessSvc.deleteBusinessByDownGrade( bizId, userId);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> deleteLocationByDownGrade(Integer locId,Integer userId) {
        try {
                businessSvc.deleteLocationByDownGrade( locId, userId);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> deleteResourceByDownGrade(String resId,Integer locId,Integer userId) {
        try {
              businessSvc.deleteResourceByDownGrade( resId, locId, userId);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Method to add package details to database
    
    public ResponseEntity<Object> addPackage(Package pack, String commandName) {
        try {
               businessSvc.addPackage( pack,  commandName);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Method to delete a package from the database
    
    public ResponseEntity<Object> deletePackageByLocToSvcId(Integer locToSvcId) {
        try {
            businessSvc.deletePackageByLocToSvcId(locToSvcId);
             return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get all the Active registered Businesses
    
    public ResponseEntity<Object> getAllBusinesses() {
        try {
                List<Business> result = businessSvc.getAllBusinesses();
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //-----
    
    public ResponseEntity<Object> getPackageDetailsOfBusiness(Integer bizId) {
        try {
            PackageDetails result = businessSvc.getPackageDetailsOfBusiness( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get all Leave reasons list
    
    public ResponseEntity<Object> getLeaveTypes() {
        try {
            List<LeaveReason> result = businessSvc.getLeaveTypes();
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Add the resource leave details to the database
    
    public ResponseEntity<Object> addResourceLeave(ResourceLeaveSchedule resourceLeaveSchedule) {
        try {
               businessSvc.addResourceLeave( resourceLeaveSchedule);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get all Business Clients
    
    public ResponseEntity<Object>  getAllClients(Integer bizId,Integer pageSize, Integer pageNo, String sortBy, String sort, String startDate, String endDate, String clientStatus) {
        try {
            OnskedList result = businessSvc.getAllClients( bizId, pageSize,  pageNo,  sortBy,  sort,  startDate,  endDate,  clientStatus);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get all Business Clients With More Options
    
    public ResponseEntity<Object> getAllClientsMoreOptions(Integer bizId,Integer pageSize, Integer pageNo, String sortBy, String sort,String countMin,String countMax,String valueMin,String valurMax, String svcId, String statusCode, String startDate, String endDate, String clientStatus, String pkgId, String locId) {
        try {
            OnskedList result = businessSvc.getAllClientsMoreOptions( bizId, pageSize,  pageNo,  sortBy,  sort, countMin, countMax, valueMin, valurMax,  svcId,  statusCode,  startDate,  endDate,  clientStatus,  pkgId,  locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Add business Client
    
    public ResponseEntity<Object> addBizClient(Client client,String requestPath) {
        try {
            Integer result = businessSvc.addBizClient( client, requestPath);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> addBizClientAddInfo(ClientReferral clientReferral) {
        try {
              businessSvc.addBizClientAddInfo(clientReferral);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> updateBizClientAddInfo(ClientReferral clientReferral) {
        try {
               businessSvc.updateBizClientAddInfo(clientReferral);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getClientReferralPresentByClientId(Integer clientId) {
        try {
            Integer result = businessSvc.getClientReferralPresentByClientId(clientId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // delete the resource hours for a resource
    
    public ResponseEntity<Object> deleteResourceHours(Integer resId,Integer locId) {
        try {
                businessSvc.deleteResourceHours(resId, locId);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the business holiday by bizId, locId and year of holiday
    
    public ResponseEntity<Object> getBusinessHolidayByBizIdLocIdYearOfHoliday(Integer bizId,Integer locId, Integer yr, Integer pageSize, Integer pageNo, String sortBy, String sort) {
        try {
            OnskedList result = businessSvc.getBusinessHolidayByBizIdLocIdYearOfHoliday(bizId,locId ,yr,pageSize, pageNo, sortBy, sort );
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the resource tile by bizId
    
    public ResponseEntity<Object> getResourceTitleByBizId(Integer bizId) {
        try {
            Category result = businessSvc.getResourceTitleByBizId(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the package count of business by biz id
    
    public ResponseEntity<Object> getPackageCountOfBusinessByBizId(Integer bizId) {
        try {
            Integer result = businessSvc.getPackageCountOfBusinessByBizId( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // set the is_active column of business table
    
    public ResponseEntity<Object> activateDeactivate(String table,String updateColumn, String updateColumnValue,String conditionColumn, String conditionColumnValue) {
        try {
                 businessSvc.activateDeactivate( table, updateColumn,  updateColumnValue, conditionColumn,  conditionColumnValue);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get timezone code by locId
    
    public ResponseEntity<Object> getTimeZoneCodeByLocId(Integer locId) {
        try {
                String result = businessSvc.getTimeZoneCodeByLocId(locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getBusinessExpiryDate(Integer bizId) {
        try {
                String result = businessSvc.getBusinessExpiryDate(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get Business Hours wrt timezone of a location
    
    public ResponseEntity<Object> getBizHrsWrtTimeZn(Integer bizId,String timeZoneCode, String bizTimeZoneCode) {
        try {
            List<BusinessHours> result = businessSvc.getBizHrsWrtTimeZn(bizId, timeZoneCode, bizTimeZoneCode);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get Location Hours of location wrt its timeZone
    
    public ResponseEntity<Object> getLocHrsWrtTmZone(Integer locId1, String srcTz) {
        try {
            List<LocationHours> result = businessSvc.getLocHrsWrtTmZone(locId1,srcTz);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the list of locations added after confirming the business
    
    public ResponseEntity<Object> getListOfLocationsAddedAfterBizConfirmation(Integer bizId) {
        try {
                List<Location> result = businessSvc.getListOfLocationsAddedAfterBizConfirmation(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the list of locations which are inactive
    
    public ResponseEntity<Object> getListOfInactiveBusinessLocationsWithoutService(Integer bizId) {
        try {
                List<Location> result = businessSvc.getListOfInactiveBusinessLocationsWithoutService(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get the Client details by client Id
    
    public ResponseEntity<Object> getClientDtlsByClientId(Integer clientId) {
        try {
            Client result = businessSvc.getClientDtlsByClientId(clientId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getClientAddInfoByClientId(Integer clientId) {
        try {
            ClientReferral result = businessSvc.getClientAddInfoByClientId(clientId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Update Business Client details
    
    public ResponseEntity<Object> updateClientDetails(Client cmdClient) {
        try {
              businessSvc.updateClientDetails(cmdClient);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get Client details for viewing
    
    public ResponseEntity<Object> getClientDtls(Integer clientId){
        try {
            Client result = businessSvc.getClientDtls(clientId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the timezone code of business user
    
    public  ResponseEntity<Object> getTimeZoneCodeOfBizUser(Integer bizId) {
        try {
                String result = businessSvc.getTimeZoneCodeOfBizUser(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get all the clients of business filtered by search element
    
    public  ResponseEntity<Object> getClientsByBizIDSearchElement(Integer bizId, String searchElement,Integer pageSize,Integer pageNo,String sortBy,String sort, String startDate, String endDate, String clientEmail, String clientPhone, String clientStatus) {
        try {
            OnskedList result = businessSvc.getClientsByBizIDSearchElement(bizId, searchElement,pageSize, pageNo, sortBy, sort , startDate, endDate, clientEmail, clientPhone, clientStatus);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get all the clients of business filtered by search element with more options
    
    public  ResponseEntity<Object> getClientsByBizIDSearchElementMoreOptions(Integer bizId, String searchElement,Integer pageSize,Integer pageNo,String sortBy,String sort,String countMin,String countMax, String valueMin, String valueMax, String svcId, String statusCode, String startDate, String endDate, String clientStatus, String pkgId, String locId,String clientEmail, String clientPhone) {
        try {
            OnskedList result = businessSvc.getClientsByBizIDSearchElementMoreOptions( bizId,  searchElement, pageSize, pageNo, sortBy, sort, countMin, countMax,  valueMin,  valueMax,  svcId,  statusCode,  startDate,  endDate,  clientStatus,  pkgId,  locId, clientEmail,  clientPhone);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //gets all featured Business details
    
    public  ResponseEntity<Object> getFeaturedBusinesses() {
        try {
            List<Business> result = businessSvc.getFeaturedBusinesses();
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public  ResponseEntity<Object> getCourseDetails() {
        try {
            List<Course> result = businessSvc.getCourseDetails();
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public  ResponseEntity<Object> getCourseDetailsBySort(Integer userId,Integer pageSize,Integer pageNo,String sortBy,String sort) {
        try {
            OnskedList result = businessSvc.getCourseDetailsBySort( userId, pageSize, pageNo, sortBy, sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public  ResponseEntity<Object> getCourseDetailsByCourseId(String courseId) {
        try {
            Course result = businessSvc.getCourseDetailsByCourseId( courseId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> activateDeletedBusiness(Integer bizId,Integer userId, String requestPath) {
        try {
                businessSvc.activateDeletedBusiness( bizId, userId,  requestPath);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> deleteResourceCertificateByResCertId(Integer resId,Integer resCertId) {
        try {
               businessSvc.deleteResourceCertificateByResCertId( resId, resCertId);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get the services for location, whose packages are to be used
    
    public ResponseEntity<Object> getPackagesByLocIdSvcId(Integer locId, Integer svcId, Integer bizId){
        try {
            List<Package> result = businessSvc.getPackagesByLocIdSvcId( locId,  svcId,  bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getGroupPkgType(){
        try {
            List<GroupPackage> result = businessSvc.getGroupPkgType();
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getPackagesByLocIdResId(Integer locId, Integer resId){
        try {
            List<Package> result = businessSvc.getPackagesByLocIdResId( locId,  resId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Add the Promotion by Location,Service,Package to database
    
    public ResponseEntity<Object> addPromotion(Promotion promotion){
        try {
            Integer result = businessSvc.addPromotion( promotion);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the details for a given Resource of a location
    
    public ResponseEntity<Object> getResourceOfLocation(Integer resId,Integer locId) {
        try {
            Resource result = businessSvc.getResourceOfLocation( resId, locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the list of resource hours using resId and locId
    
    public ResponseEntity<Object> getResourceHoursByResIdLocId(Integer resId,Integer locId) {
        try {
            List<ResourceHours> result = businessSvc.getResourceHoursByResIdLocId( resId, locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object>  getResourceCertificateByResId(Integer resId) {
        try {
            List<ResourceCertificate> result = businessSvc.getResourceCertificateByResId( resId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the details for a given Resource
    
    public ResponseEntity<Object> getResourceByResId(Integer resId) {
        try {
            Resource result = businessSvc.getResourceByResId( resId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getapptIdByCourseId(String courseId) {
        try {
                String result = businessSvc.getapptIdByCourseId( courseId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the list of resource hours using resId of all the locations
    
    public ResponseEntity<Object> getResourceHoursOfAllLocations(Integer resId) {
        try {
            List<ResourceHours> result = businessSvc.getResourceHoursOfAllLocations( resId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the  Resource by email
    
    public ResponseEntity<Object> getResourceByEmail(String email) {
        try {
            Resource result = businessSvc.getResourceByEmail( email);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getResourceByEmailIsDeleted(String email) {
        try {
            Resource result = businessSvc.getResourceByEmailIsDeleted( email);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getResourceByDiffNickName(String email,String nickName) {
        try {
            Resource result = businessSvc.getResourceByDiffNickName( email, nickName);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }
    // Get the resource by email id and loc Id
    
    public ResponseEntity<Object> getResourceByLocIdAndEmail(String locId,String email) {
        try {
            Resource result = businessSvc.getResourceByLocIdAndEmail( locId, email);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Method to update the client location package
    
    public ResponseEntity<Object> updateLocationToSvc(Package pack) {
        try {
                 businessSvc.updateLocationToSvc( pack);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Method to get address of client for mailing
    
    public ResponseEntity<Object> getAddressOfClient(String clientId) {
        try {
                String result = businessSvc.getAddressOfClient( clientId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getclientLocationOrNot(String locId,String svcId) {
        try {
                String result = businessSvc.getclientLocationOrNot( locId, svcId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Method to get address of location for mailing
    
    public ResponseEntity<Object> getAddressOfLocation(String locId) {
        try {
                String result = businessSvc.getAddressOfLocation( locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get appointment count for res_id before deleting resource
    
    public ResponseEntity<Object> getApptCountToResource(String resId,String locId){
        try {
            Integer result = businessSvc.getApptCountToResource( resId, locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Edit Promotion by Promotion id
    
    public ResponseEntity<Object> getPromotionByPromotionId(Integer promotionId){
        try {
                Promotion result = businessSvc.getPromotionByPromotionId( promotionId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get all the past promotion until current date
    
    public ResponseEntity<Object> getPastPromotion(String curDate, Integer bizId,Integer pageSize,Integer pageNo,String sortBy,String sort){
        try {
            OnskedList result = businessSvc.getPastPromotion( curDate,  bizId, pageSize, pageNo, sortBy, sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get all the saved promotion
    
    public ResponseEntity<Object> getSavedPromotion(Integer bizId,Integer pageSize,Integer pageNo,String sortBy,String sort){
        try {
            OnskedList result = businessSvc.getSavedPromotion( bizId, pageSize, pageNo, sortBy, sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get all the past Inactive promotion until current date
    
    public ResponseEntity<Object> getPastInactivePromotion(String curDate,Integer bizId,Integer pageSize,Integer pageNo,String sortBy,String sort) {
        try {
            OnskedList result = businessSvc.getPastInactivePromotion( curDate, bizId, pageSize, pageNo, sortBy, sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Update the promotion to disable
    
    public ResponseEntity<Object> disablePromotion(Integer promotionId){
        try {
                businessSvc.disablePromotion( promotionId);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Delete the promotion
    
    public ResponseEntity<Object> deletePromotion(Integer promotionId){
        try {
               businessSvc.deletePromotion(promotionId);
             return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Add data to clients to access promotion
    
    public ResponseEntity<Object> addDataToClients(String destinationDir){
        try {
               businessSvc.addDataToClients(destinationDir);
               return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get active promotion details
    
    public ResponseEntity<Object> getActivePromotion(Integer bizId){
        try {
            List<Promotion> result = businessSvc.getActivePromotion( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get additional Information from business table
    
    public ResponseEntity<Object> getAdditional(Integer bizId){
        try {
            Business result = businessSvc.getAdditional(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Edit additional Information from business table
    
    public ResponseEntity<Object> getAdditionalEdit(Integer bizId1){
        try {
               businessSvc.getAdditionalEdit(bizId1);
                return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get upcoming promotion details
    
    public ResponseEntity<Object> getUpComingPromotion(String curDate, Integer bizId,Integer pageSize,Integer pageNo,String sortBy,String sort) {
        try {
            OnskedList result = businessSvc.getUpComingPromotion( curDate,  bizId, pageSize, pageNo, sortBy, sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get ongoing promotion details
    
    public ResponseEntity<Object> getOngoingPromotion(String curDate, Integer bizId,Integer pageSize,Integer pageNo,String sortBy,String sort) {
        try {
            OnskedList result = businessSvc.getOngoingPromotion( curDate,  bizId, pageSize, pageNo, sortBy, sort) ;
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Update the Promotion by Location,Service,Package to database
    
    public ResponseEntity<Object> updatePromotion(Promotion promotion){
        try {
                businessSvc.updatePromotion( promotion);
             return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get business rating from appointment table
    
    public ResponseEntity<Object>  getAppointmentRatingByBizId(Integer bizId){
        try {
            Double result = businessSvc.getAppointmentRatingByBizId(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get all the Active registered Businesses Promotion
    
    public ResponseEntity<Object> getBusinessPromotion(Integer userId){
        try {
            List<Business> result = businessSvc.getBusinessPromotion( userId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }
    //Delete the past promotion
    
    public ResponseEntity<Object> disablePastPromotion(Integer promotionId){
        try {
               businessSvc.disablePastPromotion( promotionId);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get all the business which are active
    
    public ResponseEntity<Object> getBusinessesByUserIdByPromotionId(Integer userId){
        try {
            List<Business> result = businessSvc.getBusinessesByUserIdByPromotionId( userId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get promotion id by promotion code
    
    public ResponseEntity<Object>  getPromotionByPromotionCode(String promotionCode,String svcId,Integer locId,String date, Integer userId,Integer pkgId){
        try {
            Boolean result = businessSvc.getPromotionByPromotionCode( promotionCode, svcId, locId, date,  userId, pkgId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get promotion id by promotion code by client Id
    
    public ResponseEntity<Object> getPromotionByPromotionCodeByClientId(String promotionCode, String svcId, Integer locId, String date, String clientId,Integer pkgId){
        try {
            Boolean result = businessSvc.getPromotionByPromotionCodeByClientId( promotionCode,  svcId,  locId,  date,  clientId, pkgId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // check promotion code exits or not
    
    public ResponseEntity<Object> checkPromotionCodeExist(String promotionCode){
        try {
            Integer result = businessSvc.checkPromotionCodeExist( promotionCode);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get old promotion code
    
    public ResponseEntity<Object> oldPromotionCode(Integer promotionId){
        try {
                String result = businessSvc.oldPromotionCode( promotionId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getCountOfApptsToLoc(Integer locId){
        try {
            Integer result = businessSvc.getCountOfApptsToLoc( locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getApptCntToBiz(Integer bizId){
        try {
            Integer result = businessSvc.getApptCntToBiz( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getResourceHoursByLocation(Integer resId, Integer locId1){
        try {
            List<ResourceHours> result = businessSvc.getResourceHoursByLocation( resId,  locId1);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get all the services for the location by bizId
    
    public ResponseEntity<Object> getLocationScvByBizId(Integer bizId){
        try {
                List<Location> result = businessSvc.getLocationScvByBizId( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get all promotion id by userid
    
    public ResponseEntity<Object> getUserBusinessPromotion(Integer userId){
        try {
            List<Business> result = businessSvc.getUserBusinessPromotion( userId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get count of the event booked at same time with same locId, BizId, svcId, resId
    
    public ResponseEntity<Object> getAppointmentsCount(Integer bizId,Integer locId,String svcId,Integer resId,String startTime){
        try {
            Integer result = businessSvc.getAppointmentsCount( bizId, locId, svcId, resId, startTime);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the Location for a User Business
    // Get the locations for a given business
    
    public ResponseEntity<Object> getLocationPackageExist(Integer bizId) {
        try {
                List<Location> result = businessSvc.getLocationPackageExist( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> addMaterial(Materials material){
        try {
               businessSvc.addMaterial( material);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> checkForDupliceteMaterial(String matName,Integer bizId){
        try {
                Integer result = businessSvc.checkForDupliceteMaterial( matName, bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getMaterialsByBizId(Integer bizId,Integer pkgId){
        try {
            List<Materials> result = businessSvc.getMaterialsByBizId( bizId, pkgId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getMaterialsByBizIdByMatId(Integer bizId,Integer pkgId,Integer matId){
        try {
            List<Materials> result = businessSvc.getMaterialsByBizIdByMatId( bizId, pkgId, matId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> addMaterialToPkg(MatToPackage mat){
        try {
               businessSvc.addMaterialToPkg( mat);
               return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getActiveBusinessesByUserId(Integer userId){
        try {
            List<Business> result = businessSvc.getActiveBusinessesByUserId( userId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getPkgsToSvcsByLocId(Integer locId){
        try {
            List<Package> result = businessSvc.getPkgsToSvcsByLocId(locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getMaterialsToPkgByLocSvcId(Integer pkgId){
        try {
            List<MatToPackage> result = businessSvc.getMaterialsToPkgByLocSvcId( pkgId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getMaterialAndQtyByMatId(String matId, Integer pkg){
        try {
            MatToPackage result = businessSvc.getMaterialAndQtyByMatId( matId,  pkg);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> updateMatMaster(Materials mtp){
        try {
              businessSvc.updateMatMaster( mtp);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getMatByMatId(Integer matId){
        try {
            Materials result = businessSvc.getMatByMatId( matId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> updateMatToPkg(Integer pkg, String materialId,
                        String qtyNeeded, Integer matId){
        try {
               businessSvc.updateMatToPkg( pkg,  materialId, qtyNeeded,  matId);
               return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> deleteMaterialToPackage(MatToPackage mtp){
        try {
              businessSvc.deleteMaterialToPackage( mtp);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getMaterialsListByBizId(Integer bizId){
        try {
            List<Materials> result = businessSvc.getMaterialsListByBizId(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> getMatCountByMatNameAndManufacturer(Integer bizId, String matName,String manufacturer){
        try {
                Integer result = businessSvc.getMatCountByMatNameAndManufacturer( bizId,  matName, manufacturer);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> updateMasterMaterial(Materials cmdMat){
        try {
               businessSvc.updateMasterMaterial( cmdMat);
               return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> checkForPkgUsingMaterial(Integer matId){
        try {
                Integer result = businessSvc.checkForPkgUsingMaterial( matId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> deleteMasterMaterialByMatId(Integer matId){
        try {
              businessSvc.deleteMasterMaterialByMatId( matId);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> addPurchase(PurchaseHeader cmdPurchaseHeader){
        try {
                Integer result = businessSvc.addPurchase( cmdPurchaseHeader);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getBasicPurchaseDetailsByPid(Integer pId,Integer bizId){
        try {
                PurchaseHeader result = businessSvc.getBasicPurchaseDetailsByPid( pId, bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> addPurchaseDetails(PurchaseDetails temp_pd){
        try {
              businessSvc.addPurchaseDetails( temp_pd);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> updateBasicPurchaseMaterial(PurchaseHeader cmdPurchaseHeader){
        try {
              businessSvc.updateBasicPurchaseMaterial( cmdPurchaseHeader);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> stocksCronjob(){
        try {
               businessSvc.stocksCronjob();
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getStocksToLocId(Integer locId,Integer pageSize, Integer pageNo, String sortBy, String sort){
        try {
            OnskedList result = businessSvc.getStocksToLocId( locId, pageSize,  pageNo,  sortBy,  sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> getInventoryBizCountByUserId(Integer userId){
        try {
                Integer result = businessSvc.getInventoryBizCountByUserId(userId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> updatePurchaseHeader(Integer purchaseId){
        try {
              businessSvc.updatePurchaseHeader( purchaseId);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getLocsToBizWhichHasActiveRes(Integer bizId){
        try {
                List<Location> result = businessSvc.getLocsToBizWhichHasActiveRes(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getClientInfoForBizCal(Integer bizId){
        try {
                List<Client> result = businessSvc.getClientInfoForBizCal( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getClientInfoForCourseCal(Integer bizId){
        try {
                List<Client> result = businessSvc.getClientInfoForCourseCal( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get all the business which are active with limit
    
    public ResponseEntity<Object> getBusinessesByUserIdByPromotionIdByLimitBySort(Integer userId,Integer pageSize,Integer pageNo,String sortBy,String sort){
        try {
            OnskedList result = businessSvc.getBusinessesByUserIdByPromotionIdByLimitBySort( userId, pageSize, pageNo, sortBy, sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }
    //get all the service for all the categories of that business
    
    public ResponseEntity<Object> getMasterServicesByBizId(Integer bizId) {
        try {
            List<ServiceMaster> result = businessSvc.getMasterServicesByBizId( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get all the service for all the categories which are not opted by the business
    
    public ResponseEntity<Object> getServiceListByBizIdLocId(Integer bizId,Integer loc){
        try {
            List<ServiceMaster> result = businessSvc.getServiceListByBizIdLocId( bizId, loc);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get all the categories selected by the business not selected
    
    public ResponseEntity<Object> getBusinessCategoriesNotSelected(Integer bizId){
        try {
            List<Category> result = businessSvc.getBusinessCategoriesNotSelected( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get all the categories selected by the business and selected
    
    public ResponseEntity<Object> getBusinessCategoriesSelected(Integer bizId){
        try {
            List<Category> result = businessSvc.getBusinessCategoriesSelected(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get all the categories selected by the business and used
    
    public ResponseEntity<Object> getBusinessCategoriesUsed(Integer bizId){
        try {
            List<Category> result = businessSvc.getBusinessCategoriesUsed( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get all the categories selected by the business
    
    public ResponseEntity<Object> getBusinessCategories(Integer bizId){
        try {
            List<Category> result = businessSvc.getBusinessCategories( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> getApptCountToResourcePast(String resId,String locId){
        try {
                Integer result = businessSvc.getApptCountToResourcePast( resId, locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getResourceToLocationByNickName(String nickName, Integer locId,
                                             Integer bizId){
        try {
            Resource result = businessSvc.getResourceToLocationByNickName( nickName,  locId, bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getResourceByNickNamelist(String nickName, Integer locId, Integer bizId){
        try {
            List<Resource> result = businessSvc.getResourceByNickNamelist( nickName,  locId,  bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getResourceToLocationByNickNameList(String nickName, Integer locId, Integer bizId){
        try {
            List<Resource> result = businessSvc.getResourceToLocationByNickNameList( nickName,  locId,  bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> addResourceToService(Integer locId, Integer resId, String svcId, Integer userId){
        try {
              businessSvc.addResourceToService( locId,  resId,  svcId,  userId);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> updateLocationToResource(Integer locId, Integer resId, Integer userId){
        try {
               businessSvc.updateLocationToResource( locId,  resId,  userId);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getUniqueLocationToServiceByLocIdBizIdforCategoryCode(
            Integer loc, Integer bizId){
        try {
            List<ServiceMaster> result = businessSvc.getUniqueLocationToServiceByLocIdBizIdforCategoryCode(loc, bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getUniqueLocationToServiceByLocIdBizIdOnCategoryCode(Integer locId, Integer bizId){
        try {
            List<ServiceMaster> result = businessSvc.getUniqueLocationToServiceByLocIdBizIdOnCategoryCode( locId,  bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getResourceServicesByCategory(Integer resId, Integer locId){
        try {
            List<ServiceMaster> result = businessSvc.getResourceServicesByCategory( resId,  locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> getApptCountToService(Integer svcId, Integer loc){
        try {
                Integer result = businessSvc.getApptCountToService( svcId,  loc);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> getApptCountToResourceService(Integer locId, Integer resId, Integer svcId){
        try {
                Integer result = businessSvc.getApptCountToResourceService( locId,  resId,  svcId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> getResCountToService(Integer svcId, Integer loc){
        try {
                Integer result = businessSvc.getResCountToService( svcId,  loc);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> checkToDelSvc(Integer svcId, Integer loc){
        try {
            OnskedList result = businessSvc.checkToDelSvc( svcId,  loc);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> addMaterialAndGetMatId(Materials cmdMat){
        try {
                Integer result = businessSvc.addMaterialAndGetMatId( cmdMat);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> checkDuplicateClientInBiz(String email, Integer bizId){
        try {
                Integer result = businessSvc.checkDuplicateClientInBiz( email,  bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getPackageDetails1(Integer bizId){
        try {
            List<Package> result = businessSvc.getPackageDetails1( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getPackageDetailsByLocSvcId(String svcId, Integer pkgId){
        try {
            List<Package> result = businessSvc.getPackageDetailsByLocSvcId( svcId,  pkgId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> updatePackage(Package temp_pd1){
        try {
               businessSvc.updatePackage( temp_pd1);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> deletePackages(String packId){
        try {
               businessSvc.deletePackages( packId);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getCountOfAppt(String packId){
        try {
                Integer result = businessSvc.getCountOfAppt( packId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getCountMaterialToPackage(String packId){
        try {
            Integer result = businessSvc.getCountMaterialToPackage( packId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getLocSvcId(String svcId){
        try {
            List<Package> result = businessSvc.getLocSvcId( svcId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }


    
    public ResponseEntity<Object> getMaterialsListByBizIdByLimitBySort(Integer bizId,Integer pageSize,Integer pageNo,String sortBy,String sort){
        try {
                OnskedList result = businessSvc.getMaterialsListByBizIdByLimitBySort( bizId, pageSize, pageNo, sortBy, sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getMaterialsToPkgByLocSvcIdByLimitBySort(Integer pkgId,Integer bizId,Integer pageSize, Integer pageNo, String sortBy, String sort){
        try {
            OnskedList result = businessSvc.getMaterialsToPkgByLocSvcIdByLimitBySort( pkgId, bizId, pageSize,  pageNo,  sortBy,  sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //query for BreadCrum
    
    public ResponseEntity<Object> inventoryBreadCrum(Integer pkgId) {
        try {
            Business result = businessSvc.inventoryBreadCrum( pkgId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get packages and service name based by bizId
    
    public ResponseEntity<Object> getPackageDetailsOfBusinessByBizId(Integer bizId){
        try {
            List<Package> result = businessSvc.getPackageDetailsOfBusinessByBizId( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get all the packages (including inactive and deleted) for a given business by biz id
    
    public ResponseEntity<Object> getAllPackagesOfBusinessByBizId(Integer bizId) {
        try {
            List<Package> result = businessSvc.getAllPackagesOfBusinessByBizId( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //gets all active businesses belonging to the user
    
    public ResponseEntity<Object> getActiveBusinessesByUserIdForCal(Integer userId){
        try {
            List<Business> result = businessSvc.getActiveBusinessesByUserIdForCal( userId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getActiveBusinessesForSMS(){
        try {
            List<Business> result = businessSvc.getActiveBusinessesForSMS();
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }


    //get the count for locationTo Service 	by loc_id and biz_id
   
    public ResponseEntity<Object> getLocationScvByBizIdCount(Integer bizId, Integer locId){
        try {
                Integer result = businessSvc.getLocationScvByBizIdCount( bizId,  locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }


    //Checking if any appointment is using the package

   
    public ResponseEntity<Object> checkForApptUsingPackage(Integer pkg, Integer matId){
        try {
                Integer result = businessSvc.checkForApptUsingPackage( pkg,  matId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Gets the list of all contries (this is only for ScheduleApptByBizAdmin because it didn't support hash map)
    
    public ResponseEntity<Object> getCountries(){
        try {
            List<Country> result = businessSvc.getCountries();
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //To get count of services based on categoryCode and serviceCode
    
    public ResponseEntity<Object> getServiceCount(String categoryCode, String serviceCode){
        try {
                Integer result = businessSvc.getServiceCount( categoryCode,  serviceCode);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //To get count of category based on categoryCode
    
    public ResponseEntity<Object> getCategoryCount(Integer categoryCode){
        try {
            Integer result = businessSvc.getCategoryCount( categoryCode);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //To get all the location services packages & resources by bizId
    
    public ResponseEntity<Object> getLocSvcPackRes(Integer bizId){
        try {
            List<LocationToService> result = businessSvc.getLocSvcPackRes( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //To get all the resources by bizId
    
    public ResponseEntity<Object> getResourceDetailsByBizId(Integer bizId){
        try {
            List<Resource> result = businessSvc.getResourceDetailsByBizId( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //To get business details and services
    
    public ResponseEntity<Object> getBusinessServiceByBizId(Integer bizId){
        try {
            Business result = businessSvc.getBusinessServiceByBizId( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //to get all the business with there locations by user id
    
    public ResponseEntity<Object> getBusinessesByUserIdByInventoryByLimitBySort(Integer userId,
                                                             Integer pageSize, Integer pageNo, String sortBy, String sort, String isInventory){
        try {
            OnskedList result = businessSvc.getBusinessesByUserIdByInventoryByLimitBySort( userId, pageSize,  pageNo,  sortBy,  sort,  isInventory);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getBusinessesBySort(Integer userId,Integer pageSize, Integer pageNo, String sortBy, String sort){
        try {
            OnskedList result = businessSvc.getBusinessesBySort( userId, pageSize,  pageNo,  sortBy,  sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getActivebusinessByUserId(Integer userId,Integer pageSize, Integer pageNo, String sortBy, String sort){
        try {
            OnskedList result = businessSvc.getActivebusinessByUserId( userId, pageSize,  pageNo,  sortBy,  sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getBusinessName(Integer userId){
        try {
            List<Business> result = businessSvc.getBusinessName(userId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getLocationName(Integer userId){
        try {
                List<Location> result = businessSvc.getLocationName( userId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //Get all the Active registered Businesses
    
    public ResponseEntity<Object> getAllBusinessesBySort(Integer pageSize, Integer pageNo, String sortBy, String sort){
        try {
            OnskedList result = businessSvc.getAllBusinessesBySort( pageSize,  pageNo,  sortBy,  sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getAllDeletedBusinessesBySort(Integer pageSize, Integer pageNo, String sortBy, String sort){
        try {
            OnskedList result = businessSvc.getAllDeletedBusinessesBySort( pageSize,  pageNo,  sortBy,  sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // Get the locations for a given business by sort
    
    public ResponseEntity<Object> getLocationsByLimitBySort(Integer bizId, Integer pageSize, Integer pageNo, String sortBy, String sort) {
        try {
            OnskedList result = businessSvc.getLocationsByLimitBySort( bizId,  pageSize,  pageNo,  sortBy,  sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object>  getResourcesByLimitBySort(Integer attribute, Integer pageSize,Integer pageNo, String sortBy, String sort) {
        try {
            OnskedList result = businessSvc.getResourcesByLimitBySort( attribute,  pageSize, pageNo,  sortBy,  sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getResourceName(Integer userId){
        try {
            List<Resource> result = businessSvc.getResourceName( userId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getPromotionDetails(Integer promotionId,Integer bizId) {
        try {
                Promotion result = businessSvc.getPromotionDetails( promotionId, bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> listPurchaseDetails(Integer bizId,Integer pageSize,Integer pageNo, String sortBy, String sort) {
        try {
            OnskedList result = businessSvc.listPurchaseDetails( bizId, pageSize, pageNo,  sortBy,  sort) ;
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getMaterialList(Integer bizId, Integer pId) {
        try {
            List<PurchaseDetails> result = businessSvc.getMaterialList( bizId,  pId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> updatePurchaseMaterial(PurchaseDetails purchase) {
        try {
               businessSvc.updatePurchaseMaterial(purchase);
               return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> updateActivebusinessByUserId(Integer bizId,Integer userId,String flagSMS,String flagPIN,String name,Integer modifiedBy) {
        try {
              businessSvc.updateActivebusinessByUserId( bizId, userId, flagSMS, flagPIN, name, modifiedBy);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getBusinessDetailsByBizId(Integer bizId) {
        try {
            Business result = businessSvc.getBusinessDetailsByBizId( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> checkInvoice(Integer bizId, Integer locId,String PurchaseOrder) {
        try {
                Integer result = businessSvc.checkInvoice( bizId,  locId, PurchaseOrder);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> checkLocationExist(Integer userId){
        try {
            List<Business> result = businessSvc.checkLocationExist( userId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the unique location to service to display it in package page
    
    public ResponseEntity<Object> getUniqueLocationToServiceByLimit(Integer bizId,Integer pageSize, Integer pageNo){
        try {
            OnskedList result = businessSvc.getUniqueLocationToServiceByLimit( bizId, pageSize,  pageNo);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getMaterialsListByBizIdBySearch(Integer bizId,String matName, String manufacturer,String disposable,Integer pageSize,Integer pageNo,String sortBy,String sort){
        try {
            OnskedList result = businessSvc.getMaterialsListByBizIdBySearch( bizId, matName,  manufacturer, disposable, pageSize, pageNo, sortBy, sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getMatIdsByLocIdBySearch(Integer locId,String matName,String manufacturer,Integer pageSize,Integer pageNo,String sortBy,String sort){
        try {
            OnskedList result = businessSvc.getMatIdsByLocIdBySearch( locId, matName, manufacturer, pageSize, pageNo, sortBy, sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the count of appointments by bizId and clientId
   
    public ResponseEntity<Object> getAppointmentCountByClientIdAndBizId(Integer bizId,
                                                  Integer clientId){
        try {
                Integer result = businessSvc.getAppointmentCountByClientIdAndBizId( bizId, clientId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //disabling the client
    
    public ResponseEntity<Object> disableClient(Integer bizId, Integer clientId,Integer userId){
        try {
              businessSvc.disableClient( bizId,  clientId, userId);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //enabling the client
    
    public ResponseEntity<Object> enableClient(Integer bizId, Integer clientId,Integer userId){
        try {
              businessSvc.enableClient( bizId,  clientId, userId);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getUniqueLocationToServiceByLocIdBizIdOnResource( Integer locId, Integer bizId){
        try {
            List<ServiceMaster> result = businessSvc.getUniqueLocationToServiceByLocIdBizIdOnResource(  locId,  bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getMatchingLocationToServiceByLocIdBizIdOnResource(String locId, Integer bizId){
        try {
            List<ServiceMaster> result = businessSvc.getMatchingLocationToServiceByLocIdBizIdOnResource( locId,  bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get resource and there location
    
    public ResponseEntity<Object> getResourcesForLocByBizId(Integer bizId){
        try {
            List<Resource> result = businessSvc.getResourcesForLocByBizId( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getResourceHoursByBizId1(Integer bizId){
        try {
            List<ResourceHours> result = businessSvc.getResourceHoursByBizId1( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getLocationHoursByBizId1(Integer bizId){
        try {
            List<LocationHours> result = businessSvc.getLocationHoursByBizId1(bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getAppointmentRatingByCategoryCode(String categoryCode){
        try {
            List<AppointmentSchedule> result = businessSvc.getAppointmentRatingByCategoryCode( categoryCode);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //for android
    
    public ResponseEntity<Object>  getPackageDetailsOfBusinessByLocId(Integer locId){
        try {
            List<Package> result = businessSvc.getPackageDetailsOfBusinessByLocId( locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getLocationHours1(String tmZnCode,Integer locId) {
        try {
            List<LocationHours> result = businessSvc.getLocationHours1( tmZnCode, locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getLocationListByBizId(Integer bizId){
        try {
            List<AppointmentSchedule> result = businessSvc.getLocationListByBizId( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getLocSvcPackRes1(Integer bizId, Integer locId){
        try {
            List<LocationToService> result = businessSvc.getLocSvcPackRes1( bizId, locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get all the patients which are active with limit
    
    public ResponseEntity<Object> getPatientListByLimitBySort(Integer userId,Integer pageSize,Integer pageNo,String sortBy,String sort) {
        try {
            OnskedList result = businessSvc.getPatientListByLimitBySort( userId, pageSize, pageNo, sortBy, sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getSMSLogByUserId(String userId,String bizId,String startDate,String endDate,Integer pageSize,Integer pageNo,String sortBy,String sort) {
        try {
            OnskedList result = businessSvc.getSMSLogByUserId( userId, bizId, startDate, endDate, pageSize, pageNo, sortBy, sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> addPatient(Patient patient) {
        try {
                Integer result = businessSvc.addPatient( patient);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getClientListNotInPatientByBizId(Integer bizId, Integer userId) {
        try {
                List<Client> result = businessSvc.getClientListNotInPatientByBizId( bizId,  userId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getClientListNotInPatient(Integer userId) {
        try {
                List<Client> result = businessSvc.getClientListNotInPatient( userId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // add the patient illness details
    
    public ResponseEntity<Object> addPatientsIllness(PatientIllness patientillness) {
        try {
               businessSvc.addPatientsIllness( patientillness);
               return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get the list of patient illness details by patientId
    
    public ResponseEntity<Object> getPatientIllnessDetailsByPatientId(Integer patientId) {
        try {
            List<PatientIllness> result = businessSvc.getPatientIllnessDetailsByPatientId( patientId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get the list of prev patient illness details by patientId
    
    public ResponseEntity<Object> getPrevPatientIllnessDetailsByPatientId(Integer patientId) {
        try {
            List<PatientIllness> result = businessSvc.getPrevPatientIllnessDetailsByPatientId( patientId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //update the details of illness of patient
    
    public ResponseEntity<Object> updatePatientsIllness(PatientIllness patientIllness) {
        try {
              businessSvc.updatePatientsIllness( patientIllness) ;
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // delete list of patient illness
    
    public ResponseEntity<Object> deletePatientIllness(String patientIllnessId) {
        try {
               businessSvc.deletePatientIllness( patientIllnessId);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get the patient insurance list
    
    public ResponseEntity<Object> getPatientInsuranceListByLimitBySort(Integer patientId,Integer pageSize,Integer pageNo,String sortBy,String sort) {
        try {
            OnskedList result = businessSvc.getPatientInsuranceListByLimitBySort( patientId, pageSize, pageNo, sortBy, sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getClientInsuranceListByLimitBySort(Integer clientId,Integer pageSize,Integer pageNo,String sortBy,String sort) {
        try {
            OnskedList result = businessSvc.getClientInsuranceListByLimitBySort( clientId, pageSize, pageNo, sortBy, sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object>  getClientPhysicianListByLimitBySort(Integer clientId,Integer pageSize,Integer pageNo,String sortBy,String sort) {
        try {
            OnskedList result = businessSvc.getClientPhysicianListByLimitBySort( clientId, pageSize, pageNo, sortBy, sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // add the patient insurance details
    
    public ResponseEntity<Object> addPatientInsurance(PatientInsurance patientInsurance) {
        try {
              businessSvc.addPatientInsurance( patientInsurance);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> addClientInsurance(ClientInsurance clientInsurance) {
        try {
              businessSvc.addClientInsurance( clientInsurance);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> addClientPhysician(ClientPhysician clientPhysician) {
        try {
              businessSvc.addClientPhysician( clientPhysician);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get the patient by patientId
    
    public ResponseEntity<Object> getPatientByPatientId(Integer patientId) {
        try {
            Patient result = businessSvc.getPatientByPatientId( patientId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get the client list by userId
    
    public ResponseEntity<Object> getClientListByUserId(Integer userId) {
        try {
                List<Client> result = businessSvc.getClientListByUserId( userId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get the patient by client Id
    
    public ResponseEntity<Object> getPatientByClientId(Integer clientId) {
        try {
            Patient result = businessSvc.getPatientByClientId( clientId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get the patient by appt Id
    
    public ResponseEntity<Object> getPatientByApptId(Integer apptId) {
        try {
            Patient result = businessSvc.getPatientByApptId( apptId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //update patient details
    
    public ResponseEntity<Object> updatePatient(Patient patient) {
        try {
               businessSvc.updatePatient( patient) ;
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //delete patient
    
    public ResponseEntity<Object> disablePatient(Integer patientId) {
        try {
                businessSvc.disablePatient( patientId);
               return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get the patient Insurance details by patient Insurance Id
    
    public ResponseEntity<Object> getPatientInsuranceByPatientInsId(Integer patientInsuranceId) {
        try {
            PatientInsurance result = businessSvc.getPatientInsuranceByPatientInsId( patientInsuranceId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getClientInsuranceByClientInsId(Integer clientInsuranceId) {
        try {
            ClientInsurance result = businessSvc.getClientInsuranceByClientInsId( clientInsuranceId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getClientPhysicianByClientInsId(Integer clientPhysicianId) {
        try {
            ClientPhysician result = businessSvc.getClientPhysicianByClientInsId( clientPhysicianId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // update the insurance details
    
    public ResponseEntity<Object> updatePatientInsurance(PatientInsurance patientInsurance) {
        try {
               businessSvc.updatePatientInsurance( patientInsurance);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> updateClientInsurance(ClientInsurance clientInsurance) {
        try {
               businessSvc.updateClientInsurance( clientInsurance);
               return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> updateClientPhysician(ClientPhysician clientPhysician) {
        try {
              businessSvc.updateClientPhysician( clientPhysician);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //delete the patient insurance details
    
    public ResponseEntity<Object> deletePatientInsurance(Integer patientInsId) {
        try {
              businessSvc.deletePatientInsurance( patientInsId);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> deleteClientInsurance(Integer clientInsId) {
        try {
               businessSvc.deleteClientInsurance( clientInsId);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the top 6 master illness list
    
    public ResponseEntity<Object> getMasterIllnessList() {
        try {
            List<PatientIllness> result = businessSvc.getMasterIllnessList();
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the master illness list not added for patient in patient_illness
    
    public ResponseEntity<Object> getPatientIllnessDetailsNotInCurNPrevByPatientId(String patientId) {
        try {
            List<PatientIllness> result = businessSvc.getPatientIllnessDetailsNotInCurNPrevByPatientId( patientId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the master illness by illness name
    
    public ResponseEntity<Object> getIllnessByName(String illnessName) {
        try {
                Integer result = businessSvc.getIllnessByName( illnessName) ;
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // add new master illness
    
    public ResponseEntity<Object> addMasterIllness(MasterIllness masterillness) {
        try {
               businessSvc.addMasterIllness( masterillness);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the active patient illness by medical Code
    
    public ResponseEntity<Object> getActivePatientIllnessByMedicalCode(String medicalCode,Integer patientId) {
        try {
                Integer result = businessSvc.getActivePatientIllnessByMedicalCode( medicalCode, patientId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the patient list for appt booking
    
    public ResponseEntity<Object> getPatientInfoForBizCal(Integer bizId) {
        try {
            List<Patient> result = businessSvc.getPatientInfoForBizCal( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the count of insurance for the patient
    
    public ResponseEntity<Object> getPatientInsCnt(Integer patientId) {
        try {
                Integer result = businessSvc.getPatientInsCnt( patientId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //get the count of location nick name for the business
    
    public ResponseEntity<Object> getDuplicateLocCount(String locName,Integer bizId) {
        try {
            Integer result = businessSvc.getDuplicateLocCount( locName, bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //gets discount details for appt billing
    
    public ResponseEntity<Object> getdiscountdetails(String promoCode, Integer svcId, Integer locId, String startTime, Integer userId, Integer integer,Integer clientId){
        try {
            PaymentHistory result = businessSvc.getdiscountdetails( promoCode,  svcId, locId,  startTime,  userId,  integer, clientId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    //gets the biz user payment credential
    
    public ResponseEntity<Object> getBizUserPaymentCred(Integer bizId){
        try {
            Business result = businessSvc.getBizUserPaymentCred( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // add new group package
    
    public ResponseEntity<Object> addGroupPackage(GroupPackage grpPkg) {
        try {
            businessSvc.addGroupPackage( grpPkg);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get group package by group package id
    
    public ResponseEntity<Object> getGroupPkgByGroupPkgId(String grpPkgId) {
        try {
            GroupPackage result = businessSvc.getGroupPkgByGroupPkgId( grpPkgId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get group package to package list by group package id
    
    public ResponseEntity<Object> getGroupPkgOccurencesByGroupPkgId(String grpPkgId) {
        try {
            List<GroupPackageOccurence> result = businessSvc.getGroupPkgOccurencesByGroupPkgId( grpPkgId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // update group package
    
    public ResponseEntity<Object> updateGroupPackage(GroupPackage grpPkg) {
        try {
               businessSvc.updateGroupPackage( grpPkg);
               return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // update group package to appointment
    
    public ResponseEntity<Object> updateGroupPackageAppt(Integer bookedApptId, Integer groupPkgId, Integer pkgId,Integer groupPackagePurchaseId) {
        try {
              businessSvc.updateGroupPackageAppt( bookedApptId,  groupPkgId,  pkgId, groupPackagePurchaseId);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get list of group packages of business user by userId
    
    public ResponseEntity<Object> getAllGroupPackagesListByUserId(Integer userId, String bizId, String locId, Integer pageSize,Integer pageNo,String sortBy,String sort) {
        try {
            OnskedList result = businessSvc.getAllGroupPackagesListByUserId( userId,  bizId,  locId,  pageSize, pageNo, sortBy, sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getAllPurchasedGroupPackagesListByUserId(Integer userId, String bizId, String locId, Integer pageSize,Integer pageNo,String sortBy,String sort) {
        try {
            OnskedList result = businessSvc.getAllPurchasedGroupPackagesListByUserId( userId,  bizId,  locId,  pageSize, pageNo, sortBy, sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    // get the biz name and loc name by loc Id
    
    public ResponseEntity<Object> getBizNamenLocNamebyLocId(String locId) {
        try {
            Business result = businessSvc.getBizNamenLocNamebyLocId( locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> getGroupPkgbyGrpPkgNameAndId(String grpPkgName, String grpPkgId, String locId) {
        try {
                Integer result = businessSvc.getGroupPkgbyGrpPkgNameAndId( grpPkgName,  grpPkgId,  locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> getGrpPkgApptCountByGrpPkgId(String grpPkgId) {
        try {
                Integer result = businessSvc.getGrpPkgApptCountByGrpPkgId( grpPkgId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> getGrpPkgPurchaseCountByGrpPkgId(String grpPkgId) {
        try {
                Integer result = businessSvc.getGrpPkgPurchaseCountByGrpPkgId( grpPkgId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> deleteGrpPkg(String grpPkgId) {
        try {
              businessSvc.deleteGrpPkg( grpPkgId);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getBizWhichHasGrpPkgs() {
        try {
            List<Business> result = businessSvc.getBizWhichHasGrpPkgs();
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getProductModel() {
        try {
            List<ProductModel> result = businessSvc.getProductModel();
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getProductIssue(String string) {
        try {
            List<ProductIssue> result = businessSvc.getProductIssue( string);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object>  getProductHardwareIssueList(String techFormId) {
        try {
            List<ProductHardwareIssue> result = businessSvc.getProductHardwareIssueList( techFormId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getProductPartsUsedList(String techFormId) {
        try {
            List<ProductPartsUsed> result = businessSvc.getProductPartsUsedList( techFormId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getUnregUserDetailsForInStore(String apptId) {
        try {
            AppointmentSchedule result = businessSvc.getUnregUserDetailsForInStore(apptId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getRepairFormDetails(String apptId, String repairFormIdHex) {
        try {
            RepairForm result = businessSvc.getRepairFormDetails( apptId,  repairFormIdHex);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getTechicianFormDetails(String apptId,String repairFormId) {
        try {
            TechnicianForm result = businessSvc.getTechicianFormDetails( apptId, repairFormId) ;
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> getRepairFormUsingApptId(Integer apptId) {
        try {
                Integer result = businessSvc.getRepairFormUsingApptId( apptId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> getRepairFormIdForShowingTechnicianForm(Integer apptId) {
        try {
                Integer result = businessSvc.getRepairFormIdForShowingTechnicianForm( apptId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getLocsWhichHasGrpPkgs(Integer bizId) {
        try {
                List<Location> result = businessSvc.getLocsWhichHasGrpPkgs( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getNonDeletedLocations(Integer bizId) {
        try {
                List<Location> result = businessSvc.getNonDeletedLocations( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> addGroupPackagePurchase(GroupPackagePurchase grpPkgPurchase) {
        try {
                Integer result = businessSvc.addGroupPackagePurchase( grpPkgPurchase);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> addGroupPackagePayment(GroupPackagePayment grpPkgPayment) {
        try {
                Integer result = businessSvc.addGroupPackagePayment( grpPkgPayment);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> addGroupPackageAppt(GroupPackageAppointment grpPkgAppt) {
        try {
                Integer result = businessSvc.addGroupPackageAppt( grpPkgAppt);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getUserPurchasedGroupPackagesDetails(Integer userId,Integer groupPkgId,Integer pageSize,Integer pageNo,String sortBy,String sort) {
        try {
            OnskedList result = businessSvc.getUserPurchasedGroupPackagesDetails( userId, groupPkgId, pageSize, pageNo, sortBy, sort);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getUserPurchasedGroupPackagesDetailsByGroupPkgId(Integer userId,Integer groupPkgId,Integer groupPkgPurchaseId) {
        try {
            List<GroupPackage> result = businessSvc.getUserPurchasedGroupPackagesDetailsByGroupPkgId( userId, groupPkgId, groupPkgPurchaseId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getUserSelectedPurchasedGroupPackagesDetails(Integer userId,Integer groupPkgId,Integer pgkId,Integer groupPkgPurchaseId) {
        try {
            List<GroupPackageAppointment> result = businessSvc.getUserSelectedPurchasedGroupPackagesDetails( userId, groupPkgId, pgkId, groupPkgPurchaseId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getBizResourceSelectedPurchasedGroupPackagesDetails(Integer userId,Integer groupPkgId,Integer pgkId,Integer groupPkgPurchaseId) {
        try {
            List<GroupPackageAppointment> result = businessSvc.getBizResourceSelectedPurchasedGroupPackagesDetails( userId, groupPkgId, pgkId, groupPkgPurchaseId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getUserPurchasedGroupPackagesIds(Integer userId) {
        try {
            List<GroupPackageAppointment> result = businessSvc.getUserPurchasedGroupPackagesIds( userId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> getClientPresentByClientId(Integer clientId) {
        try {
                Integer result = businessSvc.getClientPresentByClientId( clientId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> getClientbyEmailAndClientId(String email, String clientId, Integer bizId) {
        try {
                Integer result = businessSvc.getClientbyEmailAndClientId( email,  clientId,  bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> getClientIdByBizIdAndEmail(Integer bizId, String email) {
        try {
                Integer result = businessSvc.getClientIdByBizIdAndEmail( bizId,  email);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> addTechnicianForm(TechnicianForm technicianForm) {
        try {
                String result = businessSvc.addTechnicianForm( technicianForm);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> updateTechnicianForm(TechnicianForm technicianForm, String requestPath) {
        try {
                String result = businessSvc.updateTechnicianForm( technicianForm,  requestPath);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getTechnicianFormIdForShowingEditFillTechnicianForm(Integer apptId,Integer repairFormId){
        try {
            TechnicianForm result = businessSvc.getTechnicianFormIdForShowingEditFillTechnicianForm( apptId, repairFormId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getPhoneCarrier(){
        try {
            List<PhoneCarrier> result = businessSvc.getPhoneCarrier();
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> updateClientPhysicianDetails(ClientPhysician clientPhysician) {
        try {
              businessSvc.updateClientPhysicianDetails( clientPhysician);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getResourceTypeDetails(Integer bizId){
        try {
            List<ResourceRoleType> result = businessSvc.getResourceTypeDetails( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getTechniciansForRepairForm(Integer locId){
        try {
            List<Resource> result = businessSvc.getTechniciansForRepairForm( locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getFormStausListForTechnicianForm(){
        try {
            List<FormStatus> result = businessSvc.getFormStausListForTechnicianForm();
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getAppointmentStatusForGrid(){
        try {
            List<AppointmentStatus> result = businessSvc.getAppointmentStatusForGrid();
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> addTechnicianFormComment(TechnicianFormComments techFormComments){
        try {
              businessSvc.addTechnicianFormComment( techFormComments);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getTechnicianFormCommentsByTechFormId(String techFormId){
        try {
            List<TechnicianFormComments> result = businessSvc.getTechnicianFormCommentsByTechFormId( techFormId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> updateRepairFormSelfAssign(String repairFormId, String assignTechId, String techFormId, Integer userId){
        try {
              businessSvc.updateRepairFormSelfAssign( repairFormId,  assignTechId,  techFormId,  userId);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object>  getTechFormCommentsByTechFormId(String techFormId){
        try {
            List<TechnicianFormComments> result = businessSvc.getTechFormCommentsByTechFormId( techFormId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getAuditDetails(WeakHashMap map, String query){
        try {
            List<AuditTrail> result = businessSvc.getAuditDetails( map,  query);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> isDisplayCounterEnabled(Integer bizId){
        try {
                String result = businessSvc.isDisplayCounterEnabled( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> updateResourceHours(Resource resourceWorkingHour){
        try {
               businessSvc.updateResourceHours( resourceWorkingHour);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getApptBookedTime(WeakHashMap map){
        try {
            List<AppointmentSchedule> result = businessSvc.getApptBookedTime( map);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getMaxWorkingHrs(Integer locId) {
        try {
            Package result = businessSvc.getMaxWorkingHrs( locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getServiceForManageClientsForBusiness(String bizId){
        try {
            List<Service> result = businessSvc.getServiceForManageClientsForBusiness( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getUpcomingPromotionListForClient(String bizId){
        try {
            List<Promotion> result = businessSvc.getUpcomingPromotionListForClient( bizId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> addDataToClientsEmail(Map<String, Object> result){
        try {
              businessSvc.addDataToClientsEmail(result);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getPackageByPromotionId(String promotionId){
        try {
                String result = businessSvc.getPackageByPromotionId( promotionId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> deleteClient(String clientId){
        try {
               businessSvc.deleteClient( clientId);
               return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getAvailedProductsByClientId(Integer clientId, String svcId, String statusCode, String pkgId, String locId){
        try {
            List<String> result = businessSvc.getAvailedProductsByClientId( clientId,  svcId,  statusCode,  pkgId,  locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getAvailedLocationsByClientId(Integer clientId, String svcId, String statusCode, String pkgId, String locId){
        try {
            List<String> result = businessSvc.getAvailedLocationsByClientId( clientId,  svcId,  statusCode,  pkgId,  locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> updateClientAddress(WeakHashMap map){
        try {
              businessSvc.updateClientAddress( map);
              return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getServiveListFromLocationList(String locIdList){
        try {
            List<ServiceMaster> result = businessSvc.getServiveListFromLocationList( locIdList);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getLastCompletedAppointmentDate(Integer clientId){
        try {
                String result = businessSvc.getLastCompletedAppointmentDate( clientId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getClientDetailsForDownload(String clientList){
        try {
                List<Client> result = businessSvc.getClientDetailsForDownload( clientList);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

   
    public ResponseEntity<Object> isClientPresentInPromotion(String bizId, String promotionId, String clientEmail){
        try {
                Integer result = businessSvc.isClientPresentInPromotion( bizId,  promotionId,  clientEmail);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getPackageDetailsByPackageId(String pkgId){
        try {
                Promotion result = businessSvc.getPackageDetailsByPackageId( pkgId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getServiceNameByServiceId(String svcId){
        try {
                Promotion result = businessSvc.getServiceNameByServiceId( svcId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getlocationNameForPromotionByLocId(String locId){
        try {
                Promotion result = businessSvc.getlocationNameForPromotionByLocId( locId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getPromotionByPromotionCodeForPromotionValidation(String promotionCode){
        try {
                Promotion result = businessSvc.getPromotionByPromotionCodeForPromotionValidation( promotionCode);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getPromotionParticipents(String promotionId){
        try {
                List<Client> result = businessSvc.getPromotionParticipents( promotionId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getClientAddress(Integer clientId){
        try {
            Client result = businessSvc.getClientAddress( clientId);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

    
    public ResponseEntity<Object> getTimezonesFromCountry(String countryCode){
        try {
            List<TimeZones> result = businessSvc.getTimezonesFromCountry( countryCode);
              if(result!=null)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>("No Results Found", HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Exception");
        }
    }

}

