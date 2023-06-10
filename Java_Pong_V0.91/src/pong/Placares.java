package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import java.awt.FontMetrics;
import java.util.Collections;

public class Placares extends Tela {
    public static List<Entry> lista;

    public Placares(){
        lista=new ArrayList<>();
    }

    public void run(Graphics g, BufferStrategy bs) { // Metodo do FPS do jogo
        try {
            this.desenhar(g, bs);
            this.atualizar();
            Thread.sleep(1); // Velocidade que o jogo atualiza o frame

        } catch (InterruptedException e) { // Excecao para caso a thread seja interrompida
            e.printStackTrace();// Rastreia o momento que a excecao ocorreu
        }
    }

    public void desenhar(Graphics g, BufferStrategy bs) {
        g.setColor(new Color(0, 0, 0)); // Escolhe a cor
        g.fillRect(0, 0, largura, altura); // X e y de onde começa e o tamanho

        g.setColor(new Color(255, 255, 255)); // Define a cor do texto
        g.setFont(new Font("Arial", Font.BOLD, 30)); // Define a fonte e o tamanho do texto
        FontMetrics fm = g.getFontMetrics();

        int x = (largura - fm.stringWidth("AAA : 1000")) / 2; // Calcula a posição x centralizada
        int y = (altura - (fm.getHeight() * lista.size())) / 2; // Calcula a posição y centralizada

        for (int i = 0; i < lista.size(); i++) {
            String pontuacao = lista.get(i).getNome()+": "+lista.get(i).getNumero();
            String textoPontuacao = (i + 1) + ". " + pontuacao;
            g.drawString(textoPontuacao, x, 20+y + (i * fm.getHeight()));
        }

        bs.show(); // Mostra o gráfico no buffer

    }

    public void atualizar() {

    }

    public static void adicionarLista(List<Entry> lista, String nome, int numero){
        Entry entry = new Entry(nome, numero);
        lista.add(entry);
        Collections.sort(lista);

        // Remover o 11° elemento se a lista tiver mais de 10 elementos
        if (lista.size() > 10) {
            lista.remove(10);
        }
    }
}
