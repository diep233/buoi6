package net.javaguides.login.bean;

public class ThongTinHocSinh {

    private String hovaten;
    private String lop;

    /**
     * 
     */
    public ThongTinHocSinh() {
	super();
    }

    /**
     * @param hovaten
     * @param lop
     */
    public ThongTinHocSinh(String hovaten, String lop) {
	super();
	this.hovaten = hovaten;
	this.lop = lop;
    }

    /**
     * @return the hovaten
     */
    public String getHovaten() {
	return hovaten;
    }

    /**
     * @param hovaten the hovaten to set
     */
    public void setHovaten(String hovaten) {
	this.hovaten = hovaten;
    }

    /**
     * @return the lop
     */
    public String getLop() {
	return lop;
    }

    /**
     * @param lop the lop to set
     */
    public void setLop(String lop) {
	this.lop = lop;
    }

}
