import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "consumers")
public class Consumer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String name;

    public int getId() {
        return id;
    }

    @OneToMany(mappedBy = "consumer", cascade = CascadeType.ALL)
    private List<GoodsInfo> goodsInfo;

    public List<GoodsInfo> getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(List<GoodsInfo> goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

//    @ManyToMany
//    @JoinTable(
//            name = "purchase_history",
//            joinColumns = @JoinColumn(name = "consumer_id"),
//            inverseJoinColumns = @JoinColumn(name = "good_id")
//
//    )
//    private List<Good> goods;


//    public List<Good> getGoods() {
//        return goods;
//    }
//
//    public void setGoods(List<Good> goods) {
//        this.goods = goods;
//    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Consumer() {
    }

    public Consumer(String name) {
        this.name = name;
    }

    public Consumer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return  name;
    }
}
