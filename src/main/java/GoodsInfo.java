import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "purchase_history")
public class GoodsInfo {

    @Embeddable
    public static class Id implements Serializable {
        int consumerid;
        int goodid;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Id id = (Id) o;
            return consumerid == id.consumerid && goodid == id.goodid;
        }

        @Override
        public int hashCode() {
            return consumerid + goodid;
        }

        public int getConsumerid() {
            return consumerid;
        }

        public void setConsumerid(int consumerid) {
            this.consumerid = consumerid;
        }

        public int getGoodid() {
            return goodid;
        }

        public void setGoodid(int goodid) {
            this.goodid = goodid;
        }
    }


    @EmbeddedId
    Id id = new Id();

    @ManyToOne
    @MapsId("consumerid")
    @JoinColumn(name = "consumer_id")
    Consumer consumer;

    @ManyToOne
    @MapsId("goodid")
    @JoinColumn(name = "good_id")
    Good good;


    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public GoodsInfo() {
    }


    @Column
    int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Id getId() {
        return id;
    }


    public void setId(Id id) {
        this.id = id;
    }


    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    @Override
    public String toString() {
        return good.getName() + " price=" + price;
    }
}
