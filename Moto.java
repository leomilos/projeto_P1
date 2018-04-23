import java.util.ArrayList;
import java.util.Random;
///cria uma moto com mesmas propriedades dos automovel
class Moto extends Automovel{
  Automovel a=new Automovel();
  private int capacidade_carga;
  public void CriaMoto(){
    Random gerador = new Random();
    ///gera um numero aleatorio pro x
    int temp = gerador.nextInt(29);
    ///gera um numero aleatorio para o y
    int temp2 = gerador.nextInt(59);
    ///define aonde vai comecar a moto
    a.setposicao(temp,temp2);
    ///define a velocidade da moto
    a.setvelocidade(3);
    ///define a cor da moto
    a.setcor("Azul");
  }
  public void mover(){
    ///move a moto
    a.move();
    a.move();
    a.move();
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