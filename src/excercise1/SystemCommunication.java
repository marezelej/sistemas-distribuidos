package excercise1;

import java.io.IOException;
import java.net.*;
import java.util.LinkedList;
import java.util.List;

public class SystemCommunication implements SystemCommunicationInterface {

    public List<Process> Processes;

    public List<Group> Groups;


    public SystemCommunication() throws UnknownHostException {
        Processes = new LinkedList<Process>();
        Groups = new LinkedList<Group>();
    }

    @Override
    public void SendMessage(String Message, String ProcessName) throws Exception {
        this.SendMessage(Message, this.getProcess(ProcessName));
    }

    @Override
    public String ReceiveMessage(String ProcessName) throws Exception {
        return ReceiveMessage(getProcess(ProcessName));
    }

    public void SendMultiCast(String Message, String GroupName) throws Exception
    {
        this.SendMessage(Message, this.getGroup(GroupName));
    }

    protected Process getProcess(String Name) throws Exception {
        Process Process = Processes.stream().filter((Process p) -> Name.equals(p.name)).findAny().orElse(null);
        if (Process != null) {
            return Process;
        } else {
            throw new Exception("Process not found");
        }
    }

    protected Group getGroup(String Name) throws Exception {
        Group Group = Groups.stream().filter((Group p) -> Name.equals(p.name)).findAny().orElse(null);
        if (Group != null) {
            return Group;
        } else {
            throw new Exception("Process not found");
        }
    }

    protected void SendMessage(String Message, Process Process) throws IOException {
        DatagramSocket Socket = new DatagramSocket();
        DatagramPacket Packet = new DatagramPacket(Message.getBytes(), Message.length(), Process.IP, Process.Port);
        Socket.send(Packet);
        Socket.close();
    }

    protected void SendMessage(String Message, Group Group) throws IOException {
        try{
            for (Process Process : Group.Processes) {
                this.SendMessage(Message, Process);
            }
            for (Process Process : Group.Processes) {
                this.SendMessage("ACCEPT", Process);
            }
        } catch (IOException e) {
            for (Process Process : Group.Processes) {
                this.SendMessage("DISMISS", Process);
            }
        }
    }

    protected String ReceiveMessage(Process Process) throws IOException {
        DatagramSocket Socket = new DatagramSocket(Process.Port);
        byte[] Buffer = new byte[1024];
        DatagramPacket Packet = new DatagramPacket(Buffer, 1024);
        Socket.receive(Packet);
        String Message = new String(Packet.getData(), 0, Packet.getLength());
        Socket.close();
        return Message;
    }
}
