package test.model.dto;

public class ProductDto {
    private int pno;
    private String pnick;
    private String pname;
    private String pcomment;
    private int pprice;
    private String ppw;
    private String pphone;

    public ProductDto(int pno, String pnick, int pprice, String ppw, String pphone) {
        this.pno = pno;
        this.pnick = pnick;
        this.pname = pname;
        this.pcomment = pcomment;
        this.pprice = pprice;
        this.ppw = ppw;
        this.pphone = pphone;
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public String getPnick() {
        return pnick;
    }

    public void setPnick(String pnick) {
        this.pnick = pnick;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPcomment() {
        return pcomment;
    }

    public void setPcomment(String pcomment) {
        this.pcomment = pcomment;
    }

    public int getPprice() {
        return pprice;
    }

    public void setPprice(int pprice) {
        this.pprice = pprice;
    }

    public String getPpw() {
        return ppw;
    }

    public void setPpw(String ppw) {
        this.ppw = ppw;
    }

    public String getPphone() {
        return pphone;
    }

    public void setPphone(String pphone) {
        this.pphone = pphone;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "pno=" + pno +
                ", pnick='" + pnick + '\'' +
                ", pname='" + pname + '\'' +
                ", pcomment='" + pcomment + '\'' +
                ", pprice=" + pprice +
                ", ppw='" + ppw + '\'' +
                ", pphone='" + pphone + '\'' +
                '}';
    }
}
