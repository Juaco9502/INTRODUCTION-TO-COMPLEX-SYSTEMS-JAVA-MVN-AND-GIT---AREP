package edu.escuelaing.arep.tarea1.fileReader;

import edu.escuelaing.arep.tarea1.linkedList.LinkedListGeneric;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * class that receives a data.txt file and converts it into a linkedList
 * according to business logic
 * 
 * @author Juan.Ortiz
 */
public class FileReader {

    private final List<Double> listProxySize;
    private final List<Double> listDevHours;
    private final Charset charset;

    public FileReader() {
        this.listProxySize = new LinkedListGeneric<>();
        this.listDevHours = new LinkedListGeneric<>();
        this.charset = Charset.forName("UTF-8");
    }

    /**
     * receives a data.txt file and converts it into a two linkedList
     * 
     * @author Juan.Ortiz
     * @param file - file data.txt
     * @throws java.lang.Exception
     */
    public void getNumbers(Path file) throws Exception {
        try {
            BufferedReader BR = Files.newBufferedReader(file, this.charset);
            String linea = BR.readLine();
            while (linea != null) {
                String[] tmp = linea.split(" ");
                this.listProxySize.add(Double.parseDouble(tmp[0]));
                this.listDevHours.add(Double.parseDouble(tmp[1]));
                linea = BR.readLine();
            }
        } catch (IOException ex) {
            throw new Exception("Error leyendo el archivo, revise la ruta");
        }
    }

    /**
     * get Proxy Size LinkedList
     *
     * @author Juan.Ortiz
     * @return the Proxy Size LinkedList
     */
    public List<Double> getListProxySize() {
        return listProxySize;
    }

    /**
     * get Developer Hours LinkedList
     *
     * @author Juan.Ortiz
     * @return the Developer Hours  LinkedList
     */
    public List<Double> getListDevHours() {
        return listDevHours;
    }

}
