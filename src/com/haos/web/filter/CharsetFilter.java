package com.haos.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 瀛楃闆嗙紪鐮�Fileter
 * User: YinWei
 * Date: 2011-8-2
 * Time: 17:55:03
 */
public class CharsetFilter implements Filter {
    private final static Log log = LogFactory.getLog(CharsetFilter.class);
    public static final String DEFAULT_CHARSET_VALUE = "gbk";
    private Pattern inputCharsetPattern;
    private String defaultCharset;


    public void init(FilterConfig filterConfig) throws ServletException {
        inputCharsetPattern = Pattern.compile("_charset_=([\\w-]+)", Pattern.CASE_INSENSITIVE);
        //浠庨厤缃枃浠朵腑鑾峰彇鍒濆鍖栧弬鏁�
        if (null != filterConfig) {
            String charset = filterConfig.getInitParameter("defaultCharset");
            if (null != charset) {
                this.defaultCharset = charset;
            }
        }
        if (defaultCharset == null) {
            defaultCharset = DEFAULT_CHARSET_VALUE;
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        try {
            // 璇曞浘浠巕ueryString涓彇寰梚nputCharset
            String queryString = request.getQueryString();
            if (queryString != null) {
                Matcher matcher = inputCharsetPattern.matcher(queryString);

                if (matcher.find()) {
                    MatchResult matchResult = matcher.toMatchResult();
                    String charset = matchResult.group(1);
                    request.setCharacterEncoding(charset);
                    request.getParameterNames();
                    log.debug("Set INPUT charset to " + charset);
                }
            } else {
                request.setCharacterEncoding(defaultCharset);
            }
        } catch (UnsupportedEncodingException e) {
            try {
                request.setCharacterEncoding(defaultCharset);

            } catch (UnsupportedEncodingException ee) {
                log.error("Failed to set INPUT charset to " + defaultCharset, e);
            }
        }

        chain.doFilter(request, response);

    }

    public void destroy() {


    }


}
