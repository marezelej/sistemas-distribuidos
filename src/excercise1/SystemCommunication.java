package excercise1;

import java.io.IOException;
import java.net.*;

public class SystemCommunication implements SystemCommunicationInterface {

    protected Inet4Address IP = (Inet4Address) Inet4Address.getByName("127.0.0.1");

    protected Integer Port = 3000;


    public SystemCommunication() throws UnknownHostException, SocketException {
    }

    @Override
    public void SendMessage(String Message) throws IOException {
        DatagramSocket Socket = new DatagramSocket();
        DatagramPacket Packet = new DatagramPacket(Message.getBytes(), Message.length(), this.IP, this.Port);
        Socket.send(Packet);
        Socket.close();
    }

    @Override
    public String ReceiveMessage() throws IOException {
        DatagramSocket Socket = new DatagramSocket(this.Port);
        byte[] Buffer = new byte[1024];
        DatagramPacket Packet = new DatagramPacket(Buffer, 1024);
        Socket.receive(Packet);
        String Message = new String(Packet.getData(), 0, Packet.getLength());
        Socket.close();
        return Message;
    }
}
