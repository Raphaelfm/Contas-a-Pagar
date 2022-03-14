import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class App {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        Connection conexao = ConexaoBD.conectar();

        System.out.println("Informe a opção desejada: \n"
        + "1 - Cadastrar contas a pagar. \n"
        + "2 - Listar contas a pagar. \n"
        + "3 - Baixar contas a pagar.");

        int opcao = Integer.parseInt(input.nextLine());
        
        switch(opcao){
            case 1:
                Credor c = new Credor();
                System.out.println("Cadastro de contas a pagar...");
                System.out.println("Nome do credor: ");
                c.setNome(input.nextLine());
                System.out.println("Observacoes: ");
                c.setObservacao(input.nextLine());
                System.out.println("Valor a pagar: ");
                c.setValor(Float.parseFloat(input.nextLine()));
                System.out.println("Data de vencimento da conta: ");
                c.setData_previsao(input.nextLine());

                CadastrarListar cad = new CadastrarListar(conexao);
                cad.cadastrar(c);

                break;
            
            case 2:
                System.out.println("Linstando contas: ");                
                CadastrarListar lista = new CadastrarListar(conexao);
                lista.getCredor();
                for(Credor list : lista.getCredor()) {
                    System.out.println("Nome do credor: "+list.getNome() + " - Descricao: "+list.getObservacao()
                     + " Valor: "+list.getValor() + " Data de vencimento: " + list.getData_previsao());
                }
                break;
            case 3:
                System.out.println("Informe o codigo da conta que deseja baixar: ");
                CadastrarListar baixar = new CadastrarListar(conexao);
                int codigo = Integer.parseInt(input.nextLine());
                baixar.baixar(codigo);
                System.out.println("Baixado com sucesso!");
                break;
            default:
                System.out.println("Opcao invalida.");
        }
        
        
    }
}
