import java.net.URLStreamHandlerFactory;
import java.security.Permission;
import java.security.PermissionCollection;

public class A {



	public Class<? extends URLStreamHandlerFactory> newPermissionCollection(Permission permission,
			URLStreamHandlerFactory factory) {
		PermissionCollection newPermissionCollection = permission.newPermissionCollection();
		if (newPermissionCollection.elements().hasMoreElements()) {
			return factory.getClass();
		}
		throw new RuntimeException();
	}



}
