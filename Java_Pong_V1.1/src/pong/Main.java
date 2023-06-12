package pong;

public class Main {
    public static void main(String args[]) throws Exception {
        TelaInicial jogo=new TelaInicial();
        new Thread(jogo).start(); // Inicia a execucao da Thread em jogo
    }
}