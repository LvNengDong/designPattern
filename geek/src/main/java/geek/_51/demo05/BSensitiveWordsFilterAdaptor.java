package geek._51.demo05;

import geek._51.demo04.ASensitiveWordsFilter;
import geek._51.demo04.BSensitiveWordsFilter;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 16:15
 */
public class BSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {

    private BSensitiveWordsFilter bFilter;

    @Override
    public String filter(String text) {
        return bFilter.filter(text);
    }
}
