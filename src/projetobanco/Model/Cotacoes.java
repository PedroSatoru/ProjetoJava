package projetobanco.Model;

/**
 *
 * @author Pedro Satoru
 */
public class Cotacoes {
    //recebe tods os valores de todas as criptos
    private double btc;
    private double eth;
    private double xrp;

    /**
     *
     * @param btc
     * @param eth
     * @param xrp
     */
    public Cotacoes(double btc, double eth, double xrp) {
        this.btc = btc;
        this.eth = eth;
        this.xrp = xrp;
    }

    /**
     *
     * @return
     */
    public double getBtc() {
        return btc;
    }

    /**
     *
     * @param btc
     */
    public void setBtc(double btc) {
        this.btc = btc;
    }

    /**
     *
     * @return
     */
    public double getEth() {
        return eth;
    }

    /**
     *
     * @param eth
     */
    public void setEth(double eth) {
        this.eth = eth;
    }

    /**
     *
     * @return
     */
    public double getXrp() {
        return xrp;
    }

    /**
     *
     * @param xrp
     */
    public void setXrp(double xrp) {
        this.xrp = xrp;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Cotacoes{" +
                "btc=" + btc +
                ", eth=" + eth +
                ", xrp=" + xrp +
                '}';
    }
}

