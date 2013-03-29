package test;

import java.util.Date;

import org.apache.log4j.Logger;

import junit.framework.TestCase;

import com.thread.test.Client1;
import com.thread.test.MoneyStorage;

public class CountNumberTest extends TestCase {
	
	
	/**
	 * 100W条数据19S
	 */
	Logger logger=Logger.getLogger(Client1.class);
	public void testCountNumberTest(){
		MoneyStorage ms=new MoneyStorage();
		Date startDate=new Date();
		logger.warn("开始日期为:"+startDate);
		while(ms.moneyNumber>0){
			System.out.println("Current Money is "+ms.moneyNumber);
			ms.moneyNumber--;
		}
		Date endDate=new Date();
		logger.warn("结束日期为:"+endDate);
		logger.warn("相隔时间为:"+(endDate.getTime()-startDate.getTime())/1000);
	}
}
