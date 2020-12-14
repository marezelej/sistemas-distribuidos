package RMI;

import RMI.Domain.Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ClientService extends UnicastRemoteObject implements ClientServiceInterface {
    protected List<Client> clients = new ArrayList<Client>();

    protected ClientService() throws RemoteException {
    }

    @Override
    public Client getClient(int id) {
        return this.clients.get(id);
    }

    @Override
    public void addClient(Client client) {
        this.clients.add(client);
    }

    @Override
    public Client deleteClient(int id) {
        Client client = this.getClient(id);
        this.clients.remove(client);
        return client;
    }
}
