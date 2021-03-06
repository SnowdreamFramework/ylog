package com.github.snowdream.util.log

import android.content.Context
import com.github.snowdream.toybricks.annotation.Interface
import com.github.snowdream.util.log.transform.AbstractLogTransform


/**
 * Created by snowdream on 17/4/20.
 */
@Interface
interface ILog {
    /**
     * set Log option
     *
     * @param option
     */
    fun setOption(option: LogOption)

    /**
     * quick way to set the default option
     *
     * @param context context
     *
     * @param console  enable log 2 console
     *
     * @param file  enable log 2 file
     */
    fun setOption(context: Context, console: Boolean = true, file: Boolean = false)

    /**
     * Send a {@link #VERBOSE} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    fun v(tag: String, msg: String, tr: Throwable? = null)

    /**
     * Send a {@link #VERBOSE} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    fun v(tag: String, msg: String)

    /**
     * Send a {@link #DEBUG} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    fun d(tag: String, msg: String, tr: Throwable? = null)

    /**
     * Send a {@link #DEBUG} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    fun d(tag: String, msg: String)

    /**
     * Send a {@link #INFO} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    fun i(tag: String, msg: String, tr: Throwable? = null)

    /**
     * Send a {@link #INFO} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    fun i(tag: String, msg: String)

    /**
     * Send a {@link #WARN} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    fun w(tag: String, msg: String, tr: Throwable? = null)

    /**
     * Send a {@link #WARN} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    fun w(tag: String, msg: String)

    /**
     * Checks to see whether or not a log for the specified tag is loggable at the specified level.

     * The default level of any tag is set to INFO. This means that any level above and including
     * INFO will be logged. Before you make any calls to a logging method you should check to see
     * if your tag should be logged. You can change the default level by setting a system property:
     * 'setprop log.tag.&lt;YOUR_LOG_TAG> &lt;LEVEL>'
     * Where level is either VERBOSE, DEBUG, INFO, WARN, ERROR, ASSERT, or SUPPRESS. SUPPRESS will
     * turn off all logging for your tag. You can also create a local.prop file that with the
     * following in it:
     * 'log.tag.&lt;YOUR_LOG_TAG>=&lt;LEVEL>'
     * and place that in /data/local.prop.

     * @param tag The tag to check.
     * *
     * @param level The level to check.
     * *
     * @return Whether or not that this is allowed to be logged.
     * *
     * @throws IllegalArgumentException is thrown if the tag.length() > 23.
     */
    fun isLoggable(tag: String, level: Int): Boolean

    /*
     * Send a {@link #WARN} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param tr An exception to log
     */
    fun w(tag: String, tr: Throwable)

    /**
     * Send a [.ERROR] log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     * *        the class or activity where the log call occurs.
     * *
     * @param msg The message you would like logged.
     * *
     * @param tr An exception to log
     */
    fun e(tag: String, msg: String, tr: Throwable? = null)

    /**
     * Send a [.ERROR] log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     * *        the class or activity where the log call occurs.
     * *
     * @param msg The message you would like logged.
     * *
     */
    fun e(tag: String, msg: String)

    /**
     * What a Terrible Failure: Report an exception that should never happen.
     * Similar to [.wtf], with an exception to log.
     * @param tag Used to identify the source of a log message.
     * *
     * @param tr An exception to log.
     */
    fun wtf(tag: String, tr: Throwable)

    /**
     * What a Terrible Failure: Report an exception that should never happen.
     * Similar to [.wtf], with a message as well.
     * @param tag Used to identify the source of a log message.
     * *
     * @param msg The message you would like logged.
     * *
     * @param tr An exception to log.  May be null.
     */
    fun wtf(tag: String, msg: String, tr: Throwable? = null)

    /**
     * What a Terrible Failure: Report an exception that should never happen.
     * Similar to [.wtf], with a message as well.
     * @param tag Used to identify the source of a log message.
     * *
     * @param msg The message you would like logged.
     * *
     */
    fun wtf(tag: String, msg: String)

    /**
     * Send a {@link #INFO} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param obj The object you would like logged.
     * @param transform An transform to log
     */
    fun obj(tag: String, obj: Any, transform: AbstractLogTransform)

    /**
     * Send a {@link #INFO} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    fun json(tag: String, msg: String)

    /**
     * Send a {@link #INFO} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    fun xml(tag: String, msg: String)

    /**
     * Handy function to get a loggable stack trace from a Throwable
     * @param tr An exception to log
     */
    fun getStackTraceString(tr: Throwable?): String

    /**
     * Low-level logging call.
     * @param priority The priority/type of this log message
     * *
     * @param tag Used to identify the source of a log message.  It usually identifies
     * *        the class or activity where the log call occurs.
     * *
     * @param msg The message you would like logged.
     * *
     * @return The number of bytes written.
     */
    fun println(priority: Int, tag: String, msg: String)
}