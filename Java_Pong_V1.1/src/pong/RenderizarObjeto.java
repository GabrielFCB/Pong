package pong;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public interface RenderizarObjeto {
    public void desenhar(Graphics g);
    public void desenhar(Graphics g, BufferStrategy bs);
    public void atualizar();
}
