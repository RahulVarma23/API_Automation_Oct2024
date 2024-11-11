package response;

import lombok.Getter;

import java.util.List;


@Getter
public class Users {

    int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<Data> data;
    private Support support;


}
