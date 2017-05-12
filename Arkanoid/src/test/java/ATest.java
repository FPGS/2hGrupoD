import java.io.IOException;
import java.net.URLStreamHandlerFactory;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ATest {
	A object;
	@Mock
	private URLStreamHandlerFactory factory;
	@Mock
	private Permission permission;
	@Mock
	private PermissionCollection permissionCollection;
	@Mock
	private Enumeration<Permission> enume;


	@Before
	public void setUp() throws Exception {
		object = new A();
	}

	@Test
	public void testGetUrlStreamHandler() throws IOException {
		Mockito.when(permission.newPermissionCollection()).thenReturn(permissionCollection);
		Mockito.when(permissionCollection.elements()).thenReturn(enume);
		Mockito.when(enume.hasMoreElements()).thenReturn(false);

		// Mockito.when(permissionCollection.elements().hasMoreElements()).thenReturn(true);

		//

		object.newPermissionCollection(permission, factory);
	}



}
