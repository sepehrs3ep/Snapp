package ir.snapp.assignment.models.vehicle

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
enum class VehicleType(
    val key: String
) {
    Eco("Eco"),
    Plus("Plus"),
    Unknown("Unknown");

    companion object {
        fun parse(type: String): VehicleType {
            return when (type.trimStart().trimEnd()) {
                "ECO" -> Eco
                "PLUS" -> Plus
                else -> Unknown
            }
        }
    }
}