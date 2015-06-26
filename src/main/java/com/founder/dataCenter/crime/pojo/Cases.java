/**  
 * @Project: crimeSystem_rest
 * @Title:   Cases.java
 * @Package  com.founder.dataCenter.crime.pojo
 * @Description: TODO
 * @author qs
 * @date 2015-4-30 下午4:53:20
 * @Copyright: 2015 
 * @version V1.2  
*/

package com.founder.dataCenter.crime.pojo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @ClassName   Cases
 * @Description TODO
 * @author qs
 * @date 2015-4-30
 */

public class Cases implements Serializable {

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = 8905621579690521301L;
	
	private ArrayList<CaseBean> caseList;

	public ArrayList<CaseBean> getCaseList() {
		return caseList;
	}

	public void setCaseList(ArrayList<CaseBean> caseList) {
		this.caseList = caseList;
	}
}
