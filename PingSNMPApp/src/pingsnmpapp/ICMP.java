package pingsnmpapp;

import org.icmp4j.IcmpPingUtil;
import org.icmp4j.IcmpPingRequest;
import org.icmp4j.IcmpPingResponse;


public class ICMP {

    public static boolean ExecutePing (String serverAddress) throws Exception {
        boolean serverResponded = false;
        
        final IcmpPingRequest request = IcmpPingUtil.createIcmpPingRequest ();
        request.setHost (serverAddress);


        for (int count = 1; count <= 1; count ++) {

            final IcmpPingResponse response = IcmpPingUtil.executePingRequest (request);

            final String formattedResponse = IcmpPingUtil.formatResponse (response);
            System.out.println (formattedResponse);

            String[] splitStr = formattedResponse.split("\\s+");
            int valor = 0; 
            if(splitStr.length>5) {   
                //Quitamos los ms
                char[] cadenaEnChars = splitStr[4].toCharArray();             
                if(cadenaEnChars.length==8){
                    valor = Integer.parseInt(Character.toString(cadenaEnChars[5])); 
                }
                else{
                    valor = Integer.parseInt(Character.toString(cadenaEnChars[5])+ Character.toString(cadenaEnChars[6]));
                }
                return true;
            } 
            else {
                valor = 0; 
            }
            //Thread.sleep (1000);
        }

        return serverResponded;
    }
}
