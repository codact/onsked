package com.amazech.onsked.service;

import com.amazech.onsked.domain.PageviewTracker;
import com.amazech.onsked.exceptions.DataAccessException;

import java.util.List;

public interface PageviewTrackerSvc {
    Integer getPageviewCountOfBusiness(String bizId, String pageName) throws DataAccessException;

    // get the count of users visited the web page of all businesses of a Bizuser
    List<PageviewTracker> getPageviewCountOfAllBusiness(String userId, String pageName) throws DataAccessException;

    // Add a PageviewCount of a web page to the database
    void addPageviewCount(PageviewTracker pageviewTracker) throws DataAccessException;
}
