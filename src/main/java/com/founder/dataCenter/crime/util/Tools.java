/**
 * 
 */
package com.founder.dataCenter.crime.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 * @author qs
 * 
 */
public class Tools {
	public Tools() {
	}

	/**
	 * @category 检测对象是否为空
	 * @param 待检测参数
	 * @return 合法则返回true
	 * */
	public static boolean IsNull(Object _obj) {
		if (_obj == null)
			return true;
		return false;
	}

	/**
	 * @category 检测字符型输入参数是否合法
	 * @param 待检测参数
	 * @return 合法则返回true
	 * */
	public static Boolean CheckInputStrParam(String _InputStrParam) {
		if (_InputStrParam == null)
			return false;
		if (_InputStrParam.trim().length() == 0)
			return false;
		return true;
	}

	/**
	 * @category 检测字符串是否为4位数字
	 * @param 待检测参数
	 * @return 合法则返回true
	 * */

	public static boolean IsNumber(String str, int length) {
		if (!CheckInputStrParam(str)) {
			return false;
		}
		if (str.length() > length) {
			return false;
		}
		return str.trim().matches("^[0-9]\\d*$");
	}

	/**
	 * @category 严禁特殊字符长度小于end大于begin
	 * @param 待检测参数
	 * @return 合法则返回true
	 * */

	public static boolean CheckSpecialCode(String str, int begin, int end) {
		// 非空
		if (!CheckInputStrParam(str)) {
			return false;
		}
		// 严禁非法字符
		if (!str.replaceAll("[\u4e00-\u9fa5]", "aa").matches("^[A-Za-z0-9]+$")) {
			return false;
		}
		// 长度在5~20之间
		if (CharNumber(str) > end || CharNumber(str) < begin) {
			return false;
		}
		return true;
	}

	/**
	 * @category 判断字符数
	 * @param 待检测参数
	 * @return 合法则返回true
	 * */

	public static int CharNumber(String str) {
		if (!CheckInputStrParam(str)) {
			return 0;
		}
		return str.replaceAll("[\u4e00-\u9fa5]", "aa").length();
	}

	public static Boolean CheckFileExist(String path) {
		File file = new File(path);
		if (file.exists())
			return true;
		return false;
	}

	/**
	 * @category iso-8859-1转GBK
	 * @param _src
	 *            目标字符串
	 * @return 返回GBK编码字符串
	 * */
	public static String GBKConverter(String _src) {
		String des = "";
		try {
			des = new String(_src.getBytes("iso-8859-1"), "GBK");
			return des;
		} catch (Exception ex) {
			return "";
		}
	}

	/**
	 * @category iso-8859-1转UTF-8
	 * @param _src
	 *            目标字符串
	 * @return 返回UTF编码字符串
	 * */
	public static String UTF8Converter(String _src) {
		String des = "";
		try {
			des = new String(_src.getBytes("iso-8859-1"), "utf-8");
			return des;
		} catch (Exception ex) {
			return "";
		}
	}

	/**
	 * @category "
	 * @param _src
	 *            目标字符串
	 * @return 返回path编码字符串
	 * */
	public static String pathConverter(String _src) {
		String des = "";
		try {
			des = _src.replace("\\", "\\\\");
			return des;
		} catch (Exception ex) {
			return "";
		}
	}

	public static String getJbName(String strJb) {
		if (strJb.equals("1"))
			return "\u603B\u961F";
		if (strJb.equals("2"))
			return "\u652F\u961F";
		if (strJb.equals("3"))
			return "\u5927\u961F";
		if (strJb.equals("4"))
			return "\u4E2D\u961F";
		else
			return "";
	}

	public static String[] splitString(String str, String split) {
		String tmpStr = str.trim();
		String result[];
		if (tmpStr.equals(""))
			result = (String[]) null;
		else
			result = tmpStr.split(split);
		return result;
	}

	public static String cScriptInfoStr(String strJava) {
		String r = null;
		if (strJava == null) {
			r = "";
		} else {
			r = strJava.replaceAll("'", "\"");
			r = r.replaceAll("\"", "\\\"");
			r = r.replaceAll("\r", "");
			r = r.replaceAll("\n", "A~A~");
		}
		return r;
	}

	public static String[] splitIpString(String str, char split) {
		int i = 1;
		int j = 0;
		str = str + split;
		String str2 = str;
		while (i > -1) {
			i = str2.indexOf(split);
			if (i > -1) {
				str2 = str2.substring(i + 1);
				j++;
			}
		}
		String result[] = new String[j];
		for (int k = 0; k < j; k++) {
			i = str.indexOf(split);
			if (i > -1) {
				String str1 = str.substring(0, i);
				str = str.substring(i + 1);
				result[k] = String.valueOf(str1);
			} else {
				result[k] = String.valueOf(str);
			}
			if (result[k].trim() == null)
				result[k] = "0";
		}

		return result;
	}

