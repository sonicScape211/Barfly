package edu.wou.jmozingo12.barfly.data;

import android.content.ContentValues;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by jmozi on 3/13/2018.
 */

public class BreweriesContentContract {
    /**
     * The authority of the notes content provider - this must match the authority
     * specified in the AndroidManifest.xml provider section
     */
    public static final String AUTHORITY = "edu.wou.jmozingo12.barfly.provider";

    /**
     * The content URI for the top-level notes authority
     */
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    /**
     * Constraints for the Breweries Table
     */
    public static final class Breweries implements BaseColumns {

        public static final String TABLE_NAME = "breweries";

        public static final String _ID = "id";

        public static final String NAME = "name";

        public static final String LOCATION = "location";

        /**
         * Projects all columns of the database.
         */
        public static final String[] PROJECTION_ALL = {
                _ID,
                NAME,
                LOCATION
        };
    }

}
