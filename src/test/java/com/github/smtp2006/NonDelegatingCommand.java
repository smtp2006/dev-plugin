package com.github.smtp2006;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

/**
 * <p>
 * Implementation of {@link Command} that simply logs its identifier and
 * returns.
 * </p>
 * 
 * @author Craig R. McClanahan
 * @version $Revision: 480477 $ $Date: 2006-11-29 08:34:52 +0000 (Wed, 29 Nov
 *          2006) $
 */

public class NonDelegatingCommand implements Command {

    // ------------------------------------------------------------ Constructor

    public NonDelegatingCommand() {
        this("");
    }

    // Construct an instance that will log the specified identifier
    public NonDelegatingCommand(String id) {
        this.id = id;
    }

    // ----------------------------------------------------- Instance Variables

    // The identifier to log for this Command instance
    protected String id = null;

    String getId() {
        return (this.id);
    }

    public void setId(String id) {
        this.id = id;
    }

    // -------------------------------------------------------- Command Methods

    // Execution method for this Command
    public boolean execute(Context context) throws Exception {

        if (context == null) {
            throw new IllegalArgumentException();
        }
        log(context, id);
        return (true);

    }

    // ------------------------------------------------------ Protected Methods

    /**
     * <p>
     * Log the specified <code>id</code> into a StringBuffer attribute named
     * "log" in the specified <code>context</code>, creating it if necessary.
     * </p>
     * 
     * @param context
     *            The {@link Context} into which we log the identifiers
     * @param id
     *            The identifier to be logged
     */
    protected void log(Context context, String id) {
        StringBuffer sb = (StringBuffer) context.get("log");
        if (sb == null) {
            sb = new StringBuffer();
            context.put("log", sb);
        }
        if (sb.length() > 0) {
            sb.append('/');
        }
        sb.append(id);
    }

}
