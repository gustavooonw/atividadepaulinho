package com.mycompany.atividadespaulinho;
import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.List;

public class mainCadastro {
    public static void main(String[] args) {
        cadastrarClientes registroClientes = new cadastrarClientes();
        while (true) {
            String escolha = JOptionPane.showInputDialog("1 -> Registrar novo cliente\n"
                                                        + "2 -> Remover cliente\n"
                                                        + "3 -> Atualizar dados do cliente\n"
                                                        + "4 -> Visualizar dados do cliente\n"
                                                        + "5 -> Visualizar todos os clientes\n"
                                                        + "6 -> Encerrar programa\nPor favor, escolha uma opção:");
            if ("6".equals(escolha)) {
                break;
            }
            switch (escolha) {
                case "1":
                    Cliente novoCliente = new Cliente();
                    novoCliente.setCodigo(JOptionPane.showInputDialog("Por favor, insira o código do novo cliente:"));
                    novoCliente.setNome(JOptionPane.showInputDialog("Por favor, insira o nome do novo cliente:"));
                    novoCliente.setTelefone(JOptionPane.showInputDialog("Por favor, insira o telefone do novo cliente:"));
                    novoCliente.setDataNascimento(JOptionPane.showInputDialog("Por favor, insira a data de nascimento do novo cliente:"));
                    registroClientes.adicionarCliente(novoCliente);
                    break;
                case "2":
                    registroClientes.deleteCliente(JOptionPane.showInputDialog("Por favor, insira o código do cliente que deseja remover:"));
                    break;
                case "3":
                    String codigoCliente = JOptionPane.showInputDialog("Por favor, insira o código do cliente que deseja atualizar:");
                    Cliente dadosAtualizados = new Cliente();
                    dadosAtualizados.setNome(JOptionPane.showInputDialog("Por favor, insira o novo nome do cliente:"));
                    dadosAtualizados.setDataNascimento(JOptionPane.showInputDialog("Por favor, insira a nova data de nascimento do cliente:"));
                    dadosAtualizados.setTelefone(JOptionPane.showInputDialog("Por favor, insira o novo telefone do cliente:"));
                    registroClientes.atualizarCliente(codigoCliente, dadosAtualizados);
                    break;
                case "4":
                    Cliente clienteBuscado = registroClientes.getCliente(JOptionPane.showInputDialog("Por favor, insira o código do cliente que deseja visualizar:"));
                    if (clienteBuscado != null) {
                        JOptionPane.showMessageDialog(null, "Dados do cliente:\nCódigo: " + clienteBuscado.getCodigo() 
                                + "\nNome: " + clienteBuscado.getNome() 
                                + "\nData de Nascimento: " + clienteBuscado.getDataNascimento() 
                                + "\nTelefone: " + clienteBuscado.getTelefone());
                    } else {
                        JOptionPane.showMessageDialog(null, "Desculpe, não conseguimos encontrar o cliente.");
                    }
                    break;
                case "5":
                    StringBuilder listaClientes = new StringBuilder("Lista de todos os clientes:\n");
                    for (Cliente c : registroClientes.getTodosClientes()) {
                        listaClientes.append("Código: ").append(c.getCodigo()).append("\nNome: ").append(c.getNome()).append("\nData de Nascimento: ").append(c.getDataNascimento()).append("\nTelefone: ").append(c.getTelefone()).append("\n--------------------\n");
                    }
                    JOptionPane.showMessageDialog(null, listaClientes.toString());
                    break;
            }
        }
    }
}
