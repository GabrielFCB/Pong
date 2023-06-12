package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.HashMap;
import java.util.Map;
import java.awt.Font;
import java.awt.FontMetrics;

public class Derrota extends Tela{
    private String letra1="";
    private String letra2="";
    private String letra3="";
    private Map<Integer, String> alfabeto;
    private int numero=1;
    private boolean trigger1=true;
    private boolean trigger2=true;
    private boolean trigger3=true;
    private static String nomeSalvo="";

    

    public String getLetra1() {
        return letra1;
    }


    public void setLetra1(String letra1) {
        this.letra1 = letra1;
    }


    public String getLetra2() {
        return letra2;
    }


    public void setLetra2(String letra2) {
        this.letra2 = letra2;
    }


    public String getLetra3() {
        return letra3;
    }


    public void setLetra3(String letra3) {
        this.letra3 = letra3;
    }


    public Map<Integer, String> getAlfabeto() {
        return alfabeto;
    }


    public void setAlfabeto(Map<Integer, String> alfabeto) {
        this.alfabeto = alfabeto;
    }


    public int getNumero() {
        return numero;
    }


    public void setNumero(int numero) {
        this.numero = numero;
    }


    public boolean getTrigger1() {
        return trigger1;
    }


    public void setTrigger1(boolean trigger1) {
        this.trigger1 = trigger1;
    }


    public boolean getTrigger2() {
        return trigger2;
    }


    public void setTrigger2(boolean trigger2) {
        this.trigger2 = trigger2;
    }


    public boolean getTrigger3() {
        return trigger3;
    }


    public void setTrigger3(boolean trigger3) {
        this.trigger3 = trigger3;
    }


    public static String getNomeSalvo() {
        return nomeSalvo;
    }


    public static void setNomeSalvo(String nomeSalvo) {
        Derrota.nomeSalvo = nomeSalvo;
    }


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
            Placares.adicionarLista(Placares.lista,nomeSalvo,Placar.getPontuacao());
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
        String textoPontuacao = "Pontuaçã final: "+Placar.getPontuacao();
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


    @Override
    public String toString() {
        return "Derrota [largura="+largura+", altura="+altura+", letra1=" + letra1 + ", letra2=" + letra2 + ", letra3=" + letra3 + ", alfabeto=" + alfabeto
                + ", numero=" + numero + ", trigger1=" + trigger1 + ", trigger2=" + trigger2 + ", trigger3=" + trigger3
                + "]";
    }

    
}
