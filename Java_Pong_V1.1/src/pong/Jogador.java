package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Jogador extends Objeto implements RenderizarObjeto{
    public boolean up;
    public boolean down;


    public boolean getUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean getDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

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

    public void desenhar(Graphics g, BufferStrategy bs) {
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

    @Override
    public String toString() {
        return "Jogador [x= "+x+", y="+y+", largura="+largura+", altura="+altura+",up=" + up + ", down=" + down + "]";
    }
}
