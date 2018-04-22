import java.util.ArrayList;
import java.util.Random;
class Caminhao extends Automovel{
  Automovel a=new Automovel();
  private int capacidade_carga;
  public void CriaCaminhao(){
    Random gerador = new Random();
    int temp = gerador.nextInt(29);//gera um numero aleatorio pro x
    int temp2 = gerador.nextInt(59);//gera um numero aleatorio para o y
    a.setposicao(temp,temp2);//coloca o caminhao nas posicoes x e y
    a.setvelocidade(1);//define a velocidade do caminhao
    a.setcor("Amarelos");//define a cor do caminhao
  }
   public void mover(){
    a.move();//move o caminhao
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