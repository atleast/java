import java.net.*;
import java.io.*;

public class Client {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        
        Client client = new Client();
    }
    
    public Client(){
        
        try {
            System.out.println( "I am a network client, I am trying to connect a network server at port 9999..." );
            Socket s = new Socket("127.0.0.1",9999);
            
            PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
            
            pw.println( "Hello, I am a client, how are you?" );
            
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            
            System.out.println("I said hello to the server and the server responsed \"" + br.readLine() + "\" to me.");
            
        }
        catch ( UnknownHostException e ) {
 
            e.printStackTrace();
        }
        catch ( IOException e ) {

            e.printStackTrace();
        }
        
        
    }

}
