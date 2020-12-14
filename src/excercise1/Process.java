package excercise1;

import java.net.Inet4Address;
import java.net.UnknownHostException;

public class Process {
    public String name;
    public Inet4Address IP;
    public Integer Port;

    public Process(String name, String IP, Integer port) throws UnknownHostException {
        this.name = name;
        this.IP = (Inet4Address) Inet4Address.getByName("127.0.0.1");;
        Port = port;
    }
}
