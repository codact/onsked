package com.amazech.onsked.service.impl;

import com.amazech.onsked.dao.mapper.PageviewTrackerMapper;
import com.amazech.onsked.domain.PageviewTracker;
import com.amazech.onsked.exceptions.DataAccessException;
import com.amazech.onsked.service.PageviewTrackerSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PageviewTrackerSvcImpl implements PageviewTrackerSvc {

    @Autowired
    PageviewTrackerMapper pageviewTrackerMapper;
    @Override
    public Integer getPageviewCountOfBusiness(String bizId, String pageName) throws DataAccessException {
        log.debug("Calling DAO method getPageviewCountOfBusiness()");
        return pageviewTrackerMapper.getPageviewCountOfBusiness(bizId,pageName);
    }

    @Override
    public List<PageviewTracker> getPageviewCountOfAllBusiness(String userId, String pageName) throws DataAccessException {
        log.debug("Calling DAO method getPageviewCountOfAllBusiness()");
        return pageviewTrackerMapper.getPageviewCountOfAllBusiness(userId,pageName);
    }

    @Override
    public void addPageviewCount(PageviewTracker pageviewTracker) throws DataAccessException {
        log.debug("Before calling DAO method addPageviewCount()");
        pageviewTrackerMapper.addPageviewCount(pageviewTracker);
        log.debug("After calling DAO method addPageviewCount()");

    }
}
