/*
 * Copyright (C) 2024 Aluno
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package avaliacao.n1;

/**
 *
 * @author Pedro Sousa Assumpção <pedroheitor55@gmail.com>
 * Date: 08/03/2024
 * 
 */


import java.util.Scanner;

public class Prova1 {
    public static void main(String[] args) {
        
        int opcao = 0, qde_expresso=0, qde_capuccino=0, 
            qde_leite_com_cafe=0, qde_cafe_gelado=0, qde_cafes_vendidos;
        double valor_expresso, valor_capuccino,
            valor_leite_com_cafe, valor_cafe_gelado, valor_cafes_vendidos = 0;
        
        Scanner sc = new Scanner(System.in);
    
        do {
        
            System.out.println("Forneça uma opção: \n"+
                                "1 ­ café expresso; \n"+
                                "2 ­ café capuccino; \n"+
                                "3 ­ leite com café; \n"+
                                "4 - café gelado; \n"+
                                "5 ­ totalizar vendas; \n"+
                                "6 - Excluir produto; \n"+
                                "7 - Pagamento parcial; \n"+
                                "8 - Pagamento total;");
  
            opcao = sc.nextInt();
  
            switch (opcao) {
                case 1:
                    qde_expresso++;
                    break;
                case 2:
                    qde_capuccino++;
                    break;
                case 3:
                    qde_leite_com_cafe++;
                    break;
                case 4:
                    qde_cafe_gelado++;
                    break;
                case 5:
                    break;
                case 6:
                    // Implementação da exclusão de produtos
                    System.out.println("Excluir produto:");
                    System.out.println("1 - café expresso");
                    System.out.println("2 - café capuccino");
                    System.out.println("3 - leite com café");
                    System.out.println("4 - café gelado");
                    int opcaoExcluir = sc.nextInt();
                    switch (opcaoExcluir) {
                        case 1:
                            if (qde_expresso > 0) {
                                qde_expresso--;
                                System.out.println("Produto removido com sucesso.");
                            } else {
                                System.out.println("Nenhum café expresso na lista.");
                            }
                            break;
                        case 2:
                            if (qde_capuccino > 0) {
                                qde_capuccino--;
                                System.out.println("Produto removido com sucesso.");
                            } else {
                                System.out.println("Nenhum café capuccino na lista.");
                            }
                            break;
                        case 3:
                            if (qde_leite_com_cafe > 0) {
                                qde_leite_com_cafe--;
                                System.out.println("Produto removido com sucesso.");
                            } else {
                                System.out.println("Nenhum leite com café na lista.");
                            }
                            break;
                        case 4:
                            if (qde_cafe_gelado > 0) {
                                qde_cafe_gelado--;
                                System.out.println("Produto removido com sucesso.");
                            } else {
                                System.out.println("Nenhum café gelado na lista.");
                            }
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }
                    break;
                case 7:
                    // Implementação do pagamento parcial
                    System.out.println("Informe o valor do pagamento parcial:");
                    double pagamentoParcial = sc.nextDouble();
                    if (pagamentoParcial < valor_cafes_vendidos) {
                        valor_cafes_vendidos -= pagamentoParcial;
                        System.out.println("Pagamento parcial realizado: R$ " + pagamentoParcial);
                    } else {
                        System.out.println("Valor do pagamento parcial excede o total da conta.");
                    }
                    break;
                case 8:
                    // Implementação do pagamento total
                    System.out.println("Valor total da conta: R$ " + valor_cafes_vendidos);
                    valor_cafes_vendidos = 0; // Zerando o valor total da conta
                    System.out.println("Pagamento total realizado.");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while ( opcao != 5);
    
        valor_expresso = qde_expresso*0.75;
        valor_capuccino = qde_capuccino*1.0;    
        valor_leite_com_cafe = qde_leite_com_cafe*1.25;
        valor_cafe_gelado = qde_cafe_gelado*1.50;
        qde_cafes_vendidos = qde_expresso + qde_capuccino + qde_leite_com_cafe + qde_cafe_gelado;
        valor_cafes_vendidos = valor_expresso + valor_capuccino + valor_leite_com_cafe + valor_cafe_gelado;
    
        System.out.println("Qde café expresso: "+qde_expresso+" - valor: "+valor_expresso);
        System.out.println("Qde café capuccino: "+qde_capuccino+" - valor: "+valor_capuccino);    
        System.out.println("Qde leite com café: "+qde_leite_com_cafe+
                            " - valor: "+valor_leite_com_cafe);
        System.out.println("Qde café gelado: "+qde_cafe_gelado+" - valor: "+valor_cafe_gelado);        
        System.out.println("Qde cafés vendidos: "+ qde_cafes_vendidos +
                            " - valor cafés vendidos: "+valor_cafes_vendidos);
         // Verificação de saldo pendente antes de sair
        if (valor_cafes_vendidos > 0) {
            System.out.println("Ainda há saldo pendente a ser pago. Por favor, realize o pagamento total antes de sair.");
            // Mantém o programa em execução até que o saldo seja quitado
            while (valor_cafes_vendidos > 0) {
                System.out.println("Informe o valor do pagamento total:");
                double pagamentoTotal = sc.nextDouble();
                valor_cafes_vendidos -= pagamentoTotal;
                if (valor_cafes_vendidos > 0) {
                    System.out.println("Ainda há saldo pendente a ser pago. Por favor, realize o pagamento total antes de sair.");
    
                }
    }
        }
    }
}

