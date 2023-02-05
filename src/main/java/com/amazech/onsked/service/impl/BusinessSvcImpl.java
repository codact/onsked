package com.amazech.onsked.service.impl;

import com.amazech.onsked.dao.mapper.BusinessMapper;
import com.amazech.onsked.domain.*;
import com.amazech.onsked.exceptions.DataAccessException;
import com.amazech.onsked.service.BusinessSvc;
import com.amazech.onsked.util.OnskedList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.Package;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
@Slf4j
@Service
public class BusinessSvcImpl implements BusinessSvc {
    @Autowired
    private BusinessMapper businessMapper;
 //   private SendMailImpl sendMailImpl;


   

    @Override
    public List<CourseSchedule> getCourseListForClient(Integer biz) throws DataAccessException {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method businessMapper.getCourseListForClient(): "+biz);
        List<CourseSchedule> courseListForCLient = businessMapper.getCourseListForClient(biz);
        log.debug("After calling DAO method businessMapper.getCourseListForClient()");
        return courseListForCLient;
    }

    // Operation methods, implementing the BusinessService interface
    public void addBusiness(Business business) throws DataAccessException {
        log.debug("Before calling DAO method addBusiness()");
        businessMapper.addBusiness(business);
        log.debug("After calling DAO method addBusiness()");
    }

    public String addRepairForm(RepairForm repairForm,AppointmentSchedule appointmentSchedule,String requestPath) throws DataAccessException {
        log.debug("Before calling DAO method addRepairForm()");
        return businessMapper.addRepairForm(repairForm,appointmentSchedule,requestPath);
        //log.debug("After calling DAO method addRepairForm()");
    }

    public String updateRepairForm(RepairForm repairForm,AppointmentSchedule appointmentSchedule,RepairForm repairFormForUpdate,String requestPath) throws DataAccessException {
        log.debug("Before calling DAO method updateRepairForm()");
        return businessMapper.updateRepairForm(repairForm,appointmentSchedule,repairFormForUpdate,requestPath);
        //log.debug("After calling DAO method addRepairForm()");
    }

    public void updateBusiness(Business business) throws DataAccessException {
        log.debug("Before calling DAO method updateBusiness()");
        businessMapper.updateBusiness(business);
        log.debug("After calling DAO method updateBusiness()");
    }

    public void updateBasicBusinessDetails(Business business) throws DataAccessException {
        log.debug("Before calling DAO method updateBasicBusinessDetails()");
        businessMapper.updateBasicBusinessDetails(business);
        log.debug("After calling DAO method updateBasicBusinessDetails()");
    }

    public Business getBusinessByBizId(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getBusinessByBizId()");
        return businessMapper.getBusinessByBizId(bizId);
    }

    public OnskedList getLocationsByBizId(Integer bizId,int pageSize, int pageNo,String sortBy, String sort) throws DataAccessException {
        log.debug("Calling DAO method getLocationsByBizId()");
        return businessMapper.getLocationsByBizId(bizId,pageSize,pageNo,sortBy,sort);
    }

    public OnskedList getResourcesByBizId(Integer bizId,int pageSize, int pageNo,String sortBy, String sort) throws DataAccessException {
        log.debug("Calling DAO method getResourcesByBizId()");
        return businessMapper.getResourcesByBizId(bizId,pageSize,pageNo,sortBy,sort);
    }

    public List<Business> getBusinessForAppoitmentByUserId(Integer userId) throws DataAccessException {
        log.debug("Calling DAO method getBusinessForAppoitmentByUserId()");
        return businessMapper.getBusinessForAppoitmentByUserId(userId);
    }

    public Business getBusiness(Integer userId) throws DataAccessException {
        log.debug("Calling DAO method getBusiness()");
        return businessMapper.getBusiness(userId);
    }

    public List<Business> getBusinesses(Integer userId) throws DataAccessException {
        log.debug("Calling DAO method getBusinesses()");
        return businessMapper.getBusinesses(userId);
    }

    public List<Business> getAllBusinessEntries(Integer userId) throws DataAccessException {
        log.debug("Calling DAO method getAllBusinessEntries()");
        return businessMapper.getAllBusinessEntries(userId);
    }

    public Location getLocation(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getLocation()");
        return businessMapper.getLocation(bizId);
    }

    public Location getBusinessLocation(Integer locId) throws DataAccessException {
        log.debug("Calling DAO method getBusinessLocation()");
        return businessMapper.getBusinessLocation(locId);
    }

    public Location getHeadquartersLocation(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getHeadquartersLocation()");
        return businessMapper.getHeadquartersLocation(bizId);
    }

    public Location getBusinessLocationByLocId(Integer locId) throws DataAccessException {
        log.debug("Calling DAO method getBusinessLocationByLocId()");
        return businessMapper.getBusinessLocationByLocId(locId);
    }

    public List<ServiceMaster> getMasterServices(Integer categoryCode) throws DataAccessException {
        log.debug("Calling DAO method getMasterServices()"+categoryCode);
        return businessMapper.getMasterServices(categoryCode);
    }

    public List<ServiceMaster> getBusinessMasterServices(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getBusinessMasterServices()"+bizId);
        return businessMapper.getBusinessMasterServices(bizId);
    }

    public List<ServiceMaster> getBusinessMasterServicesUnselected(Integer bizId,Integer categoryCode) throws DataAccessException {
        log.debug("Calling DAO method getBusinessMasterServicesUnselected()"+bizId);
        return businessMapper.getBusinessMasterServicesUnselected(bizId,categoryCode);
    }

    public List<ServiceMaster> getResourceMasterServices(Integer resId) throws DataAccessException {
        log.debug("Calling DAO method getResourceMasterServices()"+resId);
        return businessMapper.getResourceMasterServices(resId);
    }

    public List<ServiceMaster> getResourceMasterServicesUnselected(Integer bizId,Integer resId) throws DataAccessException {
        log.debug("Calling DAO method getResourceMasterServicesUnselected()"+resId);
        return businessMapper.getResourceMasterServicesUnselected(bizId,resId);
    }

    public List<ServiceMaster> getResourceServices(Integer resId,Integer locId) throws DataAccessException {
        log.debug("Calling DAO method getResourceServices()"+resId);
        return businessMapper.getResourceServices(resId,locId);
    }

    public List<ServiceMaster> getResourceServicesUnselected(Integer locId,Integer resId) throws DataAccessException {
        log.debug("Calling DAO method getResourceMasterServicesUnselected()"+resId);
        return businessMapper.getResourceServicesUnselected(locId,resId);
    }

    public List<ServiceMaster> getResourceSvcByBizId(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getResourceSvcByBizId()");
        return businessMapper.getResourceSvcByBizId(bizId);
    }

    public List<Location> getResourceLocByBizId(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getResourceLocByBizId()");
        return businessMapper.getResourceLocByBizId(bizId);
    }

    public List<Location> getResourceLocByResId(Integer resId) {
        log.debug("Calling DAO method getResourceLocByResId()");
        return businessMapper.getResourceLocByResId(resId);
    }

    public void addBusinessMasterServices(ServiceMaster masterServices,Integer bizId) throws DataAccessException {
        log.debug("Before calling DAO method addBusinessMasterServices()");
        businessMapper.addBusinessMasterServices(masterServices,bizId);
        log.debug("After calling DAO method addBusinessMasterServices()");
    }

    public void deleteBusinessMasterServices(String svcId,Integer loc,Integer userId) throws DataAccessException {
        log.debug("Before calling DAO method deleteBusinessMasterServices()"+svcId);
        businessMapper.deleteBusinessMasterServices(svcId,loc,userId);
        log.debug("After calling DAO method deleteBusinessMasterServices()");
    }

    public void addResourceMasterServices(Resource resource) throws DataAccessException {
        log.debug("Before calling DAO method addResourceMasterServices()");
        businessMapper.addResourceMasterServices(resource);
        log.debug("After calling DAO method addResourceMasterServices()");
    }

    public void updateResourceMasterServices(Resource resource) throws DataAccessException {
        log.debug("Before calling DAO method updateResourceMasterServices()");
        businessMapper.updateResourceMasterServices(resource);
        log.debug("After calling DAO method updateResourceMasterServices()");
    }

    public void removeServicesProvided(Integer svcId) throws DataAccessException {
        log.debug("Before calling DAO method removeServicesProvided()");
        businessMapper.removeServicesProvided(svcId);
        log.debug("After calling DAO method removeServicesProvided()");
    }

    public Resource getResource(Integer resId) throws DataAccessException {
        log.debug("Calling DAO method getResource()");
        return businessMapper.getResource(resId);
    }

    public Resource getResourceByNickName(String nickName,Integer locId,Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getResourceByNickName()");
        return businessMapper.getResourceByNickName(nickName,locId,bizId);
    }

    public List<Resource> getResourceByOnskedUserId(String onskedUserId) throws DataAccessException {
        log.debug("Calling DAO method getResourceByOnskedUserId()");
        return businessMapper.getResourceByOnskedUserId(onskedUserId);
    }

    public List<Resource> getResources(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getResources()");
        return businessMapper.getResources(bizId);
    }

    public List<Resource> getAllResourcesOfBusinessByBizId(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getAllResourcesOfBusinessByBizId()");
        return businessMapper.getAllResourcesOfBusinessByBizId(bizId);
    }

    public List<Resource> getResourcesByLocId(Integer locId) throws DataAccessException {
        log.debug("Calling DAO method getResourcesByLocId()");
        return businessMapper.getResourcesByLocId(locId);
    }

    public List<Location> getLocations(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getLocations()");
        return businessMapper.getLocations(bizId);
    }

    public void addResource(Resource resource,String bizIsActive) throws DataAccessException {
        log.debug("Before calling DAO method addResource()");
        businessMapper.addResource(resource,bizIsActive);
        log.debug("After calling DAO method addResource()");
    }

    public void saveResourceRatePerHour(Resource resource) throws DataAccessException {
        log.debug("Before calling DAO method addResourceRatePerHour()");
        businessMapper.saveResourceRatePerHour(resource);
        log.debug("After calling DAO method addResourceRatePerHour()");
    }

    public void saveResourcePayoutPercentage(Resource resource) throws DataAccessException {
        log.debug("Before calling DAO method addResourcePayoutPercentage()");
        businessMapper.saveResourcePayoutPercentage(resource);
        log.debug("After calling DAO method addResourcePayoutPercentage()");
    }

    public void addLocation(Location location,String bizIsActive) throws DataAccessException {
        log.debug("Before calling DAO method addLocation()");
        businessMapper.addLocation(location,bizIsActive);
        log.debug("After calling DAO method addLocation()");
    }

    public void updateResource(Resource resource) throws DataAccessException {
        log.debug("Before calling DAO method updateResource()");
        businessMapper.updateResource(resource);
        log.debug("After calling DAO method updateResource()");
    }

    public void updateBusinessResource(Resource resource,Integer locId) throws DataAccessException {
        log.debug("Before calling DAO method updateBusinessResource()");
        businessMapper.updateBusinessResource(resource,locId);
        log.debug("After calling DAO method updateBusinessResource()");
    }

    public void updateBusinessLocation(Location location) throws DataAccessException {
        log.debug("Before calling DAO method updateBusinessLocation()");
        businessMapper.updateBusinessLocation(location);
        log.debug("After calling DAO method updateBusinessLocation()");
    }

    public void deleteResource(Integer resId,String bizIsActive,Integer locId,Integer userId) throws DataAccessException {
        log.debug("Before calling DAO method deleteResource()");
        businessMapper.deleteResource(resId,bizIsActive,locId,userId);
        log.debug("After calling DAO method deleteResource()");
    }

    public void deleteBusinessLocation(Integer locId,String bizIsActive,String userId) throws DataAccessException {
        log.debug("Before calling DAO method deleteBusinessLocation()");
        businessMapper.deleteBusinessLocation(locId,bizIsActive,userId);
        log.debug("After calling DAO method deleteBusinessLocation()");
    }

    public void deleteCourseWithAppointment(String courseId,Integer userId,String requestPath) throws DataAccessException {
        log.debug("Before calling DAO method deleteCourseWithAppointment()");
        businessMapper.deleteCourseWithAppointment(courseId,userId,requestPath);
        log.debug("After calling DAO method deleteCourseWithAppointment()");
    }

    public void addBusinessHours(BusinessHours businessHours) throws DataAccessException {
        log.debug("Before calling DAO method addBusinessHours()"+businessHours.getDayOfWeek()+"----"+businessHours.getOpenTime());
        businessMapper.addBusinessHours(businessHours);
        log.debug("After calling DAO method addBusinessHours()");
    }

    public void addBusinessBasicHours(Business business) throws DataAccessException {
        log.debug("Before calling DAO method addBusinessBasicHours()");
        businessMapper.addBusinessBasicHours(business);
        log.debug("After calling DAO method addBusinessBasicHours()");
    }

    public void addLocationHours(Location location) throws DataAccessException {
        log.debug("Before calling DAO method addLocationHours()"+location.getDayOfWeek()+"----"+location.getOpenTime());
        businessMapper.addLocationHours(location);
        log.debug("After calling DAO method addLocationHours()");
    }

    public List<BusinessHours> getBasicBusinessHours(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getBasicBusinessHours()"+bizId);
        return businessMapper.getBasicBusinessHours(bizId);
    }

    public List<LocationHours> getLocationHoursByBizId(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getLocationHoursByBizId()"+bizId);
        return businessMapper.getLocationHoursByBizId(bizId);
    }

    public List<LocationHours> getLocationHours(Integer locId) throws DataAccessException {
        log.debug("Calling DAO method getLocationHours()"+locId);
        return businessMapper.getLocationHours(locId);
    }

    public List<BusinessHoliday> getHolidays(Integer bizId, Integer locId) throws DataAccessException {
        log.debug("Calling DAO method getHolidays()"+bizId+"------"+locId);
        return businessMapper.getHolidays(bizId, locId);
    }

    public void addBusinessHoliday(BusinessHoliday businessHoliday) throws DataAccessException {
        log.debug("Before calling DAO method addBusinessHoliday()");
        businessMapper.addBusinessHoliday(businessHoliday);
        log.debug("After calling DAO method addBusinessHoliday()");
    }

    public void deleteHoliday(Integer bizId, Integer locId) throws DataAccessException {
        log.debug("Before calling DAO method deleteHoliday()");
        businessMapper.deleteHoliday(bizId,locId);
        log.debug("After calling DAO method deleteHoliday()");
    }

