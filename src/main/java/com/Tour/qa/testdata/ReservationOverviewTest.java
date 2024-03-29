package com.Tour.qa.testdata;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Tour.qa.base.TestBase;
import com.Tour.qa.pages.ChoosDatePage;
import com.Tour.qa.pages.ChoosTour;
import com.Tour.qa.pages.Confirm;
import com.Tour.qa.pages.CusgtomerPlan;
import com.Tour.qa.pages.EditReservationPage;
import com.Tour.qa.pages.ForgotPassword;
import com.Tour.qa.pages.HomePage;
import com.Tour.qa.pages.LoginPage;
import com.Tour.qa.pages.ModifyCancelPage;
import com.Tour.qa.pages.PaymentPage;
import com.Tour.qa.pages.PrintTicket;
import com.Tour.qa.pages.RegistrationPage;
import com.Tour.qa.pages.ResendConfPage;
import com.Tour.qa.pages.ReservationOverviewPage;

public class ReservationOverviewTest  extends TestBase{
	
	
	
/// this page is for review button from dashboard
	
	HomePage homePage;
	ChoosTour chooseTour;
	ChoosDatePage chooseDate;
	RegistrationPage RegisPage;
	Confirm confirmPage;
	LoginPage loginPage;
	ForgotPassword fgPage;
	CusgtomerPlan service;
	PaymentPage payment;
	PrintTicket print;
	ModifyCancelPage modifyCancel;
	ReservationOverviewPage reservation;
	ResendConfPage resend;
	EditReservationPage editres;
	
	
	 
	

	public ReservationOverviewTest(){
		super();
	}
	

	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		chooseTour = new ChoosTour();	
		chooseDate = new  ChoosDatePage();
		homePage = new HomePage();
		confirmPage = new Confirm();
		RegisPage = new RegistrationPage();
		loginPage = new LoginPage();
		fgPage = new ForgotPassword();
		service = new CusgtomerPlan();
		payment = new PaymentPage();
		print = new PrintTicket();
		modifyCancel = new ModifyCancelPage();
		reservation = new ReservationOverviewPage();
		resend = new ResendConfPage();
		editres = new EditReservationPage();
		
			
		
		homePage.CheckModifyCancel();
		loginPage.login(prop.getProperty("email"), prop.getProperty("pw"));
		
		 modifyCancel.CheckModifyButton(prop.getProperty("id"));
		 
				 
		 editres.CheckEditReservationForm();
		 driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
	
					
	}

	@Test(priority=1,description = "RESERVATION OVERVIEW page: Validate Modify Reservation button work as expected")
	public void validateeModifyButt(){
		
		boolean  flag =  reservation.validModifyButt();
		Assert.assertTrue(flag);
		
	}
	
	

	@Test(priority=3,description = "RESERVATION OVERVIEW page: Validate Special need section data displayed as per given data by user")
	public void checkSpecialNeed(){
		
		String sneed =  reservation.confirmSpecialNeed();
		Assert.assertEquals(sneed,"No","Special need option displayed updated"); // No are give on edit reservation page
		
		
	}
	
	
	@Test(priority=4,description = "RESERVATION OVERVIEW page: Validate  Group name display as per updated data given by user")
	public void validateGroupName(){
		
		String gname =  reservation.confirmGroupN();
		Assert.assertEquals(gname,"Happy kids","Group name dispalyed updated"); // happy kids are give on edit reservation page
		
		
	}

	
	@Test(priority=5,description = "RESERVATION OVERVIEW page: Validate  Page heading displayed as expected")
	public void validatePageH(){
		
		boolean  flag =  reservation.validPageH();
		Assert.assertTrue(flag);
		
		
	}
	
	
	@Test(priority=6,description = "RESERVATION OVERVIEW page: Validate  after clicking message should displayed 'confirmation has been send'")
	public void validateConfirmButt(){
		
		boolean  flag =  reservation.validconfirm();
		Assert.assertFalse(flag);
		
	
		
	}
	


	@Test(priority=7,description = "RESERVATION OVERVIEW page: Validate  cancel button should work as expected and reservation should be deleted from modify page")
	public void vaildateCancleButt(){
		
		boolean  flag =  reservation.validCancle(prop.getProperty("id"));
	
		Assert.assertFalse(flag);
		
		
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	


}
