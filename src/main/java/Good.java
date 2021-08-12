import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "goods")
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String name;

    @Column
    int price;

    public Good() {
    }

    @OneToMany(mappedBy = "good", cascade = CascadeType.ALL)
    private List<GoodsInfo> goodsInfo;

    public List<GoodsInfo> getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(List<GoodsInfo> goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public Good(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
