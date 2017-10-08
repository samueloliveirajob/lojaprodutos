package integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class JunitTestExample {
	
	private ArrayList testList;
	
	            @BeforeClass
	            public static void onceExecutedBeforeAll() {
	                System.out.println("@BeforeClass: onceExecutedBeforeAll");
	            }

				@Before
	            public void executedBeforeEach() {
	                testList = new ArrayList();
	                System.out.println("@Before: executedBeforeEach");
	            }
	      
	            @Test
	            public void EmptyCollection() {
	                assertTrue(testList.isEmpty());
	                System.out.println("@Test: EmptyArrayList");
	            }
	          
	            @Test
	            public void OneItemCollection() {
	                testList.add("oneItem");
	                assertEquals(1, testList.size());
	                System.out.println("@Test: OneItemArrayList");
	
	            }


}
