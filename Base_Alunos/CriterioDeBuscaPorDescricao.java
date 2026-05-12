import java.util.Comparator;

public class CriterioDeBuscaPorDescricao implements Comparator<ItemDePedido> {

    private String descricaoProcurada;

    public CriterioDeBuscaPorDescricao(String descricaoProcurada) {
        this.descricaoProcurada = descricaoProcurada;
    }

    @Override
    public int compare(ItemDePedido item, ItemDePedido outro) {
        if (item.getProduto().descricao.equals(descricaoProcurada)) {
            return 0;
        }
        return 1;
    }
}
