package test.controller;

import test.model.dao.ProductDao;
import test.model.dto.ProductDto;

import java.util.ArrayList;

public class ProductController {
    private ProductController(){}
    private static final ProductController instance=new ProductController();
    public static ProductController getInstance(){return instance;}

    private ProductDao pd=ProductDao.getInstance();

    public boolean create(String pnick, String pname, String pcomment, int pprice, String ppw, String pphone){
        boolean result=pd.create(pnick, pname, pcomment, pprice, ppw, pphone);
        return result;
    }

    public ArrayList<ProductDto> read(){
        ArrayList<ProductDto> result=pd.read();
        return result;
    }

    public boolean update(String pname, String pcomment, int pprice, String pphone){
        boolean result=pd.update(pname, pcomment, pprice, pphone);
        return result;
    }

    public boolean delete(int pno){
        boolean result=pd.delete(pno);
        return result;
    }
}
