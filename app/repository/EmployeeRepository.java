package repository;

import io.ebean.Finder;
import io.ebean.RawSql;
import io.ebean.RawSqlBuilder;
import models.Employee;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class EmployeeRepository {

    private static Finder<Long, Employee> finder = new Finder<>(Employee.class);

    public List<Employee> getById(final String id) {
        final RawSql rawSql = RawSqlBuilder.parse("SELECT id, name, passport FROM employee WHERE id = " + id)
                .create();

        return finder.query()
                .setRawSql(rawSql)
                .findList();
    }

    public List<Employee> getByIdSecured(final String id) {
        final RawSql rawSql = RawSqlBuilder.parse("SELECT id, name, passport FROM employee WHERE id = ?")
                .create();

        return finder.query()
                .setParameter(1, id)
                .setRawSql(rawSql)
                .findList();
    }

}
