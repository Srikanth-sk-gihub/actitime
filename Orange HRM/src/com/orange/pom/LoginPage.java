package com.orange.pom;

import java.net.http.WebSocket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orange.genric.BaseClass;

public class LoginPage extends BaseClass 
{
	@FindBy(name = "username")
	private WebElement userNameTbx;
	@FindBy(name = "password")
	private WebElement paswTbx;
	@FindBy(xpath = "//button[text()=' Login ']")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void setLogin(String un,String pwd)
	{
		userNameTbx.sendKeys(un);
		paswTbx.sendKeys(pwd);
		loginBtn.click();	
	}

}
