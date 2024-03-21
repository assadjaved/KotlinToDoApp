interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun epochMillis(): Long

object DateFormat {
    const val DATE_FORMAT = "EE, MMM d, yyyy"
}