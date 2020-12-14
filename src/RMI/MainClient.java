package RMI;

import RMI.Domain.Client;
import RMI.Local.LocalClient;

public class MainClient {

    public static void main(String[] args) throws Exception {
        ClientServiceInterface service;
        LocalClient localClient = new LocalClient();
        String serverName = new String("127.0.0.1");
        String objectName = new String("ClientService");
        String url = "rmi://"+serverName+"/"+objectName;

        service = (ClientServiceInterface)localClient.getRemoteObject(url);

        try {
            Client client = new Client(0);
            service.addClient(client);
            System.out.println("First client was added");

            Client firstClient = service.getClient(0);
            System.out.println("First client id was "+firstClient.id);

            service.deleteClient(0);
            System.out.println("The client was deleted");
        } catch (Exception e) {
            System.out.println("ERROR: "+e);
        }
    }
}
