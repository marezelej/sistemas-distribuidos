package RMI;

import RMI.Domain.Client;

public interface ClientServiceInterface {

    /**
     * Get client by ID
     * @param id ID of the client
     * @return The client
     */
    public Client getClient(int id);

    /**
     * Add a new client
     * @param client The client
     */
    public void addClient(Client client);

    /**
     * Delete an existing client by ID
     * @param id ID of the client
     * @return The client
     */
    public Client deleteClient(int id);
}
