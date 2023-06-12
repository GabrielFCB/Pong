package pong;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public abstract class Jogo extends Tela{ // Classe utilizada para desenhar o jogo
    public static Jogador jogador1 = new Jogador(15, 165);
    public static Jogador jogador2 = new Jogador(largura - 15 - jogador1.largura, 165);
    public Placar placar = new Placar();
    

    public static Jogador getJogador1() {
        return jogador1;
    }

    public static void setJogador1(Jogador jogador1) {
        Jogo.jogador1 = jogador1;
    }

    public static Jogador getJogador2() {
        return jogador2;
    }

    public static void setJogador2(Jogador jogador2) {
        Jogo.jogador2 = jogador2;
    }

    public Placar getPlacar() {
        return placar;
    }

    public void setPlacar(Placar placar) {
        this.placar = placar;
    }

    public Jogo() {
        this.setPreferredSize(new Dimension(largura, altura)); // Determina as dimensões do jogo
    }

    public void run(Graphics g, BufferStrategy bs) throws FalhaJogo { // Metodo do FPS do jogo
        try {
            while ((TelaInicial.getJogoBot())||(TelaInicial.getJogo2Jogador())) {
                this.desenhar(g, bs);
                this.atualizar();
                Thread.sleep(1000 / 30); // Velocidade que o jogo atualiza o frame
            }
        } catch (InterruptedException e) { // Excecao para caso a thread seja interrompida
            throw new FalhaJogo("Falha em rodar o jogo.", e);
        }
    }

    @Override
    public String toString() {
        return "Jogo [largura="+largura+", altura="+altura+", placar=" + placar + "]";
    }


}
