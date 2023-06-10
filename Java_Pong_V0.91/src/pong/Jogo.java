package pong;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public abstract class Jogo extends Tela{ // Classe utilizada para desenhar o jogo
    public static Jogador jogador1 = new Jogador(15, 165);
    public static Jogador jogador2 = new Jogador(largura - 15 - jogador1.largura, 165);
    public Placar placar = new Placar();

    public Jogo() {
        this.setPreferredSize(new Dimension(largura, altura)); // Determina as dimensões do jogo
    }

    public void run(Graphics g, BufferStrategy bs) { // Metodo do FPS do jogo
        try {
            while ((TelaInicial.jogoBot)||(TelaInicial.jogo2Jogador)) {
                this.desenhar(g, bs);
                this.atualizar();
                Thread.sleep(1000 / 30); // Velocidade que o jogo atualiza o frame
            }
        } catch (InterruptedException e) { // Excecao para caso a thread seja interrompida
            e.printStackTrace();// Rastreia o momento que a excecao ocorreu
        }
    }

}
