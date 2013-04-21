package com.github.smtp2006;

import java.util.Iterator;

import org.apache.commons.chain.Catalog;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.config.ConfigParser;
import org.apache.commons.chain.impl.CatalogBase;
import org.apache.commons.chain.impl.CatalogFactoryBase;
import org.apache.commons.chain.impl.ContextBase;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConfigParserTestCase {
    // ------------------------------------------------------------ Statics
    private static final String xml = "test-config.xml";

    // ------------------------------------------------------------ Constructors

    // ------------------------------------------------------ Instance Variables

    /**
     * <p>
     * The <code>Catalog</code> to contain our configured commands.
     * </p>
     */
    protected Catalog catalog = null;

    /**
     * <p>
     * The <code>Context</code> to use for execution tests.
     * </p>
     */
    protected Context context = null;

    /**
     * <p>
     * The <code>ConfigParser</code> instance under test.
     * </p>
     */
    protected ConfigParser parser = null;

    // ---------------------------------------------------- Overall Test Methods

    // ------------------------------------------------ Individual Test Methods
    /**
     * Set up instance variables required by this test case.
     */
    @Before
    public void setUp() {
        catalog = new CatalogBase();
        context = new ContextBase();
        parser = new ConfigParser();
    }

    @Test
    public void testDefaut() throws Exception {
        // Load the default test-config.xml file and examine the results
        load(xml);
        checkCommandCount(3);
    }

    // Load the specified catalog from the specified resource path
    protected void load(String path) throws Exception {
        parser.parse(this.getClass().getClassLoader().getResource(path));
        catalog = CatalogFactoryBase.getInstance().getCatalog();
    }

    // Verify the number of configured commands
    @SuppressWarnings("rawtypes")
    protected void checkCommandCount(int expected) {
        int n = 0;
        Iterator names = catalog.getNames();
        while (names.hasNext()) {
            String name = (String) names.next();
            n++;
            assertNotNull(name + " exists", catalog.getCommand(name));
        }
        assertEquals("Correct command count", expected, n);
    }
}
