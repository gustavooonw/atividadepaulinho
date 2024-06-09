package com.mycompany.atividadespaulinho;
import java.util.LinkedList;
import java.util.List;
public class cadastrarClientes {
    private List<Cliente> clientes;
    public cadastrarClientes() {
        this.clientes = new LinkedList<>();
    }
    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
    public void deleteCliente(String codigo) {
        this.clientes.removeIf(cliente -> cliente.getCodigo().equals(codigo));
    }
    public void atualizarCliente(String codigo, Cliente dadosAtualizados) {
        for (Cliente cliente : this.clientes) {
            if (cliente.getCodigo().equals(codigo)) {
                cliente.setNome(dadosAtualizados.getNome());
                cliente.setDataNascimento(dadosAtualizados.getDataNascimento());
                cliente.setTelefone(dadosAtualizados.getTelefone());
                break;
            }
        }
    }
    public Cliente getCliente(String codigo) {
        for (Cliente cliente : this.clientes) {
            if (cliente.getCodigo().equals(codigo)) {
                return cliente;
            }
        }
        return null;
    }
    public List<Cliente> getTodosClientes() {
        return this.clientes;
    }
}
