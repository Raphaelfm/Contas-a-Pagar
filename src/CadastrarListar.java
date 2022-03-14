/**/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CadastrarListar {

    private Connection conexao;
        
    

    public CadastrarListar(Connection conexao){
        this.conexao = conexao;

    }

    public void cadastrar(Credor c) throws SQLException {
        String sql = ("insert into contasapagar(nome_credor, descricao, valor, DATA) values(?,?,?,?)");

        try {

            PreparedStatement query = conexao.prepareStatement(sql);

            query.setString(1, c.getNome());
			query.setString(2, c.getObservacao());
			query.setFloat(3, c.getValor());
            query.setString(4, c.getData_previsao());

			query.execute();
			query.close();
        
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            conexao.close();
        }

    }

    public List<Credor> getCredor(){
		
		String sql = "select * from contasapagar";
		
		List<Credor> contasapagar = new ArrayList<Credor>();
		
		Connection conexao = null;
		
		PreparedStatement pstm = null;
		
		ResultSet rSet = null;
		
		try {
			conexao = ConexaoBD.conectar();
			
			pstm = (PreparedStatement) conexao.prepareStatement(sql);
			
			rSet = pstm.executeQuery();
			
			while (rSet.next()) {
				
				Credor conta = new Credor();
				
				//Recuperar o id
				conta.setId(rSet.getInt("id"));
				//Recuperar o nome
				conta.setNome(rSet.getString("nome_credor"));
				//Recuperar a descricao da conta
				conta.setObservacao(rSet.getString("descricao"));
                //Recuperar o valor
                conta.setValor(rSet.getFloat("valor"));
				//Recuperar a senha
				conta.setData_previsao(rSet.getString("DATA"));
				//Recuperar a idade
				/*contato.setId(rset.getInt("idade"));
				//Recuperar a data de cadastrado
				contato.setDataCadastro(rset.getDate("datacadastro"));
				*/
				
				contasapagar.add(conta);
				
			}
		}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rSet!=null) {
						rSet.close();
					}
					
					if(pstm!=null) {
						pstm.close();
					}
					
					if(conexao!=null) {
						conexao.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		
		return contasapagar;
	}

	public void baixar(int codigo) throws SQLException{

		String sql = "update contasapagar set status = 'pg' where id = " + codigo;		
		
		Connection conexao = null;
		
		PreparedStatement pstm = null;
		
		int rSet;
		
		try {
			conexao = ConexaoBD.conectar();
			
			pstm = (PreparedStatement) conexao.prepareStatement(sql);
			
			rSet = pstm.executeUpdate();			
				
			
		}catch (Exception e) {
				e.printStackTrace();
			
			}
		
		

	}

	public List<Credor> getCredorPago(){
		
		String sql = "select * from contasapagar where status is null";
		
		List<Credor> contasapagar = new ArrayList<Credor>();
		
		Connection conexao = null;
		
		PreparedStatement pstm = null;
		
		ResultSet rSet = null;
		
		try {
			conexao = ConexaoBD.conectar();
			
			pstm = (PreparedStatement) conexao.prepareStatement(sql);
			
			rSet = pstm.executeQuery();
			
			while (rSet.next()) {
				
				Credor conta = new Credor();
				
				//Recuperar o id
				conta.setId(rSet.getInt("id"));
				//Recuperar o nome
				conta.setNome(rSet.getString("nome_credor"));
				//Recuperar a descricao da conta
				conta.setObservacao(rSet.getString("descricao"));
                //Recuperar o valor
                conta.setValor(rSet.getFloat("valor"));
				//Recuperar a senha
				conta.setData_previsao(rSet.getString("DATA"));
				//Recuperar a idade
				/*contato.setId(rset.getInt("idade"));
				//Recuperar a data de cadastrado
				contato.setDataCadastro(rset.getDate("datacadastro"));
				*/
				
				contasapagar.add(conta);
				
			}
		}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rSet!=null) {
						rSet.close();
					}
					
					if(pstm!=null) {
						pstm.close();
					}
					
					if(conexao!=null) {
						conexao.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		
		return contasapagar;
	}

    
    
}
