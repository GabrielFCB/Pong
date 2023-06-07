package pong;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public abstract class Jogo extends Tela implements KeyListener { // Classe utilizada para desenhar o jogo
    public static Jogador jogador1 = new Jogador(15, 165);
    public Placar placar = new Placar();

    public Jogo() {
        this.setPreferredSize(new Dimension(largura, altura)); // Determina as dimensões do jogo
        this.addKeyListener(this);
    }

    public void run(Graphics g, BufferStrategy bs) { // Metodo do FPS do jogo
        try {
            while (true) {
                this.desenhar(g, bs);
                this.atualizar();
                Thread.sleep(1000 / 30); // Velocidade que o jogo atualiza o frame
            }
        } catch (InterruptedException e) { // Excecao para caso a thread seja interrompida
            e.printStackTrace();// Rastreia o momento que a excecao ocorreu
        }
    }

    public void keyTyped(KeyEvent e) { // Método desnecessário
        
    }

    public void keyPressed(KeyEvent e) { // O que fazer se a tecla for apertada
        if (e.getKeyCode() == KeyEvent.VK_W) {
            jogador1.up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            jogador1.down = true;
        }
    }

    public void keyReleased(KeyEvent e) { // O que fazer se a tecla for solta
        if (e.getKeyCode() == KeyEvent.VK_W) {
            jogador1.up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            jogador1.down = false;
        }
    }

}
