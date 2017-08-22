package service;

import dao.entity.SchRoll;
import dto.response.Response;

/**
 * Created by DELL on 2017-08-21.
 */
public interface SchRollService {
    Response insert(SchRoll roll);

    Response update(SchRoll roll);

    Response delete(int usrId);

    Response getUserSchRoll(int usrId);
}
