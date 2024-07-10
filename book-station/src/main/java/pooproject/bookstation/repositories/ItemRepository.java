package pooproject.bookstation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pooproject.bookstation.domain.item.Item;

public interface ItemRepository extends JpaRepository<Item, String> {
}
