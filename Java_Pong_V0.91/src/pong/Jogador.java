package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Jogador extends Objeto implements Renderizar{
    public boolean up;
    public boolean down;

    public Jogador(int x, int y) {
        this.x = x;
        this.y = y;
        this.largura = 10;
        this.altura = 70;
    }

    public void desenhar(Graphics g) {
        g.setColor(new Color(255, 255, 255));
        g.fillRect(x, y, largura, altura);

    }

    public void atualizar() {
        if (up) {
            if (y > 0) {
                y -= 6;
            }
        }
        if (down) {
            if (y < Jogo.altura - altura) {
                y += 6;
            }
        }
    }
}
