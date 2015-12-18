package untils;

/**
 * Created by w on 2015/12/15.
 */


    import java.net.*;
    import java.io.*;

    public class PubSub {
        public static void main(String[] args) {
            System.out.print("args.len"+args.length);
            String cmd = args[0] + "\r\n";

            try
            {
                Socket socket = new Socket("192.168.0.116", 6379);
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                out.write(cmd.getBytes());

                byte[] buffer = new byte[1024];
                while (true) {
                    int readCount = in.read(buffer);
                    System.out.write(buffer, 0, readCount);
                    System.out.println("--------------------------------------");
                }
            } catch (Exception e) {
            }
        }
    }

