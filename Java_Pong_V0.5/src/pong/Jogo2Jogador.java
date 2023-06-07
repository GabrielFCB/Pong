package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

public class Jogo2Jogador extends Jogo {
    public static Jogador jogador2 = new Jogador(largura - 15 - jogador1.largura, 165);
    public Bola bola = new Bola(true);

    public void desenhar(Graphics g, BufferStrategy bs) {
        g.setColor(new Color(0, 0, 0)); // Escolhe a cor
        g.fillRect(0, 0, largura, altura); // X e y de onde começa e o tamanho
        bola.desenhar(g);
        jogador1.desenhar(g);
        jogador2.desenhar(g);
        placar.desenhar(g);
        bs.show(); // Mostra o grafico no buffer
    }

    public void atualizar() {
        bola.atualizar();
        jogador1.atualizar();
        jogador2.atualizar();
        if (bola.pontoJogador1) {
            placar.jogador1 += 1;
            jogador1 = new Jogador(15, 165);
            jogador2 = new Jogador(largura - 15 - jogador1.largura, 165);
            bola = new Bola(true);
        }
        if (bola.pontoJogador2) {
            placar.jogador2 += 1;
            jogador1 = new Jogador(15, 165);
            jogador2 = new Jogador(largura - 15 - jogador1.largura, 165);
            bola = new Bola(true);
        }
    }

    public void keyPressed(KeyEvent e) { // O que fazer se a tecla for apertada
        super.keyPressed(e);
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            jogador2.up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            jogador2.down = true;
        }
    }

    public void keyReleased(KeyEvent e) { // O que fazer se a tecla for solta
        super.keyReleased(e);
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            jogador2.up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            jogador2.down = false;
        }
    }

}
