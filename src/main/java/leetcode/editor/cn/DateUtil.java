package leetcode.editor.cn;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import sun.rmi.runtime.Log;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

/**
 * 时间工具类
 * 
 * @Title： 
 * @Author： alvin.wyh
 * @Date： 2017年3月10日 上午8:11:22
 * @Description：
 */
public class DateUtil {
	
//	private static Log log = Logger.getLogger()
	
	//时间格式
	public static final String SPOT_YMD = "yyyy.MM.dd";
	public static final String SLASH_YMD = "yyyy/MM/dd";
	public static final String YM = "yyyyMM";
	public static final String Y_M = "yyyy-MM";
	public static final String YMD = "yyyyMMdd";
	public static final String Y_M_D = "yyyy-MM-dd";
	public static final String Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";
	public static final String YMDHMS = "yyyyMMddHHmmss";
	public static final String Y_M_D_ZW = "yyyy年MM月dd日";
	public static final String Y_M_D_H_M_ZW = "yyyy年MM月dd日HH:mm";
	//当前日期
	public static String currentDate;
	
	/***************************************************************
	 * 获取yyyy-MM-dd格式的时间串
	 * @return
	 **************************************************************/
	public static String getCurrentDate(){
		return getCurrentDate(Y_M_D);
	}
	
	/***************************************************************
	 * 获取yyyy-MM-dd HH:mm:ss格式的时间串
	 * @return
	 ***************************************************************/
	public static String getCurrentDateTime(){
		return getCurrentDate(Y_M_D_H_M_S);
	}
	
	/***************************************************************
	 * 获取yyyyMMddHHmmss格式的时间串
	 * @return
	 ***************************************************************/
	public static String getCurrentTime(){
		return getCurrentDate(YMDHMS);
	}
	
	/****************************************************************
	 * 获取自定义格式的时间串
	 * @param format
	 * @return
	 ***************************************************************/
	public static String getCurrentDate(String format){
		return new SimpleDateFormat(format).format(new Date());
	}
	
