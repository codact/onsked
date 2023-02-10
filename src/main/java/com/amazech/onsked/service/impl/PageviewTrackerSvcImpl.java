package com.amazech.onsked.service.impl;

import com.amazech.onsked.domain.PageviewTracker;
import com.amazech.onsked.service.PageviewTrackerSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PageviewTrackerSvcImpl implements PageviewTrackerSvc {
    @Override
    public Integer getPageviewCountOfBusiness(String bizId, String pageName) {
        return null;
    }

    @Override
    public List<PageviewTracker> getPageviewCountOfAllBusiness(String userId, String pageName) {
        return null;
    }

    @Override
    public void addPageviewCount(PageviewTracker pageviewTracker) {

    }
}
