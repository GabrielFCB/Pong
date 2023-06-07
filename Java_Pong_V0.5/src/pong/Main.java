package pong;

import java.util.Scanner;
import javax.swing.JFrame;

public class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        Jogo jogo;
        System.out.println("Digite 'a' para jogar contra bot e 'b' para jogar contra outra pessoa");
        String modo = sc.nextLine();

        switch (modo) {
            case "a":
                jogo = new JogoBot();
                break;

            case "b":
                jogo = new Jogo2Jogador();
                break;

            default:
                jogo = new JogoBot();
                break;
        }

        JFrame jframe = new JFrame(); // Utilizado para abrir uma janela com Java
        jframe.setVisible(true);
        jframe.requestFocus(); //Foca a tela quando é aberta
        jframe.add(jogo);
        jframe.pack();
        jframe.setLocationRelativeTo(null); // Cria a janela no centro da tela
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Fecha o programa se a janela for fechada
        //new Thread(jogo).start(); // Inicia a execucao da Thread em jogo
        sc.close();
    }
}