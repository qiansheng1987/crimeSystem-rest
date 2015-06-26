package com.founder.dataCenter.crime.sevice;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.founder.dataCenter.crime.pojo.CaseBean;
import com.founder.dataCenter.crime.service.CaseService;
import com.google.gson.Gson;


@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class CaseServiceTest {
    private final static Logger LOGGER = Logger.getLogger(CaseServiceTest.class);
    @Autowired
    private CaseService caseService;

    @Test
    public void testGetCasesByRange() {
    	List<CaseBean> caseList = caseService.getCasesByRange(0, 4);
    	Gson gson = new Gson();
    	LOGGER.debug(gson.toJson(caseList));
    	Assert.assertEquals(4, caseList.size());
    }
}
