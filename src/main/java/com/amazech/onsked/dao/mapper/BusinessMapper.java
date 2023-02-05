package com.amazech.onsked.dao.mapper;

import com.amazech.onsked.domain.*;
import com.amazech.onsked.exceptions.DataAccessException;
import com.amazech.onsked.util.OnskedList;
import org.apache.ibatis.annotations.Mapper;

import java.lang.Package;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

@Mapper
public interface BusinessMapper {
    List<CourseSchedule> getCourseListForClient(Integer biz) throws DataAccessException;

    // Add a Business to database
    void addBusiness(Business business) throws DataAccessException;

    String addRepairForm(RepairForm repairForm, AppointmentSchedule appointmentSchedule, String requestPath) throws DataAccessException;

    String updateRepairForm(RepairForm repairForm,AppointmentSchedule appointmentSchedule,RepairForm repairFormForUpdate,String requestPath) throws DataAccessException;

    // Update details of a Business in database
    void updateBusiness(Business business) throws DataAccessException;

    // Update Basic Business details
    void updateBasicBusinessDetails(Business business) throws DataAccessException;

    // Get the Businesses registered by a user.(Checked for the location to be active as well)
    Business getBusiness(Integer userId) throws DataAccessException;

    // Get the Businesses registered by a user()
    List<Business> getBusinesses(Integer userId) throws DataAccessException;

    // Get the all Businesses registered by a user()
    List<Business> getAllBusinessEntries(Integer userId) throws DataAccessException;

    // Get the Businesses registered using bizId
    Business getBusinessByBizId(Integer bizId) throws DataAccessException;

    OnskedList getLocationsByBizId(Integer bizId, int pageSize, int pageNo, String sortBy, String sort) throws DataAccessException;

    OnskedList getResourcesByBizId(Integer bizId,int pageSize, int pageNo,String sortBy, String sort) throws DataAccessException;

    // Get the Businesses List Appointment Count using UserId
    List<Business> getBusinessForAppoitmentByUserId(Integer UserId) throws DataAccessException;

    // Get the Location for a Business
    Location getLocation(Integer bizId) throws DataAccessException;

    // Get the Location details based on locId
    Location getBusinessLocation(Integer locId) throws DataAccessException;

    // Get the HeadquartersLocation for a User Business (Not to be a list actually)
    Location getHeadquartersLocation(Integer bizId) throws DataAccessException;

    // Get the Location details based on locId for Location edit (Original State and Country Code)
    Location getBusinessLocationByLocId(Integer locId) throws DataAccessException;

    //Get Master Services for given categoryCode
    List<ServiceMaster> getMasterServices(Integer catgoryCode) throws DataAccessException;

    //Get Master Services for given bizId
    List<ServiceMaster> getBusinessMasterServices(Integer bizId) throws DataAccessException;

    //Get Unselected Business Master Services for a Given bizId
    List<ServiceMaster> getBusinessMasterServicesUnselected(Integer bizId,Integer categoryCode) throws DataAccessException;

    //Get Master Services for given resId
    List<ServiceMaster> getResourceMasterServices(Integer resId) throws DataAccessException;

    //Get Master Services which have not been opted previously, for a given resId
    List<ServiceMaster> getResourceMasterServicesUnselected(Integer bizId, Integer resId) throws DataAccessException;

    //Get Master Services for given resId and locId
    List<ServiceMaster> getResourceServices(Integer resId,Integer locId) throws DataAccessException;

    //Get Master Services which have not been opted previously, for a given resId
    List<ServiceMaster> getResourceServicesUnselected(Integer locId, Integer resId) throws DataAccessException;


    // Get the services offered by a Resources of a given business by BizId
    List<ServiceMaster> getResourceSvcByBizId(Integer bizId) throws DataAccessException;

    // Get the list of Location for adding resource of a Business Resource by BizId
    List<Location> getResourceLocByBizId(Integer bizId) throws DataAccessException;

    // Get the list of Location for adding resource of a Business Resource by ResId
    List<Location> getResourceLocByResId(Integer resId);

    //Add Master Services that are provided for a particular Business
    void addBusinessMasterServices(ServiceMaster masterServices,Integer bizId) throws DataAccessException;

    //Delete Master Services that are provided for a particular Business
    void deleteBusinessMasterServices(String svcId,Integer loc,Integer userId) throws DataAccessException;

    //Add Master Services that are provided for a particular Business
    void addResourceMasterServices(Resource resource) throws DataAccessException;

    //Update Master Services that are provided for a particular Business
    void updateResourceMasterServices(Resource resource) throws DataAccessException;


    // Remove Service provided for a Business by svcId
    void removeServicesProvided(Integer svcId) throws DataAccessException;

    // Get the Resource for given resId
    Resource getResource(Integer resId) throws DataAccessException;

    // Get the Resource for given nickname
    Resource getResourceByNickName(String nickName,Integer locId,Integer bizId) throws DataAccessException;

    // Get the Resource for given onsked user id
    List<Resource> getResourceByOnskedUserId(String onskedUserId) throws DataAccessException;

    // Get the Resources for a given business
    List<Resource> getResources(Integer bizId) throws DataAccessException;

    // Get all the resources (including inactive and deleted) for a given business by biz id
    List<Resource> getAllResourcesOfBusinessByBizId(Integer bizId) throws DataAccessException;

    // Get the Resources for a a Business Location by locId
    List<Resource> getResourcesByLocId(Integer locId) throws DataAccessException;

    // Get the Locations for a given business
    List<Location> getLocations(Integer bizId) throws DataAccessException;

    // Add a Resource to database
    void addResource(Resource resource,String bizIsActive) throws DataAccessException;

