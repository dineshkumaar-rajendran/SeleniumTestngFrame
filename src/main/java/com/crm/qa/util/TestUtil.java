package com.crm.qa.util;

import com.crm.qa.base.BaseClass;

public class TestUtil extends BaseClass {

	public static long page_load_timeout = 20;
	public static long implicit_wait = 60;

	public void SwitchtoFrame() {
		driver.switchTo().frame("mainpanel");
	}

}
