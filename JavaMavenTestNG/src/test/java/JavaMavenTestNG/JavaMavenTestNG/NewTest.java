package JavaMavenTestNG.JavaMavenTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class NewTest {
  @Test
  public void test1() {
	  System.out.println("test1");
  }
  
  @Test
  public void test2() {
	  System.out.println("test2");
  }
  
  @Test
  public void test3() {
	  System.out.println("test3");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforeMethod");
  }
  
  @AfterMethod
  public void afterMethod() {
	  System.out.println("afterMethod");
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("after class");
  }

}
