/*
 * Sonar PL/SQL Plugin (Community)
 * Copyright (C) 2015 Felipe Zorzo
 * felipe.b.zorzo@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package br.com.felipezorzo.sonar.plsql.statements;

import static org.sonar.sslr.tests.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.felipezorzo.sonar.plsql.api.PlSqlGrammar;
import br.com.felipezorzo.sonar.plsql.api.RuleTest;

public class RollbackStatementTest extends RuleTest {

    @Before
    public void init() {
        setRootRule(PlSqlGrammar.ROLLBACK_STATEMENT);
    }
    
    @Test
    public void matchesSimpleRollback() {
        assertThat(p).matches("rollback;");
    }
    
    @Test
    public void matchesRollbackWork() {
        assertThat(p).matches("rollback work;");
    }
    
    @Test
    public void matchesRollbackForce() {
        assertThat(p).matches("rollback force 'test';");
    }
    
    @Test
    public void matchesRollbackToSavepoint() {
        assertThat(p).matches("rollback to save;");
    }
    
    @Test
    public void matchesRollbackToSavepointAlternative() {
        assertThat(p).matches("rollback to savepoint save;");
    }
    
    @Test
    public void matchesLongRollbackStatement() {
        assertThat(p).matches("rollback work to savepoint save;");
    }
    
    @Test
    public void matchesLabeledRollback() {
        assertThat(p).matches("<<foo>> rollback;");
    }

}