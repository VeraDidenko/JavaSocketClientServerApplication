package com.db.daoJdbc;

import com.db.model.Discipline;

public interface DisciplineDAO {

    Discipline save(Discipline discipline);
    void update(Discipline discipline);
    Discipline get(Integer id);
    void delete(Integer id);


}
