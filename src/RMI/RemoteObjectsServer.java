package RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class RemoteObjectsServer {

    public void activeObjects() {
        try {
            ClientService service = new ClientService();

            Naming.rebind("ClientService", service);
            System.out.println("Servidor de clientes activado");
        } catch (Exception e) {
            System.out.println("\n ERROR: "+e);
        }
    }
}
