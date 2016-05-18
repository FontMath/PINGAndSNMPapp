/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingsnmpapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mailsender.SendMailTLS;

/**
 *
 * @author gmathus
 */
public class PingSNMPApp {

    /**
     * @param args the command line arguments
     */
    private static ArrayList<String> unAvailableHosts;
    private static ArrayList<String> availableHosts;

    public static void main(String[] args) {
        unAvailableHosts = new ArrayList<>();
        availableHosts = new ArrayList<>();
        ExecutePingRequests();
        SendEmailWithUnavailableDevices();
        CreateSNMPPieCharts();
        System.out.println("DONE!");
    }

    private static void ExecutePingRequests() {
        for (int i = 1; i < 255; i++) {
            try {
                if (ICMP.ExecutePing("172.25.150." + i) == false) {
                    unAvailableHosts.add("172.25.150." + i);
                } else {
                    availableHosts.add("172.25.150." + i);
                }
            } catch (Exception e) {
                unAvailableHosts.add("172.25.150." + i);
            }

        }

    }

    private static void SendEmailWithUnavailableDevices() {
        SendMailTLS.SendEmail("gerardo.mathus@me.com", unAvailableHosts);
    }

    private static void CreateSNMPPieCharts() {
        for (String host : availableHosts) {
            for (int i = 1; i <= 3; i++) {
                try {
                    generatePieDisk.WritePieDiskToJPG(Integer.toString(i), host);
                } catch (IOException ex) {
                    Logger.getLogger(PingSNMPApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
