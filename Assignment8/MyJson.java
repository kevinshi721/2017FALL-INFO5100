package com.kevinshi721.Assignment8;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MyJson {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/kevinshi721/IdeaProjects/INFO5100/src/com/kevinshi721/Assignment8/Question3_camino.txt");
        ArrayList<Vehicle> vehicles = readAndGetVehicles(file);
        String s = getJsonString(vehicles);
        writeToFile(s, file.getParent());
    }

    private static ArrayList<Vehicle> readAndGetVehicles(File file) throws IOException {
        FileReader reader = new FileReader(file);
        Scanner sc = new Scanner(reader);
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String[] record;

        sc.nextLine();
        while (sc.hasNextLine()) {
            record = sc.nextLine().split("~");
            Vehicle vehicle = new Vehicle(record);
            vehicles.add(vehicle);
        }
        reader.close();

        return vehicles;
    }

    public static String getJsonString(ArrayList<Vehicle> vehicles) {
        String js = "{\n\"" + vehicles.get(0).webId + "\" : [\n";
        for (Vehicle vehicle : vehicles) {
            js += "{\n";
            js += "\"id\" : \"" + vehicle.id + "\"\n";
            js += "\"category\" : \"" + vehicle.category + "\"\n";
            js += "\"year\" : \"" + vehicle.year + "\"\n";
            js += "\"make\" : \"" + vehicle.make + "\"\n";
            js += "\"model\" : \"" + vehicle.model + "\"\n";
            js += "\"trim\" : \"" + vehicle.trim + "\"\n";
            js += "\"type\" : \"" + vehicle.type + "\"\n";
            js += "\"price\" : \"" + vehicle.price + "\"\n";
            js += "\"photo\" : \"" + vehicle.photo + "\"\n";
            js += "},\n";
        }
        js += "]\n}";

        return js;
    }

    public static void writeToFile(String inputToWrite, String filePath) throws IOException {
        File f = new File("/Users/kevinshi721/IdeaProjects/INFO5100/src/com/kevinshi721/Assignment8/Question3_output.txt");
        f.createNewFile();
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(inputToWrite);
        bw.close();
    }
}
