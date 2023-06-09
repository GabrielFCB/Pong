package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.HashMap;
import java.util.Map;
import java.awt.Font;
import java.awt.FontMetrics;

public class Derrota extends Tela{
    public String letra1="";
    public String letra2="";
    public String letra3="";
    public Map<Integer, String> alfabeto;
    public int numero=1;
    public boolean trigger1=true;
    public boolean trigger2=true;
    public boolean trigger3=true;
    public static String nomeSalvo="";


    public Derrota(){
        alfabeto=new HashMap<>();
        alfabeto.put(1,"A");
        alfabeto.put(2,"B");
        alfabeto.put(3,"C");
        alfabeto.put(4,"D");
        alfabeto.put(5,"E");
        alfabeto.put(6,"F");
        alfabeto.put(7,"G");
        alfabeto.put(8,"H");
        alfabeto.put(9,"I");
        alfabeto.put(10,"J");
        alfabeto.put(11,"K");
        alfabeto.put(12,"L");
        alfabeto.put(13,"M");
        alfabeto.put(14,"N");
        alfabeto.put(15,"O");
        alfabeto.put(16,"P");
        alfabeto.put(17,"Q");
        alfabeto.put(18,"R");
        alfabeto.put(19,"S");
        alfabeto.put(20,"T");
        alfabeto.put(21,"U");
        alfabeto.put(22,"V");
        alfabeto.put(23,"W");
        alfabeto.put(24,"X");
        alfabeto.put(25,"Y");
        alfabeto.put(26,"Z");
    }


    public void run(Graphics g, BufferStrategy bs) { // Metodo do FPS do jogo
        try {
            while(trigger3){
                this.desenhar(g, bs);
                this.atualizar();
                Thread.sleep(1); // Velocidade que o jogo atualiza o frame
            }
            nomeSalvo=letra1+letra2+letra3;
            Placares.adicionarLista(nomeSalvo);
        } catch (InterruptedException e) { // Excecao para caso a thread seja interrompida
            e.printStackTrace();// Rastreia o momento que a excecao ocorreu
        }
    }


    public void desenhar(Graphics g, BufferStrategy bs) {
        g.setColor(new Color(0, 0, 0)); // Escolhe a cor
        g.fillRect(0, 0, largura, altura); // X e y de onde começa e o tamanho

        g.setColor(new Color(255, 255, 255)); 
        g.setFont(new Font("Arial", Font.BOLD, 30)); // Define a fonte e o tamanho do texto
        FontMetrics fm = g.getFontMetrics();
        String textoPontuacao = "Pontuaçã final: "+Placar.pontuacao;
        int larguraPontuaca=fm.stringWidth(textoPontuacao);
        int x = (Jogo.largura-larguraPontuaca) / 2; // Calcula a posição x centralizada
        int y = 50; // Calcula a posição y centralizada
        g.drawString(textoPontuacao, x, y);
        String textoMensagem = "Digite seu nome: "+letra1+letra2+letra3;
        int larguraMensagem=fm.stringWidth(textoMensagem);
        x = (Jogo.largura-larguraMensagem) / 2; // Calcula a posição x centralizada
        y = 200; // Calcula a posição y centralizada
        g.drawString(textoMensagem, x, y);
        
        bs.show(); // Mostra o grafico no buffer
    }


    public void atualizar() {
        if (trigger1){
            letra1=alfabeto.get(numero);
        }
        if ((trigger2)&&(!trigger1)){
            letra2=alfabeto.get(numero);
        }
        if ((trigger3)&&(!trigger1)&&(!trigger2)){
            letra3=alfabeto.get(numero);
        }


    }
}
