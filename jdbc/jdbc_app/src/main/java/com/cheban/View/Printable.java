package com.cheban.View;

import java.sql.SQLException;

/**
 * Created by MAX on 20.02.2018.
 */

@FunctionalInterface
public interface Printable {
    void print() throws SQLException;
}
