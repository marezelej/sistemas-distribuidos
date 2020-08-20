package excercise1;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        String Input = "";
        System.out.println("Ingrese 0 para salir");
        SystemCommunication SC = new SystemCommunication();
        while (!Input.equals("0"))
        {
            System.out.println("Ingrese un mensaje o '1' para recibir un mensaje");
            Input = s.nextLine();
            if (Input.equals("1")) {
                System.out.println("Esperando mensaje...");
                System.out.println(SC.ReceiveMessage());
            } else if (!Input.equals("0")) {
                SC.SendMessage(Input);
            }
        }
    }
}
