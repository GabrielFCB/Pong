package pong;


class Entry implements Comparable<Entry> {
    private String nome;
    private int numero;

    public Entry(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public String getEntrada(){
        return (nome+": "+numero);
    }

    public int compareTo(Entry other) {
        // Ordenar em ordem decrescente com base no número
        return Integer.compare(other.numero, this.numero);
    }

    @Override
    public String toString() {
        return "Entry [nome=" + nome + ", numero=" + numero + "]";
    }

}