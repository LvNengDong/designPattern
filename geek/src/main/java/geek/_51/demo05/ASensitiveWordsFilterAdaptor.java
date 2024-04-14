package geek._51.demo05;

import geek._51.demo04.ASensitiveWordsFilter;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 16:15
 */
public class ASensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {

    private ASensitiveWordsFilter aFilter;

    @Override
    public String filter(String text) {
        String maskedText = aFilter.filterSexyWords(text);
        maskedText = aFilter.filterPoliticalWords(maskedText);
        return maskedText;
    }
}
