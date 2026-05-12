import java.util.function.Predicate;

public class CondicaoFiltrarPedido implements Predicate<Pedido> {

    private String descricaoProduto;

    public CondicaoFiltrarPedido(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    @Override
    public boolean test(Pedido pedido) {
        ItemDePedido item = pedido.getItensDoPedido().buscarPor(
                new CriterioDeBuscaPorDescricao(descricaoProduto),
                null);
        return item != null;
    }
}
