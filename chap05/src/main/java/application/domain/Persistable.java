package application.domain;

import java.time.Instant;

/**
 * User : Seungho Lee ( seung7642@gmail.com )
 * Date : 2020.05.03
 * Time : 16:50
 */
public interface Persistable {

    Integer getId();
    void setId(Integer id);
    Instant getCreateTimestamp();
    void setCreateTimestamp(Instant instant);
}
