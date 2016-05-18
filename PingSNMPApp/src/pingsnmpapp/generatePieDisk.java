package pingsnmpapp;


import SNMP.classSNMP;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import utilities.claseDisco;


public class generatePieDisk {

    
    public static void WritePieDiskToJPG(String disco, String ipAddress) throws IOException {
        
        
        
        int alto = 500; 
        int ancho = 800; 
       
            
        classSNMP objectSNMP= new classSNMP(); 
        claseDisco objectDisk = new claseDisco(""); 
        objectDisk = objectSNMP.consulta(ipAddress, disco); 
            
         classPieGraph constructorGrafica = new classPieGraph();    
         JFreeChart chart = constructorGrafica.createChart(constructorGrafica.createDataset(objectDisk)); 
        
        
         String path = "pieDiskJPGs\\" + disco + "_" + ipAddress + ".jpg";
        ChartUtilities.saveChartAsJPEG(new File(path), chart, ancho, alto);
         
    }
    

}
