package gr.boot;

import static org.junit.Assert.*;

import org.junit.Test;

import gr.boot.controller.HomeController;

public class AppTest{
    
	@Test
    public void testApp()
    {
		HomeController hc = new HomeController();
		String result = hc.home();
        assertEquals( result, "Hello Man" );
    }
}
