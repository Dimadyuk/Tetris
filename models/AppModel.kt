package com.example.tetris.models

import com.example.tetris.constants.FieldConstants
import com.example.tetris.helpers.array2dOfByte
import com.example.tetris.storage.AppPreferences

class AppModel {
    var score = 0
    private var preferences: AppPreferences? = null

    var currentBlock: Block? = null
    var currentState: String = Statuses.AWAITING_START.name

    private var field: Array<ByteArray> = array2dOfByte(
        FieldConstants.ROW_COUNT.value, FieldConstants.COLUMN_COUNT.value
    )

    fun setPreferences(preferences: AppPreferences?) {
        this.preferences = preferences
    }

    fun getCellStatus(row: Int, column: Int): Byte? {
        return field[row][column]
    }

    private fun setCellStatus(row: Int, column: Int, status: Byte?) {
        if (status != null) {
            field[row][column] = status
        }
    }

    fun isGameOver(): Boolean {
        return currentState == Statuses.OVER.name
    }

    fun isGameActive(): Boolean {
        return currentState == Statuses.ACTIVE.name
    }

    fun isGameAwaitingStart(): Boolean {
        return currentState == Statuses.AWAITING_START.name
    }

    private fun boostScore() {
        score += 10
        if (score > preferences?.getHighScore() as Int)
            preferences?.saveHighScore(score)
    }

    enum class Statuses {
        AWAITING_START, ACTIVE, INACTIVE, OVER
    }

    enum class Motions {
        LEFT, RIGHT, DOWN, ROTATE
    }
}