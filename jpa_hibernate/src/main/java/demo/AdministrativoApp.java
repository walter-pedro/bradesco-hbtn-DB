package demo;

import java.util.Date;
import java.util.List;

import entities.Pessoa;
import entities.Produto;
import model.PessoaModel;
import model.ProdutoModel;

public class AdministrativoApp {

    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        // 1) Criando um produto
        produtoModel.create(p1);

        //2) Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        //3) Buscando um produtos na base de dados
        Produto produto = produtoModel.findById(produtos.get(0));
        System.out.println("Produto encontrado: " + produto);

        //4) Atualizando produto
        produto.setPreco(400.0);
        produto = produtoModel.update(produto);
        System.out.println("Produto atualizado: " + produto);

        //5) Excluindo produto
        produtoModel.delete(produto);
        produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());


        
        
        PessoaModel pessoaModel = new PessoaModel();

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Maria Santos");
        pessoa1.setEmail("maria@email.com");
        pessoa1.setIdade(32);
        pessoa1.setCpf("12345678910");
        pessoa1.setDataDeNascimento(new Date());

        // 1) Criando uma pessoa
        pessoaModel.create(pessoa1);

        //2) Buscando todos as pessoas na base de dados
        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontradas : " + pessoas.size());

        //3) Buscando uma pessoa na base de dados
        Pessoa pessoa = pessoaModel.findById(pessoas.get(0));
        System.out.println("Pessoa encontrada: " + pessoa);

        //4) Atualizando pessoa
        pessoa.setNome("Maria da Silva");
        pessoa = pessoaModel.update(pessoa);
        System.out.println("Pessoa atualizada: " + pessoa);

        //5) Excluindo produto
        pessoaModel.delete(pessoa);
        pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontradas : " + pessoas.size());

    }
}
