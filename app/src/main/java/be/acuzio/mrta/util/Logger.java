package be.acuzio.mrta.util;

import android.util.Log;

/**
 * Created by vandekr on 16/06/14.
 */
public final class Logger {
    /**
     * A wrapper for the Log.d function
     * <p/>
     * e.g. <code>
     * Logger.d(TAG, "Batman goes like %d, %d, %d, \"%s\"", 1, 2, 3, "Pow!");
     * //prints: Batman goes like 1, 2, 3, "Pow!"
     * Logger.d(TAG, "Holy Cows Batman!");
     * //prints: Holy Cows Batman!
     * </code>
     *
     * @param tag     The tag used in the logcat
     * @param message The message, which can be formatted according to String.format
     * @param args    The arguments, optional
     */
    public static void d(String tag, String message, Object... args) {
        Log.d(tag, String.format(message, args));
    }

    /**
     * A wrapper for the Log.i function
     * <p/>
     * e.g. <code>
     * Logger.i(TAG, "Batman goes like %d, %d, %d, \"%s\"", 1, 2, 3, "Pow!");
     * //prints: Batman goes like 1, 2, 3, "Pow!"
     * Logger.i(TAG, "Holy Cows Batman!");
     * //prints: Holy Cows Batman!
     * </code>
     *
     * @param tag     The tag used in the logcat
     * @param message The message, which can be formatted according to String.format
     * @param args    The arguments, optional
     */
    public static void i(String tag, String message, Object... args) {
        Log.i(tag, String.format(message, args));
    }

    /**
     * A wrapper for the Log.e function
     * <p/>
     * e.g.
     * <code>
     * try {
     * ...
     * throw new Exception("Holy Cow Batman!");
     * } catch(Exception e) {
     * Logger.e("MyTag", e);
     * //prints:
     * // ...  E/MyTag﹕ Holy Cows Batman!
     * //           java.lang.Exception: Holy Cows Batman!
     * //           at ...
     * //           at ...
     * }
     * </code>
     *
     * @param tag The tag used in the logcat
     * @param e   The exception
     */
    public static void e(String tag, Exception e) {
        Log.e(tag, e.getMessage(), e);
    }

    public static void e(String tag, String message, Exception e) {
        Log.e(tag, message, e);
    }


}

