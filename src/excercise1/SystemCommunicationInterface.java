package excercise1;

import java.io.IOException;

public interface SystemCommunicationInterface {
    void SendMessage(String Message) throws IOException;

    String ReceiveMessage() throws IOException;
}