	/****************************************************************
	 * 获取某格式的时间
	 * @param date
	 * @param format
	 * @return
	 ***************************************************************/
	public static Date getDate(String date, String format){
		
		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
//			log.error("获取某格式的时间异常", e);
		}
		return null;
	}
	
	/****************************************************************
	 * 获取字符串
	 * @param date 时间
	 * @param format 格式
	 * @return
	 ***************************************************************/
	public static String getDateToString(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}
	
	/****************************************************************
	 * 获取其他月的当前时间
	 * @param num 正数为之后num个月，负数为之前num个月
	 * @return
	 ****************************************************************/
	public static Date getAnotherMonthDate(int num){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, num);
		return c.getTime();
	}
	
	/**
	 * 转化成 XMLGregorianCalendar格式
	 * @param date
	 * @return
	 */
	public static XMLGregorianCalendar dateToXmlDate(Date date){  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        DatatypeFactory dtf = null;  
         try {  
            dtf = DatatypeFactory.newInstance();  
        } catch (DatatypeConfigurationException e) {  
        }  
        XMLGregorianCalendar dateType = dtf.newXMLGregorianCalendar();  
        dateType.setYear(cal.get(Calendar.YEAR));  
        //由于Calendar.MONTH取值范围为0~11,需要加1  
        dateType.setMonth(cal.get(Calendar.MONTH)+1);  
        dateType.setDay(cal.get(Calendar.DAY_OF_MONTH));  
        dateType.setHour(cal.get(Calendar.HOUR_OF_DAY));  
        dateType.setMinute(cal.get(Calendar.MINUTE));  
        dateType.setSecond(cal.get(Calendar.SECOND));  
        return dateType;  
    }

	public static String getAfterMonth(String inputDate,int number) {
		Calendar c = Calendar.getInstance();
		//获得一个日历的实例
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 Date date = null;
		 try{
		 date = sdf.parse(inputDate);
		// 初始日期
		 }catch(Exception e){
		 } c.setTime(date);
		// 设置日历时间
		 c.add(Calendar.MONTH,number);
		// 在日历的月份上增加6个月
		 String strDate = sdf.format(c.getTime());
		// 的到你想要得6个月后的日期
		 return strDate;
	}


	/**  
	* 字符串日期转换成中文格式日期  
	* @param date  字符串日期 yyyy-MM-dd  
	* @return  yyyy年MM月dd日  
	* @throws Exception  
	*/  
	public static String dateToCnDate(String date) {
		String result = "";
		String[] cnDate = new String[] { "〇", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
		String ten = "十";
		String[] dateStr = date.split("-");
		for (int i = 0; i < dateStr.length; i++) {
			for (int j = 0; j < dateStr[i].length(); j++) {
				String charStr = dateStr[i];
				String str = String.valueOf(charStr.charAt(j));
				if (charStr.length() == 2) {
					if (charStr.equals("10")) {
						result += ten;
						break;
					} else {
						if (j == 0) {
							if (charStr.charAt(j) == '1') {
								result += ten;
							} else if (charStr.charAt(j) == '0') {
								result += "";
							} else {
								result += cnDate[Integer.parseInt(str)] + ten;
							}
						}
						if (j == 1) {
							if (charStr.charAt(j) == '0') {
								result += "";
							} else {
								result += cnDate[Integer.parseInt(str)];
							}
						}
					}
				} else {
					result += cnDate[Integer.parseInt(str)];
				}
			}
			if (i == 0) {
				result += "年";
				continue;
			} else if (i == 1) {
				result += "月";
				continue;
			} else if (i == 2) {
				result += "日";
				continue;
			}
		}
		return result;
	}


	/**
	 * 返回num天后的日期
	 * 
	 * @param date
	 *            开始日期
	 * @param num
	 *            天数
	 * @param format
	 *            返回格式
	 * @return
	 */
	public static String getAnotherDate(String date, int num, String format) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new SimpleDateFormat(Y_M_D).parse(date));
			calendar.add(Calendar.DAY_OF_MONTH, num);
			return getDateToString(calendar.getTime(), format);
		} catch (ParseException e) {
//			log.error("获取某格式的时间异常", e);
		}
		return null;
	}

	/**
	 * 返回num天后的日期
	 *
	 * @param date
	 *            开始日期
	 * @param num
	 *            天数
	 * @param format
	 *            返回格式
	 * @return
	 */
	public static String getAnotherDateReplaceFormat(String date, int num, String format) {
		try {
			date = date.replaceAll("[_./]", "-");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new SimpleDateFormat(Y_M_D).parse(date));
			calendar.add(Calendar.DAY_OF_MONTH, num);
			return getDateToString(calendar.getTime(), format);
		} catch (ParseException e) {
//			log.error("获取某格式的时间异常", e);
		}
		return null;
	}

	public static String getAnotherMonth(String date, int num, String format) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new SimpleDateFormat(Y_M_D).parse(date));
			calendar.add(Calendar.MONTH, num);
			return getDateToString(calendar.getTime(), format);
		} catch (ParseException e) {
//			log.error("获取某格式的时间异常", e);
		}
		return null;
	}

    public static String getAnotherMonthReplaceFormat(String date, int num, String format) {
        try {
            date = date.replaceAll("[_./]", "-");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new SimpleDateFormat(Y_M_D).parse(date));
            calendar.add(Calendar.MONTH, num);
            return getDateToString(calendar.getTime(), format);
        } catch (ParseException e) {
//            log.error("获取某格式的时间异常", e);
        }
        return null;
    }

	public static String getReplaceFormat(String date, String format) {
		date = date.replaceAll("[_./]", "-");
		return date;
	}


	/**  
     * 计算两个日期之间相差的天数  
     * @param begin 较小的时间 
     * @param end  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */  
	public static int daysBetween(String begin,String end) { 
		try {   
			SimpleDateFormat sdf=new SimpleDateFormat(Y_M_D);  
	        Date bdate;
			bdate = sdf.parse(begin);
	        Date edate = sdf.parse(end);  
	        Calendar cal = Calendar.getInstance();    
	        cal.setTime(bdate);    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(edate);    
	        long time2 = cal.getTimeInMillis();         
	        long between_days=(time2-time1)/(1000*3600*24);  
	        return Integer.parseInt(String.valueOf(between_days));  
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
    }

	/**
	 * 计算两个日期之间相差的天数
	 * @param begin 较小的时间
	 * @param end  较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetweenReplaceDateFormat(String begin,String end) {
		try {
			begin = begin.replaceAll("[_./]", "-");
			end = end.replaceAll("[_./]", "-");
			SimpleDateFormat sdf=new SimpleDateFormat(Y_M_D);
			Date bdate;
			bdate = sdf.parse(begin);
			Date edate = sdf.parse(end);
			Calendar cal = Calendar.getInstance();
			cal.setTime(bdate);
			long time1 = cal.getTimeInMillis();
			cal.setTime(edate);
			long time2 = cal.getTimeInMillis();
			long between_days=(time2-time1)/(1000*3600*24);
			return Integer.parseInt(String.valueOf(between_days));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 获取指定日期，月份的最后一天
	 * @param date
	 * @param format
	 * @return
	 */
	public static String replaceDateFormat(String date, String format) {
		try {
			date = date.replaceAll("[_./]", "-");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new SimpleDateFormat(Y_M_D).parse(date));				       
			return getDateToString(calendar.getTime(), format);
		} catch (ParseException e) {
//			log.error("获取某格式的时间异常", e);
		}
		return null;
	}

	/**
	 * 获取指定日期，月份的最后一天
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getDateString(String date, String format) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new SimpleDateFormat(Y_M_D).parse(date));
			return getDateToString(calendar.getTime(), format);
		} catch (ParseException e) {
//			log.error("获取某格式的时间异常", e);
		}
		return null;
	}
	/**
	 * 日期转换成中文年月日
	 * @param date
	 * @return
	 */
	public static String convertDate(String date) {
		String newDate = "";
		String[] dates = new String[3];
		dates[0] = date.substring(0, 4);
		dates[1] = date.substring(5, 7);
		dates[2] = date.substring(8, date.length() - 1);
		for (int i = 0; i < dates.length; i++) {
			if (dates[i].startsWith("0")) {
				dates[i] = dates[i].substring(1, 2);
			}
			newDate += dates[i];
			if (i == 0) {
				newDate += "年";
			} else if (i == 1) {
				newDate += "月";
			} else {
				newDate += "日";
			}
		}
		return newDate;
	}
	
	/**
     * 判断某一时间是否在一个区间内
     * 
     * @param
     *            时间区间,半闭合,如[10:00-20:00)
     * @param curTime
     *            需要判断的时间 如10:00
     * @return 
     * @throws IllegalArgumentException
     */
    public static boolean isInTime(String sourceStartTime, String sourceEndTime, String curTime) {
        SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D);
        try {
            long now = sdf.parse(curTime).getTime();
            long start = sdf.parse(sourceStartTime).getTime();
            long end = sdf.parse(sourceEndTime).getTime();
            if (end < start) {
                if (now >= end && now <= start) {
                    return false;
                } else {
                    return true;
                }
            } 
            else {
                if (now >= start && now <= end) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

	public static int getMonthSpace(String date1, String date2) {
		date1 = date1.replaceAll("[_./]", "-");
		date2 = date2.replaceAll("[_./]", "-");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

		Calendar bef = Calendar.getInstance();
		Calendar aft = Calendar.getInstance();
		try {
			bef.setTime(sdf.parse(date1));
			aft.setTime(sdf.parse(date2));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
		int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
		return Math.abs(month + result);
	}

	/**
	 * 获取明天的凌晨12点时间戳
	 * @return
	 */
	public static String getTomorrowBegin() {
		long now = System.currentTimeMillis() / 1000l;
		long daySecond = 60 * 60 * 24;
		long dayTime = now - (now + 8 * 3600) % daySecond + 1*daySecond;
		String   format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String s = sdf.format(new Date(Long.valueOf(dayTime + "000")));
		return s;
	}

	/**
	 *
	 * @param date1 <String>
	 * @param date2 <String>
	 * @return int
	 * @throws ParseException
	 */
	public static int getInt(String date1, String date2)
			throws ParseException {

		int result = 0;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ss:ff:mm");

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(sdf.parse(date1));
		c2.setTime(sdf.parse(date2));

		result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

		return result == 0 ? 1 : Math.abs(result);

	}

}
