package co.edu.unac.poo1;

public class Libro {

    private String titulo, autor, ISBN;
    private int unidadesDisponibles;

    public Libro() {
    }

    public Libro(String titulo, String autor, String ISNB, int unidadesDisponibles) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISNB;
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }

    public void setAutor(String autor) { this.autor = autor; }

    public String getISBN() { return ISBN; }

    public void setISBN(String ISBN) { this.ISBN = ISBN; }

    public int getUnidadesDisponibles() { return unidadesDisponibles; }

    public int setUnidadesDisponibles(int unidadesDisponibles) { this.unidadesDisponibles = unidadesDisponibles;
        return unidadesDisponibles;
    }


}