    public BusinessHoliday getHoliday(Integer bizId, Integer locId) throws DataAccessException {
        log.debug("Calling DAO method getHoliday()");
        return businessMapper.getHoliday(bizId,locId);
    }

    public void updateHoliday(BusinessHoliday businessHoliday) throws DataAccessException {
        log.debug("Before calling DAO method updateHoliday()");
        businessMapper.updateHoliday(businessHoliday);
        log.debug("After calling DAO method updateHoliday()");
    }

    public List<BusinessHoliday> getHolidays(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getHolidays()"+bizId);
        return businessMapper.getHolidays(bizId);
    }

    public List<BusinessHoliday> getBusinessLocationHolidaysHQ(Integer bizId, Integer locId) throws DataAccessException {
        log.debug("Calling DAO method getBusinessLocationHolidaysHQ()"+bizId);
        return businessMapper.getBusinessLocationHolidaysHQ(bizId,locId);
    }

    public void setBusinessActive(Integer bizId,Integer userId) throws DataAccessException {
        log.debug("Before calling DAO method setBusinessActive()");
        businessMapper.setBusinessActive(bizId,userId);
        log.debug("After calling DAO method setBusinessActive()");
    }

    public void setBusinessInActive(Integer userId) throws DataAccessException {
        log.debug("Before calling DAO method setBusinessInActive()");
        businessMapper.setBusinessInActive(userId);
        log.debug("After calling DAO method setBusinessInActive()");
    }

    public BusinessHoliday getHolidayByBizIdLocIdDate(Integer holidayId) throws DataAccessException {
        log.debug("Calling DAO method getHolidayByBizIdLocIdDate()"+holidayId);
        return businessMapper.getHolidayByBizIdLocIdDate(holidayId);
    }

    public void updateHolidayByBizIdLocIdDate(BusinessHoliday businessHoliday) throws DataAccessException {
        log.debug("Before calling DAO method updateHolidayByBizIdLocIdDate()");
        businessMapper.updateHolidayByBizIdLocIdDate(businessHoliday);
        log.debug("After calling DAO method updateHolidayByBizIdLocIdDate()");
    }

    public List<BusinessHoliday> getHolidayByHolidayId(Integer bizId, Integer locId) throws DataAccessException {
        log.debug("Calling DAO method getHolidayByHolidayId()"+bizId);
        return businessMapper.getHolidayByHolidayId(bizId,locId);
    }

    public void deleteHolidayByBizIdLocIdDate(Integer holidayId,Integer userId) throws DataAccessException {
        log.debug("Before calling DAO method deleteHolidayByBizIdLocIdDate()");
        businessMapper.deleteHolidayByBizIdLocIdDate(holidayId,userId);
        log.debug("After calling DAO method deleteHolidayByBizIdLocIdDate()");
    }

    public void deleteHolidayByBizIdLocIdHolidayDate(BusinessHoliday businessHoliday) throws DataAccessException {
        log.debug("Before calling DAO method deleteHolidayByBizIdLocIdHolidayDate()");
        businessMapper.deleteHolidayByBizIdLocIdHolidayDate(businessHoliday);
        log.debug("After calling DAO method deleteHolidayByBizIdLocIdHolidayDate()");
    }

    public void addLocationToService(LocationToService locationToService ) throws DataAccessException {
        log.debug("Before calling DAO method addLocation()");
        businessMapper.addLocationToService(locationToService);
        log.debug("After calling DAO method addLocation()");
    }

    public void updateLocationToService(LocationToService locationToService ) throws DataAccessException {
        log.debug("Before calling DAO method addLocation()");
        businessMapper.updateLocationToService(locationToService);
        log.debug("After calling DAO method addLocation()");
    }

    public List<LocationToService> getBusinessLocationToService(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getBusinessLocationToService()");
        return businessMapper.getBusinessLocationToService(bizId);
    }

    public PackageDetails getPackageDetails(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getPackageDetails()");
        return businessMapper.getPackageDetails(bizId);
    }

    public List<LocationToService> getUniqueLocationToService(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getUniqueLocationToService()");
        return businessMapper.getUniqueLocationToService(bizId);
    }

    public List<LocationToService> getUniqueLocation(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getUniqueLocation()");
        return businessMapper.getUniqueLocation(bizId);
    }

    public List<ServiceMaster> getUniqueLocationToServiceByLocIdBizId(Integer locId,Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getUniqueLocationToServiceByLocIdBizId()");
        return businessMapper.getUniqueLocationToServiceByLocIdBizId(locId,bizId);
    }

    public List<ServiceMaster> getServiceListByBizIdCategoryCodeLocId(Integer bizId,Integer categoryCode,Integer locId) throws DataAccessException {
        log.debug("Calling DAO method getServiceListByBizIdCategoryCodeLocId()");
        return businessMapper.getServiceListByBizIdCategoryCodeLocId(bizId,categoryCode,locId);
    }

    public void deleteLocationToService(Integer bizId ) throws DataAccessException {
        log.debug("Before calling DAO method deleteLocationToService()");
        businessMapper.deleteLocationToService(bizId);
        log.debug("After calling DAO method deleteLocationToService()");
    }

    public void deleteLocationToServiceBySvcIdLocId(Integer locId,Integer svcId,Integer userId) throws DataAccessException {
        log.debug("Before calling DAO method deleteLocationToService()");
        businessMapper.deleteLocationToServiceBySvcIdLocId(locId,svcId,userId);
        log.debug("After calling DAO method deleteLocationToService()");
    }

    public List<Location> getLocationListForAddingSvc(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getLocations()");
        return businessMapper.getLocationListForAddingSvc(bizId);
    }

    public void deleteResourceToServiceByResIdSvcId(Integer resId,Integer svcId, Integer locId,Integer userId) throws DataAccessException {
        log.debug("Before calling DAO method deleteResourceToServiceByResIdSvcId()");
        businessMapper.deleteResourceToServiceByResIdSvcId(resId,svcId,locId,userId);
        log.debug("After calling DAO method deleteResourceToServiceByResIdSvcId()");
    }

    public List<Resource> getResourceToServiceByResId(Integer resId) throws DataAccessException {
        log.debug("Calling DAO method getResourceToServiceByResId()");
        return businessMapper.getResourceToServiceByResId(resId);
    }

    public Location getLocationByNickName(String locName, Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getLocationByNickName()");
        return businessMapper.getLocationByNickName(locName, bizId);
    }

    public Business getBusinessByBizNameEmail(String bizName,String email) throws DataAccessException {
        log.debug("Calling DAO method getBusinessByBizNameEmail()");
        return businessMapper.getBusinessByBizNameEmail(bizName,email);
    }

    public Resource getUserByUserId(Integer userId) throws DataAccessException {
        log.debug("Calling DAO method getUserByUserId()"+userId);
        return businessMapper.getUserByUserId(userId);
    }

    public Resource getUserByEmailId(String emailId) throws DataAccessException {
        log.debug("Calling DAO method getUserByUserId()"+emailId);
        return businessMapper.getUserByEmailId(emailId);
    }

    public void addResourceHours(Resource resource) throws DataAccessException {
        log.debug("Before calling DAO method addResourceHours()"+resource.getDayOfWeek()+"----"+resource.getOpenTime());
        businessMapper.addResourceHours(resource);
        log.debug("After calling DAO method addResourceHours()");
    }

    public void addResourceCertificate(ResourceCertificate resourceCertificate) throws DataAccessException {
        log.debug("Before calling DAO method addResourceCertificate()");
        businessMapper.addResourceCertificate(resourceCertificate);
        log.debug("After calling DAO method addResourceCertificate()");
    }

    public List<ResourceHours> getResourceHours(Integer resId) throws DataAccessException {
        log.debug("Calling DAO method getResourceHours()"+resId);
        return businessMapper.getResourceHours(resId);
    }

    public List<ResourceHours> getResourceHoursByBizId(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getResourceHoursByBizId()"+bizId);
        return businessMapper.getResourceHoursByBizId(bizId);
    }

    public List<ResourceHours> getResHoursByBizId(Integer bizId) {
        log.debug("Calling DAO method getResHoursByBizId()"+bizId);
        return businessMapper.getResHoursByBizId(bizId);
    }

    // function to get the default holidays for the branches
    public List<BusinessHoliday> getDefaultHolidayForBranches(String locId, String countryCode) throws DataAccessException {
        log.debug("Calling DAO method getDefaultHolidayForBranches()..locid is "+locId+" and country code is "+countryCode);
        return businessMapper.getDefaultHolidayForBranches(locId,countryCode);
    }

    // function to get the default holidays for the branches in the date and month format
    public List<BusinessHoliday> getDefaultHolidayForBranchesInDateNMonth(String locId, String countryCode) throws DataAccessException {
        log.debug("Calling DAO method getDefaultHolidayForBranchesInDateNMonth()..locid is "+locId+" and country code is "+countryCode);
        return businessMapper.getDefaultHolidayForBranchesInDateNMonth(locId,countryCode);
    }

    public List<Holiday> getHolidaysByCountryCode(String countryCode) throws DataAccessException {
        log.debug("Calling DAO method getHolidaysByCountryCode()");
        return businessMapper.getHolidaysByCountryCode(countryCode);
    }

    public List<BusinessHoliday> getHolidayByLocId(Integer locId) throws DataAccessException {
        log.debug("Calling DAO method getHolidayByLocId()"+locId);
        return businessMapper.getHolidayByLocId(locId);
    }

    public com.amazech.onsked.domain.Service getService(Integer svcId) throws DataAccessException {
        log.debug("Calling DAO method getService()");
        return businessMapper.getService(svcId);
    }

    public List<com.amazech.onsked.domain.Service> getServices(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getServices()");
        return businessMapper.getServices(bizId);
    }

    public void addService(com.amazech.onsked.domain.Service service) throws DataAccessException {
        log.debug("Before calling DAO method addService()");
        businessMapper.addService(service);
        log.debug("After calling DAO method addService()");
    }

    public void updateService(com.amazech.onsked.domain.Service service) throws DataAccessException {
        log.debug("Before calling DAO method updateService()");
        businessMapper.updateService(service);
        log.debug("After calling DAO method updateService()");
    }

    public void deleteService(Integer svcId) throws DataAccessException {
        log.debug("Before calling DAO method deleteService()");
        businessMapper.deleteService(svcId);
        log.debug("After calling DAO method deleteService()");
    }

    public List<BusinessHours> getBusinessHours(Integer bizId,String tmZnCode) throws DataAccessException {
        log.debug("Calling DAO method getBusinessHours()");
        return businessMapper.getBusinessHours(bizId,tmZnCode);
    }

    public List<ServiceMaster> getServiceNames(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getServiceNames()");
        return businessMapper.getServiceNames(bizId);
    }

    public Location getLocIdByBizId(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getLocIdByBizId()");
        return businessMapper.getLocIdByBizId(bizId);
    }

    public List<BusinessHoliday> getBusinessHolidayByBizIdLocId(Integer bizId,Integer locId) throws DataAccessException {
        log.debug("Calling DAO method getBusinessHolidayByBizIdLocId()"+bizId);
        return businessMapper.getBusinessHolidayByBizIdLocId(bizId,locId);
    }

    public List<BusinessHoliday> getHolidayByLocIdInFormatyyyyMMdd(Integer locId) throws DataAccessException {
        log.debug("Calling DAO method getHolidayByLocIdInFormatyyyyMMdd()"+locId);
        return businessMapper.getHolidayByLocIdInFormatyyyyMMdd(locId);
    }

    public List<LocationToService> getLocationToServiceByLocIdSvcId(Integer locId,Integer svcId) throws DataAccessException {
        log.debug("Calling DAO method getLocationToServiceByLocIdSvcId()..locId is "+locId+" and svc id is "+svcId);
        return businessMapper.getLocationToServiceByLocIdSvcId(locId,svcId);

    }

    public void deleteBusiness(Integer bizId,Integer userId) throws DataAccessException {
        log.debug("Before executing query Business.setBusinessIsDeleted");
        businessMapper.deleteBusiness(bizId,userId);
        log.debug("After executing query Business.setBusinessIsDeleted");
    }

    public void deleteBusinessByDownGrade(String bizId,Integer UserId) throws DataAccessException {
        log.debug("Before executing query Business.deleteBusinessByDownGrade");
        businessMapper.deleteBusinessByDownGrade(bizId,UserId);
        log.debug("After executing query Business.deleteBusinessByDownGrade");
    }

    public void deleteLocationByDownGrade(Integer locId,Integer userId) throws DataAccessException {
        log.debug("Before executing query Business.deleteLocationByDownGrade");
        businessMapper.deleteLocationByDownGrade(locId,userId);
        log.debug("After executing query Business.deleteLocationByDownGrade");
    }

    public void deleteResourceByDownGrade(String resId,Integer locId,Integer userId) throws DataAccessException {
        log.debug("Before executing query Business.deleteResourceByDownGrade");
        businessMapper.deleteResourceByDownGrade(resId,locId,userId);
        log.debug("After executing query Business.deleteResourceByDownGrade");
    }

    public void addPackage(Package pack, String commandName) throws DataAccessException {
        log.debug("Before executing query Business.addPackage"+pack.getName());
        businessMapper.addPackage(pack, commandName);
        log.debug("After executing query Business.addPackage");
    }

    public void deletePackageByLocToSvcId(Integer locToSvcId) throws DataAccessException {
        log.debug("Before executing query Business.deletePackageByLocToSvcId"+locToSvcId);
        businessMapper.deletePackageByLocToSvcId(locToSvcId);
        log.debug("After executing query Business.deletePackageByLocToSvcId");
    }

    public List<Business> getAllBusinesses() throws DataAccessException {
        log.debug("Calling DAO method getAllBusinesses()");
        return businessMapper.getAllBusinesses();
    }

    public PackageDetails getPackageDetailsOfBusiness(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getPackageDetailsOfBusiness()");
        return businessMapper.getPackageDetailsOfBusiness(bizId);
    }

    public void deleteResourceHours(Integer resId,Integer locId) throws DataAccessException {
        log.debug("Before executing query Business.deleteResourceHours"+resId);
        businessMapper.deleteResourceHours(resId,locId);
        log.debug("After executing query Business.deleteResourceHours");
    }

    public OnskedList getBusinessHolidayByBizIdLocIdYearOfHoliday(Integer bizId,Integer locId, Integer yr, int pageSize, int pageNo, String sortBy, String sort) throws DataAccessException {
        log.debug("Calling DAO method getBusinessHolidayByBizIdLocIdYearOfHoliday()"+bizId);
        return businessMapper.getBusinessHolidayByBizIdLocIdYearOfHoliday(bizId,locId,yr,pageSize,pageNo,sortBy,sort);
    }

