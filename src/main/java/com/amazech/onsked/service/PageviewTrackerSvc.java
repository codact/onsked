package com.amazech.onsked.service;

import com.amazech.onsked.domain.PageviewTracker;

import java.util.List;

public interface PageviewTrackerSvc {
    Integer getPageviewCountOfBusiness(String bizId, String pageName);

    // get the count of users visited the web page of all businesses of a Bizuser
    List<PageviewTracker> getPageviewCountOfAllBusiness(String userId, String pageName) ;

    // Add a PageviewCount of a web page to the database
    void addPageviewCount(PageviewTracker pageviewTracker);
}
