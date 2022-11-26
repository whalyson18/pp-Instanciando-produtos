package Builder;

import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

import java.time.LocalDate;
@ToString
public class Produto {
    private long id;
    private String codigoEan;
    private String descricao;
    private String marca;
    private String modelo;
    private double preco;
    private LocalDate dataCadastro;
    private LocalDate dataUltimaAtualizacao;
    private int estoque = 0;
    private String categoria;
    private String urlFoto;

    Produto(long id, String codigoEan, String descricao, String marca, String modelo, double preco, LocalDate dataCadastro, LocalDate dataUltimaAtualizacao, int estoque, String categoria, String urlFoto) {
        this.setId(id);
        this.setCodigoEan(codigoEan);
        this.setDescricao(descricao);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setPreco(preco);
        this.setDataCadastro(dataCadastro);
        this.setDataUltimaAtualizacao(dataUltimaAtualizacao);
        this.setEstoque(estoque);
        this.setCategoria(categoria);
        this.setUrlFoto(urlFoto);
    }

    public long getId() {
        return id;
    }

    public final void setId(long id) {
        if (id == 0)
            throw new IllegalArgumentException("Campo id não pode ser nulo.");
        this.id = id;
    }

    public String getCodigoEan() {
        return codigoEan;
    }

    public void setCodigoEan(String codigoEan) {
        this.codigoEan = codigoEan;
    }

    public String getDescricao() {
        return descricao;
    }

    public final void setDescricao(String descricao) {
        if (descricao == null || descricao.isEmpty())
            throw new IllegalArgumentException("Campo descricao não pode ser nulo.");
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public final void setMarca(String marca) {
        if (marca == null || marca.isEmpty())
            throw new IllegalArgumentException("Campo marca não pode ser nulo.");

        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public final void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public final void setPreco(double preco) {
        if (preco < 0)
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        if (preco == 0)
            throw new IllegalArgumentException("O preço nao pode ser nulo.");
        this.preco = preco;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public final void setDataCadastro(LocalDate dataCadastro) {
        if (this.dataCadastro != null)
            throw new IllegalArgumentException("A data de cadastro nao pode ser editada.");

        this.dataCadastro = dataCadastro == null
            ? LocalDate.now()
            : dataCadastro;
    }

    public LocalDate getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
        if (dataUltimaAtualizacao != null){
            if (dataCadastro.isAfter(dataUltimaAtualizacao))
                throw new IllegalArgumentException("A data da última atualização não pode ser anterior a data de cadastro.");
        }

        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        if (estoque < 0)
            throw new IllegalArgumentException("Não pode ser atribuído valor negativo.");

        this.estoque = estoque;
    }

    public String getCategoria() {
        return categoria;
    }

    public final void setCategoria(String categoria) {
        if (categoria == null)
            throw new IllegalArgumentException("Campo categoria não pode ser nulo.");

        this.categoria = categoria;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }



}
