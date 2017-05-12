import java.security.Permission;
import java.security.PermissionCollection;

public class A {



	public boolean newPermissionCollection(Permission permission) {

		PermissionCollection newPermissionCollection = permission.newPermissionCollection();

		if (newPermissionCollection.elements().hasMoreElements()) {
			return true;
		} else {
			throw new RuntimeException();
		}
	}



}
