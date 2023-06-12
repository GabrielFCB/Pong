package pong;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public interface RenderizarTela {
    public  void desenhar(Graphics g, BufferStrategy bs);
    public  void atualizar();
}
