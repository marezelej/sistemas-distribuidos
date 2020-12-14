package excercise1;

import java.io.IOException;

public interface SystemCommunicationInterface {
    void SendMessage(String Message, String Process) throws Exception;

    void SendMultiCast(String Message, String GroupName) throws Exception;

    String ReceiveMessage(String ProcessName) throws Exception;
}
