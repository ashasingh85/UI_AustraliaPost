package stepDefinitions;
import com.configuration.Browser;
import io.cucumber.java.After;

public class Hooks extends Browser {
	
	@After
	public void closeBrowser() {
		driver.close();
		
	}

}
