/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingsnmpapp;

import utilities.claseDisco;
import java.awt.Font;
import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;



/**
 *
 * @author Nataniel
 */
public class classPieGraph {
    
    public JFreeChart createChart(PieDataset dataset) {
        
        JFreeChart chart = ChartFactory.createPieChart(
            "Gráfica de Disco",  // chart title
            dataset,             // data
            true,               // include legend
            true,
            false
        );

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;
        
    }
    
    public PieDataset createDataset(claseDisco disco) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Memoria libre = " + (disco.tamañoDeDisco - disco.memoriaUsada) + " Gb", disco.tamañoDeDisco - disco.memoriaUsada );
        dataset.setValue("Memoria en uso = " + disco.memoriaUsada + " Gb", disco.memoriaUsada);
        dataset.setValue("Memoria total = " + disco.tamañoDeDisco + " Gb", disco.tamañoDeDisco );
        
        return dataset;        
    }
    
    
    
    
}
