/*
 * Copyright 2008-2011 Brian Thomas Matthews
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.btmatthews.maven.plugins.ldap.mojo;

import java.io.File;

import org.codehaus.plexus.util.ReflectionUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the ldif-loader plugin goal.
 *
 * @author <a href="mailto:brian.matthews@terranua.com">Brian Matthews</a>
 * @version 1.0
 */
public final class TestLDIFLoaderMojo extends AbstractLDAPMojoTest {

    private LDIFLoaderMojo mojo = new LDIFLoaderMojo();

    @Before
    public void setUp() throws Exception {
        super.setUp();
        ReflectionUtils.setVariableValueInObject(mojo, "host", "localhost");
        ReflectionUtils.setVariableValueInObject(mojo, "port", Integer.valueOf(10389));
        ReflectionUtils.setVariableValueInObject(mojo, "authDn", "uid=admin,ou=system");
        ReflectionUtils.setVariableValueInObject(mojo, "passwd", "secret");
    }

    @Test
    public void testAddLDIF() throws Exception {
        ReflectionUtils.setVariableValueInObject(mojo, "ldapFiles", new File[]{ getFile("/add.ldif") });
        ReflectionUtils.setVariableValueInObject(mojo, "continueOnError", Boolean.FALSE);
        mojo.execute();
    }

    @Test
    public void testModifyLDIF() throws Exception {
        ReflectionUtils.setVariableValueInObject(mojo, "ldapFiles", new File[]{ getFile("/modify.ldif") });
        ReflectionUtils.setVariableValueInObject(mojo, "continueOnError", Boolean.FALSE);
        mojo.execute();
    }

    @Test
    public void testDeleteLDIF() throws Exception {
        ReflectionUtils.setVariableValueInObject(mojo, "ldapFiles", new File[]{ getFile("/delete.ldif") });
        ReflectionUtils.setVariableValueInObject(mojo, "continueOnError", Boolean.FALSE);
        mojo.execute();
    }
}
