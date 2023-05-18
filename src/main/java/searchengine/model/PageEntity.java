package searchengine.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "page")
@Setter
@Getter
@NoArgsConstructor
public class PageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "site_id", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_PAGE_SITE_ID",
                    foreignKeyDefinition = "FOREIGN KEY (site_id) REFERENCES site(id) " +
                            "on delete cascade on update cascade"))
    SiteEntity site;

    @Column(columnDefinition = "TEXT NOT NULL, Index INDEX_PAGE_PATH(path(512))")
    String path;

    @Column(nullable = false)
    Integer code;

    @Column(columnDefinition = "MEDIUMTEXT", nullable = false)
    String content;

    @OneToMany(mappedBy = "page", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<IndexEntity> indexes;
}
