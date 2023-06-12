package pong;

import java.awt.Canvas;

public abstract class Tela extends Canvas implements RenderizarTela {
    public static int largura = 600;
    public static int altura = 400;
    
    public static int getLargura() {
        return largura;
    }
    public static int getAltura() {
        return altura;
    }
    @Override
    public String toString() {
        return "Tela [largura="+largura+", altura="+altura+"]";
    }

}
