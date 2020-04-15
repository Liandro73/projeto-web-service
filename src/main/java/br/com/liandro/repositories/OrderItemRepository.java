package br.com.liandro.repositories;

import br.com.liandro.entities.OrdemItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrdemItem, Long> {

}