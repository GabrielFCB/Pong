package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class JogoBot extends Jogo {
    public static Bot bot = new Bot(largura - 15 - jogador1.largura, 165);
    public static Bola bola = new Bola(false);

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
        bot.desenhar(g);
        placar.desenhar(g);
        bs.show(); // Mostra o grafico no buffer
    }

    public void atualizar() {
        bola.atualizar();
        jogador1.atualizar();
        bot.atualizar();
        if (bola.pontoJogador1) {
            placar.jogador1 += 1;
            jogador1 = new Jogador(15, 165);
            bot = new Bot(largura - 15 - jogador1.largura, 165);
            bola = new Bola(false);
        }
        if (bola.pontoJogador2) {
            placar.jogador2 += 1;
            jogador1 = new Jogador(15, 165);
            bot = new Bot(largura - 15 - jogador1.largura, 165);
            bola = new Bola(false);
        }
    }
}
