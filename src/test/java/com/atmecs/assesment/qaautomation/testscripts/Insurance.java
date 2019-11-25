package com.atmecs.assesment.qaautomation.testscripts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.atmecs.assesment.qaautomation.dataproviders.ExcelWriteData;
import com.atmecs.assesment.qaautomation.utils.ConstantPaths;
import com.atmecs.assesment.qaautomation.utils.PageAction;

public class Insurance {
	String afteronemonth;
	String aftertendays;
	String beforeonemonth;
	public WebDriver driver;
	PageAction page = new PageAction(driver);
	
	@Test
	public void gettingDates() throws Exception {
		ExcelWriteData write=new ExcelWriteData(ConstantPaths.TESTDATA_FILE);


		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String systemDate = (dtf.format(now));
		System.out.println(systemDate);

		Calendar addonemonth = Calendar.getInstance();
		addonemonth.setTime(dateformat.parse(systemDate));
		afteronemonth = page.getdata_fromExcel("date", "days", "afteronemonth");
		int aftermonth = Integer.parseInt(afteronemonth);
		addonemonth.add(addonemonth.MONTH, aftermonth);
		String afteronemonth = dateformat.format(addonemonth.getTime());
		System.out.println("date after one month" + afteronemonth);
		write.setCellData("date", "resultdates", 2, afteronemonth);

		Calendar adddays = Calendar.getInstance();
		adddays.setTime(dateformat.parse(systemDate));
		aftertendays = page.getdata_fromExcel("date", "days", "aftertendays");
		int afterdays = Integer.parseInt(aftertendays);
		adddays.add(adddays.DATE, afterdays);
		String aftertendays = dateformat.format(adddays.getTime());
		System.out.println("date after 10 days" + aftertendays);
		write.setCellData("date", "resultdates", 3, aftertendays);

		Calendar subonemonth = Calendar.getInstance();
		subonemonth.setTime(dateformat.parse(systemDate));
		beforeonemonth = page.getdata_fromExcel("date", "days", "beforeonemonth");
		int beforemonth = Integer.parseInt(beforeonemonth);
		subonemonth.add(addonemonth.MONTH, beforemonth);
		String beforeonemonth = dateformat.format(subonemonth.getTime());
		System.out.println("date before one month" + beforeonemonth);
		write.setCellData("date", "resultdates", 4, beforeonemonth);

	}
}
