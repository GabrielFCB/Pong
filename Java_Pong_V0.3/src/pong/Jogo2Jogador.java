package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

public class Jogo2Jogador extends Jogo {
    public static Jogador jogador2 = new Jogador(largura - 15 - jogador1.larguraJogador, 165);
    public Bola bola = new Bola((largura - Bola.larguraBola) / 2, (altura - Bola.alturaBola) / 2, true);

    public void run() { // Metodo do FPS do jogo
        try {
            while (true) {
                this.desenhar();
                this.atualizar();
                Thread.sleep(1000 / 30); // Velocidade que o jogo atualiza o frame
            }
        } catch (InterruptedException e) { // Excecao para caso a thread seja interrompida
            e.printStackTrace();// Rastreia o momento que a excecao ocorreu
        }
    }

    public void desenhar() {
        BufferStrategy bs = this.getBufferStrategy(); // Metodo utilizado para renderizar animacoes
        if (bs == null) {
            this.createBufferStrategy(2); // Usado pra n ficar piscando
            return;
        }
        Graphics g = bs.getDrawGraphics(); // Permitira o uso de graficos pelo buffer
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
            jogador2 = new Jogador(largura - 15 - jogador1.larguraJogador, 165);
            bola = new Bola((largura - Bola.larguraBola) / 2, (altura - Bola.alturaBola) / 2, true);
        }
        if (bola.pontoJogador2) {
            placar.jogador2 += 1;
            jogador1 = new Jogador(15, 165);
            jogador2 = new Jogador(largura - 15 - jogador1.larguraJogador, 165);
            bola = new Bola((largura - Bola.larguraBola) / 2, (altura - Bola.alturaBola) / 2, true);
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