    void saveResourceRatePerHour(Resource resource) throws DataAccessException;

    void saveResourcePayoutPercentage(Resource resource) throws DataAccessException;

    // Add a Location to database
    void addLocation(Location location,String bizIsActive) throws DataAccessException;

    // Update Resource
    void updateResource(Resource resource) throws DataAccessException;

    // Update Business Resource
    void updateBusinessResource(Resource resource,Integer locId) throws DataAccessException;

    // Update Business Location
    void updateBusinessLocation(Location location) throws DataAccessException;

    // Delete a Resource from database
    void deleteResource(Integer resId,String bizIsActive,Integer locId,Integer userId) throws DataAccessException;

    // Delete a Business Location from database
    void deleteBusinessLocation(Integer locId,String bizIsActive,String userId) throws DataAccessException;

    void deleteCourseWithAppointment(String courseId,Integer userId,String requestPath) throws DataAccessException;

    // Add working hours of a Business to database
    void addBusinessHours(BusinessHours businessHours) throws DataAccessException;

    // Add working hours of a Business to database
    void addBusinessBasicHours(Business business) throws DataAccessException;

    // Add Working hours of a Business Location to the database
    void addLocationHours(Location location) throws DataAccessException;

    // Get the working hours for a given business
    List<BusinessHours> getBasicBusinessHours(Integer bizId) throws DataAccessException;

    // Get the working hours for a given business location by bizId
    List<LocationHours> getLocationHoursByBizId(Integer bizId) throws DataAccessException;

    // Get the working hours for a given business location
    List<LocationHours> getLocationHours(Integer locId) throws DataAccessException;

    // Get the working hours for a given business
    List<BusinessHours> getBusinessHours(Integer bizId, String tmZnCode) throws DataAccessException;

    //Add a Business Holiday to database
    void addBusinessHoliday(BusinessHoliday businessHoliday) throws DataAccessException;

    //Delete a Holiday from Database
    void deleteHoliday(Integer bizId, Integer locId) throws DataAccessException;

    // Get the Holidays for a given business location
    List<BusinessHoliday> getHolidays(Integer bizId, Integer locId) throws DataAccessException;

    // Get the Holiday registered for a business
    BusinessHoliday getHoliday(Integer bizId, Integer locId) throws DataAccessException;

    // Update details of a Holiday in database
    void updateHoliday(BusinessHoliday businessHoliday) throws DataAccessException;

    // Get the Holidays for a Business's HeadQuarter Location
    List<BusinessHoliday> getHolidays(Integer bizId) throws DataAccessException;

    // Get the Holidays for a Business Holidays for a particular Location
    List<BusinessHoliday> getBusinessLocationHolidaysHQ(Integer bizId, Integer locId) throws DataAccessException;

    //Update Business table; Set Business as Active
    void setBusinessActive(Integer bizId,Integer userId) throws DataAccessException;

    //Update Business table; Set Business as InActive
    void setBusinessInActive(Integer userId) throws DataAccessException;

    //Get the Holidays for a Business Holidays for a particular Location
    BusinessHoliday getHolidayByBizIdLocIdDate(Integer holidayId) throws DataAccessException;

    // Update details of a Holiday in database
    void updateHolidayByBizIdLocIdDate(BusinessHoliday businessHoliday) throws DataAccessException;

    //Get the Holidays for a Business Holidays for a particular Location
    List<BusinessHoliday> getHolidayByHolidayId(Integer bizId, Integer locId) throws DataAccessException;

    //Delete the Holiday of particular location from database
    void deleteHolidayByBizIdLocIdDate(Integer holidayId,Integer userId) throws DataAccessException;

    //Delete the Holiday of particular location from database
    void deleteHolidayByBizIdLocIdHolidayDate(BusinessHoliday businessHoliday) throws DataAccessException;

    // Get service names
    List<ServiceMaster> getServiceNames(Integer bizId) throws DataAccessException;

    List<ServiceListFromOutside> getServicesByLocIdBizId(Integer bizId,Integer locId) throws DataAccessException;

    // Get locId by bizid
    Location getLocIdByBizId (Integer bizId) throws DataAccessException;

    // Add a Location to service
    void addLocationToService(LocationToService locationToService) throws DataAccessException;

    // update location to service
    void updateLocationToService(LocationToService locationToService) throws DataAccessException;

    // get the busines location to service list

    List<LocationToService> getBusinessLocationToService(Integer bizId) throws DataAccessException;

    PackageDetails getPackageDetails(Integer bizId)  throws DataAccessException;

    List<LocationToService> getUniqueLocationToService(Integer bizId) throws DataAccessException;

    List<LocationToService> getUniqueLocation(Integer bizId) throws DataAccessException;

    List<ServiceMaster> getUniqueLocationToServiceByLocIdBizId(Integer locId,Integer bizId) throws DataAccessException;

    List<ServiceMaster> getServiceListByBizIdCategoryCodeLocId(Integer bizId,Integer categoryCode,Integer locId) throws DataAccessException;

    void deleteLocationToService(Integer bizId) throws DataAccessException;

    void deleteLocationToServiceBySvcIdLocId(Integer locId,Integer svcId,Integer userId) throws DataAccessException;

    // Get the Locations for adding services
    List<Location> getLocationListForAddingSvc(Integer bizId) throws DataAccessException;

    void activateDeletedBusiness(Integer bizId,Integer userId, String requestPath) throws DataAccessException;

    void deleteResourceToServiceByResIdSvcId(Integer resId,Integer svcId, Integer locId,Integer userId) throws DataAccessException;

    void deleteResourceCertificateByResCertId(Integer resId,Integer resCertId) throws DataAccessException;

