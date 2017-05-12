import java.io.IOException;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ATest {

	A object = new A();

	@Mock
	Permission permission;
	@Mock
	PermissionCollection collection;
	@Mock
	Enumeration<Permission> elements;

	@Test
	public void testGetUrlStreamHandler() throws IOException {
		
		Mockito.when(permission.newPermissionCollection()).thenReturn(collection);
		Mockito.when(collection.elements()).thenReturn(elements);
		Mockito.when(elements.hasMoreElements()).thenReturn(true);
		object.newPermissionCollection(permission);
	}



}
