package com.example.springdataexample;

import javax.persistence.*;

@Entity(name = "MyCar")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mark;
    @Transient
    private String model;
    @Enumerated(EnumType.STRING) //domyslnie zapisuje BD jako kolejny od 0 nr elementu enuma tutaj black = 2 - jest to strategia EnumType.ORDINAL
    private Color color;

    //encja zawsze musi mieć bezparametrowy konstruktor
    public Car() {
    }

    //jak stworzysz konstruktor parametrowy tylko to wtedy "znika" domyślny bezparametrowy tworzony przez java
    //zawsze jest dobrze dodawać bezparametrowy z ręki
    public Car( String mark, String model, Color color){
        this.mark = mark;
        this.model = model;
        this.color = color;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", color=" + color +
                '}';
    }
}
