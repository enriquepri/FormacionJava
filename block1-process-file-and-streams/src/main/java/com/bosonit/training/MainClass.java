package com.bosonit.training;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) {
        /*if(args.length != 1){
            System.out.println("Error en los argumentos");
            return;
        }*/

        System.out.println(args.length);

        List<Person> listaPersonas = new ArrayList<>();

        try {
            listaPersonas = leerPersonas("temp");
        } catch (Exception e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }

        //listaPersonas = filtrarPersonas(2, listaPersonas);

        if(listaPersonas.isEmpty()){
            System.out.println("La lista esta vacia");
            return;
        }

        for (Person persona : listaPersonas) {
            System.out.println(persona.toString());
        }
    }

    private static List<Person> leerPersonas(String fname) throws Exception{
        List<Person> listaPersonas = new ArrayList<>();

        //String filePath = "C:\\Projects\\java\\formacion\\FormacionJava\\block1-process-file-and-streams\\src\\main\\resources\\";
        String filePath = "src/main/resources/ejemplo.csv";
        //filePath = filePath.concat(fname);

        if(!archivoExiste(filePath)){
            throw new Exception("El archivo no existe");
        }

        List<String> listaTemp = leerArchivo(Paths.get(filePath));

        int i = 1;
        for(String s : listaTemp){
            String[] temp = s.split(":", -1);
            System.out.println(s);
            System.out.println("Longitud: " + temp.length);
            if(temp.length != 3){
                String nombre;
                switch (temp.length){
                    case 1:
                        nombre = temp[0];
                        temp = new String[3];
                        temp[0] = nombre;
                        temp[1] = "unknown";
                        temp[2] = "0";
                        break;
                    case 2:
                        nombre = temp[0];
                        String town = temp[1];
                        temp = new String[3];
                        temp[0] = nombre;
                        temp[1] = town;
                        temp[2] = "0";
                        break;
                    default:
                        throw new InvalidLineFormatException("Linea mal formateada en la linea " + i);
                }
            }
            listaPersonas.add(new Person.personBuilder(temp).build());
            i++;
        }

        return listaPersonas;
    }

    private static List<Person> filtrarPersonas(int filtro, List<Person> listaPersonas){
        List<Person> listaFiltrada = new ArrayList<>();
        Stream<Person> stream = listaPersonas.stream();

        switch (filtro){
            case 1:
                listaFiltrada = stream.filter(p -> p.age < 25).toList();
                break;
            case 2:
                listaFiltrada = stream.filter(p -> p.getName().charAt(0) != 'A').toList();
                break;
            case 3:
                Person temp = stream.filter(p -> p.getTown().equals("Madrid")).findFirst().orElse(null);
                if(temp != null){
                    listaFiltrada.add(temp);
                }
                break;
            case 4:
                Person temp2 = stream.filter(p -> p.getTown().equals("Barcelona")).findFirst().orElse(null);
                if(temp2 != null){
                    listaFiltrada.add(temp2);
                }
                break;
            default:
                break;
        }

        return listaFiltrada;
    }

    private static Boolean archivoExiste(String fname){
        Path archivo = Paths.get(fname);
        if(Files.exists(archivo)){
            System.out.println("El archivo existe");
            return true;
        }else{
            System.out.println("El archivo no existe");
            return false;
        }
    }

    private static List<String> leerArchivo(Path archivo){
        List<String> todasLineas;
        try {
            todasLineas = Files.readAllLines(archivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //todasLineas.forEach(System.out::println);
        return todasLineas;
    }
}
