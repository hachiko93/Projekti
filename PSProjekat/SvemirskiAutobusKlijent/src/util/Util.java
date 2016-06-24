/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author student1
 */
public class Util {

    private Properties properties;
    private static Util instance;
    private List<String> numbers;

    private Util() throws FileNotFoundException, IOException {
        properties = new Properties();
        numbers = new LinkedList<>();
        properties.load(new FileInputStream("phone.properties"));
        ucitajSveBrojeve();
    }

    public static Util getInstance() throws IOException {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }

    public List<String> getPhoneNumber() {
        return numbers;
    }

    private void ucitajSveBrojeve() {
        Enumeration enuKeys = properties.keys();
        while (enuKeys.hasMoreElements()) {
            String key = (String) enuKeys.nextElement();
            numbers.add(key);
        }
    }

}
