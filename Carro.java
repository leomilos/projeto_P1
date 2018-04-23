import java.util.ArrayList;
import java.util.Random;
class Carro extends Automovel{
  Automovel a=new Automovel();
  private int num_passageiros;
  public void CriaCarro(){
    Random gerador = new Random();
    ///gera um numero aleatorio para o x
    int temp = gerador.nextInt(29);
    ///gera um numero aleatorio para y
    int temp2 = gerador.nextInt(59);
    ///define a posicao do carro
    a.setposicao(temp,temp2);
    ///define a velocidade do carro
    a.setvelocidade(2);
    ///define a cor do carro
    a.setcor("Vermelho");
  }
   public void mover(){
     for(int i=0;i<a.getvelocidade();i++){
       a.move();
     }
  }
  public int getx(){
    ///devolve o x caso necessario
    return a.getx();
  }
  public int gety(){
    ///devolve o y caso necessario
    return a.gety();
  }
  public boolean getf(){
    ///retorna o boolean da fabrica se necessario
    return getfabrica();
  }
  public void setf(boolean f){
    ///define o boleano da fabrica
    setfabrica(f);
  }
}