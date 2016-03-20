package jp.blackawa.examples.util;

import lombok.Data;

import java.util.List;

@Data
public class PagingView {
    private int totalRecordNum;
    private int fromRecordNum;
    private int toRecordNum;

    private int currentPageNum;

    private int recordPerPage;

    private boolean canGoNext;
    private String nextHref;

    private boolean canGoPrevious;
    private String previousHref;

    private boolean canGoLast;
    private String lastHref;

    private boolean canGoFirst;
    private String firstHref;

    private List<PagingViewElement> pagingViewElements;
}

