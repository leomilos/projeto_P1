import java.util.ArrayList;
import java.util.Random;
class Carro extends Automovel{
  Automovel a=new Automovel();
  private int num_passageiros;
  public void CriaCarro(){
    Random gerador = new Random();
    int temp = gerador.nextInt(29);//gera um numero aleatorio pro x
    int temp2 = gerador.nextInt(59);//gera um numero aleatorio para o y
    a.setposicao(temp,temp2);//define a posicao do carro
    a.setvelocidade(2);//define a velocidade do carro
    a.setcor("Vermelho");//define a cor do carro
  }
   public void mover(){
     for(int i=0;i<velocidade;i++){
       a.move();//move o carro
     }
  }
  public int getx(){
    return a.getx();//devolve o x caso necessario
  }
  public int gety(){
    return a.gety();//devolve o y caso necessario
  }
  public boolean getf(){
    return getfabrica();//retorna o boolean da fabrica se necessario
  }
  public void setf(boolean f){
    setfabrica(f);//define o boleano da fabrica
  }
}