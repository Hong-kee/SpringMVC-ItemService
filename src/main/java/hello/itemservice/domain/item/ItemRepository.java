package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>(); //static
    private static long sequence = 0L; //static

    //값 저장
    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    //조회
    public Item findById(Long id) {
        return store.get(id);
    }

    //전체 조회
    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    //업데이트
    //규모가 updateParamDto를 만드는게 낫다. Id를 update하지 않으니까.
    //명확성 vs 중복이면 명확성을 따르자.
    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    //초기화
    public void clearStore() {
        store.clear();
    }
}
