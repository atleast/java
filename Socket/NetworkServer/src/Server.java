
import java.net.*;
import java.io.*;

public class Server {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        Server server = new Server();

    }
    
    public Server(){
        try {
            ServerSocket ss = new ServerSocket(9999);
            
            System.out.println("I am a network server, I am listening at port 9999");
            
            Socket s = ss.accept();
            
            System.out.println("I was connected by a client...");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            
            System.out.println("It said \"" + br.readLine() + "\"to me.");
            
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            
            pw.println( "Hello, I am a server, I am fine, and you?" );
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        
    }

}
