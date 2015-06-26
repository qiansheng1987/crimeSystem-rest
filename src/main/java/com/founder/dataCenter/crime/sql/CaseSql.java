/**  
 * @Project: crimeSystem_rest
 * @Title:   CaseSql.java
 * @Package  com.founder.dataCenter.crime.sql
 * @Description: TODO
 * @author qs
 * @date 2015-4-30 下午2:27:09
 * @Copyright: 2015 
 * @version V1.2  
*/

package com.founder.dataCenter.crime.sql;

/**
 * @ClassName   CaseSql
 * @Description 案件sql工具类
 * @author qs
 * @date 2015-4-30
 */

public class CaseSql {
	
	private static CaseSql instance = new CaseSql();
	
	public static CaseSql getInstance() {
		return instance;
	}
	
	/**
	 * 
	 * @Title: getCaseByAjbh 
	 * @Description: 根据案件编号查询案件
	 * @param @param ajbh
	 * @param @return     
	 * @return String     
	 * @throws
	 */
	public String getCaseByAjbh(String ajbh) {
		StringBuilder builder = new StringBuilder();
		builder.append(" select ajbh,                ");     
		builder.append("        ajmc,                ");
		builder.append("        ajlbdm,              ");
		builder.append("        fasj,                ");
		builder.append("        afdz,                ");
		builder.append("        ajms,                ");
		builder.append("        ajztdm,              ");
		builder.append("        ssxqdm,              ");
		builder.append("        sspcsdm,ssgajdm,     ");
		builder.append("        objectid,            ");
		builder.append("        ajzldm, ajwldm,      ");
		builder.append("        zzjgdm               ");
		builder.append("   from ezcrm_aj a           ");
		builder.append("  where a.ajbh ="+ajbh+"     ");
		return builder.toString();
	}
}
