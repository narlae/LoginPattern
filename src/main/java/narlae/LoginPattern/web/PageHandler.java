package narlae.LoginPattern.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageHandler {
    private SearchCondition sc;
    private int totalCnt;
    private int totalPage;
    private int beginPage;
    private int endPage;
    private boolean showPrev;
    private boolean showNext;
    private int naviSize = 10;

    public PageHandler(int totalCnt, SearchCondition sc) {
        this.totalCnt = totalCnt;
        this.sc = sc;

        doPaging(totalCnt, sc);
    }

    public void doPaging(int totalCnt, SearchCondition sc) {
        this.totalCnt = totalCnt;

        totalPage = (int) Math.ceil(totalCnt / (double) sc.getPageSize());
        beginPage = (sc.getPage()-1)/naviSize*naviSize +1;
        endPage = Math.min(beginPage + naviSize - 1, totalPage);
        showPrev = beginPage != 1;
        showNext = endPage != totalPage;
    }

}
