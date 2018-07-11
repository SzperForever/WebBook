package book.vo;

import book.model.Book;

import java.util.ArrayList;
import java.util.HashMap;

public class PageJson {
    private int size;
    private int page;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }
    public Integer createStart(){
        return (this.page-1) * size;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public static HashMap<String, Integer> pageInfo(PageJson pageJson){

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("start", pageJson.createStart());
        hashMap.put("end", pageJson.getSize());
        return hashMap;
    }

}
