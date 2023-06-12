package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.FontMetrics;
import java.awt.Font;

public class Placar extends Objeto implements RenderizarObjeto{
    public int jogador1 = 0;
    public int jogador2 = 0;
    public static int pontuacao=0;

    

    public int getJogador1() {
        return jogador1;
    }

    public void setJogador1(int jogador1) {
        this.jogador1 = jogador1;
    }

    public int getJogador2() {
        return jogador2;
    }

    public void setJogador2(int jogador2) {
        this.jogador2 = jogador2;
    }

    public static int getPontuacao() {
        return pontuacao;
    }

    public static void setPontuacao(int pontuacao) {
        Placar.pontuacao = pontuacao;
    }

    public void resetar() {
        jogador1 = 0;
        jogador2 = 0;
        pontuacao=0;
    }

    public void desenhar(Graphics g) {
        g.setColor(new Color(255, 255, 255));
        g.setFont(new Font("Arial", Font.BOLD, 30)); // Define a fonte e o tamanho do texto
        String textoPlacar = pontuacao+"";
        FontMetrics fm = g.getFontMetrics();
        largura = fm.stringWidth(textoPlacar);
        altura = fm.getHeight();
        x = (Jogo.largura - largura) / 2; // Calcula a posição x centralizada
        y = (Jogo.altura + altura) / 2 - 175; // Calcula a posição y centralizada
        g.drawString(textoPlacar, x, y);
    }

    public void desenhar(Graphics g, BufferStrategy bs) {
        g.setColor(new Color(255, 255, 255));
        g.setFont(new Font("Arial", Font.BOLD, 30)); // Define a fonte e o tamanho do texto
        String textoPlacar = pontuacao+"";
        FontMetrics fm = g.getFontMetrics();
        largura = fm.stringWidth(textoPlacar);
        altura = fm.getHeight();
        x = (Jogo.largura - largura) / 2; // Calcula a posição x centralizada
        y = (Jogo.altura + altura) / 2 - 175; // Calcula a posição y centralizada
        g.drawString(textoPlacar, x, y);
    }

    public void atualizar(){
        try {
            Thread.sleep(1); // Aguarda 1 milissegundo
            pontuacao++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Placar [x= "+x+", y="+y+", largura="+largura+", altura="+altura+",jogador1=" + jogador1 + ", jogador2=" + jogador2 + "]";
    } 

}
