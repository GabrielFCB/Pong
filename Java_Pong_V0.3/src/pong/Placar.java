package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.FontMetrics;
import java.awt.Font;

public class Placar {
    public int jogador1 = 0;
    public int jogador2 = 0;

    public void resetar() {
        jogador1 = 0;
        jogador2 = 0;
    }

    public void desenhar(Graphics g) {
        g.setColor(new Color(255, 255, 255));
        g.setFont(new Font("Arial", Font.BOLD, 30)); // Define a fonte e o tamanho do texto
        String textoPlacar = jogador1 + " - " + jogador2;
        FontMetrics fm = g.getFontMetrics();
        int larguraTexto = fm.stringWidth(textoPlacar);
        int alturaTexto = fm.getHeight();
        int x = (Jogo.largura - larguraTexto) / 2; // Calcula a posição x centralizada
        int y = (Jogo.altura + alturaTexto) / 2 - 175; // Calcula a posição y centralizada
        g.drawString(textoPlacar, x, y);
    }
}
