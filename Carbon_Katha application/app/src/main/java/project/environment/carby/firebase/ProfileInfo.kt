package project.environment.carby.firebase

data class ProfileInfo(
    val name: String?,
    val email: String?,
    val phoneNumber: String?,
    val gender: String?,
    val organization: String?,
    val address: String?,
    val pointsEarned: Int,
    val pointsRedeemed: Int,
    val noOfTimesReported: Int = 0,
    val noOfTimesCollected: Int = 0,
    val noOfTimesActivity: Int = 0,
    val communities: List<String> = emptyList()
) {
    constructor() : this(
        "",
        "",
        "",
        "",
        "",
        "",
        0,
        0,
        0,
        0,
        0,
        emptyList()
    )
}

fun calculatePointsEarned(
    noOfTimesReported: Int,
    noOfTimesCollected: Int,
    noOfCommunitiesJoined: Int,
    maxReportedValue: Int,
    maxCollectedValue: Int,
    maxCommunitiesJoinedValue: Int,
    isCollectedWaste: Boolean = false
): Int {
    // Calculate percentiles for each input variable
    val percentileReported = noOfTimesReported.toDouble() / maxReportedValue.toDouble()
    val percentileCollected = noOfTimesCollected.toDouble() / maxCollectedValue.toDouble()
    val percentileCommunitiesJoined = noOfCommunitiesJoined.toDouble() / maxCommunitiesJoinedValue.toDouble()

    // Calculate the overall percentile as the average of the individual percentiles
    val overallPercentile = (percentileReported + percentileCollected + percentileCommunitiesJoined) / 4.0

    // Scale the percentile to points between 5 and 20
    val scaledPoints = (overallPercentile * 15.0 + 5.0).toInt()
    return if (isCollectedWaste) scaledPoints.coerceIn(5,20) + 5 else scaledPoints.coerceIn(5, 50)
}
