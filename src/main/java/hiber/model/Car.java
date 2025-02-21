package hiber.model;


import javax.persistence.*;
@Entity
@Table(name = "cars")
public class Car {
    public Car() {

    }

    public Car(String model, int serial) {
        this.model = model;
        this.serial = serial;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="serial",unique=true)
    private int serial;

    @Column(name = "model")
    private String model;


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", serial=" + serial +
                ", model='" + model + '\'' +
                '}';
    }
}