    List<Resource> getResourceToServiceByResId(Integer resId) throws DataAccessException;

    Location getLocationByNickName(String locName, Integer bizId)throws DataAccessException;

    Business getBusinessByBizNameEmail(String bizName,String email) throws DataAccessException;

    Resource getUserByUserId(Integer userId) throws DataAccessException ;

    Resource getUserByEmailId(String emailId) throws DataAccessException ;

    // Add Working hours of a resource to the database
    void addResourceHours(Resource resource) throws DataAccessException;

    void addResourceCertificate(ResourceCertificate resourceCertificate) throws DataAccessException;

    List<ResourceHours> getResourceHours(Integer resId) throws DataAccessException;

    List<ResourceHours> getResourceHoursByBizId(Integer bizId) throws DataAccessException ;

    List<ResourceHours> getResHoursByBizId(Integer bizId);

    // get the holiday list of a country using country code

    List<Holiday> getHolidaysByCountryCode(String countryCode) throws DataAccessException;

    //Get the Holidays for a Business Holidays for a particular Location
    List<BusinessHoliday> getHolidayByLocId(Integer locId) throws DataAccessException;


    //Get the Holidays for a Business Holidays for a particular Location
    List<BusinessHoliday> getHolidayByLocIdInFormatyyyyMMdd(Integer locId) throws DataAccessException;

    // Get the holidays by bizId and locId
    List<BusinessHoliday> getBusinessHolidayByBizIdLocId(Integer bizId,Integer locId)	throws DataAccessException ;

    // function to get the default holidays for the branches
    List<BusinessHoliday> getDefaultHolidayForBranches(String locId, String countryCode) throws DataAccessException;

    // function to get the default holidays for the branches in date and month format
    List<BusinessHoliday> getDefaultHolidayForBranchesInDateNMonth(String locId, String countryCode) throws DataAccessException;


    // Add the Service offered by business to database
    void addService(Service service) throws DataAccessException;

    // Update the Services for a given blsId
    void updateService(Service service) throws DataAccessException;

    // Delete a Service from database
    void deleteService(Integer svcId) throws DataAccessException;

    // Get the Services for a given blsId
    Service getService(Integer svcId) throws DataAccessException;

    // Get the Services offered by a given business
    List<Service> getServices(Integer bizId) throws DataAccessException;

    // get the location to service list using the locId and svcId
    List<LocationToService> getLocationToServiceByLocIdSvcId(Integer locId,Integer svcId) throws DataAccessException;

    // update isDeleted flag of business to delete the business
    void deleteBusiness(Integer bizId,Integer userId) throws DataAccessException ;

    void deleteBusinessByDownGrade(String bizId,Integer userId) throws DataAccessException ;

    void deleteLocationByDownGrade(Integer locId,Integer userId) throws DataAccessException ;

    void deleteResourceByDownGrade(String resId,Integer locId,Integer userId) throws DataAccessException ;

    //Method to add package details to database
    void addPackage(Package pack, String commandName) throws DataAccessException ;

    //Method to delete a package from the database
    void deletePackageByLocToSvcId(Integer locToSvcId) throws DataAccessException ;

    //Get all registered Active businesses
    List<Business> getAllBusinesses() throws DataAccessException ;

    //=---
    PackageDetails getPackageDetailsOfBusiness(Integer bizId) throws DataAccessException;

    //Get all Leave reasons list
    List<LeaveReason> getLeaveTypes() throws DataAccessException ;


    // Get the holidays by bizId, locId and year of holiday
    OnskedList getBusinessHolidayByBizIdLocIdYearOfHoliday(Integer bizId,Integer locId,Integer yr, int pageSize, int pageNo, String sortBy, String sort)	throws DataAccessException ;

    // Get the Services for a given blsId
    Category getResourceTitleByBizId(Integer bizId) throws DataAccessException;

    // Add the resource leave details to database
    void addResourceLeave(ResourceLeaveSchedule resourceLeaveSchedule) throws DataAccessException;

    // get the list of clients
    OnskedList getAllClients(Integer bizId,int pageSize, int pageNo, String sortBy, String sort, String startDate, String endDate, String clientStatus)throws DataAccessException ;

    // get the list of clients with More Options
    OnskedList getAllClientsMoreOptions(Integer bizId,int pageSize, int pageNo, String sortBy, String sort,String countMin,String countMax, String valueMin, String valueMax, String svcId, String statusCode, String startDate, String endDate, String clientStatus, String pkgId, String locId)throws DataAccessException ;

    // Add the details of business client to database
    Integer addBizClient(Client client,String requestPath) throws DataAccessException ;

    Integer getClientReferralPresentByClientId(Integer clientId) throws DataAccessException ;

    void addBizClientAddInfo(ClientReferral clientReferral) throws DataAccessException;

    void updateBizClientAddInfo(ClientReferral clientReferral) throws DataAccessException;

    // delete the resource hours from database
    void deleteResourceHours(Integer resId,Integer locId) throws DataAccessException;

    // Get the package count of business by biz id
    Integer getPackageCountOfBusinessByBizId(Integer bizId) throws DataAccessException;

    // set the is_active column of business table
    void activateDeactivate(String table,String updateColumn, String updateColumnValue,String conditionColumn, String conditionColumnValue) throws DataAccessException;

    //Get location's timeZone code by LocId
    String getTimeZoneCodeByLocId(Integer locId) throws DataAccessException;

    String getBusinessExpiryDate(Integer locId) throws DataAccessException;

    //Get Business Hours wrt timezone of a location
    List<BusinessHours> getBizHrsWrtTimeZn(Integer bizId, String timeZoneCode, String bizTimeZoneCode) throws DataAccessException;