    public Category getResourceTitleByBizId(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getResourceTitleByBizId()");
        return businessMapper.getResourceTitleByBizId(bizId);
    }

    public List<LeaveReason> getLeaveTypes() throws DataAccessException {
        log.debug("Calling DAO method getLeaveTypes()");
        return businessMapper.getLeaveTypes();
    }

    public void addResourceLeave(ResourceLeaveSchedule resourceLeaveSchedule) throws DataAccessException {
        log.debug("Before executing query Business.addResourceLeave");
        businessMapper.addResourceLeave(resourceLeaveSchedule);
        log.debug("After executing query Business.addResourceLeave");
    }

    public OnskedList getAllClients(Integer bizId,int pageSize, int pageNo, String sortBy, String sort, String startDate, String endDate, String clientStatus) throws DataAccessException {
        log.debug("Calling DAO method getAllClients()");
        return businessMapper.getAllClients(bizId,pageSize,pageNo,sortBy,sort, startDate, endDate, clientStatus);
    }

    public OnskedList getAllClientsMoreOptions(Integer bizId,int pageSize, int pageNo, String sortBy, String sort,String countMin,String countMax, String valueMin, String valueMax, String svcId, String statusCode, String startDate, String endDate, String clientStatus, String pkgId, String locId) throws DataAccessException {
        log.debug("Calling DAO method getAllClientsMoreOptions()");
        return businessMapper.getAllClientsMoreOptions(bizId, pageSize, pageNo, sortBy, sort, countMin, countMax, valueMin, valueMax, svcId, statusCode, startDate, endDate, clientStatus, pkgId, locId);
    }

    public Integer addBizClient(Client client,String requestPath) throws DataAccessException {
        log.debug("Before executing query Business.addBizClient");
        return businessMapper.addBizClient(client,requestPath);
    }

    public Integer getClientReferralPresentByClientId(Integer clientId) throws DataAccessException {
        log.debug("Before executing query Business.getClientReferralPresentByClientId");
        return businessMapper.getClientReferralPresentByClientId(clientId);
    }

    public void addBizClientAddInfo(ClientReferral clientReferral) throws DataAccessException {
        log.debug("Before executing query Business.addBizClientAddInfo");
        businessMapper.addBizClientAddInfo(clientReferral);
        log.debug("After executing query Business.addBizClientAddInfo");
    }

    public void updateBizClientAddInfo(ClientReferral clientReferral) throws DataAccessException {
        log.debug("Before executing query Business.updateBizClientAddInfo");
        businessMapper.updateBizClientAddInfo(clientReferral);
        log.debug("After executing query Business.updateBizClientAddInfo");
    }

    public Integer getPackageCountOfBusinessByBizId(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getPackageCountOfBusinessByBizId()");
        return businessMapper.getPackageCountOfBusinessByBizId(bizId);
    }

    public void activateDeactivate(String table,String updateColumn, String updateColumnValue,String conditionColumn, String conditionColumnValue) throws DataAccessException {
        log.debug("Before executing query Business.activateDeactivate");
        businessMapper.activateDeactivate(table,updateColumn,updateColumnValue,conditionColumn,conditionColumnValue);
        log.debug("After executing query Business.activateDeactivate");
    }

    public List<Location> getListOfLocationsAddedAfterBizConfirmation(Integer bizId) throws DataAccessException {
        log.debug("Before executing query Business.getListOfLocationsAddedAfterBizConfirmation");
        return businessMapper.getListOfLocationsAddedAfterBizConfirmation(bizId);
    }

    public List<Location> getListOfInactiveBusinessLocationsWithoutService(Integer bizId) throws DataAccessException {
        log.debug("Before executing query Business.getListOfInactiveBusinessLocationsWithoutService");
        return businessMapper.getListOfInactiveBusinessLocationsWithoutService(bizId);
    }

    public String getTimeZoneCodeByLocId(Integer locId) throws DataAccessException {
        log.debug("Calling DAO method getTimeZoneCodeByLocId()");
        return businessMapper.getTimeZoneCodeByLocId(locId);
    }

    public String getBusinessExpiryDate(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getBusinessExpiryDate()");
        return businessMapper.getBusinessExpiryDate(bizId);
    }

    public List<BusinessHours> getBizHrsWrtTimeZn(Integer bizId,String timeZoneCode,String bizTimeZoneCode) throws DataAccessException {
        log.debug("Calling DAO method getBizHrsWrtTimeZn()");
        return businessMapper.getBizHrsWrtTimeZn(bizId,timeZoneCode,bizTimeZoneCode);
    }

    public List<LocationHours> getLocHrsWrtTmZone(Integer locId,String timeZoneCode) throws DataAccessException {
        log.debug("Calling DAO method getLocHrsWrtTmZone()");
        return businessMapper.getLocHrsWrtTmZone(locId,timeZoneCode);
    }

    public Client getClientDtlsByClientId(Integer clientId) throws DataAccessException {
        log.debug("Calling DAO method getClientDtlsByClientId()");
        return businessMapper.getClientDtlsByClientId(clientId);
    }

    public ClientReferral getClientAddInfoByClientId(Integer clientId) throws DataAccessException {
        log.debug("Calling DAO method getClientAddInfoByClientId()");
        return businessMapper.getClientAddInfoByClientId(clientId);
    }

    public Client getClientDtls(Integer clientId){
        log.debug("Calling DAO method getClientDtls()");
        return businessMapper.getClientDtls(clientId);
    }

    public void updateClientDetails(Client cmdClient) throws DataAccessException {
        log.debug("Before executing query Business.updateClientDetails");
        businessMapper.updateClientDetails(cmdClient);
        log.debug("After executing query Business.updateClientDetails");
    }

    public String getTimeZoneCodeOfBizUser(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getTimeZoneCodeOfBizUser()");
        return businessMapper.getTimeZoneCodeOfBizUser(bizId);
    }

    public OnskedList getClientsByBizIDSearchElement(Integer bizId, String searchElement,int pageSize, int pageNo, String sortBy, String sort, String startDate, String endDate, String clientEmail, String clientPhone, String clientStatus) throws DataAccessException {
        log.debug("Calling DAO method getAllClients()");
        return businessMapper.getClientsByBizIDSearchElement(bizId,searchElement,pageSize,pageNo,sortBy,sort,startDate,endDate,clientEmail,clientPhone,clientStatus);
    }

    public OnskedList getClientsByBizIDSearchElementMoreOptions(Integer bizId, String searchElement,int pageSize, int pageNo, String sortBy, String sort, String countMin,String countMax, String valueMin, String valueMax, String svcId, String statusCode, String startDate, String endDate, String clientStatus, String pkgId, String locId, String clientEmail, String clientPhone) throws DataAccessException {
        log.debug("Calling DAO method getClientsByBizIDSearchElementMoreOptions()");
        return businessMapper.getClientsByBizIDSearchElementMoreOptions(bizId,searchElement,pageSize,pageNo,sortBy,sort,countMin,countMax,valueMin,valueMax,svcId,statusCode,startDate,endDate,clientStatus,pkgId,locId,clientEmail,clientPhone);
    }

    public List<Business> getFeaturedBusinesses() throws DataAccessException {
        log.debug("Calling DAO method getFeaturedBusiness()");
        return businessMapper.getFeaturedBusinesses();
    }

    public List<Course> getCourseDetails() throws DataAccessException {
        log.debug("Calling DAO method getCourseDetails()");
        return businessMapper.getCourseDetails();
    }

