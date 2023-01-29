package com.amazech.onsked.service.impl;

import com.amazech.onsked.dao.entity.*;
import com.amazech.onsked.dao.repo.*;
import com.amazech.onsked.domain.*;
import com.amazech.onsked.exceptions.GenericBusinessException;
import com.amazech.onsked.service.AdminSvc;
import com.amazech.onsked.util.DateTimeUtil;
import com.amazech.onsked.util.OnskedList;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AdminSvcImpl implements AdminSvc {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ServiceMasterRepository serviceMasterRepository;
    @Autowired
    private HolidayRepository holidayRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public Integer addBusinessCategory(Category category) {
        log.debug("Before calling DAO method addBusinessCategory()");
        CategoryEntity categoryEntity = modelMapper.map(category, CategoryEntity.class);
        categoryEntity =  categoryRepository.save(categoryEntity);
        return categoryEntity.getCategoryCode();
    }

    @Override
    public void updateBusinessCategory(Category category) throws GenericBusinessException {

        log.debug("Before calling DAO method updateBusinessCategory()");
        CategoryEntity categoryEntity = modelMapper.map(category, CategoryEntity.class);
        Optional<CategoryEntity> value = categoryRepository.findById(categoryEntity.getCategoryCode());
        if(value.isPresent()){
            log.debug("Updating categoryCode.");
            categoryRepository.deleteById(categoryEntity.getCategoryCode());
            categoryRepository.save(categoryEntity);
        }else{
            log.debug("categoryCode does not exist.");
            throw new GenericBusinessException("category does not exist.");
        }
    }

    @Override
    public Category getCategoryByCategoryCode(Integer categoryCode) {
        log.debug("Before calling method getCategoryByCategoryCode()");
        Optional<CategoryEntity> value = categoryRepository.findById(categoryCode);
        if(value.isPresent()) {
            log.debug("categoryCode is present.");
            Category category = modelMapper.map(value.get(), Category.class);
            return category;
        }
        else{
            log.debug("categoryCode does not exist.");
            return null;
        }

    }

    @Override
    public Category getCategoryByCategoryName(String categoryName) throws GenericBusinessException {
        log.debug("Before calling method getCategoryByCategoryName()");
        Optional<CategoryEntity> value = categoryRepository.findByCategoryName(categoryName);
        if(value.isPresent()) {
            log.debug("categoryName is present.");
            Category category = modelMapper.map(value.get(), Category.class);
            return category;
        }
        else{
            log.debug("categoryName "+categoryName+" does not exist.");
            throw new GenericBusinessException("categoryName "+categoryName+" does not exist.");
        }
    }

    @Override
    public void enableDisableCategory(Integer categoryCode) throws GenericBusinessException {

        log.debug("Before calling method enableDisableCategory()");
        Optional<CategoryEntity> value = categoryRepository.findById(categoryCode);
        if(value.isPresent()){
            CategoryEntity categoryEntity = value.get();
            if(categoryEntity.getIsActive().equalsIgnoreCase("Y"))
                categoryEntity.setIsActive("N");
            else
                categoryEntity.setIsActive("Y");
            categoryRepository.save(categoryEntity);
        }
        else
            throw new GenericBusinessException("categoryCode "+categoryCode+" does not exist.");

    }

    @Override
    public void addServiceToCategory(ServiceMaster servicemaster) {

        log.debug("Before calling method addServiceToCategory()");
        ServiceMasterEntity serviceMasterEntity = modelMapper.map(servicemaster, ServiceMasterEntity.class);
        serviceMasterEntity = serviceMasterRepository.save(serviceMasterEntity);

    }

    @Override
    public ServiceMaster getServiceByServiceCode(String serviceCode) throws GenericBusinessException {

        log.debug("Before calling method getServiceByServiceCode()");
        Optional<ServiceMasterEntity> value = serviceMasterRepository.findById(Integer.parseInt(serviceCode));
        if(value.isPresent()){
            log.debug("serviceCode is present.");
            ServiceMaster serviceMaster = modelMapper.map(value.get(), ServiceMaster.class);
            return serviceMaster;
        }else {
            log.debug("serviceCode is not present.");
            throw new GenericBusinessException("serviceCode "+serviceCode+" does not exist.");
        }
    }

    @Override
    public void updateServiceDetails(ServiceMaster service) throws GenericBusinessException {

        log.debug("Before calling method updateServiceDetails()");
        ServiceMasterEntity serviceMasterEntity = modelMapper.map(service, ServiceMasterEntity.class);
        Optional<ServiceMasterEntity> value = serviceMasterRepository.findById(serviceMasterEntity.getServiceCode());
        if(value.isPresent()){
            log.debug("Deleting existing service code details");
            serviceMasterRepository.deleteById(value.get().getServiceCode());
            log.debug("Saving updated values");
            serviceMasterRepository.save(serviceMasterEntity);
        }else{
            log.debug("service code "+serviceMasterEntity.getServiceCode()+" doesn't exist.");
            throw new GenericBusinessException("serviceCode "+serviceMasterEntity.getServiceCode()+" does not exist");
        }

    }

    @Override
    public List<Category> getAllCategories() throws GenericBusinessException {

        log.debug("Before calling method getAllCategories()");
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();

        if(!categoryEntities.isEmpty()) {
            List<Category> categories = categoryEntities.stream()
                    .map(categoryEntity -> modelMapper.map(categoryEntity, Category.class))
                    .collect(Collectors.toList());
            return categories;
        }
        else
            throw new GenericBusinessException("No Categories available!");

    }

    @Override
    public Integer checkService(ServiceMaster service) {
        log.debug("Before calling method checkService()");
        List<ServiceMasterEntity> value = serviceMasterRepository.findAllByServiceName(service.getServiceName());
        return value.size();
    }

    @Override
    public void addService(ServiceMaster service) {
        log.debug("Before calling method addService()");
        ServiceMasterEntity serviceMasterEntity = modelMapper.map(service, ServiceMasterEntity.class);
        serviceMasterEntity = serviceMasterRepository.save(serviceMasterEntity);
    }

    @Override
    public ServiceMaster getServiceByCategoryCodeServiceCode(String categoryCode, String serviceCode) throws GenericBusinessException {

        log.debug("Before calling method getServiceByCategoryCodeServiceCode()");
        Optional<ServiceMasterEntity> value = serviceMasterRepository.findByServiceCodeAndCategoryCode(Integer.parseInt(serviceCode), categoryCode);
        if(value.isPresent()){
            log.debug("service matching (serviceCode, categoryCode) is present.");
            ServiceMaster serviceMaster = modelMapper.map(value.get(), ServiceMaster.class);
            return serviceMaster;
        }else {
            log.debug("service matching (serviceCode, categoryCode) is NOT present.");
            throw new GenericBusinessException("service does not exist.");
        }
    }

    @Override
    public void updateService(ServiceMaster cmdService, String categoryCodePresent, String serviceCodePresent) throws GenericBusinessException {

        log.debug("Before calling method updateService()");
        ServiceMasterEntity serviceMasterEntity = modelMapper.map(cmdService, ServiceMasterEntity.class);
        Optional<ServiceMasterEntity> value = serviceMasterRepository.findByServiceCodeAndCategoryCode(Integer.parseInt(serviceCodePresent), categoryCodePresent);
        if(value.isPresent()){
            log.debug("Updating service");
            serviceMasterRepository.delete(value.get());
            serviceMasterRepository.save(serviceMasterEntity);
        }else{
            log.debug("Service does not exist");
            throw new GenericBusinessException("Service does not exist");
        }
    }

    @Override
    public void deleteService(String categoryCode, String serviceCode) throws GenericBusinessException {
        log.debug("Before calling method deleteService()");
        Optional<ServiceMasterEntity> value = serviceMasterRepository.findByServiceCodeAndCategoryCode(Integer.parseInt(serviceCode), categoryCode);
        if(value.isPresent()){
            log.debug("Deleting service");
            serviceMasterRepository.delete(value.get());
        }else{
            log.debug("Service does not exist");
            throw new GenericBusinessException("Service does not exist");
        }
    }

    @Override
    public List<ServiceMaster> getAllServices() throws GenericBusinessException {
        log.debug("Before calling method getAllServices()");
        List<ServiceMasterEntity> serviceMasterEntities = serviceMasterRepository.findAll();
        if(!serviceMasterEntities.isEmpty()) {
            List<ServiceMaster> serviceMasters = serviceMasterEntities.stream()
                    .map(serviceMasterEntity -> modelMapper.map(serviceMasterEntity, ServiceMaster.class))
                    .collect(Collectors.toList());
            return serviceMasters;
        }
        else
            throw new GenericBusinessException("No services available!");
    }

    @Override
    public List<ServiceMaster> getMasterServices(Integer categoryCode) throws GenericBusinessException {
        log.debug("Before calling method getMasterServices()");
        List<ServiceMasterEntity> serviceMasterEntities = serviceMasterRepository.findByCategoryCodeAndIsActive(categoryCode.toString(), "Y");

        if(!serviceMasterEntities.isEmpty()){
            List<ServiceMaster> serviceMasters = serviceMasterEntities.stream()
                    .map(serviceMasterEntity -> modelMapper.map(serviceMasterEntity, ServiceMaster.class))
                    .collect(Collectors.toList());
            return serviceMasters;
        }else {
            log.debug("services does not exist.");
            throw new GenericBusinessException("services does not exist.");
        }
    }

    @Override
    public void enableDisableHoliday(String countryCode, String holidayDt) throws GenericBusinessException {
        log.debug("Before calling method enableDisableHoliday()");
        Optional<HolidayEntity> value = holidayRepository.findByCountryCodeAndHolidayDt(countryCode, holidayDt);
        if(value.isPresent()){
            HolidayEntity holidayEntity = value.get();
            if(holidayEntity.getIsActive().equalsIgnoreCase("Y"))
                holidayEntity.setIsActive("N");
            else
                holidayEntity.setIsActive("Y");
            holidayRepository.save(holidayEntity);
        }
        else
            throw new GenericBusinessException("Holiday not present");
    }

    @Override
    public Integer checkDefaultHoliday(String countryCode, String holidayDt) {
        log.debug("Before calling method checkDefaultHoliday()");
        Optional<HolidayEntity> value = holidayRepository.findByCountryCodeAndHolidayDt(countryCode, holidayDt);
        if(value.isPresent())
            return 1;
        else
            return 0;
    }

    @Override
    public Holiday addDefaultHoliday(Holiday holiday) {
        log.debug("Before calling method addDefaultHoliday()");
        HolidayEntity holidayEntity = modelMapper.map(holiday, HolidayEntity.class);
        holidayEntity.setIsActive("Y");
        holidayEntity.setCreatedDt(DateTimeUtil.getUTCDateTimeAsDate());
        holidayEntity.setModifiedDt(DateTimeUtil.getUTCDateTimeAsDate());
        holidayEntity = holidayRepository.save(holidayEntity);
        return holiday;
    }

    @Override
    public Holiday getHolidayByDateAndCountry(String countryCode, String holidayDt) throws GenericBusinessException {
        log.debug("Before calling method getHolidayByDateAndCountry()");
        Optional<HolidayEntity> value = holidayRepository.findByCountryCodeAndHolidayDt(countryCode, holidayDt);
        if(value.isPresent())
            return modelMapper.map(value.get(), Holiday.class);
        else
            throw new GenericBusinessException("Holiday does not exist");
    }

    @Override
    public void updateDefaultHoliday(Holiday cmdHoliday, String countryCode, String holidayDt) throws GenericBusinessException {
        log.debug("Before calling method updateDefaultHoliday()");
        Optional<HolidayEntity> value = holidayRepository.findByCountryCodeAndHolidayDt(countryCode, holidayDt);
        if(value.isPresent()) {
            log.debug("Updating Holiday...");
            HolidayEntity entity = modelMapper.map(cmdHoliday, HolidayEntity.class);
            entity.setModifiedDt(DateTimeUtil.getUTCDateTimeAsDate());
            holidayRepository.save(entity);
        }
        else
            throw new GenericBusinessException("Holiday does not exist");
    }

    @Override
    public List<Country> getAllCountries() throws GenericBusinessException {
        log.debug("Before calling method getAllCountries()");
        List<CountryEntity> countryEntities = countryRepository.findAll();

        if(!countryEntities.isEmpty()) {
            List<Country> countries = countryEntities.stream()
                    .map(countryEntity -> modelMapper.map(countryEntity, Country.class))
                    .collect(Collectors.toList());
            return countries;
        }
        else
            throw new GenericBusinessException("No Countries available!");
    }

    @Override
    public Integer checkCountryByCountryName(String countryName) {
        log.debug("Before calling method checkCountryByCountryName()");
        List<CountryEntity> countries = countryRepository.findAllByCountryName(countryName);
        return countries.size();
    }

    @Override
    public Integer checkCountryByCountryCode(String countryCode) {
        log.debug("Before calling method checkCountryByCountryName()");
        List<CountryEntity> countries = countryRepository.findAllByCountryCode(countryCode);
        return countries.size();
    }

    @Override
    public Integer checkState(State state) {
        return null;
    }

    @Override
    public void addCountry(Country country) {
        log.debug("Before calling method addCountry()");
        countryRepository.save(modelMapper.map(country, CountryEntity.class));
    }

    @Override
    public Country getCountryByCountryCode(String countryCodePresent) throws GenericBusinessException {
        log.debug("Before calling method getCountryByCountryCode()");
        Optional<CountryEntity> countryEntity = countryRepository.findById(countryCodePresent);
        if(countryEntity.isPresent()){
            log.debug("countryCode present.");
            Country country = modelMapper.map(countryEntity.get(), Country.class);
            return country;
        }
        else
            throw new GenericBusinessException("countryCode "+countryCodePresent+" does not exist.");
    }

    @Override
    public void updateCountry(Country cmdCountry, String countryCodePresent) throws GenericBusinessException {
        log.debug("Before calling method updateCountry()");
        Optional<CountryEntity> value = countryRepository.findById(countryCodePresent);
        if(value.isPresent()){
            log.debug("Updating country details");
            CountryEntity countryEntity = modelMapper.map(cmdCountry, CountryEntity.class);
            countryRepository.save(countryEntity);
        }
        else
            throw new GenericBusinessException("Country does not exist");
    }

    @Override
    public void deleteCountry(String countryCode) {
        log.debug("Before calling method deleteCountry()");
        countryRepository.deleteById(countryCode);
    }

    @Override
    public OnskedList getAllStatesBySort(int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public OnskedList getCountryStates(String countryCode, int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public void deleteState(String countryCode, String stateCode) {
        log.debug("Before calling method deleteState()");
        StateId stateId = new StateId();
        stateId.setCountry_code(countryCode);
        stateId.setState_code(stateCode);
        stateRepository.deleteById(stateId);
    }

    @Override
    public void addState(State state) {
        log.debug("Before calling method addState()");
        state.setStateCode(state.getStateCode().toUpperCase());
        StateEntity stateEntity = modelMapper.map(state, StateEntity.class);
        stateRepository.save(stateEntity);
    }

    @Override
    public State getStateByCountryCodeStateCode(String countryCode, String stateCode) throws GenericBusinessException {
        log.debug("Before calling method getStateByCountryCodeStateCode()");
        StateId stateId = new StateId();
        stateId.setCountry_code(countryCode);
        stateId.setState_code(stateCode.toUpperCase());
        Optional<StateEntity> value = stateRepository.findById(stateId);
        if(value.isPresent())
            return modelMapper.map(value.get(), State.class);
        else
            throw new GenericBusinessException("State not present");
    }

    @Override
    public void updateState(State cmdState, String countryCodePresent, String stateCodePresent) throws GenericBusinessException {
        log.debug("Before calling method getStateByCountryCodeStateCode()");
        StateId stateId = new StateId();
        stateId.setCountry_code(countryCodePresent);
        stateId.setState_code(stateCodePresent.toUpperCase());
        Optional<StateEntity> value = stateRepository.findById(stateId);
        if(value.isPresent()){
            cmdState.setStateCode(cmdState.getStateCode().toUpperCase());
            StateEntity stateEntity = modelMapper.map(cmdState, StateEntity.class);
            stateRepository.save(stateEntity);
        }else
            throw new GenericBusinessException("State not present");
    }

    @Override
    public void enableDisableBusiness(Integer bizId) throws GenericBusinessException {
        log.debug("Before calling method enableDisableBusiness()");
        Optional<BusinessEntity> value = businessRepository.findById(bizId);
        if(value.isPresent()){
            BusinessEntity businessEntity = value.get();
            if(businessEntity.getIsActive().equalsIgnoreCase("Y"))
                businessEntity.setIsActive("N");
            else
                businessEntity.setIsActive("Y");
            businessRepository.save(businessEntity);
        }
        else
            throw new GenericBusinessException("businessId "+bizId+" does not exist.");

    }

    @Override
    public List<Business> getFeaturedBusinesses() {
        return null;
    }

    @Override
    public OnskedList getCategoriesOfSearchElement(String searchElement, int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public OnskedList getCountriesOfSearchElement(String searchElement, int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public OnskedList getStatesOfSearchElement(String filterState, String searchElement, int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public OnskedList getHolidaysOfSearchElement(String searchElement, int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public int checkStateIsEditable(String countryCode, String stateCode) {
        return 0;
    }

    @Override
    public void markOrRemoveFeaturedBusiness(Integer bizId, Integer userId) {

    }

    @Override
    public OnskedList getAllActiveOnskedUsersBySort(int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public OnskedList getUpgradeOptionsBySort(int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public void addPaymentDetails(Payment payment, String requestPath) {

    }

    @Override
    public void insertSubscription(int userId, int numberOfBusiness, int numberOfLocation, int numberOfResource, String requestPath) {

    }

    @Override
    public void updateExpiryDate(String expiryDate, Integer userId, String requestPath) {

    }

    @Override
    public String getExpiryDate(Integer userId) {
        return null;
    }

    @Override
    public void upgradeUser(Integer userId) throws GenericBusinessException {
        log.debug("Before calling upgradeUser()");
        Optional<UserRoleEntity> value = userRoleRepository.findById(userId);
        if(value.isPresent()){
            log.debug("Upgrading user");
            UserRoleEntity userRoleEntity = value.get();
            userRoleEntity.setRoleCode("BIZADMIN");
            userRoleRepository.save(userRoleEntity);
        }
        else
            throw new GenericBusinessException("User id does not exist");
    }

    @Override
    public OnskedList getUsersByEmailId(String searchElement, int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public OnskedList getFeaturedBusinessesBySort(int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public OnskedList getAllCategoriesBySort(int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public OnskedList getAllServicesBySort(int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public OnskedList getMasterServicesBySort(Integer categoryCode, int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public OnskedList getServicesOfSearchElement(Integer filterService, String searchElement, int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public void updateOnskedUsers(String userId) {
        log.debug("Before calling method updateOnskedUsers()");
        Optional<UserEntity> value = userRepository.findById(Integer.parseInt(userId));
        if(value.isPresent()){
            log.debug("Updating user");
            UserEntity userEntity = value.get();
            if(userEntity.getIsActive().equalsIgnoreCase("Y"))
                userEntity.setIsActive("N");
            else
                userEntity.setIsActive("Y");
            userRepository.save(userEntity);
        }
    }

    @Override
    public Integer checkStateExist(String countryCode) {
        return null;
    }

    @Override
    public Integer checkAppointmentExists(String countryCode, String holidayDt) {
        return null;
    }
}
