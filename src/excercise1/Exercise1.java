package excercise1;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) throws Exception {
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
                System.out.println(SC.ReceiveMessage("M1"));
            } else if (!Input.equals("0")) {
                SC.SendMessage(Input, "M1");
            }
        }
    }
}
