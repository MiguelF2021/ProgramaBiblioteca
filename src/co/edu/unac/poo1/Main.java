package co.edu.unac.poo1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Map<String, Libro> libros = new HashMap<String, Libro>();
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        while (opcion == 0) {

                System.out.println("\nIngresa el número de la opción que elijas: \n"
                        + "1.- Agregar libro\n"
                        + "2.- Buscar libro\n"
                        + "3.- Prestar Libro\n"
                        + "4.- Devolver Libro\n"
                        + "5.- Salir");

                int opc = entrada.nextInt();
                switch (opc) {
                    case 1:
                        System.out.println("Ingrese los datos de libro que desea ingresar:");
                        System.out.println("Titulo:");
                        String titulo = entrada.next();
                        System.out.println("Autor:");
                        String autor = entrada.next();
                        System.out.println("ISBN:");
                        String ISBN = entrada.next();
                        System.out.println("Cantidad disponible:");
                        int canDisp = entrada.nextInt();
                        Libro LibroNuevo = new Libro(titulo, autor, ISBN, canDisp);
                        libros.put(titulo, LibroNuevo);
                        break;
                    case 2:
                        System.out.println("Ingrese el titulo del libro que desea buscar:");
                        String tituloBuscar = entrada.next();
                        try{
                            if(libros.containsKey(tituloBuscar) == true){
                                System.out.println("El libro si está en la biblioteca: " + "Titulo: " + libros.get(tituloBuscar).getTitulo() +
                                        "; Autor: " + libros.get(tituloBuscar).getAutor() + "; ISBN: " + libros.get(tituloBuscar).getISBN() + "; Cantidad disponible: " +
                                        libros.get(tituloBuscar).getUnidadesDisponibles());
                            } else {
                                throw new LibroExepciones(" El libro con el titulo " + tituloBuscar + " no está en la biblioteca. Intente con otro nombre. ");
                            }
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("Ingrese el titulo del libro que desea pedir prestado:");
                        String tituloPrestar = entrada.next();
                        System.out.println("Unidades disponibles: " + libros.get(tituloPrestar).getUnidadesDisponibles());
                        System.out.println("Ingrese el número de ejemplares del libro que desea pedir prestado:");
                        int numeroEjemplares = entrada.nextInt();

                        try {
                            if(libros.containsKey(tituloPrestar) == true && numeroEjemplares < libros.get(tituloPrestar).getUnidadesDisponibles()){
                                int cantidadResultante = libros.get(tituloPrestar).getUnidadesDisponibles();
                                libros.get(tituloPrestar).setUnidadesDisponibles(cantidadResultante - numeroEjemplares);
                                System.out.println("......... Prestamo autorizado .........");
                            } else {
                                throw new LibroExepciones("[Error]: No hay unidades disponibles para prestar.");
                            }
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println("Ingrese el titulo del libro que desea devolver:");
                        String tituloDevolver = entrada.next();
                        int unidadesDisponibles = libros.get(tituloDevolver).getUnidadesDisponibles();
                        System.out.println("Unidades disponibles: " + unidadesDisponibles);
                        System.out.println("Ingrese el número de ejemplares del libro que desea devolver:");
                        int librosDevolver = entrada.nextInt();
                        int cifraActualizada = libros.get(tituloDevolver).setUnidadesDisponibles(unidadesDisponibles + librosDevolver);
                        System.out.println("Cifra actualizada de unidades disponibles: " + cifraActualizada + "");
                        break;
                    case 5:
                        System.out.println("Gracias por utilizar nuestro sistema");
                        opcion = 1;
                        break;
                    default:
                        System.out.println("Opción invalida, intente nuevamente......");
                        break;
                }
            }
        }
    }


