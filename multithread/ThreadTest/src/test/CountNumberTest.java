package test;

import java.util.Date;

import org.apache.log4j.Logger;

import junit.framework.TestCase;

import com.thread.test.Client1;
import com.thread.test.MoneyStorage;

public class CountNumberTest extends TestCase {
	
	
	/**
	 * 100W������19S
	 */
	Logger logger=Logger.getLogger(Client1.class);
	public void testCountNumberTest(){
		MoneyStorage ms=new MoneyStorage();
		Date startDate=new Date();
		logger.warn("��ʼ����Ϊ:"+startDate);
		while(ms.moneyNumber>0){
			System.out.println("Current Money is "+ms.moneyNumber);
			ms.moneyNumber--;
		}
		Date endDate=new Date();
		logger.warn("��������Ϊ:"+endDate);
		logger.warn("���ʱ��Ϊ:"+(endDate.getTime()-startDate.getTime())/1000);
	}
}
