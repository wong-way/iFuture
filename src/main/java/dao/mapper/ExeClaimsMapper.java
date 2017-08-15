package dao.mapper;

import dao.entity.ExeClaims;
import org.springframework.stereotype.Component;

/**
 * Created by DELL on 2017-08-11.
 * 理赔数据处理
 */
@Component
public interface ExeClaimsMapper {
    public void insert(ExeClaims claims);

    public void update(ExeClaims claims);

    public void delete(int clmId);

    public ExeClaims getClaimByUsrId(int id);


}
