package dao.mapper;

import dao.entity.SchRoll;

/**
 * Created by DELL on 2017-08-12.
 */
public interface SchRollMapper {
    void insert(SchRoll schRoll);

    void update(SchRoll schRoll);

    void delete(int usrId);

    SchRoll getRollById(int usrId);
}
