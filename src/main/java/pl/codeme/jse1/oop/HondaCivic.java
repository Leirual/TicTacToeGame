package pl.codeme.jse1.oop;

public class HondaCivic extends Honda implements WersjaTypeR {

    public HondaCivic() {
        super(1800, 1000);
    }

    public void typeR(int predkosc) {
        this.predkosc += predkosc;
    }

}
