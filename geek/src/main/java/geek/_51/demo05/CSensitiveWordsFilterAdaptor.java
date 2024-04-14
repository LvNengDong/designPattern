package geek._51.demo05;

import geek._51.demo04.BSensitiveWordsFilter;
import geek._51.demo04.CSensitiveWordsFilter;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 16:15
 */
public class CSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {

    private CSensitiveWordsFilter cFilter;

    private static final String mask = "***";
    @Override
    public String filter(String text) {
        return cFilter.filter(text, mask);
    }
}
