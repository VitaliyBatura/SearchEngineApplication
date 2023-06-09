package searchengine.dto.searching;

import lombok.Data;

@Data
public class SearchData {

    private Float relevance;

    private String site;

    private String siteName;

    private String uri;

    private String title;

    private String snippet;
}
