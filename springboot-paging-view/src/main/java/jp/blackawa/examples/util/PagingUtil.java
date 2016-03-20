package jp.blackawa.examples.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PagingUtil {
    /**
     *
     * @param currentPageNum 表示しようとしているページ番号
     * @param totalRecordNum 全件数
     * @param recordPerPage 1ページに表示するレコード数
     * @param length ページングのリスト長
     * @param params 現在の、ページ情報以外の検索条件のMap
     * @return ビューに渡せば描画してくれるページネーションのオブジェクト
     */
    public static PagingView generatePagingView(
            int currentPageNum,
            int totalRecordNum,
            int recordPerPage,
            int length,
            Map<String, String> params
    ) {
        String baseQueryString = toQueryString(params);
        String preAppendPageNum = baseQueryString + "&page=";

        PagingView pagingView = new PagingView();

        pagingView.setTotalRecordNum(totalRecordNum);
        pagingView.setFromRecordNum((currentPageNum - 1) * recordPerPage + 1);
        // 終端のページを表示する時はその終端の件数を出す
        pagingView.setToRecordNum(currentPageNum * recordPerPage < totalRecordNum ? currentPageNum * recordPerPage : totalRecordNum);
        pagingView.setRecordPerPage(recordPerPage);
        pagingView.setCurrentPageNum(currentPageNum);

        pagingView.setCanGoFirst(currentPageNum != 1);
        pagingView.setFirstHref(preAppendPageNum + 1);

        int totalPageNum = (int) Math.ceil((double) totalRecordNum / (double) recordPerPage);
        pagingView.setCanGoLast(currentPageNum != totalPageNum);
        pagingView.setLastHref(preAppendPageNum + totalPageNum);

        pagingView.setCanGoPrevious(currentPageNum != 1);
        pagingView.setPreviousHref(preAppendPageNum + (currentPageNum - 1));

        pagingView.setCanGoNext(currentPageNum != totalPageNum);
        pagingView.setNextHref(preAppendPageNum + (currentPageNum + 1));

        pagingView.setPagingViewElements(generatePagingViewElements(currentPageNum, totalPageNum, length, preAppendPageNum));

        return pagingView;
    }

    /**
     * Mapをクエリストリングに変換する。
     * もしMapが空の場合、"?"のみを返却する。
     * @param params クエリストリングの要素Map
     * @return 生成されたクエリストリング
     */
    protected static String toQueryString(Map<String, String> params) {
        // TODO URLエンコーディング？
        return "?" + params.entrySet().stream().map(Object::toString).collect(Collectors.joining("&"));
    }

    /**
     * 現在のページがなるべく中央にくるようにページングのリストを生成する。
     * @param currentPageNum 現在のページ番号
     * @param totalPageNum 最終ページ番号
     * @param length 表示するリストの長さ
     * @param preAppendPageNum ページ番号を末尾に連結すれば正常なクエリストリングになる文字列(ex. ?foo=bar&page=)
     * @return ページングのリスト
     */
    protected static List<PagingViewElement> generatePagingViewElements(
            int currentPageNum,
            int totalPageNum,
            int length,
            String preAppendPageNum
    ) {
        /* 偶数個のリストが要求された場合は現在のページが前寄せになる。
           例) [] がついているのが現在ページ
             << < 1 2 [3] 4 5 6 > >>
        */
        int backSpan = (length - 1) / 2;
        int forthSpan = (length - 1) - backSpan;

        int startIndex;
        int endIndex;

        if (currentPageNum - backSpan < 1) {
            // 表示幅に従うと存在しないページ(0ページ以下)が生成されるので、1ページから始める
            startIndex = 1;
            endIndex = length < totalPageNum ? length : totalPageNum;
        } else if (currentPageNum + forthSpan > totalPageNum) {
            // 表示幅に従うと存在しないページ(最終ページ以降)が生成されるので、表示領域を最終ページから逆算する
            startIndex = totalPageNum - (length - 1) > 1 ? totalPageNum - (length - 1) : 1;
            endIndex = totalPageNum;
        } else {
            // その間なので、中央にcurrentPageNumがくるように配置する。
            // ページのリストの端に当たっていないので、単純に中央にくるような両端を考えればよい。
            startIndex = currentPageNum - backSpan;
            endIndex = currentPageNum + forthSpan;
        }
        return IntStream.range(startIndex, endIndex + 1)
                .mapToObj(n -> new PagingViewElement(String.valueOf(n), preAppendPageNum + n))
                .collect(Collectors.toList());
    }
}
