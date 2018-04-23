import java.util.ArrayList;
import java.util.Random;
class Caminhao extends Automovel{
  Automovel a=new Automovel();
  private int capacidade_carga;
  public void CriaCaminhao(){
    Random gerador = new Random();
    ///gera um numero aleatorio para o x
    int temp = gerador.nextInt(29);
    ///gera um numero aleatorio para o y
    int temp2 = gerador.nextInt(59);
    ///coloca o caminhao nas posicoes x e y
    a.setposicao(temp,temp2);
    ///define a velocidade do caminhao
    a.setvelocidade(1);
    ///define a cor do caminhao
    a.setcor("Amarelos");
  }
   public void mover(){
     ///move o caminhao
    a.move();
    
  }
  public int getx(){
    return a.getx();
    ///devolve o x caso necessario
  }
  public int gety(){
    return a.gety();
    ///devolve o y caso necessario
  }
  public boolean getf(){
    return getfabrica();
    ///retorna o boolean da fabrica se necessario
  }
  public void setf(boolean f){
    setfabrica(f);
    ///define o boleano da fabrica
  }  
}