	public static Date string2Date(String strDateTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = null;
		if (strDateTime != null && !strDateTime.equals("")) {
			try {
				date = format.parse(strDateTime);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return date;
	}

	public static Date string2Date2(String strDateTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		if (strDateTime != null && !strDateTime.equals("")) {
			try {
				date = format.parse(strDateTime);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return date;
	}

	public static String date2String(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String strDate = null;
		if (date != null) {
			try {
				strDate = format.format(date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return strDate;
	}

	public static String date2String2(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = null;
		if (date != null) {
			try {
				strDate = format.format(date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return strDate;
	}

	public static String date2StringR(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = null;
		if (date != null) {
			try {
				strDate = format.format(date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return strDate;
	}

	public static String formatDate(String strDateTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (strDateTime != null && !strDateTime.equals(""))
			try {
				strDateTime = format.format(format.parse(strDateTime));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		else
			strDateTime = "";
		return strDateTime;
	}

	public static String formatDate1(String strDateTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
		if (strDateTime != null && !strDateTime.equals(""))
			try {
				strDateTime = format.format(format.parse(strDateTime));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		else
			strDateTime = "";
		return strDateTime;
	}

	public static String formatDate(String strDateTime, String format) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy年MM月dd日");
		if (format != null && !"".equals(format)) {
			format2 = new SimpleDateFormat(format);
		}

		if (strDateTime != null && !strDateTime.equals("")) {
			try {
				Date d = format1.parse(strDateTime);
				strDateTime = format2.format(d);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			strDateTime = "";
		}
		return strDateTime;
	}

	public static Long nvl(Long l) {
		if (l == null) {
			l = 0l;
		}
		return l;
	}

	public static String rm2Digits(double d) {
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		return nf.format(d);
	}

	/**
	 * 公共功能对字符串的判空处理
	 * 
	 * @author WangChen
	 * @param inStr
	 * @return 如果输入的字符串为空值返回空串，否则返回
	 */
	public static String nulltoString(String inStr) {
		if (inStr == null) {
			return "";
		} else {
			return inStr.trim();
		}
	}

	public static int nulltoInt(String inStr) {
		int returnVal = 0;
		if (inStr == null) {
			return returnVal;
		} else {
			try {
				returnVal = Integer.valueOf(inStr);
			} catch (Exception e) {
				return 0;
			}
			return returnVal;
		}
	}

	/**
	 * 获取properties配置文件内相应属性的值
	 * 
	 * @param name
	 *            属性名
	 * @param Filename
	 *            属性文件名
	 * @return 属性的值
	 * @throws Exception
	 * @throws IOException
	 *             文件读取错误时抛出
	 */
	public static String getFactoryProperties(String name, String filename) {
		Logger logger = Logger.getRootLogger();
		Properties prop = new Properties();
		String tmpStr = null;
		try {
			prop.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("clientService.properties"));
			tmpStr = (String) prop.get(name);
		} catch (IOException e) {
			logger.error("在classpath下没有找到" + filename + "文件", e);
		} catch (Exception e) {
			logger.error("在classpath下没有找到" + filename + "文件", e);
			return null;
		}
		// 没有找到相应属性时，抛出异常
		if (tmpStr == null) {
			logger.error("没有找到相应属性");
			return null;
		}
		return tmpStr;
	}

	/**
	 * 方法名称：验证ip格式 方法说明：通过正则判断是否为ip
	 * 
	 * @param strIp
	 * @return 是IP返回TRUE
	 */
	public static boolean isIP(String strIp) {
		Pattern pattern = Pattern
				.compile("\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");
		Matcher matcher = pattern.matcher(nulltoString(strIp));
		return matcher.matches();
	}

	/**
	 * <p>
	 * 转码
	 * </p>
	 * 
	 * @CreationTime 2010-7-30
	 * @param str
	 * @return
	 */
	public static String chineseStr(String str) {
		try {
			if (str == null)
				return "";
			String tempStr = str;
			byte[] tempArray = tempStr.getBytes("ISO8859-1");
			String temp = new String(tempArray);
			return temp;
		} catch (Exception ex) {
			System.out
					.println("Exception : com.sclh.common.ChineseString/chineseStr() "
							+ ex.getMessage());
		}
		return "";
	}

	public static String getServerProperties(String key,
			HttpServletRequest request) {
		Properties prop = new Properties();
		String realPath = request.getRealPath(File.separator);
		String serverPropertiesPath = realPath + "META-INF\\server.properties";
		String propValue = "";
		try {
			File f = new File(serverPropertiesPath);
			FileInputStream fis = new FileInputStream(f);
			prop.load(fis);
			propValue = prop.getProperty(key);
			fis.close();

		} catch (Exception e) {

		}
		return propValue;
	}

	public static void setServerProperties(String key, String value,
			HttpServletRequest request) {
		Properties prop = new Properties();
		String realPath = request.getRealPath(File.separator);
		String serverPropertiesPath = realPath + "META-INF\\server.properties";
		try {
			File f = new File(serverPropertiesPath);
			FileInputStream fis = new FileInputStream(f);
			prop.load(fis);
			prop.setProperty(key, value);
			FileOutputStream fos = new FileOutputStream(f);
			prop.store(fos, "");
			fis.close();
			fos.close();
		} catch (Exception e) {

		}
	}
}
