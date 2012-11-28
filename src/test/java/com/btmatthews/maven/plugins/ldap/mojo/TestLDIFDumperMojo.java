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

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.codehaus.plexus.util.ReflectionUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * Unit tests for the ldif-dumper plugin goal.
 *
 * @author <a href="mailto:brian.matthews@btmatthews.com">Brian Matthews</a>
 * @version 1.0
 */
public final class TestLDIFDumperMojo extends AbstractLDAPMojoTest {

    @Rule
    public TemporaryFolder outputDirectory = new TemporaryFolder();


    /**
     * Test the configuration for the dsml-dump goal.
     *
     * @throws Exception If something unexpected happens.
     */
    @Test
    public void testDSMLDumper() throws Exception {
        final LDIFDumperMojo mojo = new LDIFDumperMojo();
        ReflectionUtils.setVariableValueInObject(mojo, "outputDirectory", outputDirectory.getRoot());
        ReflectionUtils.setVariableValueInObject(mojo, "host", "localhost");
        ReflectionUtils.setVariableValueInObject(mojo, "port", Integer.valueOf(10389));
        ReflectionUtils.setVariableValueInObject(mojo, "authDn", "uid=admin,ou=system");
        ReflectionUtils.setVariableValueInObject(mojo, "passwd", "secret");
        ReflectionUtils.setVariableValueInObject(mojo, "searchBase", "dc=btmatthews,dc=com");
        ReflectionUtils.setVariableValueInObject(mojo, "filename", "dump.ldif");
        mojo.execute();
        assertTrue(new File(outputDirectory.getRoot(), "dump.ldif").exists());
    }
}
