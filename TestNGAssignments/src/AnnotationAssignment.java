import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnnotationAssignment {
	@BeforeClass
	@AfterClass
	public void startCar() {
		System.out.println("Get in to car & start the engine");

	}

	@Test(priority = 1)
	public void searchRoute() {
		System.out.println("Navigate to Cineplex");
	}
	@Test(priority = 2)
	public void stopCar() {
		System.out.println("Stop the engine & get out");

	}

	@Test(priority = 3)
	public void purchaseTicket() {
		System.out.println("Purchase Ticket");
		Assert.fail();
	}

	@Test(priority = 4, dependsOnMethods = "purchaseTicket")
	public void watchMovie() {
		System.out.println("Watch Movie");
	}

}
