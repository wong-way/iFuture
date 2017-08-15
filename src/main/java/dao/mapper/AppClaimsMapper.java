package dao.mapper;

import dao.entity.AppClaims;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DELL on 2017-08-11.
 */
@Component
public interface AppClaimsMapper {
    public void insert(AppClaims appClaims);

    public void update(AppClaims appClaims);

    public void delete(int id);

    public AppClaims getAppClaimById(int id);
    public List<AppClaims> getAppClaimByUsrId(int Usrid);
    public List<AppClaims> getAllAppClaims();
}
