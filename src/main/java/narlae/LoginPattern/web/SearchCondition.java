package narlae.LoginPattern.web;

import lombok.Data;
import org.springframework.web.util.UriComponentsBuilder;

@Data
public class SearchCondition {

    private String keyword = "";
    private String option = "";
    private Integer page = 1;
    private Integer pageSize = 20;

    public String getQueryString(Integer page) {
        return UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("pageSize", pageSize)
                .queryParam("option", option)
                .queryParam("keyword", keyword)
                .build().toString();
    }
}
