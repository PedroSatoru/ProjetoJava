package projetobanco.Model;

public class Cotacoes {
    private double btc;
    private double eth;
    private double xrp;

    public Cotacoes(double btc, double eth, double xrp) {
        this.btc = btc;
        this.eth = eth;
        this.xrp = xrp;
    }

    public double getBtc() {
        return btc;
    }

    public void setBtc(double btc) {
        this.btc = btc;
    }

    public double getEth() {
        return eth;
    }

    public void setEth(double eth) {
        this.eth = eth;
    }

    public double getXrp() {
        return xrp;
    }

    public void setXrp(double xrp) {
        this.xrp = xrp;
    }

    @Override
    public String toString() {
        return "Cotacoes{" +
                "btc=" + btc +
                ", eth=" + eth +
                ", xrp=" + xrp +
                '}';
    }
}

