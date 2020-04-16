package br.com.liandro.entities;

import br.com.liandro.entities.pk.OrdemItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
@NoArgsConstructor
public class OrdemItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrdemItemPK id = new OrdemItemPK();

    @Getter @Setter
    private Integer quantity;
    @Getter @Setter
    private Double price;

    public OrdemItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemItem ordemItem = (OrdemItem) o;
        return id.equals(ordemItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
