
package SNMP;

import java.util.ArrayList;
import snmpup.SNMP4JHelper;
import utilities.claseDisco;

public class classSNMP {
    
    public claseDisco consulta(String ipAddress, String numeroDeDiscoString){
        
            int numeroDeDisco = Integer.parseInt(numeroDeDiscoString); 
            
            if(numeroDeDisco<1){
                return null; 
            }
            System.out.println(ipAddress);
            String Comunidad="clases";
            String OIDInicial="1.3.6.1.2.1.25.2.3.1";
            claseDisco objectDisk = new claseDisco(""); 
            String OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OIDInicial);            
            int k=1,iteracion;
            //Se repetirá el ciclo hasta que ya no se obtengan más datos. 
            String tempString; 
            
            
            while(OID.contains(OIDInicial))
            {
                if(OID.contains(OIDInicial+".1")) 
                {                               
                    iteracion = 1;
                    while(OID.contains(OIDInicial+".1"))
                    {
                    	if(iteracion ==numeroDeDisco)
                    	{
	                        tempString = SNMP4JHelper.snmpGet(ipAddress,Comunidad, OID);
	                        objectDisk.indice = tempString; 
	                        OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);	                        	                        

                    	}
                    	else{
                    		//Solo se incrementa el OID
                    		OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);

                    	}
                    	iteracion++;
                    }

                }
                if(OID.contains(OIDInicial+".2")) 
                {                               
                    iteracion = 1;
                    while(OID.contains(OIDInicial+".2"))
                    {
                    	if(iteracion ==numeroDeDisco)
                    	{
	                        tempString = SNMP4JHelper.snmpGet(ipAddress,Comunidad, OID);
	                        objectDisk.tipo = tempString; 
	                        OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);	                        	                        

                    	}
                    	else{
                    		//Solo se incrementa el OID
                    		OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);

                    	}
                    	iteracion++;
                    }

                }
                if(OID.contains(OIDInicial+".3")) 
                {                               
                    iteracion = 1;
                    while(OID.contains(OIDInicial+".3"))
                    {
                    	if(iteracion ==numeroDeDisco)
                    	{
	                        tempString = SNMP4JHelper.snmpGet(ipAddress,Comunidad, OID);
	                        objectDisk.descripcion = tempString; 
	                        OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);	                        	                        

                    	}
                    	else{
                    		//Solo se incrementa el OID
                    		OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);

                    	}
                    	iteracion++;
                    }

                }
                if(OID.contains(OIDInicial+".4")) 
                {                               
                    iteracion = 1;
                    while(OID.contains(OIDInicial+".4"))
                    {
                    	if(iteracion ==numeroDeDisco)
                    	{
	                        tempString = SNMP4JHelper.snmpGet(ipAddress,Comunidad, OID);
	                        objectDisk.unidades = Long.parseLong(tempString); 
	                        OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);	                        	                        

                    	}
                    	else{
                    		//Solo se incrementa el OID
                    		OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);

                    	}
                    	iteracion++;
                    }

                }
                if(OID.contains(OIDInicial+".5")) 
                {                               
                    iteracion = 1;
                    while(OID.contains(OIDInicial+".5"))
                    {
                    	if(iteracion ==numeroDeDisco)
                    	{
	                        tempString = SNMP4JHelper.snmpGet(ipAddress,Comunidad, OID);
	                        objectDisk.tamañoDeDisco = Long.parseLong(tempString); 
	                        OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);	                        	                        

                    	}
                    	else{
                    		//Solo se incrementa el OID
                    		OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);

                    	}
                    	iteracion++;
                    }

                }   
                
                if(OID.contains(OIDInicial+".6")) 
                {                               
                    iteracion = 1;
                    while(OID.contains(OIDInicial+".6"))
                    {
                    	if(iteracion ==numeroDeDisco)
                    	{
	                        tempString = SNMP4JHelper.snmpGet(ipAddress,Comunidad, OID);
	                        objectDisk.memoriaUsada = Long.parseLong(tempString); 
	                        OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);	                        	                        

                    	}
                    	else{
                    		//Solo se incrementa el OID
                    		OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);

                    	}
                    	iteracion++;
                    }

                }
                
                if(OID.contains(OIDInicial+".7")) 
                {                               
                    iteracion = 1;
                    while(OID.contains(OIDInicial+".7"))
                    {
                    	if(iteracion ==numeroDeDisco)
                    	{
	                        tempString = SNMP4JHelper.snmpGet(ipAddress,Comunidad, OID);
	                        objectDisk.fallosDeDisco = Long.parseLong(tempString); 
	                        OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);	                        	                        

                    	}
                    	else{
                    		//Solo se incrementa el OID
                    		OID=SNMP4JHelper.snmpGetNextOID(ipAddress,Comunidad,OID);

                    	}
                    	iteracion++;
                    }

                }
                                   
    }
            objectDisk.tamañoDeDisco = objectDisk.tamañoDeDisco*objectDisk.unidades/1024/1024/1024;            
            objectDisk.memoriaUsada = objectDisk.memoriaUsada * objectDisk.unidades/1024/1024/1024;             
                
            return objectDisk; 
}
}
    

    

