package com.codecx.composeui.utils

object ValueCalculator {
    fun bytesToGB(bytes: Long): Double {
        val gigabyte = 1024 * 1024 * 1024.0
        return bytes / gigabyte
    }

    fun formatFileSize(fileLength: Long): Pair<String, String> {
        val kilobyte = 1024
        val megabyte = kilobyte * 1024
        val gigabyte = megabyte * 1024

        return when {
            fileLength > gigabyte -> Pair(
                String.format("%.2f", fileLength.toFloat() / gigabyte),
                "GB"
            )

            fileLength > megabyte -> Pair(
                String.format("%.2f", fileLength.toFloat() / megabyte),
                "MB"
            )

            fileLength > kilobyte -> Pair(
                String.format("%.2f", fileLength.toFloat() / kilobyte),
                "KB"
            )

            else -> Pair("$fileLength", "Bytes")
        }
    }

    fun formatSize(fileLength: Long): String {
        val kilobyte = 1024
        val megabyte = kilobyte * 1024
        val gigabyte = megabyte * 1024

        return when {
            fileLength > gigabyte -> String.format("%.2f GB", fileLength.toFloat() / gigabyte)
            fileLength > megabyte -> String.format("%.2f MB", fileLength.toFloat() / megabyte)
            fileLength > kilobyte -> String.format("%.2f KB", fileLength.toFloat() / kilobyte)
            else -> String.format("%d Bytes", fileLength)
        }
    }

    fun calculateProgress(current: Long, total: Long): Int {
        return ((current * 100) / total).toInt()
    }
}