    //Get Location Hours of location wrt its timeZone
    List<LocationHours> getLocHrsWrtTmZone(Integer locId, String timeZoneCode) throws DataAccessException;

    // get the list of locations added after confirming the business
    List<Location> getListOfLocationsAddedAfterBizConfirmation(Integer bizId) throws DataAccessException;

    // get the list of locations added after confirming the business
    List<Location> getListOfInactiveBusinessLocationsWithoutService(Integer bizId) throws DataAccessException;

    //Get details of Client by ClientId
    Client getClientDtlsByClientId(Integer clientId) throws DataAccessException;

    ClientReferral getClientAddInfoByClientId(Integer clientId) throws DataAccessException;

    //Update Business Client Details
    void updateClientDetails(Client cmdClient) throws DataAccessException;

    //Get client details for viewing
    Client getClientDtls(Integer clientId);

    // Get the timezone code of business user
    public String getTimeZoneCodeOfBizUser(Integer bizId) throws DataAccessException;


    //gets all featured business details
    List<Business> getFeaturedBusinesses() throws DataAccessException;

    List<Course> getCourseDetails() throws DataAccessException;

    OnskedList getCourseDetailsBySort(Integer userId,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    Course getCourseDetailsByCourseId(String courseId) throws DataAccessException;

    // Get the details for a given Resource of a location
    Resource getResourceOfLocation(Integer resId,Integer locId) throws DataAccessException;

    // get the list of resource hours using resId and locId
    List<ResourceHours> getResourceHoursByResIdLocId(Integer resId,Integer locId) throws DataAccessException;

    List<ResourceCertificate> getResourceCertificateByResId(Integer resId) throws DataAccessException;

    // Get the details for a given Resource
    Resource getResourceByResId(Integer resId) throws DataAccessException;

    List<ResourceHours> getResourceHoursOfAllLocations(Integer resId) throws DataAccessException;

    // Get the  Resource by email
    Resource getResourceByEmail(String email) throws DataAccessException;

    Resource getResourceByEmailIsDeleted(String email) throws DataAccessException;

    Resource getResourceByDiffNickName(String email,String nickName) throws DataAccessException;
    // Get the resource by email id and loc Id
    Resource getResourceByLocIdAndEmail(String locId,String email) throws DataAccessException;

    Integer getApptCountToResource(String resId,String locId);

    //Method to update the client location package
    void updateLocationToSvc(Package pack) throws DataAccessException;

    // Method to get address of client for mailing
    String getAddressOfClient(String clientId) throws DataAccessException;

    String getclientLocationOrNot(String locId,String svcId) throws DataAccessException;

    String getapptIdByCourseId(String courseId) throws DataAccessException;

    // Method to get address of location for mailing
    String getAddressOfLocation(String locId) throws DataAccessException;

    //Get the services for location, whose packages are to be used
    List<Package> getPackagesByLocIdSvcId(Integer locId, Integer svcId, Integer bizId);

    List<GroupPackage> getGroupPkgType();

    List<Package> getPackagesByLocIdResId(Integer locId, Integer resId);

    // Add the Promotion by Location,Service,Package to database
    Integer addPromotion(Promotion promotion);

    // Edit the Promotion by Promotion Id
    Promotion getPromotionByPromotionId(Integer promotionId);

    //get all the past promotion until current date
    OnskedList getPastPromotion(String curDate, Integer bizId,int pageSize, int pageNo, String sortBy, String sort);

    //get all the saved promotion
    OnskedList getSavedPromotion(Integer bizId,int pageSize, int pageNo, String sortBy, String sort);

    //Update the promotion to disable
    void disablePromotion(int promotionId);

    //Delete the promotion
    void deletePromotion(int promotionId);

    //Add data to clients to access promotion
    void addDataToClients(String destinationDir);

    //get Active Promotion
    List<Promotion> getActivePromotion(Integer bizId);

    //get additional Information from business table
    Business getAdditional(Integer bizId);

    //Edit additional Information from business table
    void getAdditionalEdit(Integer bizId1);


    // Update the Promotion by Location,Service,Package to database
    void updatePromotion(Promotion promotion);

    // get business rating from appointment table
    Double getAppointmentRatingByBizId(Integer bizId);

    // Get the Business promotion registered by a user.(Checked for the location to be active as well)
    List<Business> getBusinessPromotion(int userId);

    //Delete the past promotion
    void disablePastPromotion(int promotionId);

    //get business which are active
    List<Business> getBusinessesByUserIdByPromotionId(int userId);

    //get promotion id by promotion code
    boolean getPromotionByPromotionCode(String promotionCode, String svcId, Integer locId, String date, Integer userId,int pkgId);

    //get promotion id by promotion code by Client Id
    boolean getPromotionByPromotionCodeByClientId(String promotionCode, String svcId, Integer locId, String date, String clientId,int pkgId);

    //check whether promotion exists or not
    Integer checkPromotionCodeExist(String promotionCode);

    //get old promotion code
    String oldPromotionCode(Integer promotionId);

    Integer getCountOfApptsToLoc(Integer locId);

    Integer getApptCntToBiz(Integer bizId);

    List<ResourceHours> getResourceHoursByLocation(Integer resId, Integer locId1);

    //get all the services for the location by bizId
    List<Location> getLocationScvByBizId(Integer bizId);

    List<Business> getUserBusinessPromotion(Integer userId);
    //get count of the event booked at same time with same locId, BizId, svcId, resId
    int getAppointmentsCount(Integer bizId, Integer locId, String svcId,
                             Integer resId, String startTime);

    //Get Master Services for given categoryCode
    List<ServiceMaster> getMasterServicesByBizId(Integer bizId) throws DataAccessException;
    // Get the Locations for a given business by package
    List<Location> getLocationPackageExist(Integer bizId) throws DataAccessException;
    void addMaterial(Materials material);

    Integer checkForDupliceteMaterial(String matName, Integer bizId);

    List<Materials> getMaterialsByBizIdByMatId(int bizId,  Integer pkgId,int matId);

    List<Materials> getMaterialsByBizId(int bizId, Integer pkgId);

    void addMaterialToPkg(MatToPackage mat);

    List<Business> getActiveBusinessesByUserId(Integer userId);

    List<Package> getPkgsToSvcsByLocId(Integer locId);

    List<MatToPackage> getMaterialsToPkgByLocSvcId(Integer pkgId);

    MatToPackage getMaterialAndQtyByMatId(String matId, Integer pkg);

    void updateMatMaster(Materials matToPkg);

    Materials getMatByMatId(Integer matId);

    void updateMatToPkg(Integer pkg,String materialId,
                        String qtyNeeded, Integer matId);

    void deleteMaterialToPackage(MatToPackage mtp);

    List<Materials> getMaterialsListByBizId(Integer bizId);

    Integer getMatCountByMatNameAndManufacturer(Integer bizId, String matName,
                                                String matName2);

    void updateMasterMaterial(Materials cmdMat);

    Integer checkForPkgUsingMaterial(Integer matId);

    void deleteMasterMaterialByMatId(Integer matId);

    Integer addPurchase(PurchaseHeader cmdPurchaseHeader);

    PurchaseHeader getBasicPurchaseDetailsByPid(Integer pId,Integer bizId);

    void addPurchaseDetails(PurchaseDetails temp_pd);

    void updateBasicPurchaseMaterial(PurchaseHeader cmdPurchaseHeader);

    void stocksCronjob();

    OnskedList getStocksToLocId(Integer locId,int pageSize, int pageNo, String sortBy, String sort);

    Integer getInventoryBizCountByUserId(Integer userId);

    void updatePurchaseHeader(Integer purchaseId);

    List<Location> getLocsToBizWhichHasActiveRes(int bizId);

    //get business which are active with limit by sort
    OnskedList getBusinessesByUserIdByPromotionIdByLimitBySort(int userId,int pageSize,int pageNo,String sortBy,String sort);
    //get all the service for all the categories which are not opted by the business
    List<ServiceMaster> getServiceListByBizIdLocId(Integer bizId, Integer loc);

    List<Client> getClientInfoForBizCal(int bizId);

    List<Client> getClientInfoForCourseCal(int bizId);

    //get all the categories selected by the business and not selected
    List<Category> getBusinessCategoriesNotSelected(Integer bizId);

    //get all the categories selected by the business and selected
    List<Category> getBusinessCategoriesSelected(Integer bizId);

    //get all the categories selected by the business and used
    List<Category> getBusinessCategoriesUsed(Integer bizId);

    //get all the categories selected by the business
    List<Category> getBusinessCategories(Integer bizId);

    Integer getApptCountToResourcePast(String resId, String locId);

    Resource getResourceToLocationByNickName(String nickName, Integer locId,
                                             Integer bizId);

    List<Resource> getResourceByNickNamelist(String nickName, Integer locId,
                                             Integer bizId);

    List<Resource> getResourceToLocationByNickNameList(String nickName,
                                                       Integer locId, Integer bizId);

    void addResourceToService(Integer locId, Integer resId, String svcId, int userId);

    void updateLocationToResource(Integer locId, Integer resId, int userId);

    List<ServiceMaster> getUniqueLocationToServiceByLocIdBizIdforCategoryCode(
            Integer loc, Integer bizId);

    List<ServiceMaster> getUniqueLocationToServiceByLocIdBizIdOnCategoryCode(
            int locId, int bizId);

    List<ServiceMaster> getResourceServicesByCategory(int locId, int resId);

    Integer getApptCountToService(Integer svcId, Integer loc);

    Integer getApptCountToResourceService(Integer locId, Integer resId, Integer svcId);

    Integer getResCountToService(Integer svcId, Integer loc);

    OnskedList checkToDelSvc(Integer svcId, Integer loc);

    int addMaterialAndGetMatId(Materials cmdMat);

    int checkDuplicateClientInBiz(String email, int bizId);

    List<Package> getPackageDetails1(Integer bizId);

    List<Package> getPackageDetailsByLocSvcId(String svcId, Integer pkgId);

    void updatePackage(Package temp_pd1);

    void deletePackages(String packId);

    int getCountOfAppt(String packId);

    int getCountMaterialToPackage(String packId);

    List<Package> getLocSvcId(String svcId);

    //	void disableResource(Integer resId, String isActive, Integer locId);
    //Business getBusinessNameByBizId(Integer bizId) throws DataAccessException;
    OnskedList getMaterialsListByBizIdByLimitBySort(Integer bizId,int pageSize,int pageNo,String sortBy,String sort);

    OnskedList getMaterialsToPkgByLocSvcIdByLimitBySort(Integer pkgId,Integer bizId,int pageSize, int pageNo, String sortBy, String sort);

    Business inventoryBreadCrum(Integer pkgId) throws DataAccessException;
    // get packages and service name based by bizId
    List<Package> getPackageDetailsOfBusinessByBizId(Integer bizId);

    // get all the packages (including inactive and deleted) for a given business by biz id
    List<Package> getAllPackagesOfBusinessByBizId(Integer bizId) throws DataAccessException;

    List<Business> getActiveBusinessesByUserIdForCal(Integer userId);

    List<Business> getActiveBusinessesForSMS();

    //get the count for locationTo Service 	by loc_id and biz_id
    Integer getLocationScvByBizIdCount(Integer bizId, Integer locId);

    //Checking if any appointment is using the package

    Integer checkForApptUsingPackage(Integer pkg, Integer matId);

    //Gets the list of all contries (this is only for ScheduleApptByBizAdmin because it didn't support hash map)
    List<Country> getCountries();

    //To get count of services based on categoryCode and serviceCode
    int getServiceCount(String categoryCode, String serviceCode);

    //To get count of category based on categoryCode
    int getCategoryCount(Integer categoryCode);

    //To get all the location services packages & resources by bizId
    List<LocationToService> getLocSvcPackRes(Integer bizId);

    //To get all the resources by bizId
    List<Resource> getResourceDetailsByBizId(Integer bizId);

    //To get business details and services
    Business getBusinessServiceByBizId(Integer bizId);

    //to get all the business with there locations by user id
    OnskedList getBusinessesByUserIdByInventoryByLimitBySort(int userId,int pageSize, int pageNo, String sortBy, String sort, String isInventory);

    // Get the Businesses registered by a user()
    OnskedList getBusinessesBySort(Integer userId, int pageSize, int pageNo,String sortBy, String sort);

    OnskedList getActivebusinessByUserId(Integer userId, int pageSize, int pageNo,String sortBy, String sort);

    List<Business> getBusinessName(Integer userId);

    List<Location> getLocationName(Integer userId);

    List<Resource> getResourceName(Integer userId);

    Business getBusinessDetailsByBizId(Integer bizId)  throws DataAccessException;
    //Get all registered Active businesses
    OnskedList getAllBusinessesBySort(int pageSize, int pageNo,String sortBy, String sort);

    OnskedList getAllDeletedBusinessesBySort(int pageSize, int pageNo,String sortBy, String sort);

    //Get the Locations for a given business by sort
    OnskedList getLocationsByLimitBySort(Integer bizId,int pageSize, int pageNo,String sortBy, String sort) throws DataAccessException;

    // Get the Resources for a given business
    OnskedList getResourcesByLimitBySort(Integer bizId,int pageSize, int pageNo,String sortBy, String sort) throws DataAccessException;

    //get all the past Inactive promotion until current date
    OnskedList getPastInActivePromotion(String curDate, Integer bizId,int pageSize, int pageNo, String sortBy, String sort)throws DataAccessException;

    // upcoming promotions
    OnskedList getUpComingPromotion(String curDate, Integer bizId,int pageSize, int pageNo, String sortBy, String sort)throws DataAccessException;

    OnskedList getOngoingPromotion(String curDate, Integer bizId, int pageSize,int pageNo, String sortBy, String sort)throws DataAccessException;


    // get all the clients of business filtered by search element
    OnskedList getClientsByBizIDSearchElement(Integer bizId,
                                              String searchElement, int pageSize, int pageNo, String sortBy,
                                              String sort, String startDate, String endDate, String clientEmail, String clientPhone, String clientStatus)throws DataAccessException;

    // get all the clients of business filtered by search element with more options
    OnskedList getClientsByBizIDSearchElementMoreOptions(Integer bizId,
                                                         String searchElement, int pageSize, int pageNo, String sortBy,
                                                         String sort, String countMin, String countMax, String valueMin, String valueMax,
                                                         String svcId, String statusCode, String startDate, String endDate, String clientStatus, String pkgId, String locId,
                                                         String clientEmail, String clientPhone)throws DataAccessException;

    Promotion getPromotionDetails(Integer promotionId, Integer bizId)throws DataAccessException;

    OnskedList listPurchaseDetails(Integer bizId, int pageSize,int pageNo, String sortBy, String sort)throws DataAccessException;

    List<PurchaseDetails> getMaterialList(Integer bizId, int pId)throws DataAccessException;

    void updatePurchaseMaterial(PurchaseDetails purchase) throws DataAccessException;

    void updateActivebusinessByUserId(Integer bizId,Integer userId,String flagSMS,String flagPIN,String name,Integer modifiedBy) throws DataAccessException;

    Integer checkInvoice(Integer bizId, Integer locId,String PurchaseOrder) throws DataAccessException;

    List<Business> checkLocationExist(int userId);

    OnskedList getUniqueLocationToServiceByLimit(Integer bizId, int pageSize,int pageNo);

    OnskedList getMaterialsListByBizIdBySearch(Integer bizId, String matName,String manufacturer, String disposable, int pageSize, int pageNo,String sortBy, String sort);

    OnskedList getMatIdsByLocIdBySearch(Integer locId, String matName,String manufacturer,int pageSize, int pageNo, String sortBy, String sort);

    //get the count of appointments by bizId and clientId
    Integer getAppointmentCountByClientIdAndBizId(Integer bizId, Integer clientId);

    //disabling the client
    void disableClient(Integer bizId, Integer clientId,Integer userId);

    //enabling the client
    void enableClient(Integer bizId, Integer clientId,Integer userId);

    List<ServiceMaster> getUniqueLocationToServiceByLocIdBizIdOnResource(
            int locId, int bizId);

    List<ServiceMaster> getMatchingLocationToServiceByLocIdBizIdOnResource(
            String locId, int bizId);

    List<Resource> getResourcesForLocByBizId(Integer bizId);

    List<ResourceHours> getResourceHoursByBizId1(Integer bizId);

    List<LocationHours> getLocationHoursByBizId1(Integer bizId);

    List<AppointmentSchedule> getAppointmentRatingByCategoryCode(String categoryCode);

    //for android
    List<Package> getPackageDetailsOfBusinessByLocId(Integer locId);

    List<LocationHours> getLocationHours1(String tmZnCode,Integer locId) throws DataAccessException;

    List<AppointmentSchedule> getLocationListByBizId(Integer bizId);

    List<LocationToService> getLocSvcPackRes1(Integer bizId, Integer locId);

    // get all the patients of business
    OnskedList getPatientListByLimitBySort(Integer userId, int pageSize, int pageNo, String sortBy,String sort)throws DataAccessException;

    OnskedList getSMSLogByUserId(String userId,String bizId,String startDate, String endDate, int pageSize, int pageNo, String sortBy,String sort)throws DataAccessException;

    Integer addPatient(Patient patient) throws DataAccessException;

    List<Client> getClientListNotInPatientByBizId(Integer bizId, Integer userId) throws DataAccessException;

    List<Client> getClientListNotInPatient(Integer userId) throws DataAccessException;

    //add patient illness
    void addPatientsIllness(PatientIllness patientillness) throws DataAccessException;

    //get the list of patient illness details by patientId
    List<PatientIllness> getPatientIllnessDetailsByPatientId(Integer patientId)throws DataAccessException;

    //get the list of prev patient illness details by patientId
    List<PatientIllness> getPrevPatientIllnessDetailsByPatientId(Integer patientId)throws DataAccessException;

    //update the details of illness of patient
    void updatePatientsIllness(PatientIllness patientIllness) throws DataAccessException;

    // delete list of patient illness
    void deletePatientIllness(String patientIllnessId) throws DataAccessException;

    //get the patient insurance list
    OnskedList getPatientInsuranceListByLimitBySort(int patientId,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    OnskedList getClientInsuranceListByLimitBySort(int clientId,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    OnskedList getClientPhysicianListByLimitBySort(int clientId,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    // add the patient insurance details
    void addPatientInsurance(PatientInsurance patientInsurance) throws DataAccessException;

    void addClientInsurance(ClientInsurance clientInsurance) throws DataAccessException;

    void addClientPhysician(ClientPhysician clientPhysician) throws DataAccessException;

    //get the patient by client Id
    Patient getPatientByClientId(Integer clientId) throws DataAccessException;

    //get the patient by patientId
    Patient getPatientByPatientId(Integer patientId) throws DataAccessException;

    //get the client list by userId
    List<Client> getClientListByUserId(Integer userId) throws DataAccessException;

    //get the patient by client Id
    Patient getPatientByApptId(Integer clientId) throws DataAccessException;

    //update patient details
    void updatePatient(Patient patient) throws DataAccessException;

    //delete patient
    void disablePatient(Integer patientId) throws DataAccessException;

    //get the patient Insurance details by patient Insurance Id
    PatientInsurance getPatientInsuranceByPatientInsId(Integer patientInsuranceId) throws DataAccessException;

    ClientInsurance getClientInsuranceByClientInsId(Integer clientInsuranceId) throws DataAccessException;

    ClientPhysician getClientPhysicianByClientInsId(Integer clientPhysicianId) throws DataAccessException;

    // update the insurance details
    void updatePatientInsurance(PatientInsurance patientInsurance) throws DataAccessException;

    void updateClientInsurance(ClientInsurance clientInsurance) throws DataAccessException;

    void updateClientPhysician(ClientPhysician clientPhysician) throws DataAccessException;

    //delete the patient insurance details
    void deletePatientInsurance(Integer patientInsId) throws DataAccessException;

    void deleteClientInsurance(Integer clientInsId) throws DataAccessException;

    // get the top 6 master illness list
    List<PatientIllness> getMasterIllnessList() throws DataAccessException;

    // get the master illness list not added for patient in patient_illness
    List<PatientIllness> getPatientIllnessDetailsNotInCurNPrevByPatientId(String patientId) throws DataAccessException;

    // get the master illness by illness name
    int getIllnessByName(String illnessName) throws DataAccessException;

    // add new master illness
    void addMasterIllness(MasterIllness masterillness) throws DataAccessException;

    // get the active patient illness by medical code
    int getActivePatientIllnessByMedicalCode(String medicalCode,Integer patientId) throws DataAccessException;

    // get the patient list for appt booking
    List<Patient> getPatientInfoForBizCal(int bizId) throws DataAccessException;

    // get the count of insurance for the patient
    int getPatientInsCnt(Integer patientId) throws DataAccessException;

    // get the count of location nick name for the business
    int getDuplicateLocCount(String locName, Integer bizId) throws DataAccessException;

    // get discount details for appt billing
    PaymentHistory getdiscountdetails(String promoCode, int svcId, int locId,
                                      String startTime, int userId, int pkgId,int clientId);

    //gets the biz user payment credential
    Business getBizUserPaymentCred(int bizId);

    // add new group package
    void addGroupPackage(GroupPackage grpPkg) throws DataAccessException;

    // get group package by group package id
    GroupPackage getGroupPkgByGroupPkgId(String grpPkgId) throws DataAccessException;

    // get group package to package list by group package id
    List<GroupPackageOccurence> getGroupPkgOccurencesByGroupPkgId(String grpPkgId) throws DataAccessException;

    // update group package
    void updateGroupPackage(GroupPackage grpPkg) throws DataAccessException;

    // update group package
    void updateGroupPackageAppt(int bookedApptId, int groupPkgId, int pkgId,int groupPackagePurchaseId) throws DataAccessException;

    // get list of group packages of business user by userId
    OnskedList getAllGroupPackagesListByUserId(Integer userId, String bizId, String locId, int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    OnskedList getAllPurchasedGroupPackagesListByUserId(Integer userId, String bizId, String locId, int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    // get the biz name and loc name by loc Id
    Business getBizNamenLocNamebyLocId(String locId) throws DataAccessException;

    Integer getGroupPkgbyGrpPkgNameAndId(String grpPkgName, String grpPkgId, String locId) throws DataAccessException;

    Integer getGrpPkgApptCountByGrpPkgId(String grpPkgId) throws DataAccessException;

    Integer getGrpPkgPurchaseCountByGrpPkgId(String grpPkgId) throws DataAccessException;

    void deleteGrpPkg(String grpPkgId) throws DataAccessException;

    List<Business> getBizWhichHasGrpPkgs() throws DataAccessException;

    List<ProductModel> getProductModel() throws DataAccessException;

    List<ProductIssue> getProductIssue(String repairFormId) throws DataAccessException;

    List<ProductHardwareIssue> getProductHardwareIssueList(String techFormId) throws DataAccessException;

    List<ProductPartsUsed> getProductPartsUsedList(String techFormId) throws DataAccessException;

    AppointmentSchedule getUnregUserDetailsForInStore(String apptId) throws DataAccessException;

    RepairForm getRepairFormDetails(String apptId, String repairFormIdHex) throws DataAccessException;

    TechnicianForm getTechnicianFormDetails(String apptId,String repairFormId) throws DataAccessException;

    Integer getRepairFormUsingApptId(Integer apptId) throws DataAccessException;

    Integer getRepairFormIdForShowingTechnicianForm(Integer apptId) throws DataAccessException;

    List<Location> getLocsWhichHasGrpPkgs(int bizId) throws DataAccessException;

    List<Location> getNonDeletedLocations(int bizId) throws DataAccessException;

    Integer addGroupPackagePurchase(GroupPackagePurchase grpPkgPurchase) throws DataAccessException;

    Integer addGroupPackagePayment(GroupPackagePayment grpPkgPayment) throws DataAccessException;

    Integer addGroupPackageAppt(GroupPackageAppointment grpPkgAppt) throws DataAccessException;

    OnskedList getUserPurchasedGroupPackagesDetails(Integer userId,Integer groupPkgId,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    List<GroupPackage> getUserPurchasedGroupPackagesDetailsByGroupPkgId(Integer userId,Integer groupPkgId,Integer groupPkgPurchaseId) throws DataAccessException;

    List<GroupPackageAppointment> getUserSelectedPurchasedGroupPackagesDetails(Integer userId,int groupPkgId,int pkgId,int groupPkgPurchaseId) throws DataAccessException;

    List<GroupPackageAppointment> getBizResourceSelectedPurchasedGroupPackagesDetails(Integer userId,int groupPkgId,int pkgId,int groupPkgPurchaseId) throws DataAccessException;

    List<GroupPackageAppointment> getUserPurchasedGroupPackagesIds(Integer userId) throws DataAccessException;

    Integer getClientPresentByClientId(Integer clientId) throws DataAccessException;

    Integer getClientbyEmailAndClientId(String email, String clientId, Integer bizId) throws DataAccessException;

    Integer getClientIdByBizIdAndEmail(Integer bizId, String email) throws DataAccessException;

    String addTechnicianForm(TechnicianForm technicianForm) throws DataAccessException;

    String updateTechnicianForm(TechnicianForm technicianForm, String requestPath) throws DataAccessException;

    TechnicianForm getTechnicianFormIdForShowingEditFillTechnicianForm(Integer apptId, Integer repairFormId);

    List<PhoneCarrier> getPhoneCarrier();

    void updateClientPhysicianDetails(ClientPhysician clientPhysician) throws DataAccessException;

    List<ResourceRoleType> getResourceTypeDetails(Integer bizId);

    List<Resource> getTechniciansForRepairForm(Integer locId);

    List<FormStatus> getFormStausListForTechnicianForm();

    List<AppointmentStatus> getAppointmentStatusForGrid();

    void addTechnicianFormComment(TechnicianFormComments techFormComments);

    List<TechnicianFormComments> getTechnicianFormCommentsByTechFormId(String techFormId);

    void updateRepairFormSelfAssign(String repairFormId, String assignTechId, String techFormId, Integer userId);

    List<TechnicianFormComments> getTechFormCommentsByTechFormId(String techFormId);

    List<AuditTrail> getAuditDetails(WeakHashMap map, String query);

    String isDisplayCounterEnabled(Integer bizId);

    void updateResourceHours(Resource resourceWorkingHour);

    List<AppointmentSchedule> getApptBookedTime(WeakHashMap map);

    List<Service> getServiceForManageClientsForBusiness(String bizId);

    Package getMaxWorkingHrs(Integer locId) throws DataAccessException;

    List<Promotion> getUpcomingPromotionListForClient(String bizId);

    void addDataToClientsEmail(Map<String, Object> result);

    String getPackageByPromotionId(String promotionId);

    void deleteClient(String clientId);

    List<String> getAvailedProductsByClientId(Integer clientId, String svcId, String statusCode, String pkgId, String locId);

    List<String> getAvailedLocationsByClientId(Integer clientId, String svcId, String statusCode, String pkgId, String locId);

    void updateClientAddress(WeakHashMap map);

    List<ServiceMaster> getServiveListFromLocationList(String locIdList);

    String getLastCompletedAppointmentDate(Integer clientId);

    List<Client> getClientDetailsForDownload(String clientList);

    Integer isClientPresentInPromotion(String bizId, String promotionId, String clientEmail);

    Promotion getPackageDetailsByPackageId(String pkgId);

    Promotion getServiceNameByServiceId(String svcId);

    Promotion getlocationNameForPromotionByLocId(String locId);

    Promotion getPromotionByPromotionCodeForPromotionValidation(String promotionCode);

    List<Client> getPromotionParticipents(String promotionId);

    Client getClientAddress(Integer clientId);

    List<TimeZones> getTimezonesFromCountry(String countryCode);
}