    public OnskedList getCourseDetailsBySort(Integer userId,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException {
        log.debug("Calling DAO method getCourseDetails()");
        return businessMapper.getCourseDetailsBySort(userId,pageSize, pageNo, sortBy, sort);
    }

    public Course getCourseDetailsByCourseId(String courseId) throws DataAccessException {
        log.debug("Calling DAO method getCourseDetailsByCourseId()");
        return businessMapper.getCourseDetailsByCourseId(courseId);
    }

    public Resource getResourceOfLocation(Integer resId,Integer locId) throws DataAccessException {
        log.debug("Calling DAO method getResourceOfLocation().. resId is "+resId+" and loc id is"+locId);
        return businessMapper.getResourceOfLocation(resId,locId);
    }

    public List<ResourceHours> getResourceHoursByResIdLocId(Integer resId,Integer locId) throws DataAccessException {
        log.debug("Calling DAO method getResourceHoursByResIdLocId().. resId is "+resId+" and loc id is"+locId);
        return businessMapper.getResourceHoursByResIdLocId(resId,locId);
    }

    public List<ResourceCertificate> getResourceCertificateByResId(Integer resId) throws DataAccessException {
        log.debug("Calling DAO method getResourceCertificateByResId().. ");
        return businessMapper.getResourceCertificateByResId(resId);
    }

    public Resource getResourceByResId(Integer resId) throws DataAccessException {
        log.debug("Calling DAO method getResource()");
        return businessMapper.getResourceByResId(resId);
    }

    public List<ResourceHours> getResourceHoursOfAllLocations(Integer resId) throws DataAccessException {
        log.debug("Calling DAO method getResourceHoursOfAllLocations()"+resId);
        return businessMapper.getResourceHoursOfAllLocations(resId);
    }

    public Resource getResourceByEmail(String email) throws DataAccessException {
        log.debug("Calling DAO method getResourceByEmail()");
        return businessMapper.getResourceByEmail(email);
    }

    public Resource getResourceByEmailIsDeleted(String email) throws DataAccessException {
        log.debug("Calling DAO method getResourceByEmailIsDeleted()");
        return businessMapper.getResourceByEmailIsDeleted(email);
    }

    public Resource getResourceByDiffNickName(String email,String nickName) throws DataAccessException {
        log.debug("Calling DAO method getResourceByDiffNickName()");
        return businessMapper.getResourceByDiffNickName(email,nickName);
    }

    public Resource getResourceByLocIdAndEmail(String locId,String email) throws DataAccessException {
        log.debug("Calling DAO method getResourceByLocIdAndEmail()");
        return businessMapper.getResourceByLocIdAndEmail(locId,email);
    }

    public Integer getApptCountToResource(String resId,String locId) {
        return businessMapper.getApptCountToResource(resId,locId);
    }

    public void updateLocationToSvc(Package pack) throws DataAccessException {
        log.debug("Before executing query Business.updateLocationToSvc"+pack.getName());
        businessMapper.updateLocationToSvc(pack);
        log.debug("After executing query Business.updateLocationToSvc");
    }

    public String getAddressOfClient(String clientId) throws DataAccessException {
        log.debug("Calling DAO method getAddressOfClient()");
        return businessMapper.getAddressOfClient(clientId);
    }

    public String getclientLocationOrNot(String locId,String svcId) throws DataAccessException {
        log.debug("Calling DAO method getclientLocationOrNot()");
        return businessMapper.getclientLocationOrNot(locId,svcId);
    }

    public String getapptIdByCourseId(String courseId) throws DataAccessException {
        log.debug("Calling DAO method getapptIdByCourseId()");
        return businessMapper.getapptIdByCourseId(courseId);
    }

    public String getAddressOfLocation(String locId) throws DataAccessException {
        log.debug("Calling DAO method getAddressOfLocation()");
        return businessMapper.getAddressOfLocation(locId);
    }
    public List<Package> getPackagesByLocIdSvcId(Integer locId,Integer svcId, Integer bizId) {
        log.debug("Calling DAO method getPackagesByLocIdSvcId()");
        return businessMapper.getPackagesByLocIdSvcId(locId,svcId,bizId);
    }
    public List<GroupPackage> getGroupPkgType() {
        log.debug("Calling DAO method getGroupPkgType()");
        return businessMapper.getGroupPkgType();
    }

    public List<Package> getPackagesByLocIdResId(Integer locId,Integer resId) {
        log.debug("Calling DAO method getPackagesByLocIdResId()");
        return businessMapper.getPackagesByLocIdResId(locId,resId);
    }
    public Integer addPromotion(Promotion promotion) {
        log.debug("Before calling DAO method addPromotion()");
        return businessMapper.addPromotion(promotion);
    }

    public Promotion getPromotionByPromotionId(Integer promotionId) {
        log.debug("Calling DAO method getPromotionByPromotionId()");
        return businessMapper.getPromotionByPromotionId(promotionId);
    }

    public  OnskedList getPastPromotion(String curDate, Integer bizId,int pageSize,int pageNo,String sortBy,String sort) {
        log.debug("Calling DAO method getPastPromotion()");
        return businessMapper.getPastPromotion(curDate, bizId,pageSize,pageNo,sortBy,sort);
    }

    public  OnskedList getSavedPromotion(Integer bizId,int pageSize,int pageNo,String sortBy,String sort) {
        log.debug("Calling DAO method getSavedPromotion()");
        return businessMapper.getSavedPromotion(bizId,pageSize,pageNo,sortBy,sort);
    }

    public OnskedList getPastInactivePromotion(String curDate,Integer bizId,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException {
        log.debug("Calling DAO method getPastInactivePromotion()");
        return businessMapper.getPastInActivePromotion(curDate, bizId,pageSize,pageNo,sortBy,sort);
    }

    public void disablePromotion(int promotionId) {
        log.debug("Before calling DAO method diablePromotion()");
        businessMapper.disablePromotion(promotionId);
        log.debug("After calling DAO method diablePromotion()");
    }

    public void deletePromotion(int promotionId) {
        log.debug("Before calling DAO method deletePromotion()");
        businessMapper.deletePromotion(promotionId);
        log.debug("After calling DAO method deletePromotion()");
    }

    public void addDataToClients(String destinationDir) {
        log.debug("Before calling DAO method addDataToClients()");
        businessMapper.addDataToClients(destinationDir);
        log.debug("After calling DAO method addDataToClients()");
    }

    public List<Promotion> getActivePromotion(Integer bizId) {
        log.debug("Calling DAO method getActivePromotion()");
        return businessMapper.getActivePromotion(bizId);
    }

    public Business getAdditional(Integer bizId) {
        log.debug("Calling DAO method getAdditional()");
        return businessMapper.getAdditional(bizId);
    }

    public void getAdditionalEdit(Integer bizId1) {
        log.debug("Before calling DAO method getAdditionalEdit()");
        businessMapper.getAdditionalEdit(bizId1);
        log.debug("After calling DAO method getAdditionalEdit()");

    }

    public OnskedList getUpComingPromotion(String curDate, Integer bizId,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException {
        log.debug("Calling DAO method getUpComingPromotion()");
        return businessMapper.getUpComingPromotion(curDate, bizId,pageSize,pageNo,sortBy,sort);
    }

    public OnskedList getOngoingPromotion(String curDate, Integer bizId,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException {
        log.debug("Calling DAO method getOngoingPromotion()");
        return businessMapper.getOngoingPromotion(curDate, bizId,pageSize,pageNo,sortBy,sort);
    }

    public void updatePromotion(Promotion promotion) {
        log.debug("Before calling DAO method updatePromotion()");
        businessMapper.updatePromotion(promotion);
        log.debug("After calling DAO method updatePromotion()");
    }

    public Double getAppointmentRatingByBizId(Integer bizId) {
        log.debug("Calling DAO method getAppointmentRatingByBizId()");
        return businessMapper.getAppointmentRatingByBizId(bizId);
    }

    public List<Business> getBusinessPromotion(int userId) {
        log.debug("Calling DAO method getBusinessPromoiton()");
        return businessMapper.getBusinessPromotion(userId);
    }

    public void disablePastPromotion(int promotionId) {
        log.debug("Before calling DAO method disablePastPromotion()");
        businessMapper.disablePastPromotion(promotionId);
        log.debug("After calling DAO method disablePastPromotion()");
    }

    public List<Business> getBusinessesByUserIdByPromotionId(int userId) {
        log.debug("Calling DAO method getBusinessesByUserIdByPromotionId()");
        return businessMapper.getBusinessesByUserIdByPromotionId(userId);
    }

    public boolean getPromotionByPromotionCode(String promotionCode, String svcId, Integer locId, String date, Integer userId, int pkgId) {
        log.debug("Calling DAO method getPromotionByPromotioncode()");
        return businessMapper.getPromotionByPromotionCode(promotionCode,svcId,locId,date,userId,pkgId);
    }

    public boolean getPromotionByPromotionCodeByClientId( String promotionCode, String svcId, Integer locId, String date, String clientId,int pkgId) {
        log.debug("Calling DAO method getPromotionByPromotionCodeByClientId()");
        return businessMapper.getPromotionByPromotionCodeByClientId(promotionCode,svcId,locId,date,clientId,pkgId);
    }

    public Integer checkPromotionCodeExist(String promotionCode) {
        log.debug("Calling DAO method checkPromotionCodeExist()");
        return businessMapper.checkPromotionCodeExist(promotionCode);
    }

    public String oldPromotionCode(Integer promotionId) {
        log.debug("Calling DAO method checkPromotionCodeExist()");
        return businessMapper.oldPromotionCode(promotionId);
    }

    public Integer getCountOfApptsToLoc(Integer locId) {
        log.debug("Before Calling DAO method getCountOfApptsToLoc()");
        Integer cnt = businessMapper.getCountOfApptsToLoc(locId);
        log.debug("After Calling DAO method getCountOfApptsToLoc()");
        return cnt;
    }

    public Integer getApptCntToBiz(Integer bizId) {
        log.debug("Before Calling DAO method getApptCntToBiz()");
        Integer cnt = businessMapper.getApptCntToBiz(bizId);
        log.debug("After Calling DAO method getApptCntToBiz()");
        return cnt;
    }

    public List<ResourceHours> getResourceHoursByLocation(Integer resId,
                                                          Integer locId1) {
        log.debug("Before Calling DAO method getApptCntToBiz()");
        //log.debug("After Calling DAO method getApptCntToBiz()");
        return businessMapper.getResourceHoursByLocation(resId,locId1);
    }

    //get all the services for the location by bizId
    public List<Location> getLocationScvByBizId(Integer bizId) {
        log.debug("Before Calling DAO method getLocationScvByBizId()");
        List<Location> locationServices = businessMapper.getLocationScvByBizId(bizId);
        log.debug("After Calling DAO method getLocationScvByBizId()");
        return locationServices;
    }
    public  List<Business> getUserBusinessPromotion(Integer userId) {
        log.debug("Calling DAO method getUserBusinessPromotion(Integer userId)");
        return businessMapper.getUserBusinessPromotion(userId);
    }


    public Integer getAppointmentsCount(Integer bizId,Integer locId,String svcId,Integer resId,String startTime) {
        log.debug("Before Calling DAO method getAppointmentsCount()");
        int apptCount = businessMapper.getAppointmentsCount(bizId,locId,svcId,resId,startTime);
        log.debug("After Calling DAO method getAppointmentsCount()");
        return apptCount;
    }
    public List<Location> getLocationPackageExist(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getLocationPackageExist()");
        return businessMapper.getLocationPackageExist(bizId);
    }
    public void addMaterial(Materials material) {
        log.debug("Before Calling DAO method addMaterial()");
        businessMapper.addMaterial(material);
        log.debug("After Calling DAO method addMaterial()");
    }

    public Integer checkForDupliceteMaterial(String matName,Integer bizId) {
        log.debug("Before Calling DAO method checkForDupliceteMaterial()");
        Integer cnt = businessMapper.checkForDupliceteMaterial(matName,bizId);
        log.debug("After Calling DAO method checkForDupliceteMaterial()");
        return cnt;
    }

    public List<Materials> getMaterialsByBizIdByMatId(int bizId,Integer pkgId,int matId) {
        log.debug("Before Calling DAO method getMaterialsByBizIdByMatId()");
        List<Materials> materials = (List<Materials>)businessMapper.getMaterialsByBizIdByMatId(bizId,pkgId,matId);
        log.debug("After Calling DAO method getMaterialsByBizIdByMatId()");
        return materials;
    }

    public List<Materials> getMaterialsByBizId(int bizId, Integer pkgId) {
        log.debug("Before Calling DAO method getMaterialsByBizId()");
        List<Materials> materials = (List<Materials>) businessMapper.getMaterialsByBizId(bizId,pkgId);
        log.debug("After Calling DAO method getMaterialsByBizId()");
        return materials;
    }



    public void addMaterialToPkg(MatToPackage mat) {
        log.debug("Before Calling DAO method addMaterialToPkg()");
        businessMapper.addMaterialToPkg(mat);
        log.debug("After Calling DAO method addMaterialToPkg()");
    }

    public List<Business> getActiveBusinessesByUserId(Integer userId) {
        log.debug("Before Calling DAO method getActiveBusinessesByUserId()");
        List<Business> bizList = (List<Business>) businessMapper.getActiveBusinessesByUserId(userId);
        log.debug("After Calling DAO method getActiveBusinessesByUserId()");
        return bizList;
    }

    public List<Package> getPkgsToSvcsByLocId(Integer locId) {
        log.debug("Before Calling DAO method getPkgsToSvcsByLocId()");
        List<Package> pkgsToSvcs = (List<Package>) businessMapper.getPkgsToSvcsByLocId(locId);
        log.debug("After Calling DAO method getPkgsToSvcsByLocId()");
        return pkgsToSvcs;
    }

    public List<MatToPackage> getMaterialsToPkgByLocSvcId(Integer pkgId) {
        log.debug("Before Calling DAO method getMaterialsToPkgByCategoryCodeAndLocSvcId()");
        List<MatToPackage> matToPkg= (List<MatToPackage>) businessMapper.getMaterialsToPkgByLocSvcId(pkgId);
        log.debug("After Calling DAO method getMaterialsToPkgByCategoryCodeAndLocSvcId()");
        return matToPkg;
    }

    public MatToPackage getMaterialAndQtyByMatId(String matId,Integer pkg) {
        log.debug("Before Calling DAO method getMaterialAndQtyByMatId()");
        MatToPackage matToPkg= (MatToPackage) businessMapper.getMaterialAndQtyByMatId(matId,pkg);
        log.debug("After Calling DAO method getMaterialAndQtyByMatId()");
        return matToPkg;
    }

    public void updateMatMaster(Materials matToPkg) {
        log.debug("Before calling DAO method updateMatMaster()");
        businessMapper.updateMatMaster(matToPkg);
        log.debug("After calling DAO method updateMatMaster()");
    }

    public Materials getMatByMatId(Integer matId) {
        log.debug("Before Calling DAO method getMatByMatId()");
        Materials matToPkg= (Materials) businessMapper.getMatByMatId(matId);
        log.debug("After Calling DAO method getMatByMatId()");
        return matToPkg;
    }

    public void updateMatToPkg(Integer pkg,String materialId,
                               String qtyNeeded, Integer matId) {
        log.debug("Before calling DAO method updateMatToPkg()");
        businessMapper.updateMatToPkg(pkg,materialId,qtyNeeded,matId);
        log.debug("After calling DAO method updateMatToPkg()");
    }

    public void deleteMaterialToPackage(MatToPackage mtp) {
        log.debug("Before calling DAO method deleteMaterialToPackage()");
        businessMapper.deleteMaterialToPackage(mtp);
        log.debug("After calling DAO method deleteMaterialToPackage()");
    }

    public List<Materials> getMaterialsListByBizId(Integer bizId) {
        log.debug("Before Calling DAO method getMaterialsListByBizId()");
        List<Materials> mats= (List<Materials>) businessMapper.getMaterialsListByBizId(bizId);
        log.debug("After Calling DAO method getMaterialsListByBizId()");
        return mats;
    }

    public Integer getMatCountByMatNameAndManufacturer(Integer bizId,
                                                       String matName, String manufacturer) {
        log.debug("Before Calling DAO method getMatCountByMatNameAndManufacturer()");
        Integer matCnt = (Integer) businessMapper.getMatCountByMatNameAndManufacturer(bizId,matName,manufacturer);
        log.debug("After Calling DAO method getMatCountByMatNameAndManufacturer()");
        return matCnt;
    }

    public void updateMasterMaterial(Materials cmdMat) {
        log.debug("Before calling DAO method updateMasterMaterial()");
        businessMapper.updateMasterMaterial(cmdMat);
        log.debug("After calling DAO method updateMasterMaterial()");
    }

    public Integer checkForPkgUsingMaterial(Integer matId) {
        log.debug("Before Calling DAO method checkForPkgUsingMaterial()");
        Integer matCnt = (Integer) businessMapper.checkForPkgUsingMaterial(matId);
        log.debug("After Calling DAO method checkForPkgUsingMaterial()");
        return matCnt;
    }

    public void deleteMasterMaterialByMatId(Integer matId) {
        log.debug("Before calling DAO method deleteMasterMaterialByMatId()");
        businessMapper.deleteMasterMaterialByMatId(matId);
        log.debug("After calling DAO method deleteMasterMaterialByMatId()");
    }

    public Integer addPurchase(PurchaseHeader cmdPurchaseHeader) {
        log.debug("Before Calling DAO method addPurchase()");
        Integer pId = businessMapper.addPurchase(cmdPurchaseHeader);
        log.debug("After Calling DAO method addPurchase()");
        return pId;
    }

    public PurchaseHeader getBasicPurchaseDetailsByPid(Integer pId,Integer bizId) {
        log.debug("Before Calling DAO method getBasicPurchaseDetailsByPid()");
        PurchaseHeader ph = (PurchaseHeader) businessMapper.getBasicPurchaseDetailsByPid(pId,bizId);
        log.debug("After Calling DAO method getBasicPurchaseDetailsByPid()");
        return ph;
    }

    public void addPurchaseDetails(PurchaseDetails temp_pd) {
        log.debug("Before Calling DAO method addPurchaseDetails()");
        businessMapper.addPurchaseDetails(temp_pd);
        log.debug("After Calling DAO method addPurchaseDetails()");
    }

    public void updateBasicPurchaseMaterial(PurchaseHeader cmdPurchaseHeader) {
        log.debug("Before calling DAO method updateBasicPurchaseMaterial()");
        businessMapper.updateBasicPurchaseMaterial(cmdPurchaseHeader);
        log.debug("After calling DAO method updateBasicPurchaseMaterial()");
    }

    public void stocksCronjob() {
        log.debug("Before calling DAO method stocksCronjob()");
        businessMapper.stocksCronjob();
        log.debug("After calling DAO method stocksCronjob()");
    }

    public OnskedList getStocksToLocId(Integer locId,int pageSize, int pageNo, String sortBy, String sort) {
        log.debug("Before calling DAO method getStocksToLocId()");
        //OnskedList= businessMapper.getStocksToLocId(locId, pageSize,  pageNo, sortBy,  sort);
        log.debug("After calling DAO method getStocksToLocId()");
        return businessMapper.getStocksToLocId(locId,pageSize,pageNo,sortBy,sort);
    }

    public Integer getInventoryBizCountByUserId(Integer userId) {
        log.debug("Before calling DAO method getInventoryBizCountByUserId()");
        Integer cnt= (Integer)businessMapper.getInventoryBizCountByUserId(userId);
        log.debug("After calling DAO method getInventoryBizCountByUserId()");
        return cnt;
    }

    public void updatePurchaseHeader(Integer purchaseId) {
        log.debug("Before calling DAO method updatePurchaseHeader()");
        businessMapper.updatePurchaseHeader(purchaseId);
        log.debug("After calling DAO method updatePurchaseHeader()");
    }

    public OnskedList getBusinessesByUserIdByPromotionIdByLimitBySort(int userId,int pageSize,int pageNo,String sortBy,String sort) {
        log.debug("Calling DAO method getBusinessesByUserIdByPromotionIdByLimitBySort()");
        return businessMapper.getBusinessesByUserIdByPromotionIdByLimitBySort(userId,pageSize,pageNo,sortBy,sort);
    }

    public List<ServiceMaster> getMasterServicesByBizId(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getMasterServices()"+bizId);
        return businessMapper.getMasterServicesByBizId(bizId);
    }

    public List<ServiceMaster> getServiceListByBizIdLocId(Integer bizId,
                                                          Integer loc) {
        log.debug("Calling DAO method getServiceListByBizIdLocId()");
        return businessMapper.getServiceListByBizIdLocId(bizId,loc);
    }

    public List<Category> getBusinessCategoriesNotSelected(Integer bizId) {
        log.debug("Calling DAO method getBusinessCategoriesNotSelected()");
        return businessMapper.getBusinessCategoriesNotSelected(bizId);
    }

    public List<Category> getBusinessCategoriesSelected(Integer bizId) {
        log.debug("Calling DAO method getBusinessCategoriesSelected()");
        return businessMapper.getBusinessCategoriesSelected(bizId);
    }

    public List<Category> getBusinessCategoriesUsed(Integer bizId) {
        log.debug("Calling DAO method getBusinessCategoriesUsed()");
        return businessMapper.getBusinessCategoriesUsed(bizId);
    }

    public List<Category> getBusinessCategories(Integer bizId) {
        log.debug("Calling DAO method getBusinessCategories()");
        return businessMapper.getBusinessCategories(bizId);
    }

    public Integer getApptCountToResourcePast(String resId,String locId) {
        return businessMapper.getApptCountToResourcePast(resId,locId);
    }

    public Resource getResourceToLocationByNickName(String nickName,
                                                    Integer locId, Integer bizId) {
        log.debug("Calling DAO method getResourceToLocationByNickName()");
        return businessMapper.getResourceToLocationByNickName(nickName,locId,bizId);
    }

    public List<Resource> getResourceByNickNamelist(String nickName, Integer locId,
                                                    Integer bizId) {
        log.debug("Calling DAO method getResourceByNickNamelist()");
        return businessMapper.getResourceByNickNamelist(nickName,locId,bizId);
    }

    public List<Resource> getResourceToLocationByNickNameList(String nickName,
                                                              Integer locId, Integer bizId) {
        log.debug("Calling DAO method getResourceToLocationByNickNameList()");
        return businessMapper.getResourceToLocationByNickNameList(nickName,locId,bizId);
    }

    public void addResourceToService(Integer locId, Integer resId, String svcId,int userId) {
        log.debug("Calling DAO method addResourceToService()");
        businessMapper.addResourceToService(locId,resId,svcId,userId);
        log.debug("After calling DAO method addResourceToService()");

    }

    public void updateLocationToResource(Integer locId, Integer resId,
                                         int userId) {
        // TODO Auto-generated method stub
        log.debug("Calling DAO method updateLocationToResource()");
        businessMapper.updateLocationToResource(locId,resId,userId);
        log.debug("After calling DAO method updateLocationToResource()");

    }

    public List<ServiceMaster> getUniqueLocationToServiceByLocIdBizIdforCategoryCode(
            Integer loc, Integer bizId) {
        log.debug("Calling DAO method getUniqueLocationToServiceByLocIdBizIdforCategoryCode()");
        return businessMapper.getUniqueLocationToServiceByLocIdBizIdforCategoryCode(loc,bizId);
    }

    public List<ServiceMaster> getUniqueLocationToServiceByLocIdBizIdOnCategoryCode(
            int locId, int bizId) {
        log.debug("Calling DAO method getUniqueLocationToServiceByLocIdBizIdOnCategoryCode()");
        return businessMapper.getUniqueLocationToServiceByLocIdBizIdOnCategoryCode(locId,bizId);
    }

    public List<ServiceMaster> getResourceServicesByCategory(int resId,
                                                             int locId) {
        log.debug("Calling DAO method getResourceServicesByCategory()");
        return businessMapper.getResourceServicesByCategory(locId,resId);
    }

	/*public void disableResource(Integer resId, String isActive, Integer locId) {
		log.debug("Before calling DAO method deleteResource()");
		businessMapper.disableResource(resId,isActive,locId);
		log.debug("After calling DAO method deleteResource()");

	}*/

    public List<Location> getLocsToBizWhichHasActiveRes(int bizId) {
        log.debug("Before calling DAO method getLocsToBizWhichHasActiveRes()");
        List<Location> locs = businessMapper.getLocsToBizWhichHasActiveRes(bizId);
        log.debug("After calling DAO method getLocsToBizWhichHasActiveRes()");
        return locs;
    }

    public List<Client> getClientInfoForBizCal(int bizId) {
        log.debug("Before calling DAO method getClientInfoForBizCal()");
        List<Client> cls = businessMapper.getClientInfoForBizCal(bizId);
        log.debug("After calling DAO method getClientInfoForBizCal()");
        return cls;
    }

    public List<Client> getClientInfoForCourseCal(int bizId) {
        log.debug("Before calling DAO method getClientInfoForCourseCal()");
        List<Client> cls = businessMapper.getClientInfoForCourseCal(bizId);
        log.debug("After calling DAO method getClientInfoForCourseCal()");
        return cls;
    }

    public Integer getApptCountToService(Integer svcId, Integer loc) {
        return businessMapper.getApptCountToService(svcId,loc);
    }

    public Integer getApptCountToResourceService(Integer locId, Integer resId, Integer svcId)
    {
        return businessMapper.getApptCountToResourceService(locId, resId, svcId);
    }

    public Integer getResCountToService(Integer svcId, Integer loc) {
        return businessMapper.getResCountToService(svcId,loc);
    }

    public OnskedList checkToDelSvc(Integer svcId, Integer loc) {
        return businessMapper.checkToDelSvc(svcId,loc);
    }

    public int addMaterialAndGetMatId(Materials cmdMat) {
        log.debug("Before Calling DAO method addMaterialAndGetMatId()");
        int matId=businessMapper.addMaterialAndGetMatId(cmdMat);
        log.debug("After Calling DAO method addMaterialAndGetMatId()");
        return matId;
    }

    public Integer checkDuplicateClientInBiz(String email, int bizId) {
        log.debug("Before Calling DAO method checkDuplicateClientInBiz()");
        int ccnt=businessMapper.checkDuplicateClientInBiz(email,bizId);
        log.debug("After Calling DAO method checkDuplicateClientInBiz()");
        return ccnt;
    }


    //public OnskedList getMaterialsListByBizIdByLimitBySort(int userId,int pageSize,int pageNo,String sortBy,String sort) {



    public OnskedList getMaterialsListByBizIdByLimitBySort(Integer bizId,
                                                           int pageSize, int pageNo, String sortBy, String sort) {
        log.debug("Calling DAO method getMaterialsListByBizIdByLimitBySort()");
        return businessMapper.getMaterialsListByBizIdByLimitBySort(bizId,pageSize,pageNo,sortBy,sort);

    }
    public OnskedList getMaterialsToPkgByLocSvcIdByLimitBySort(Integer pkgId,Integer bizId,
                                                               int pageSize, int pageNo, String sortBy, String sort) {
        log.debug("Calling DAO method getMaterialsToPkgByLocSvcIdByLimitBySort()");
        return businessMapper.getMaterialsToPkgByLocSvcIdByLimitBySort(pkgId,bizId,pageSize,pageNo,sortBy,sort);
    }

    @Override
    public Business inventoryBreadCrum(Integer pkgId) throws DataAccessException {
        log.debug("Calling DAO method inventoryBreadCrum()");
        return businessMapper.inventoryBreadCrum(pkgId);
    }
    public List<Package> getPackageDetails1(Integer bizId) {
        log.debug("Calling DAO method getPackageDetails1()");
        return businessMapper.getPackageDetails1(bizId);
    }

    public List<Package> getPackageDetailsByLocSvcId(String svcId, Integer pkgId) {
        log.debug("Calling DAO method getPackageDetailsByLocSvcId()");
        return businessMapper.getPackageDetailsByLocSvcId(svcId, pkgId);
    }

    public void updatePackage(Package temp_pd1) {
        log.debug("Calling DAO method updatePackage()");
        businessMapper.updatePackage(temp_pd1);
        log.debug("After calling DAO method updatePackage()");

    }

    public void deletePackages(String packId) {
        log.debug("Calling DAO method deletePackages()");
        businessMapper.deletePackages(packId);
        log.debug("After calling DAO method deletePackages()");
    }

    public int getCountOfAppt(String packId) {
        log.debug("Calling DAO method getCountOfAppt() packId === "+packId);
        return businessMapper.getCountOfAppt(packId);
    }

    public int getCountMaterialToPackage(String packId) {
        log.debug("Calling DAO method getCountMaterialToPackage()");
        return businessMapper.getCountMaterialToPackage(packId);
    }

    public List<Package> getLocSvcId(String svcId) {
        log.debug("Calling DAO method getLocSvcId()");
        return businessMapper.getLocSvcId(svcId);
    }

    // get packages and service name based by bizId
    public List<Package> getPackageDetailsOfBusinessByBizId(Integer bizId) {
        log.debug("Calling DAO method getLocSvcId()");
        return businessMapper.getPackageDetailsOfBusinessByBizId(bizId);
    }

    // get all the packages (including inactive and deleted) for a given business by biz id
    public List<Package> getAllPackagesOfBusinessByBizId(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getAllPackagesOfBusinessByBizId()");
        return businessMapper.getAllPackagesOfBusinessByBizId(bizId);
    }

    //Checking if any appointment is using the package
    public Integer checkForApptUsingPackage(Integer pkgId,Integer matId) {
        log.debug("Before Calling DAO method checkForApptUsingPackage()");
        Integer pkgCnt = (Integer) businessMapper.checkForApptUsingPackage(pkgId,matId);
        log.debug("After Calling DAO method checkForApptUsingPackage()");
        return pkgCnt;
    }
    @Override
    public List<Business> getActiveBusinessesByUserIdForCal(Integer userId) {
        log.debug("Before Calling DAO method getActiveBusinessesByUserIdForCal()");
        List<Business> bizList = (List<Business>) businessMapper.getActiveBusinessesByUserIdForCal(userId);
        log.debug("After Calling DAO method getActiveBusinessesByUserIdForCal()");
        return bizList;
    }

    @Override
    public List<Business> getActiveBusinessesForSMS() {
        log.debug("Before Calling DAO method getActiveBusinessesForSMS()");
        List<Business> bizList = (List<Business>) businessMapper.getActiveBusinessesForSMS();
        log.debug("After Calling DAO method getActiveBusinessesForSMS()");
        return bizList;
    }

    //get the count for locationTo Service 	by loc_id and biz_id
    public Integer getLocationScvByBizIdCount(Integer bizId, Integer locId) {
        log.debug("Calling DAO method getLocationScvByBizIdCount()");
        return businessMapper.getLocationScvByBizIdCount(bizId,locId);
    }

    @Override
    public List<Country> getCountries() {
        log.debug("Calling DAO method getCountries()");
        List<Country> coutries = (List<Country>)businessMapper.getCountries();
        return coutries;
    }

    //To get count of services based on categoryCode and serviceCode
    public int getServiceCount(String categoryCode, String serviceCode) {
        log.debug("Calling DAO method getServiceCount()");
        return businessMapper.getServiceCount(categoryCode,serviceCode);
    }
    //To get count of category based on categoryCode
    public int getCategoryCount(Integer categoryCode) {
        log.debug("Calling DAO method getServiceCount()");
        return businessMapper.getCategoryCount(categoryCode);
    }

    //To get all the location services packages & resources by bizId
    public List<LocationToService> getLocSvcPackRes(Integer bizId) {
        log.debug("Calling DAO method getLocSvcPackRes()");
        return businessMapper.getLocSvcPackRes(bizId);
    }

    //To get all the resources by bizId
    public List<Resource> getResourceDetailsByBizId(Integer bizId) {
        log.debug("Calling DAO method getLocSvcPackRes()");
        return businessMapper.getResourceDetailsByBizId(bizId);
    }

    //To get business details and services
    public Business getBusinessServiceByBizId(Integer bizId) {
        log.debug("Calling DAO method getBusinessByBizId()");
        return businessMapper.getBusinessServiceByBizId(bizId);
    }
    public OnskedList getBusinessesBySort(Integer userId, int pageSize,
                                          int pageNo, String sortBy, String sort) {
        log.debug("Calling DAO method getBusinesses()");
        return businessMapper.getBusinessesBySort(userId,pageSize,pageNo,sortBy,sort);
    }

    public OnskedList getActivebusinessByUserId(Integer userId, int pageSize,
                                                int pageNo, String sortBy, String sort) {
        log.debug("Calling DAO method getActivebusinessByUserId()");
        return businessMapper.getActivebusinessByUserId(userId,pageSize,pageNo,sortBy,sort);
    }

    public List<Business> getBusinessName(Integer userId) {
        log.debug("Calling DAO method getBusinessName()");
        return businessMapper.getBusinessName(userId);
    }

    public List<Location> getLocationName(Integer userId) {
        log.debug("Calling DAO method getLocationName()");
        return businessMapper.getLocationName(userId);
    }

    public List<Resource> getResourceName(Integer userId) {
        log.debug("Calling DAO method getResourceName()");
        return businessMapper.getResourceName(userId);
    }
    public Business getBusinessDetailsByBizId(Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getBusinessDetailsByBizId()");
        return businessMapper.getBusinessDetailsByBizId(bizId);
    }

    //to get all the business with there locations by user id
    public OnskedList getBusinessesByUserIdByInventoryByLimitBySort(int userId,
                                                                    int pageSize, int pageNo, String sortBy, String sort, String isInventory) {
        log.debug("Calling DAO method getBusinessesByUserIdByInventoryByLimitBySort()");
        return businessMapper.getBusinessesByUserIdByInventoryByLimitBySort(userId,pageSize,pageNo,sortBy,sort,isInventory);
    }

    public OnskedList getAllBusinessesBySort(int pageSize, int pageNo,
                                             String sortBy, String sort) {
        log.debug("Calling DAO method getAllBusinessesBySort()");
        return businessMapper.getAllBusinessesBySort(pageSize,pageNo,sortBy,sort);
    }
    public OnskedList getAllDeletedBusinessesBySort(int pageSize, int pageNo,
                                                    String sortBy, String sort) {
        log.debug("Calling DAO method getAllDeletedBusinessesBySort()");
        return businessMapper.getAllDeletedBusinessesBySort(pageSize,pageNo,sortBy,sort);
    }

    public OnskedList getLocationsByLimitBySort(Integer bizId,int pageSize, int pageNo,
                                                String sortBy, String sort) throws DataAccessException {
        log.debug("Calling DAO method getLocations()");
        return businessMapper.getLocationsByLimitBySort(bizId,pageSize,pageNo,sortBy,sort);
    }

    public OnskedList getResourcesByLimitBySort(Integer bizId,int pageSize, int pageNo,String sortBy, String sort) throws DataAccessException {
        log.debug("Calling DAO method getResources()");
        return businessMapper.getResourcesByLimitBySort(bizId,pageSize,pageNo,sortBy,sort);
    }

    public void activateDeletedBusiness(Integer bizId,Integer userId,String requestPath) throws DataAccessException {
        log.debug("Before calling DAO method activateDeletedBusiness()");
        businessMapper.activateDeletedBusiness(bizId,userId,requestPath);
        log.debug("After calling DAO method activateDeletedBusiness()");
    }

    public void deleteResourceCertificateByResCertId(Integer resId,Integer resCertId) throws DataAccessException {
        log.debug("Before calling DAO method deleteResourceCertificateByResCertId()");
        businessMapper.deleteResourceCertificateByResCertId(resId,resCertId);
        log.debug("After calling DAO method deleteResourceCertificateByResCertId()");
    }

    public Promotion getPromotionDetails(Integer promotionId, Integer bizId) throws DataAccessException {
        log.debug("Calling DAO method getResources()");
        return businessMapper.getPromotionDetails(promotionId, bizId);
    }

    public OnskedList listPurchaseDetails(Integer bizId, int pageSize,
                                          int pageNo, String sortBy, String sort) throws DataAccessException {
        log.debug("Calling DAO method getResources()");
        return businessMapper.listPurchaseDetails(bizId,pageSize,pageNo,sortBy,sort);

    }


    public List<PurchaseDetails> getMaterialList(Integer bizId, int pId) throws DataAccessException {
        log.debug("Calling DAO method getResources()");
        return businessMapper.getMaterialList(bizId,pId);
    }

    public void updatePurchaseMaterial(PurchaseDetails purchase) throws DataAccessException {
        log.debug("Before calling DAO method updateBusiness()");
        businessMapper.updatePurchaseMaterial(purchase);
        log.debug("After calling DAO method upadatePurchaseMaterial()");

    }

    public void updateActivebusinessByUserId(Integer bizId,Integer userId,String flagSMS,String flagPIN,String name,Integer modifiedBy) throws DataAccessException {
        log.debug("Before calling DAO method updateActivebusinessByUserId()");
        businessMapper.updateActivebusinessByUserId(bizId,userId,flagSMS,flagPIN,name,modifiedBy);
        log.debug("After calling DAO method updateActivebusinessByUserId()");
    }

    public Integer checkInvoice(Integer bizId, Integer locId,String PurchaseOrder) throws DataAccessException {
        log.debug("Calling DAO method checkInvoice()");
        return businessMapper.checkInvoice(bizId,locId,PurchaseOrder);
    }
    public List<Business> checkLocationExist(int userId) {
        log.debug("Calling DAO method checkLocationExist()");
        return businessMapper.checkLocationExist(userId);
    }

    public OnskedList getUniqueLocationToServiceByLimit(Integer bizId,int pageSize,int pageNo){
        log.debug("Calling DAO method getUniqueLocationToService()");
        return businessMapper.getUniqueLocationToServiceByLimit(bizId,pageSize,pageNo);
    }

    public OnskedList getMaterialsListByBizIdBySearch(Integer bizId,
                                                      String matName, String manufacturer, String disposable,
                                                      int pageSize, int pageNo, String sortBy, String sort) {
        log.debug("Calling DAO method getMaterialsListByBizIdBySearch()");
        return businessMapper.getMaterialsListByBizIdBySearch(bizId,matName,manufacturer,disposable,pageSize,pageNo,sortBy,sort);

    }

    public OnskedList getMatIdsByLocIdBySearch(Integer locId, String matName,String manufacturer,
                                               int pageSize, int pageNo, String sortBy, String sort) {
        log.debug("Calling DAO method getMaterialsListByBizIdBySearch()");
        return businessMapper.getMatIdsByLocIdBySearch(locId,matName,manufacturer,pageSize,pageNo,sortBy,sort);

    }

    //get the count of appointments by bizId and clientId
    public Integer getAppointmentCountByClientIdAndBizId(Integer bizId,
                                                         Integer clientId) {
        log.debug("Calling DAO method getAppointmentCountByClientIdAndBizId()");
        return businessMapper.getAppointmentCountByClientIdAndBizId(bizId,clientId);
    }

    //disabling the client
    public void disableClient(Integer bizId, Integer clientId,Integer userId) {
        log.debug("Before calling DAO method disableClient()");
        businessMapper.disableClient(bizId,clientId,userId);
        log.debug("After calling DAO method disableClient()");

    }

    //enabling the client
    public void enableClient(Integer bizId, Integer clientId,Integer userId) {
        log.debug("Before calling DAO method enableClient()");
        businessMapper.enableClient(bizId,clientId,userId);
        log.debug("After calling DAO method enableClient()");
    }

    public List<ServiceMaster> getUniqueLocationToServiceByLocIdBizIdOnResource(
            int locId, int bizId) {
        log.debug("Calling DAO method getUniqueLocationToServiceByLocIdBizIdOnResource()");
        return businessMapper.getUniqueLocationToServiceByLocIdBizIdOnResource(locId,bizId);

    }

    @Override
    public List<ServiceMaster> getMatchingLocationToServiceByLocIdBizIdOnResource(
            String locId, int bizId) {
        // TODO Auto-generated method stub
        log.debug("Calling DAO method getMatchingLocationToServiceByLocIdBizIdOnResource()");
        return businessMapper.getMatchingLocationToServiceByLocIdBizIdOnResource(locId,bizId);
    }

    public List<Resource> getResourcesForLocByBizId(Integer bizId) {
        log.debug("Calling DAO method getResourcesForLocByBizId()");
        return businessMapper.getResourcesForLocByBizId(bizId);
    }

    @Override
    public List<ResourceHours> getResourceHoursByBizId1(Integer bizId) {
        log.debug("Calling DAO method getResourceHoursByBizId1()"+bizId);
        return businessMapper.getResourceHoursByBizId1(bizId);
    }

    @Override
    public List<LocationHours> getLocationHoursByBizId1(Integer bizId) {
        log.debug("Calling DAO method getLocationHoursByBizId1()"+bizId);
        return businessMapper.getLocationHoursByBizId1(bizId);
    }

    public List<AppointmentSchedule> getAppointmentRatingByCategoryCode(String categoryCode){
        log.info("Before executing the getAppointmentRatingByCategoryCode inside the BusinessSvcImpl");
        return businessMapper.getAppointmentRatingByCategoryCode(categoryCode);
    }
    public List<Package> getPackageDetailsOfBusinessByLocId(Integer locId) {
        log.debug("Calling DAO method getPackageDetailsOfBusinessByLocId" +locId);
        return businessMapper.getPackageDetailsOfBusinessByLocId(locId);
    }

    public List<LocationHours> getLocationHours1(String tmZnCode,Integer locId) throws DataAccessException {
        log.debug("Calling DAO method getLocationHours1()");
        return businessMapper.getLocationHours1(tmZnCode, locId);
    }
    @Override
    public List<LocationToService> getLocSvcPackRes1(Integer bizId,Integer locId) {
        log.debug("Calling DAO method getLocSvcPackRes1()");
        return businessMapper.getLocSvcPackRes1(bizId,locId);
    }

    public List<AppointmentSchedule> getLocationListByBizId(Integer bizId){
        log.debug("Calling DAO method getLocationHours1()");
        return businessMapper.getLocationListByBizId(bizId);
    }

    //get all the patients which are active with limit
    public OnskedList getPatientListByLimitBySort(int userId,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException {
        log.debug("Calling DAO method getAllClients()");
        return businessMapper.getPatientListByLimitBySort(userId,pageSize,pageNo,sortBy,sort);
    }

    public OnskedList getSMSLogByUserId(String userId,String bizId,String startDate, String endDate,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException {
        log.debug("Calling DAO method getSMSLogByUserId()");
        return businessMapper.getSMSLogByUserId(userId,bizId,startDate,endDate,pageSize,pageNo,sortBy,sort);
    }

    //add new patient
    public Integer addPatient(Patient patient) throws DataAccessException {
        log.debug("Calling DAO method addPatient()");
        return businessMapper.addPatient(patient);
    }

    // get the list of clients not in patient table by BizId
    public List<Client> getClientListNotInPatientByBizId(Integer bizId, Integer userId) throws DataAccessException {
        log.debug("Calling DAO method getClientListNotInPatientByBizId()");
        return businessMapper.getClientListNotInPatientByBizId(bizId, userId);
    }

    // get the list of clients not in patient table
    public List<Client> getClientListNotInPatient(Integer userId) throws DataAccessException {
        log.debug("Calling DAO method getClientListNotInPatient()");
        return businessMapper.getClientListNotInPatient(userId);
    }

    // add the illness of patient
    public void addPatientsIllness(PatientIllness patientillness) throws DataAccessException {
        log.info("calling DAO method addPatientsIllness()");
        businessMapper.addPatientsIllness(patientillness);
    }

    //get the list of patient illness details by patientId
    public List<PatientIllness> getPatientIllnessDetailsByPatientId(Integer patientId) throws DataAccessException {
        log.info("calling DAO method getPatientIllnessDetailsByPatientId()");
        return businessMapper.getPatientIllnessDetailsByPatientId(patientId);
    }

    //get the list of prev patient illness details by patientId
    public List<PatientIllness> getPrevPatientIllnessDetailsByPatientId(Integer patientId) throws DataAccessException {
        log.info("calling DAO method getPrevPatientIllnessDetailsByPatientId()");
        return businessMapper.getPrevPatientIllnessDetailsByPatientId(patientId);
    }

    //update the details of illness of patient
    public void updatePatientsIllness(PatientIllness patientIllness) throws DataAccessException {
        log.info("Before calling Dao method updatePatientsIllness()");
        businessMapper.updatePatientsIllness(patientIllness);
    }

    // delete list of patient illness
    public void deletePatientIllness(String patientIllnessId) throws DataAccessException {
        log.info("Before calling DAO method deletePatientIllness()");
        businessMapper.deletePatientIllness(patientIllnessId);
        log.info("After calling DAO method deletePatientIllness()");
    }

    //get the patient insurance list
    public OnskedList getPatientInsuranceListByLimitBySort(int patientId,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException {
        log.info("calling DAO method getPatientInsuranceListByLimitBySort()");
        return businessMapper.getPatientInsuranceListByLimitBySort(patientId,pageSize,pageNo,sortBy,sort);
    }

    public OnskedList getClientInsuranceListByLimitBySort(int clientId,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException {
        log.info("calling DAO method getClientInsuranceListByLimitBySort()");
        return businessMapper.getClientInsuranceListByLimitBySort(clientId,pageSize,pageNo,sortBy,sort);
    }

    public OnskedList getClientPhysicianListByLimitBySort(int clientId,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException {
        log.info("calling DAO method getClientPhysicianListByLimitBySort()");
        return businessMapper.getClientPhysicianListByLimitBySort(clientId,pageSize,pageNo,sortBy,sort);
    }

    // add the patient insurance details
    public void addPatientInsurance(PatientInsurance patientInsurance) throws DataAccessException {
        log.info("Calling DAO method addPatientInsurance()");
        businessMapper.addPatientInsurance(patientInsurance);
    }

    public void addClientInsurance(ClientInsurance clientInsurance) throws DataAccessException {
        log.info("Calling DAO method addClientInsurance()");
        businessMapper.addClientInsurance(clientInsurance);
    }
    public void addClientPhysician(ClientPhysician clientPhysician) throws DataAccessException {
        log.info("Calling DAO method addClientPhysician()");
        businessMapper.addClientPhysician(clientPhysician);
    }
    //get the patient by client Id
    public Patient getPatientByClientId(Integer clientId) throws DataAccessException {
        log.debug("Calling DAO method getPatientByClientId()");
        return businessMapper.getPatientByClientId(clientId);
    }

    //get the patient by patientId
    public Patient getPatientByPatientId(Integer patientId) throws DataAccessException {
        log.info("Before calling DAO method getPatientByPatientId()");
        return businessMapper.getPatientByPatientId(patientId);
    }

    //get the client list by userId
    public List<Client> getClientListByUserId(Integer userId) throws DataAccessException {
        log.debug("Calling DAO method getClientListByUserId()");
        return businessMapper.getClientListByUserId(userId);
    }

    //get the patient by appt Id
    public Patient getPatientByApptId(Integer apptId) throws DataAccessException {
        log.debug("Calling DAO method getPatientByApptId()");
        return businessMapper.getPatientByApptId(apptId);
    }

    public void updatePatient(Patient patient) throws DataAccessException {
        log.info("Before calling DAO method updatePatient()");
        businessMapper.updatePatient(patient);
    }

    public void disablePatient(Integer patientId) throws DataAccessException {
        log.info("Before calling DAO method updatePatient()");
        businessMapper.disablePatient(patientId);
    }

    //get the patient Insurance details by patient Insurance Id
    public PatientInsurance getPatientInsuranceByPatientInsId(Integer patientInsuranceId) throws DataAccessException {
        log.info("Before calling DAO method getPatientInsuranceByPatientInsId()");
        return businessMapper.getPatientInsuranceByPatientInsId(patientInsuranceId);
    }

    public ClientInsurance getClientInsuranceByClientInsId(Integer clientInsuranceId) throws DataAccessException {
        log.info("Before calling DAO method getClientInsuranceByClientInsId()");
        return businessMapper.getClientInsuranceByClientInsId(clientInsuranceId);
    }

    public ClientPhysician getClientPhysicianByClientInsId(Integer clientPhysicianId) throws DataAccessException {
        log.info("Before calling DAO method getClientInsuranceByClientInsId()");
        return businessMapper.getClientPhysicianByClientInsId(clientPhysicianId);
    }

    // update the insurance details
    public void updatePatientInsurance(PatientInsurance patientInsurance) throws DataAccessException {
        log.info("Before calling DAO method updatePatientInsurance()");
        businessMapper.updatePatientInsurance(patientInsurance);
    }

    public void updateClientInsurance(ClientInsurance clientInsurance) throws DataAccessException {
        log.info("Before calling DAO method updateClientInsurance()");
        businessMapper.updateClientInsurance(clientInsurance);
    }

    public void updateClientPhysician(ClientPhysician clientPhysician) throws DataAccessException {
        log.info("Before calling DAO method updateClientPhysician()");
        businessMapper.updateClientPhysician(clientPhysician);
    }

    //delete the patient insurance details
    public void deletePatientInsurance(Integer patientInsId) throws DataAccessException {
        log.info("Before calling DAO method updatePatientInsurance()");
        businessMapper.deletePatientInsurance(patientInsId);
    }

    public void deleteClientInsurance(Integer clientInsId) throws DataAccessException {
        log.info("Before calling DAO method deleteClientInsurance()");
        businessMapper.deleteClientInsurance(clientInsId);
    }

    //get the top 6 master illness list
    public List<PatientIllness> getMasterIllnessList() throws DataAccessException {
        log.info("Before calling DAO method getTopMasterIllnessList()");
        return businessMapper.getMasterIllnessList();
    }

    // get the master illness list not added for patient in patient_illness
    public List<PatientIllness> getPatientIllnessDetailsNotInCurNPrevByPatientId(String patientId) throws DataAccessException {
        log.info("Before calling DAO method getPatientIllnessDetailsNotInCurNPrevByPatientId()");
        return businessMapper.getPatientIllnessDetailsNotInCurNPrevByPatientId(patientId);
    }

    // get the master illness by illness name
    public int getIllnessByName(String illnessName) throws DataAccessException {
        log.info("Before calling DAO method getIllnessByName()");
        return businessMapper.getIllnessByName(illnessName);
    }

    // add new master illness
    public void addMasterIllness(MasterIllness masterillness) throws DataAccessException {
        log.info("Before calling DAO method getIllnessByName()");
        businessMapper.addMasterIllness(masterillness);
    }

    // get the active patient illness by medical code
    public int getActivePatientIllnessByMedicalCode(String medicalCode,Integer patientId) throws DataAccessException {
        log.info("Before calling DAO method getActivePatientIllnessByMedicalCode()");
        return businessMapper.getActivePatientIllnessByMedicalCode(medicalCode,patientId);
    }

    // get the patient list for appt booking
    public List<Patient> getPatientInfoForBizCal(int bizId) throws DataAccessException {
        log.debug("Before calling DAO method getPatientInfoForBizCal()");
        List<Patient> patients = businessMapper.getPatientInfoForBizCal(bizId);
        log.debug("After calling DAO method getPatientInfoForBizCal()");
        return patients;
    }

    //get the count of insurance for the patient
    public int getPatientInsCnt(Integer patientId) throws DataAccessException {
        log.debug("Before calling DAO method Business.getPatientInsCnt");
        int insCnt = businessMapper.getPatientInsCnt(patientId);
        log.debug("After calling DAO method Business.getPatientInsCnt");
        return insCnt;
    }

    @Override
    public int getDuplicateLocCount(String locName, Integer bizId) throws DataAccessException {
        log.debug("Before calling DAO method Business.getDuplicateLocCount" +locName + "**********" + bizId);
        int locCnt = businessMapper.getDuplicateLocCount(locName, bizId);
        log.debug("After calling DAO method Business.getDuplicateLocCount" +locName + "**********" + bizId);
        return locCnt;
    }

    @Override
    public PaymentHistory getdiscountdetails(String promoCode, int svcId,
                                             int locId, String startTime, int userId, int pkgId,int clientId) {
        log.debug("Before calling DAO method Business.getdiscountdetails");
        PaymentHistory discountDetails = businessMapper.getdiscountdetails(promoCode,svcId,locId,startTime,userId,pkgId,clientId);
        log.debug("After calling DAO method Business.getdiscountdetails");
        return discountDetails;
    }

    @Override
    public Business getBizUserPaymentCred(int bizId) {
        log.debug("Before calling DAO method Business.getBizUserPaymentCred");
        Business paymentCred = businessMapper.getBizUserPaymentCred(bizId);
        log.debug("After calling DAO method Business.getBizUserPaymentCred");
        return paymentCred;
    }

    // add new group package
    public void addGroupPackage(GroupPackage grpPkg) throws DataAccessException {
        log.debug("Before calling DAO method Business.addGroupPackage");
        businessMapper.addGroupPackage(grpPkg);
        log.debug("After calling DAO method Business.addGroupPackage");
    }

    // get group package by group package id
    public GroupPackage getGroupPkgByGroupPkgId(String grpPkgId) throws DataAccessException {
        log.debug("Before calling DAO method Business.getGroupPkgByGroupPkgId");
        GroupPackage grpPkg = businessMapper.getGroupPkgByGroupPkgId(grpPkgId);
        log.debug("After calling DAO method Business.getGroupPkgByGroupPkgId");
        return grpPkg;
    }

    // get group package to package list by group package id
    public List<GroupPackageOccurence> getGroupPkgOccurencesByGroupPkgId(String grpPkgId) throws DataAccessException {
        log.debug("Before executing query Business.getGroupPkgToPkgByGroupPkgId");
        List<GroupPackageOccurence> grpPkg = businessMapper.getGroupPkgOccurencesByGroupPkgId(grpPkgId);
        log.debug("After executing query Business.getGroupPkgToPkgByGroupPkgId");
        return grpPkg;
    }

    // update group package
    public void updateGroupPackage(GroupPackage grpPkg) throws DataAccessException {
        log.debug("Before calling DAO method Business.updateGroupPackage");
        businessMapper.updateGroupPackage(grpPkg);
        log.debug("After calling DAO method Business.updateGroupPackage");
    }

    // update group package
    public void updateGroupPackageAppt(int bookedApptId, int groupPkgId, int pkgId,int groupPackagePurchaseId) throws DataAccessException {
        log.debug("Before calling DAO method Business.updateGroupPackageAppt");
        businessMapper.updateGroupPackageAppt(bookedApptId, groupPkgId, pkgId,groupPackagePurchaseId);
        log.debug("After calling DAO method Business.updateGroupPackageAppt");
    }

    // get list of group packages of business user by userId
    public OnskedList getAllGroupPackagesListByUserId(Integer userId,String bizId, String locId, int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException {
        log.debug("Before calling DAO method Business.getAllGroupPackagesListByUserId");
        OnskedList gpList = businessMapper.getAllGroupPackagesListByUserId(userId,bizId,locId,pageSize,pageNo,sortBy,sort);
        log.debug("After calling DAO method Business.getAllGroupPackagesListByUserId");
        return gpList;
    }
    public OnskedList getAllPurchasedGroupPackagesListByUserId(Integer userId,String bizId, String locId, int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException {
        log.debug("Before calling DAO method Business.getAllPurchasedGroupPackagesListByUserId");
        OnskedList gpList = businessMapper.getAllPurchasedGroupPackagesListByUserId(userId,bizId,locId,pageSize,pageNo,sortBy,sort);
        log.debug("After calling DAO method Business.getAllPurchasedGroupPackagesListByUserId");
        return gpList;
    }
    public Business getBizNamenLocNamebyLocId(String locId) throws DataAccessException {
        log.debug("Before calling DAO method Business.getBizNamenLocNamebyLocId");
        Business bizNameLocName = businessMapper.getBizNamenLocNamebyLocId(locId);
        log.debug("After calling DAO method Business.getBizNamenLocNamebyLocId");
        return bizNameLocName;
    }

    public Integer getGroupPkgbyGrpPkgNameAndId(String grpPkgName, String grpPkgId, String locId) throws DataAccessException {
        log.debug("Before calling DAO method Business.getGroupPkgbyGrpPkgNameAndId");
        Integer grpPkgCount = businessMapper.getGroupPkgbyGrpPkgNameAndId(grpPkgName,grpPkgId, locId);
        log.debug("After calling DAO method Business.getGroupPkgbyGrpPkgNameAndId");
        return grpPkgCount;
    }

    public Integer getGrpPkgApptCountByGrpPkgId(String grpPkgId) throws DataAccessException {
        log.debug("Before calling DAO method Business.getGrpPkgApptCountByGrpPkgId");
        Integer grpPkgCount = businessMapper.getGrpPkgApptCountByGrpPkgId(grpPkgId);
        log.debug("After calling DAO method Business.getGrpPkgApptCountByGrpPkgId");
        return grpPkgCount;
    }

    public Integer getGrpPkgPurchaseCountByGrpPkgId(String grpPkgId) throws DataAccessException {
        log.debug("Before calling DAO method Business.getGrpPkgPurchaseCountByGrpPkgId");
        Integer grpPkgCount = businessMapper.getGrpPkgPurchaseCountByGrpPkgId(grpPkgId);
        log.debug("After calling DAO method Business.getGrpPkgPurchaseCountByGrpPkgId");
        return grpPkgCount;
    }

    public void deleteGrpPkg(String grpPkgId) throws DataAccessException {
        log.debug("Before calling DAO method Business.deleteGrpPkg");
        businessMapper.deleteGrpPkg(grpPkgId);
        log.debug("After calling DAO method Business.deleteGrpPkg");
    }

    public List<Business> getBizWhichHasGrpPkgs() throws DataAccessException {
        log.debug("Before calling DAO method Business.getBizWhichHasGrpPkgs");
        List<Business> bizList = businessMapper.getBizWhichHasGrpPkgs();
        log.debug("After calling DAO method Business.getBizWhichHasGrpPkgs");
        return bizList;
    }

    public List<ProductModel> getProductModel() throws DataAccessException {
        log.debug("Before calling DAO method Business.getProductModel");
        List<ProductModel> productModel = businessMapper.getProductModel();
        log.debug("After calling DAO method Business.getProductModel");
        return productModel;
    }

    public List<ProductIssue> getProductIssue(String repairFormId) throws DataAccessException {
        log.debug("Before calling DAO method Business.getProductIssue");
        List<ProductIssue> productIssue = businessMapper.getProductIssue(repairFormId);
        log.debug("After calling DAO method Business.getProductIssue");
        return productIssue;
    }

    public List<ProductHardwareIssue> getProductHardwareIssueList(String techFormId) throws DataAccessException {
        log.debug("Before calling DAO method Business.getProductHardwareIssueList");
        List<ProductHardwareIssue> productHardwareIssue = businessMapper.getProductHardwareIssueList(techFormId);
        log.debug("After calling DAO method Business.getProductHardwareIssueList");
        return productHardwareIssue;
    }

    public List<ProductPartsUsed> getProductPartsUsedList(String techFormId) throws DataAccessException {
        log.debug("Before calling DAO method Business.getProductPartsUsedList");
        List<ProductPartsUsed> productPartsUsedList = businessMapper.getProductPartsUsedList(techFormId);
        log.debug("After calling DAO method Business.getProductPartsUsedList");
        log.debug("getProductPartsUsedList size == "+productPartsUsedList.size());
        return productPartsUsedList;
    }

    public AppointmentSchedule getUnregUserDetailsForInStore(String apptId) throws DataAccessException {
        log.debug("Before calling DAO method Business.getUnregUserDetailsForInStore");
        AppointmentSchedule appointmentSchedule = businessMapper.getUnregUserDetailsForInStore(apptId);
        log.debug("After calling DAO method Business.getUnregUserDetailsForInStore");
        return appointmentSchedule;
    }

    public RepairForm getRepairFormDetails(String apptId, String repairFormIdHex) throws DataAccessException {
        log.debug("Before calling DAO method Business.getRepairFormDetails");
        RepairForm repairForm = businessMapper.getRepairFormDetails(apptId, repairFormIdHex);
        log.debug("After calling DAO method Business.getRepairFormDetails");
        return repairForm;
    }

    public TechnicianForm getTechicianFormDetails(String apptId,String repairFormId) throws DataAccessException {
        log.debug("Before calling DAO method Business.getTechnicianFormDetails");
        TechnicianForm technicianForm = businessMapper.getTechnicianFormDetails(apptId,repairFormId);
        log.debug("After calling DAO method Business.getTechnicianFormDetails");
        return technicianForm;
    }

    public Integer getRepairFormUsingApptId(Integer apptId) throws DataAccessException {
        log.debug("Before calling DAO method Business.getRepairFormUsingApptId");
        Integer repairForm = businessMapper.getRepairFormUsingApptId(apptId);
        log.debug("After calling DAO method Business.getRepairFormUsingApptId");
        return repairForm;
    }

    public List<Location> getLocsWhichHasGrpPkgs(int bizId) throws DataAccessException {
        log.debug("Before calling DAO method Business.getLocsWhichHasGrpPkgs");
        List<Location> locList = businessMapper.getLocsWhichHasGrpPkgs(bizId);
        log.debug("After calling DAO method Business.getLocsWhichHasGrpPkgs");
        return locList;
    }

    public List<Location> getNonDeletedLocations(int bizId) throws DataAccessException {
        log.debug("Before calling DAO method Business.getNonDeletedLocations");
        List<Location> locList = businessMapper.getNonDeletedLocations(bizId);
        log.debug("After calling DAO method Business.getNonDeletedLocations");
        return locList;
    }

    public Integer addGroupPackagePurchase(GroupPackagePurchase grpPkgPurchase) throws DataAccessException {
        log.debug("Before calling DAO method Business.addGroupPackagePurchase");
        Integer grpPkgPurchaseId = businessMapper.addGroupPackagePurchase(grpPkgPurchase);
        log.debug("After calling DAO method Business.addGroupPackagePurchase");
        return grpPkgPurchaseId;
    }

    public Integer addGroupPackagePayment(GroupPackagePayment grpPkgPayment) throws DataAccessException {
        log.debug("Before calling DAO method Business.addGroupPackagePayment");
        Integer grpPkgPaymentId = businessMapper.addGroupPackagePayment(grpPkgPayment);
        log.debug("After calling DAO method Business.addGroupPackagePayment");
        return grpPkgPaymentId;
    }

    public Integer addGroupPackageAppt(GroupPackageAppointment grpPkgAppt) throws DataAccessException {
        log.debug("Before calling DAO method Business.addGroupPackageAppt");
        Integer grpPkgPaymentId = businessMapper.addGroupPackageAppt(grpPkgAppt);
        log.debug("After calling DAO method Business.addGroupPackageAppt");
        return grpPkgPaymentId;
    }

    public OnskedList getUserPurchasedGroupPackagesDetails(Integer userId,Integer groupPkgId,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException {
        log.debug("Before calling DAO method Business.getUserPurchasedGroupPackages");
        OnskedList gpa = businessMapper.getUserPurchasedGroupPackagesDetails(userId,groupPkgId,pageSize,pageNo,sortBy,sort);
        log.debug("After calling DAO method Business.getUserPurchasedGroupPackages");
        return gpa;
    }

    public List<GroupPackage> getUserPurchasedGroupPackagesDetailsByGroupPkgId(Integer userId,Integer groupPkgId,Integer groupPkgPurchaseId) throws DataAccessException {
        log.debug("Before calling DAO method Business.getUserPurchasedGroupPackagesDetailsByGroupPkgId");
        List<GroupPackage> gpa = businessMapper.getUserPurchasedGroupPackagesDetailsByGroupPkgId(userId,groupPkgId,groupPkgPurchaseId);
        log.debug("After calling DAO method Business.getUserPurchasedGroupPackagesDetailsByGroupPkgId");
        return gpa;
    }

    public List<GroupPackageAppointment> getUserSelectedPurchasedGroupPackagesDetails(Integer userId,int groupPkgId,int pgkId,int groupPkgPurchaseId) throws DataAccessException {
        log.debug("Before calling DAO method Business.getUserSelectedPurchasedGroupPackagesDetails");
        List<GroupPackageAppointment> gpa = businessMapper.getUserSelectedPurchasedGroupPackagesDetails(userId,groupPkgId,pgkId,groupPkgPurchaseId);
        log.debug("After calling DAO method Business.getUserSelectedPurchasedGroupPackagesDetails");
        return gpa;
    }

    public List<GroupPackageAppointment> getBizResourceSelectedPurchasedGroupPackagesDetails(Integer userId,int groupPkgId,int pgkId,int groupPkgPurchaseId) throws DataAccessException {
        log.debug("Before calling DAO method Business.getBizResourceSelectedPurchasedGroupPackagesDetails");
        List<GroupPackageAppointment> gpa = businessMapper.getBizResourceSelectedPurchasedGroupPackagesDetails(userId,groupPkgId,pgkId,groupPkgPurchaseId);
        log.debug("After calling DAO method Business.getBizResourceSelectedPurchasedGroupPackagesDetails");
        return gpa;
    }

    public List<GroupPackageAppointment> getUserPurchasedGroupPackagesIds(Integer userId) throws DataAccessException {
        log.debug("Before calling DAO method Business.getUserPurchasedGroupPackagesIds");
        List<GroupPackageAppointment> gpa = businessMapper.getUserPurchasedGroupPackagesIds(userId);
        log.debug("After calling DAO method Business.getUserPurchasedGroupPackagesIds");
        return gpa;
    }

    public Integer getClientPresentByClientId(Integer clientId) throws DataAccessException {
        log.debug("Before executing query Business.getClientPresentByClientId");
        return businessMapper.getClientPresentByClientId(clientId);
    }

    public Integer getClientbyEmailAndClientId(String email, String clientId, Integer bizId) throws DataAccessException {
        log.debug("Before calling DAO method Business.getClientbyEmailAndClientId");
        Integer count = businessMapper.getClientbyEmailAndClientId(email,clientId,bizId);
        log.debug("After calling DAO method Business.getClientbyEmailAndClientId");
        return count;
    }

    public Integer getClientIdByBizIdAndEmail(Integer bizId, String email) throws DataAccessException {
        log.debug("Before calling DAO method Business.getClientIdByBizIdAndEmail");
        Integer count = businessMapper.getClientIdByBizIdAndEmail(bizId, email);
        log.debug("After calling DAO method Business.getClientIdByBizIdAndEmail");
        return count;
    }

    public List<ServiceListFromOutside> getServicesByLocIdBizId(Integer bizId,Integer locId) throws DataAccessException {
        log.debug("Calling DAO method getServicesByLocId()");
        return businessMapper.getServicesByLocIdBizId(bizId,locId);
    }

    @Override
    public Integer getRepairFormIdForShowingTechnicianForm(Integer apptId) throws DataAccessException {
        // TODO Auto-generated method stub
        return businessMapper.getRepairFormIdForShowingTechnicianForm(apptId);
    }

    @Override
    public TechnicianForm getTechnicianFormIdForShowingEditFillTechnicianForm(Integer apptId,Integer repairFormId) {
        // TODO Auto-generated method stub
        return businessMapper.getTechnicianFormIdForShowingEditFillTechnicianForm(apptId,repairFormId);
    }

    @Override
    public String addTechnicianForm(TechnicianForm technicianForm) throws DataAccessException {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method Business.addTechnicianForm");
        String techFormId = businessMapper.addTechnicianForm(technicianForm);
        log.debug("After calling DAO method Business.addTechnicianForm");
        return techFormId;
    }

    @Override
    public String updateTechnicianForm(TechnicianForm technicianForm, String requestPath) throws DataAccessException {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method Business.updateTechnicianForm");
        String techFormId = businessMapper.updateTechnicianForm(technicianForm,requestPath);
        log.debug("After calling DAO method Business.updateTechnicianForm");
        return techFormId;
    }

    @Override
    public List<PhoneCarrier> getPhoneCarrier() {
        // TODO Auto-generated method stub
        return businessMapper.getPhoneCarrier();
    }

    public void updateClientPhysicianDetails(ClientPhysician clientPhysician) throws DataAccessException {
        log.info("Before calling DAO method updateClientPhysicianDetails()");
        businessMapper.updateClientPhysicianDetails(clientPhysician);
        log.info("After calling DAO method updateClientPhysicianDetails()");
    }

    @Override
    public List<ResourceRoleType> getResourceTypeDetails(Integer bizId){
        // TODO Auto-generated method stub
        return businessMapper.getResourceTypeDetails(bizId);
    }

    public List<Resource> getTechniciansForRepairForm(Integer locId){
        // TODO Auto-generated method stub
        return businessMapper.getTechniciansForRepairForm(locId);
    }

    public List<FormStatus> getFormStausListForTechnicianForm(){
        // TODO Auto-generated method stub
        return businessMapper.getFormStausListForTechnicianForm();
    }

    @Override
    public List<AppointmentStatus> getAppointmentStatusForGrid() {
        // TODO Auto-generated method stub
        return businessMapper.getAppointmentStatusForGrid();
    }

    @Override
    public void addTechnicianFormComment(TechnicianFormComments techFormComments) {
        // TODO Auto-generated method stub
        businessMapper.addTechnicianFormComment(techFormComments);
    }

    @Override
    public List<TechnicianFormComments> getTechnicianFormCommentsByTechFormId(String techFormId) {
        // TODO Auto-generated method stub
        return businessMapper.getTechnicianFormCommentsByTechFormId(techFormId);
    }

    @Override
    public void updateRepairFormSelfAssign(String repairFormId, String assignTechId, String techFormId, Integer userId) {
        // TODO Auto-generated method stub
        businessMapper.updateRepairFormSelfAssign(repairFormId, assignTechId, techFormId, userId);

    }

    @Override
    public List<TechnicianFormComments> getTechFormCommentsByTechFormId(String techFormId) {
        // TODO Auto-generated method stub
        return businessMapper.getTechFormCommentsByTechFormId(techFormId);
    }

    @Override
    public List<AuditTrail> getAuditDetails(WeakHashMap map, String query) {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method businessMapper.getAuditDetails() map: "+map+" query: "+query);
        List<AuditTrail> auditList = businessMapper.getAuditDetails(map, query);
        log.debug("After calling DAO method businessMapper.getAuditDetails()");
        return auditList;
    }

    @Override
    public String isDisplayCounterEnabled(Integer bizId) {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method businessMapper.isDisplayCounterEnabled()");
        String isDisplayCounterEnabled = businessMapper.isDisplayCounterEnabled(bizId);
        log.debug("After calling DAO method businessMapper.isDisplayCounterEnabled()");
        return isDisplayCounterEnabled;
    }

    @Override
    public void updateResourceHours(Resource resourceWorkingHour) {
        // TODO Auto-generated method stub
        businessMapper.updateResourceHours(resourceWorkingHour);
    }

    @Override
    public List<AppointmentSchedule> getApptBookedTime(WeakHashMap map) {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method businessMapper.getApptBookedTime() map: "+map);
        List<AppointmentSchedule> apptBookedList = businessMapper.getApptBookedTime(map);
        log.debug("After calling DAO method businessMapper.getApptBookedTime()");
        return apptBookedList;
    }

    @Override
    public Package getMaxWorkingHrs(Integer locId) throws DataAccessException {
        // TODO Auto-generated method stub
        return businessMapper.getMaxWorkingHrs(locId);
    }


    @Override
    public List<com.amazech.onsked.domain.Service> getServiceForManageClientsForBusiness(String bizId) {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method businessMapper.getServiceForManageClientsForBusiness()"+bizId);
        List<com.amazech.onsked.domain.Service> serviceForManageClientsBusinessList = businessMapper.getServiceForManageClientsForBusiness(bizId);
        log.debug("After calling DAO method businessMapper.getServiceForManageClientsForBusiness()");
        return serviceForManageClientsBusinessList;
    }

    @Override
    public List<Promotion> getUpcomingPromotionListForClient(String bizId) {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method businessMapper.getUpcomingPromotionListForClient()"+bizId);
        List<Promotion> upcomingPromotionListForClient = businessMapper.getUpcomingPromotionListForClient(bizId);
        log.debug("After calling DAO method businessMapper.getUpcomingPromotionListForClient()");
        return upcomingPromotionListForClient;
    }

    @Override
    public void addDataToClientsEmail(Map<String, Object> result) {
        // TODO Auto-generated method stub
        log.debug("Before executing DAO method businessMapper.addDataToClientsEmail()");
        businessMapper.addDataToClientsEmail(result);
        log.debug("After executing DAO method businessMapper.addDataToClientsEmail()");
    }

    @Override
    public String getPackageByPromotionId(String promotionId) {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method businessMapper.getPackageByPromotionId()"+promotionId);
        String packageId = businessMapper.getPackageByPromotionId(promotionId);
        log.debug("After calling DAO method businessMapper.getPackageByPromotionId()"+packageId);
        return packageId;
    }

    @Override
    public void deleteClient(String clientId) {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method businessMapper.deleteClient()"+clientId);
        businessMapper.deleteClient(clientId);
        log.debug("After calling DAO method businessMapper.deleteClient()");
    }

    @Override
    public List<String> getAvailedProductsByClientId(Integer clientId, String svcId, String statusCode, String pkgId, String locId) {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method businessMapper.getAvailedProductsByClientId() clientId = "+clientId+"svcId"+svcId+"statusCode"+statusCode+"pkgId"+pkgId+"locId"+locId);
        List<String> availedProductsList = businessMapper.getAvailedProductsByClientId(clientId,svcId,statusCode,pkgId,locId);
        log.debug("After calling DAO method businessMapper.getAvailedProductsByClientId()");
        return availedProductsList;
    }

    @Override
    public List<String> getAvailedLocationsByClientId(Integer clientId, String svcId, String statusCode, String pkgId, String locId) {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method businessMapper.getAvailedLocationsByClientId() clientId = "+clientId+"svcId"+svcId+"statusCode"+statusCode+"pkgId"+pkgId+"locId"+locId);
        List<String> availedLocationsList = businessMapper.getAvailedLocationsByClientId(clientId,svcId,statusCode,pkgId,locId);
        log.debug("After calling DAO method businessMapper.getAvailedLocationsByClientId()");
        return availedLocationsList;
    }

    @Override
    public void updateClientAddress(WeakHashMap map) {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method businessMapper.updateClientAddress(): "+map);
        businessMapper.updateClientAddress(map);
        log.debug("After calling DAO method businessMapper.updateClientAddress()");
    }

    @Override
    public List<ServiceMaster> getServiveListFromLocationList(String locIdList) {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method businessMapper.getServiveListFromLocationList() locIdList = "+locIdList);
        return businessMapper.getServiveListFromLocationList(locIdList);
    }

    @Override
    public String getLastCompletedAppointmentDate(Integer clientId) {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method businessMapper.getLastCompletedAppointmentDate()"+clientId);
        String appointmentDate = businessMapper.getLastCompletedAppointmentDate(clientId);
        log.debug("After calling DAO method businessMapper.getLastCompletedAppointmentDate()"+clientId);
        return appointmentDate;
    }

    @Override
    public List<Client> getClientDetailsForDownload(String clientList) {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method businessMapper.getClientDetailsForDownload()"+clientList);
        List<Client> clientDetailsList = businessMapper.getClientDetailsForDownload(clientList);
        log.debug("After calling DAO method businessMapper.getClientDetailsForDownload()"+clientList);
        return clientDetailsList;
    }

    @Override
    public Integer isClientPresentInPromotion(String bizId, String promotionId,
                                              String clientEmail) {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method businessMapper.isClientPresentInPromotion()");
        Integer isClientPresent = businessMapper.isClientPresentInPromotion(bizId,promotionId,clientEmail);
        log.debug("After calling DAO method businessMapper.isClientPresentInPromotion()");
        return isClientPresent;
    }

    @Override
    public Promotion getPackageDetailsByPackageId(String pkgId) {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method businessMapper.getPackageDetailsByPackageId()");
        Promotion promotion = businessMapper.getPackageDetailsByPackageId(pkgId);
        log.debug("After calling DAO method businessMapper.getPackageDetailsByPackageId()");
        return promotion;
    }

    @Override
    public Promotion getServiceNameByServiceId(String svcId) {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method businessMapper.getServiceNameByServiceId()");
        Promotion promotion = businessMapper.getServiceNameByServiceId(svcId);
        log.debug("After calling DAO method businessMapper.getServiceNameByServiceId()");
        return promotion;
    }

    @Override
    public Promotion getlocationNameForPromotionByLocId(String locId) {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method businessMapper.getlocationNameForPromotionByLocId()");
        Promotion promotion = businessMapper.getlocationNameForPromotionByLocId(locId);
        log.debug("After calling DAO method businessMapper.getlocationNameForPromotionByLocId()");
        return promotion;
    }

    @Override
    public Promotion getPromotionByPromotionCodeForPromotionValidation(String promotionCode) {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method businessMapper.getPromotionByPromotionCode()");
        Promotion promotion = businessMapper.getPromotionByPromotionCodeForPromotionValidation(promotionCode);
        log.debug("After calling DAO method businessMapper.getPromotionByPromotionCode()");
        return promotion;
    }

    @Override
    public List<Client> getPromotionParticipents(String promotionId) {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method businessMapper.getPromotionParticipents()");
        List<Client> promotionParticipents = businessMapper.getPromotionParticipents(promotionId);
        log.debug("After calling DAO method businessMapper.getPromotionParticipents()");
        return promotionParticipents;
    }

    @Override
    public Client getClientAddress(Integer clientId) {
        // TODO Auto-generated method stub
        log.debug("Before calling DAO method businessMapper.getClientAddress()");
        Client clientAddressDetails = businessMapper.getClientAddress(clientId);
        log.debug("After calling DAO method businessMapper.getClientAddress()");
        return clientAddressDetails;
    }

    @Override
    public List<TimeZones> getTimezonesFromCountry(String countryCode) {
        log.debug("Before calling DAO method businessMapper.getTimezonesFromCountry()");
        List<TimeZones> timezonesList = businessMapper.getTimezonesFromCountry(countryCode);
        log.debug("After calling DAO method businessMapper.getTimezonesFromCountry()");
        return timezonesList;
    }
}
