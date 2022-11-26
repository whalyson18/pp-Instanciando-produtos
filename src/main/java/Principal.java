import Builder.Produto;
import Builder.ProdutoBuilder;
import BuilderImmutables.ProdutoImmutables;
import BuilderLombok.ProdutoLombok;

import java.time.LocalDate;

public class Principal {
    public static void main(String[] args) {
        Produto produto = new ProdutoBuilder()
                .id(1)
                .descricao("balde vermelho")
                .marca("finish")
                .preco(10)
                .dataCadastro(LocalDate.now())
                .categoria("Produtos para casa")
                .createProduto();

        System.out.println(produto);

        //nao fucionou o immutables
        //ProdutoImmutables produtoImmutables = new ProdutoImmutablesBuilder()

        ProdutoLombok produtoLombok = ProdutoLombok.builder()
                .id(1)
                .descricao("balde vermelho")
                .marca("finish")
                .preco(10)
                .dataCadastro(LocalDate.now())
                .categoria("Produtos para casa")
                .build();

        System.out.println(produtoLombok);
    }
}
