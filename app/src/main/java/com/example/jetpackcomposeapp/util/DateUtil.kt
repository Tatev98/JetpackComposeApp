package com.example.jetpackcomposeapp.util


object DateUtil {
    private const val SECOND = 1
    private const val MINUTE = 60 * SECOND
    private const val HOUR = 60 * MINUTE
    private const val DAY = (24 * HOUR).toLong()
    private const val WEEK = (7 * DAY)
    private const val MONTH = (30 * DAY)
    private const val YEAR = (365 * DAY)

    fun getIntervalAgoSinceNow(interval: Long): String {
        when {
            interval < 1 * MINUTE -> {
                return "just now"
            }
            interval < 2 * MINUTE -> {
                return " a minute ago"
            }
            interval <= 45 * MINUTE -> {
                return (interval / MINUTE).toString() + " minutes ago"
            }
            interval <= 90 * MINUTE -> {
                return "an hour ago"
            }
            interval < 3 * HOUR -> {
                return "2 hours ago"
            }
            interval < 23 * HOUR -> {
                return (interval / HOUR).toString() + " hours ago"
            }
            interval < 36 * HOUR -> {
                return "a day ago"
            }
            interval < 72 * HOUR -> {
                return "2 days ago"
            }
            interval < 7 * DAY -> {
                return (interval / DAY).toString() + " days ago"
            }
            interval < 11 * DAY -> {
                return "a week ago"
            }
            interval < 14 * DAY -> {
                return "2 weeks ago"
            }
            interval < 9 * WEEK -> {
                return (interval / WEEK).toString() + " weeks ago"
            }
            interval < 19 * MONTH -> {
                return (interval / MONTH).toString() + " months ago"
            }
            interval < 2 * YEAR -> {
                return "a year ago"
            }
            else -> {
                return (interval / YEAR).toString() + " years ago"
            }
        }
    }
}