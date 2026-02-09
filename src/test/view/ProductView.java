package test.view;

import test.controller.ProductController;
import test.model.dto.ProductDto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductView {
    private ProductView(){}
    private static final ProductView instance=new ProductView();
    public static ProductView getInstance(){return instance;}

    private ProductController pc=ProductController.getInstance();
    private Scanner scan=new Scanner(System.in);

    public void index() {
        for (; ; ) {
            try {
                System.out.println("1.중고 물품 등록|2.전체 물품 목록 조회ㅣ3.물품 정보 수정ㅣ4.등록 물품 삭제");
                System.out.println("선택 > ");
                int ch = scan.nextInt();
                if (ch == 1) {create();}
                else if (ch == 2) {read();}
                else if (ch == 3) {update();}
                else if (ch == 4) {delete();}
                else {
                    System.out.println("[경고] 없는 기능 번호입니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("[경고] 잘못된 입력 방식입니다. [재입력]");
                scan = new Scanner(System.in);
            } catch (Exception e) {
                System.out.println("[시스템오류] 관리자에게 문의");
            }
        }
    }

    public void create(){
        scan.nextLine();
        System.out.println("판매자 닉네임: "); String pnick=scan.next();
        System.out.println("물품명: "); String pname=scan.next();
        System.out.println("물품설명: "); String pcomment=scan.next();
        System.out.println("물품가격: "); int pprice=scan.nextInt();
        System.out.println("비밀번호(등록용): "); String ppw=scan.next();
        System.out.println("연락처: "); String pphone=scan.next();
        boolean result=pc.create(pnick, pname, pcomment, pprice, ppw, pphone);
        if(result){
            System.out.println("제품등록성공");}
        else{
            System.out.println("제품등록실패");}
    }

    public void read(){
        ArrayList<ProductDto> productDtos=pc.read();
        for(int index=0; index<=productDtos.size()-1; index++){
            ProductDto productDto=productDtos.get(index);
            System.out.printf("물품 번호:%d, 물품명: %s, 물품 가격: %d, 닉네임: %s, 연락처: %s \n",
                    productDto.getPno(), productDto.getPname(), productDto.getPprice(), productDto.getPnick(), productDto.getPphone() );
        }
    }

    public void update(){
        if(ppw.equals(ppw))
        System.out.println("수정할 게시물 번호"); int pno=scan.nextInt();
        scan.nextLine();
        System.out.println("수정할 물품명"); String pname=scan.nextLine();
        System.out.println("수정할 설명"); String pcomment=scan.nextLine();
        System.out.println("수정할 가격"); int pprice=scan.nextInt();
        scan.nextLine();
        System.out.println("수정할 연락처"); String pphone=scan.nextLine();
        boolean result=pc.update(pname, pcomment, pprice, pphone);
        if(result){
            System.out.println("[안내] 게시물 수정 성공");}
        else{
            System.out.println("[경고] 게시물 수정 실패 또는 없는 게시물 번호 입니다.");}
    }

    public void delete(){
        System.out.println("삭제할 게시물 번호");
        int pno=scan.nextInt();
        boolean result=pc.delete(pno);
        if(result){
            System.out.println("[안내] 게시물 삭제 성공");}
        else{
            System.out.println("[경고] 게시물 삭제 실패 또는 없는 게시물 번호 입니다.");}
    }

}
