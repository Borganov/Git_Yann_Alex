package JUnitTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import contact.Contact;

public class FrameContactAddTest {

	@Test
	public void testContactControl() throws IOException {
		
		Contact ab = new Contact("Alexandre", "Berclaz", "12");
		Contact yc = new Contact("Yann", "Clavien", "182");
		
		Contact test = new Contact("Alexandre", "Berclaz", "12");
		
		boolean reponse = false;
		
		
		ArrayList<Contact> testList= new ArrayList<Contact>();
		testList.add(ab);
		testList.add(yc);
		
		boolean original =test.contactControl(testList);
		
		if(original!=reponse)
		fail("Méthode contactControl fausse");
	}

}
