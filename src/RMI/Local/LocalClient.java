package RMI.Local;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class LocalClient {

    public Object getRemoteObject(String url) {
        Object obj = null;
        try {
            obj = Naming.lookup(url);
            System.out.println("Búsqueda exitosa!");
        } catch (RemoteException e) {
            System.out.println("Error remoto: " + e);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return obj;
    }
}
