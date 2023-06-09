package pong;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public abstract class Tela extends Canvas {
    public static int largura = 600;
    public static int altura = 400;

    public abstract void desenhar(Graphics g, BufferStrategy bs);

    public abstract void atualizar();
}
