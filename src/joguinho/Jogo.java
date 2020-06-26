package joguinho;
import java.util.Random;
import java.util.Scanner;
public class Jogo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        boolean jogo = true, heroi = true, acaoPlayer1 = true, acaoPlayer2 = true, playerAtacar = false, playerStatus = false,playerPassar = false;
        System.out.println("Digite o nome de seu personagem");
        String meuNome = input.nextLine();
        System.out.println("Digite o nome de seu inimigo");
        String inimigoNome = input.nextLine();
        String pass, resultado = null;
        int roundSemAcaoPlay1 = 0, roundSemAcaoPlay2 = 0;
        
        Personagem play1 = new Heroi(meuNome, 10, 150);
        Personagem play2 = new Inimigo(inimigoNome, 10, 150);
        
        //game em si
        while(jogo == true){
            if(roundSemAcaoPlay1 > 0){
                roundSemAcaoPlay1--;
            }else{
            heroi = true;
            }
            //game do player 1
            while(heroi == true){
                
                //opções das ações
                
                
                while(acaoPlayer1 == true){
                    
                    space();
                    System.out.println("Digite qual ação você deseja fazer\n1- atacar\n2- recuperar pontos\n3- obter status da partida");
                input = new Scanner(System.in);
                pass = input.nextLine();
                
                if("1".equals(pass)){
                    playerAtacar = true;
                }
                else if("2".equals(pass)){
                    playerPassar = true;
                }
                else if("3".equals(pass)){
                    playerStatus = true;
                }
                else{
                    System.out.println("opção Inválida!");
                }
                    
                    while(playerAtacar == true){space();
                        
                        
                        if(play1.getVigor() >= 2){
                            System.out.println("------------>Usar ataque normal<------------\nCustos: 2 pontos\nAtack: 5 \n");
                        }else{
                            System.out.println("Pontos restantes para usar >ataque normal<: "+(2-play1.getVigor())+"\n");
                        }
                        if(play1.getVigor() >= 5){
                            System.out.println("------------->Usar ataque médio<-------------\nCustos: 5 pontos\nAtack: 7 \n");
                        }else{
                            System.out.println("Pontos restantes para usar >ataque médio<: "+(5-play1.getVigor())+"\n");
                        }
                        if(play1.getVigor() >= 15){
                            System.out.println("------------->Usar ataque forte<-------------\nCustos: 15 pontos\nAtack: 10 + quantia aleatória entre 0 - 10 \n");
                        }else{
                            System.out.println("Pontos restantes para usar >ataque forte<: "+(15-play1.getVigor())+"\n");
                        }
                        if(play1.getVigor() >= 10){
                            System.out.println("----------->Usar ataque furtivo<-----------\n(possui 50% de chance de deixar o inimigo sem ação por mais 1 round!)\nCustos: 10 pontos\nAtack: 3 \n\n");
                        }else{
                            System.out.println("Pontos restantes para usar >ataque furtivo<: \n\n"+(10-play1.getVigor())+"\n\n");
                        }
                        
                        System.out.println("Qual ataque deseja realizar?(Digite apenas o número)\n\nSua vida: "+play1.getVida()+"\nSeus pontos: "+play1.getVigor()+"\n\n1- ataque normal\n2- ataque médio\n3- ataque forte\n4- ataque furtivo\n5- voltar");
                        int ataqueDesejado = input.nextInt();
                        //------------------------------------------------------
                        
                        
                        if(ataqueDesejado == 1 && play1.getVigor() >= 2){space();
                            play1.setVigor((play1.getVigor()-2));
                            play2.setVida((play2.getVida()-5));
                            resultado = "Você fez um ataque normal com 5 pontos de dano que deixou "+play2.getNome()+" com "+play2.getVida()+" de HP";
                            System.out.println(resultado+"\n\nPRESSIONE ENTER PARA CONTINUAR");
                            input = new Scanner(System.in);
                            pass = input.nextLine();
                            acaoPlayer1 = false;
                            playerAtacar = false;
                            
                        }else{
                            if(ataqueDesejado == 1){space();
                            System.out.println("Pontos insuficientes para realizar >ataque normal< PRESSIONE ENTER PARA CONTINUAR");
                            input = new Scanner(System.in);
                            pass = input.nextLine();
                            }
                        }
                        if(ataqueDesejado == 2 && play1.getVigor() >= 5){space();
                            play1.setVigor((play1.getVigor()-5));
                            play2.setVida((play2.getVida()-7));
                            resultado = "Você fez um ataque médio com 7 pontos de dano que deixou "+play2.getNome()+" com "+play2.getVida()+" de HP";
                            System.out.println(resultado+"\n\nPRESSIONE ENTER PARA CONTINUAR");
                            input = new Scanner(System.in);
                            pass = input.nextLine();
                            acaoPlayer1 = false;
                            playerAtacar = false;
                            
                        }else{space();
                            if(ataqueDesejado == 2){
                            System.out.println("Pontos insuficientes para realizar >ataque médio< PRESSIONE ENTER PARA CONTINUAR");
                            input = new Scanner(System.in);
                            pass = input.nextLine();
                            }
                        }
                        if(ataqueDesejado == 3 && play1.getVigor() >= 15){space();
                            play1.setVigor((play1.getVigor()-15));
                            int x = gerarNumeroAleatorio(11);
                            play2.setVida((play2.getVida()-(10 + x)));
                            resultado = "Você fez um ataque forte com " +(x+10)+ " pontos de dano que deixou "+play2.getNome()+" com "+play2.getVida()+" de HP";
                            System.out.println(resultado+"\n\nPRESSIONE ENTER PARA CONTINUAR");
                            input = new Scanner(System.in);
                            pass = input.nextLine();
                            acaoPlayer1 = false;
                            playerAtacar = false;
                            
                        }else{space();
                            if(ataqueDesejado == 3){
                            System.out.println("Pontos insuficientes para realizar >ataque forte< PRESSIONE ENTER PARA CONTINUAR");
                            input = new Scanner(System.in);
                            pass = input.nextLine();
                            }
                        }
                        if(ataqueDesejado == 4 && play1.getVigor() >= 10){space();
                            play1.setVigor((play1.getVigor()-10));
                            play2.setVida((play2.getVida()-3));
                            boolean furtivo = gerarPorcentagem(50);
                            if(furtivo == true){
                                roundSemAcaoPlay2 = 1;
                                resultado = "Você fez um ataque furtivo com 3 pontos de dano que deixou "+play2.getNome()+" atordoado por mais 1 round e com "+play2.getVida()+" de HP";}
                            else{
                                resultado = "Você fez um ataque furtivo com 3 pontos de dano que falhou em deixar "+play2.getNome()+" atordoado! a vida atual é de "+play2.getVida()+" de HP";
                            }
                            System.out.println(resultado+"\n\nPRESSIONE ENTER PARA CONTINUAR");
                            input = new Scanner(System.in);
                            pass = input.nextLine();
                            acaoPlayer1 = false;
                            playerAtacar = false;
                            
                        }else{space();
                            if(ataqueDesejado == 4){
                            System.out.println("Pontos insuficientes para realizar >ataque furtivo< PRESSIONE ENTER PARA CONTINUAR");
                            input = new Scanner(System.in);
                            pass = input.nextLine();
                            }
                        }
                        if(ataqueDesejado == 5){space();
                            playerAtacar = false;
                        }
                        if(ataqueDesejado < 0 || ataqueDesejado > 5){space();
                            System.out.println("opção inválida!");
                        }
                    }
                    
                    
                    
                    while(playerPassar == true){space();
                        System.out.println("opções disponíveis:\n1- Recuperar 10 de vigor\n"
                                + "2- Recuperar 25 de vigor (possui chance de 50% de vc ficar inativo no proximo round!)\n3- voltar");
                        int escolha = input.nextInt();
                        
                        if(escolha == 1){space();
                            System.out.println("Você recarregou seu vigor em 10 pontos!\nPRESIONE ENTER PARA CONTINUAR");
                            input = new Scanner(System.in);
                            pass = input.nextLine();
                            play1.setVigor(play1.getVigor()+10);
                            acaoPlayer1 = false;
                            playerPassar = false;
                        }else if(escolha == 2){space();
                            int numero = gerarNumeroAleatorio(2);
                            if(numero == 0){
                                System.out.println("Você recarregou 25 pontos de vigor porém irá ficar 1 round sem ação!\nPRESSIONE ENTER PARA CONTINUAR");
                                roundSemAcaoPlay1 = 1;
                                play1.setVigor(play1.getVigor()+25);
                                input = new Scanner(System.in);
                                pass = input.nextLine();
                                acaoPlayer1 = false;
                                playerPassar = false;
                                
                            }else{space();
                                System.out.println("Você recarregou 25 pontos de vigor com sucesso!\nPRESSIONE ENTER PARA CONTINUAR");
                                play1.setVigor(play1.getVigor()+25);
                                input = new Scanner(System.in);
                                pass = input.nextLine();
                                acaoPlayer1 = false;
                                playerPassar = false;
                                
                            }
                        }
                        else if(escolha == 3){space();
                            playerPassar = false;
                        }
                        else{space();
                            System.out.println("Opção inválida!");
                        }
                        
                    }
                    
                    if(playerStatus == true){space();
                        System.out.println("SEU NOME: "+play1.getNome()+"\nSUA VIDA: "+play1.getVida()+"\nSEU VIGOR: "+play1.getVigor());
                        System.out.println("NOME DO ADVERSARIO: "+play2.getNome()+"\nVIDA DO ADVERSARIO: "+play2.getVida()+"\nVIGOR DO ADVERSARIO: "+play2.getVigor()+"\nPRESSIONE ENTER PARA CONTINUAR");
                        input = new Scanner(System.in);
                        pass = input.nextLine();
                    playerStatus = false;}
                }
            acaoPlayer1 = true;    
            heroi = false;} 
            
            if(play1.getVida() <= 0 || play2.getVida() <= 0){
                if(play1.getVida() <= 0){
                    while(1 == 1){
                        System.out.println("VOÇÊ MORREU FILHA DA PUTA!");
                    } 
                }
                if(play2.getVida() <= 0){
                    while(1 == 1){
                        System.out.println("VOÇÊ VENCEU FILHA DA PUTA!");
                    } 
                }
        }
        //----------------------------------------------------------------------    
        
            
        
        if(roundSemAcaoPlay2 > 0){space();
            System.out.println("Voçê tem direito a mais um round! \nPRESSIONE ENTER PARA CONTINUAR");
            input = new Scanner(System.in);
            pass = input.nextLine();
            
            
        }else{//game do player 2
            space();
            System.out.println("vez da ação do adversario...\nPRESSIONE ENTER PARA CONTINUAR");
            input = new Scanner(System.in);
            pass = input.nextLine();
            
            
            
            if(play2.getVigor() < 5){
                play2.setVigor(25);
                resultado = "O "+play2.getNome()+" recuperou seu vigor em 25 pontos!";
            }else{
                while(acaoPlayer2 == true){
                    int opcao = gerarNumeroAleatorio(11);
                    //----------------------------------------------------------
                if(opcao <= 5 && play2.getVigor() >= 15){
                    
                    if(play1.getVigor() > 1){
                       int dano = ((10) + gerarNumeroAleatorio(11)); 
                    System.out.println("O inimigo efetuou um ataque! deseja defende-lo?\n1- SIM\n2- NÃO");
                    int escolha = input.nextInt();
                    if(escolha == 1){
                        int resultadoDaDefesa = defenderAtaque(play1.getVigor());
                        if(resultadoDaDefesa == 1){
                            resultado = "O Ataque de força "+dano+" de "+play2.getNome()+" foi bloqueado!";
                            play1.setVigor(play1.getVigor()-1);
                            play2.setVigor(play2.getVigor()-15);
                        }else if(resultadoDaDefesa == 10){
                            play1.setVida(play1.getVida()-dano);
                            play1.setVigor(play1.getVigor()-1);
                            play2.setVigor(play2.getVigor()-15);
                            resultado = "O Ataque de força "+dano+" de "+play2.getNome()+" NÃO foi bloqueado!\nO ataque deixou voçê com "+play1.getVida()+" de HP";
                        }else if(resultadoDaDefesa == 2){
                            resultado = "O Ataque de força "+dano+" de "+play2.getNome()+" foi bloqueado!";
                            play1.setVigor(play1.getVigor()-5);
                            play2.setVigor(play2.getVigor()-15);
                        }else if(resultadoDaDefesa == 20){
                            play1.setVida(play1.getVida()-dano);
                            play1.setVigor(play1.getVigor()-5);
                            play2.setVigor(play2.getVigor()-15);
                            resultado = "O Ataque de força "+dano+" de "+play2.getNome()+" NÃO foi bloqueado!\nO ataque deixou voçê com "+play1.getVida()+" de HP";
                        }else if(resultadoDaDefesa == 3){
                            resultado = "O Ataque de força "+dano+" de "+play2.getNome()+" foi bloqueado!";
                            play1.setVigor(play1.getVigor()-10);
                            play2.setVigor(play2.getVigor()-15);
                        }else if(resultadoDaDefesa == 30){
                            play1.setVida(play1.getVida()-dano);
                            play1.setVigor(play1.getVigor()-10);
                            play2.setVigor(play2.getVigor()-15);
                            resultado = "O Ataque de força "+dano+" de "+play2.getNome()+" NÃO foi bloqueado!\nO ataque deixou voçê com "+play1.getVida()+" de HP";
                        }
                        break;
                    }else{
                        play1.setVida(play1.getVida()-dano);
                        play2.setVigor(play2.getVigor()-15);
                        resultado = "O player "+play2.getNome()+" Usou um ataque forte com dano de "+dano+" pontos "
                            + "que deixou voçê com "+play1.getVida()+" de HP";
                    }
                    break;}
                }else{}
                //--------------------------------------------------------------
                if(opcao > 5 && opcao <= 8 && play2.getVigor() >= 10 ){
                    int dano = 7; 
                    System.out.println("O inimigo efetuou um ataque! deseja defende-lo?\n1- SIM\n2- NÃO");
                    int escolha = input.nextInt();
                    if(escolha == 1){
                        int resultadoDaDefesa = defenderAtaque(play1.getVigor());
                        if(resultadoDaDefesa == 1){
                            resultado = "O Ataque de força "+dano+" de "+play2.getNome()+" foi bloqueado!";
                            play1.setVigor(play1.getVigor()-1);
                            play2.setVigor(play2.getVigor()-10);
                        }else if(resultadoDaDefesa == 10){
                            play1.setVida(play1.getVida()-dano);
                            play1.setVigor(play1.getVigor()-1);
                            play2.setVigor(play2.getVigor()-10);
                            resultado = "O Ataque de força "+dano+" de "+play2.getNome()+" NÃO foi bloqueado!\nO ataque deixou voçê com "+play1.getVida()+" de HP";
                        }else if(resultadoDaDefesa == 2){
                            resultado = "O Ataque de força "+dano+" de "+play2.getNome()+" foi bloqueado!";
                            play1.setVigor(play1.getVigor()-5);
                            play2.setVigor(play2.getVigor()-10);
                        }else if(resultadoDaDefesa == 20){
                            play1.setVida(play1.getVida()-dano);
                            play1.setVigor(play1.getVigor()-5);
                            play2.setVigor(play2.getVigor()-10);
                            resultado = "O Ataque de força "+dano+" de "+play2.getNome()+" NÃO foi bloqueado!\nO ataque deixou voçê com "+play1.getVida()+" de HP";
                        }else if(resultadoDaDefesa == 3){
                            resultado = "O Ataque de força "+dano+" de "+play2.getNome()+" foi bloqueado!";
                            play1.setVigor(play1.getVigor()-10);
                            play2.setVigor(play2.getVigor()-10);
                        }else if(resultadoDaDefesa == 30){
                            play1.setVida(play1.getVida()-dano);
                            play1.setVigor(play1.getVigor()-10);
                            play2.setVigor(play2.getVigor()-10);
                            resultado = "O Ataque de força "+dano+" de "+play2.getNome()+" NÃO foi bloqueado!\nO ataque deixou voçê com "+play1.getVida()+" de HP";
                        }
                        break;
                    }else{
                        play1.setVida(play1.getVida()-dano);
                        play2.setVigor(play2.getVigor()-10);
                        resultado = "O player "+play2.getNome()+" Usou um ataque médio com dano de "+dano+" pontos "
                            + "que deixou voçê com "+play1.getVida()+" de HP";
                    }
                break;
                }else{}
                
                if(opcao > 8 && opcao <= 10){
                    resultado = "O player "+play2.getNome()+" recarregou seu vigor em 15 pontos!";
                    play2.setVigor(play2.getVigor()+15);
                  break;}
                    }
                }
            }
        space();
        System.out.println("Resultado do round: "+resultado+"\nPRESSIONE ENTER PARA CONTINUAR");
        input = new Scanner(System.in);
        pass = input.nextLine();
        
        if(play1.getVida() <= 0 || play2.getVida() <= 0){
            if(play1.getVida() <= 0){
                while(1 == 1){
                    System.out.println("VOÇÊ MORREU FILHA DA PUTA!");
                } 
            }
            if(play2.getVida() <= 0){
                while(1 == 1){
                    System.out.println("VOÇÊ VENCEU FILHA DA PUTA!");
                } 
            }
        }
    }
}

    
    static boolean gerarPorcentagem(int porcentagem){
        boolean chance = false;
        Random random = new Random();
        int total = random.nextInt(100);
        if(total <= porcentagem){
            chance = true;
        }
    return chance;}
    
    static int gerarNumeroAleatorio(int numero){
        Random random = new Random();
        int total = random.nextInt(numero);
    return total;}
    
    
    
    static int defenderAtaque(int vigor){
        Scanner input = new Scanner(System.in);
        int cont = 1, acao, acess = 1, resultado = 0;
        
        while(acess == 1){space();
        System.out.println("Qual tipo de defesa deseja utilizar?");
        if(vigor >= 1){
            System.out.println(cont+"- Usar >defesa fraca< (20% de chance de defender)\n");
            cont++;
        }
        if(vigor >= 5){
            System.out.println(cont+"- Usar >defesa média< (40% de chance de defender)\n");
            cont++;
        }
        if(vigor >= 10){
            System.out.println(cont+"- Usar >defesa forte< (60% de chance de defender)\n");
        }
        
        acao = input.nextInt();
        
        if(acao == 1 && vigor >= 1){
            boolean chance = gerarPorcentagem(20);
            
            if(chance == true){space();
                System.out.println("Defesa bem sucedida! \nPRESSIONE ENTER PARA CONTINUAR");
                input = new Scanner(System.in);
                String pass = input.nextLine();
                resultado = 1;
                acess = 0;
            }else{space();
                System.out.println("Defesa mal sucedida! \n PRESSIONE ENTER PARA CONTINUAR  ");
                input = new Scanner(System.in);
                String pass = input.nextLine();
                resultado = 10;
                acess = 0;
            }
        }else{space();
            if(acao == 3){
            System.out.println("Você não possui pontos suficiente para efetuar essa defesa!");
        }}
        if(acao == 2 && vigor >= 5){space();
            boolean chance = gerarPorcentagem(40);
            
            if(chance == true){space();
                System.out.println("Defesa bem sucedida! \nPRESSIONE ENTER PARA CONTINUAR");
                input = new Scanner(System.in);
                String pass = input.nextLine();
                resultado = 2;
                acess = 0;
            }else{space();
                System.out.println("Defesa mal sucedida! \n PRESSIONE ENTER PARA CONTINUAR  ");
                input = new Scanner(System.in);
                String pass = input.nextLine();
                resultado = 20;
                acess = 0;
            }
        }else{space();
            if(acao == 2){
            System.out.println("Você não possui pontos suficiente para efetuar essa defesa!");
        }}
        if (acao == 3 && vigor >= 10){
            boolean chance = gerarPorcentagem(60);
            
            if(chance == true){space();
                System.out.println("Defesa bem sucedida! \nPRESSIONE ENTER PARA CONTINUAR");
                input = new Scanner(System.in);
                String pass = input.nextLine();
                resultado = 3;
                acess = 0;
            }else{space();
                System.out.println("Defesa mal sucedida! \n PRESSIONE ENTER PARA CONTINUAR  ");
                input = new Scanner(System.in);
                String pass = input.nextLine();
                resultado = 30;
                acess = 0;
            }
        }else{space();
            if(acao == 3){
            System.out.println("Você não possui pontos suficiente para efetuar essa defesa!");
            }}
        }
    return resultado;}
    
    static void space(){
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }
}